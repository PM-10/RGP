package com.pm10.rgptest.ui.search.presenter;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.widget.EditText;
import android.widget.ImageButton;

import com.pm10.rgptest.api.Api;
import com.pm10.rgptest.api.NetworkRequest;
import com.pm10.rgptest.db.RealmProvider;
import com.pm10.rgptest.model.GitResult;
import com.pm10.rgptest.model.User;
import com.pm10.rgptest.ui.base.BasePresenter;
import com.pm10.rgptest.ui.search.adapter.SearchAdapter;
import com.pm10.rgptest.util.KeyboardUtils;
import com.pm10.rgptest.util.PageLinks;

import java.util.ArrayList;

public class SearchPresenter extends BasePresenter<SearchContract.RootView> implements SearchContract.Presenter {

    private final String IN_USERNAME = " in:login";
    private String searchText = "";

    public SearchPresenter(SearchContract.RootView view) {
        super(view);
    }

    @Override
    public void setUpInput(EditText editText, ImageButton searchButton) {
        editText.setOnEditorActionListener((textView, i, keyEvent) -> {

            String text = String.valueOf(textView.getText());

            if (TextUtils.isEmpty(text))
                return true;

            searchGithubUser(1, text);

            return false;
        });
        searchButton.setOnClickListener(button -> {
            searchGithubUser(1, String.valueOf(editText.getText()));
        });
    }

    @Override
    public void setUpRecyclerView(RecyclerView recyclerView, SearchAdapter adapter) {
        adapter.setOnLoadMoreListener(page -> {
            searchGithubUser(page, searchText);
            Log.d("page : ", page + " ");
        });
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
    }

    @Override
    public void searchGithubUser(int page, String q) {
        if (TextUtils.isEmpty(q))
            return;

        KeyboardUtils.hideKeyboard();

        searchText = q;

        rootView.loadingStart();
        NetworkRequest.request(Api.getService().getUsers(page, q + IN_USERNAME),
                response -> {

                    GitResult gitResult = response.body();
                    if (gitResult == null)
                        return;

                    boolean hasNext = PageLinks.hasNextPage(response.headers());

                    rootView.updateTotalCount(gitResult.total_count);

                    ArrayList<User> users = gitResult.items;
                    checkIsLikedUser(users);

                    if (1 < page)
                        rootView.addList(users, hasNext);
                    else
                        rootView.resetList(users, hasNext);

                    rootView.loadingComplete();
                });
    }

    @Override
    public void unLikeUser(ArrayList<User> items, int id) {
        int index = 0;
        for (User user : items) {
            if (user.id == id)
                user.liked = false;

            rootView.updateUser(index);

            ++index;
        }
    }

    private void checkIsLikedUser(ArrayList<User> items) {
        int index = 0;
        for (User user : items) {
            User likedUser = (User) RealmProvider.getInstance().findData(User.class, User.PRIMARY_KEY, user.id);
            if (likedUser != null) {
                user.liked = true;
                rootView.updateUser(index);
            }
            ++index;
        }
    }
}
