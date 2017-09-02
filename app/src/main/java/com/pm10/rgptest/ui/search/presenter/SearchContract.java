package com.pm10.rgptest.ui.search.presenter;

import android.support.v7.widget.RecyclerView;
import android.widget.EditText;
import android.widget.ImageButton;

import com.pm10.rgptest.model.User;
import com.pm10.rgptest.ui.base.BaseViewInterface;
import com.pm10.rgptest.ui.search.adapter.SearchAdapter;

import java.util.ArrayList;

public interface SearchContract {
    interface RootView extends BaseViewInterface {
        void resetList(ArrayList<User> items, boolean hasNext);

        void addList(ArrayList<User> items, boolean hasNext);

        void updateUser(int position);

        void updateTotalCount(int count);
    }

    interface Presenter {
        void setUpInput(EditText editText, ImageButton searchButton);

        void setUpRecyclerView(RecyclerView recyclerView, SearchAdapter adapter);

        void searchGithubUser(int page, String q);

        void unLikeUser(ArrayList<User> items, int id);
    }

}
