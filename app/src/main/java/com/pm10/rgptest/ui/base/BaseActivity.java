package com.pm10.rgptest.ui.base;

import android.app.ProgressDialog;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class BaseActivity<T extends ViewDataBinding, T2 extends BasePresenter> extends AppCompatActivity implements BaseViewInterface {

    protected T binding;
    protected T2 presenter;
    protected Context context;

    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        View view = getLayoutInflater().inflate(layoutResID, null);
        binding = DataBindingUtil.bind(view);
        super.setContentView(view);

        context = this;
        progressDialog = new ProgressDialog(this);
    }


    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void loadingStart() {
        if (progressDialog.isShowing())
            return;
        progressDialog.show();
    }

    @Override
    public void loadingComplete() {
        if (!progressDialog.isShowing())
            return;
        progressDialog.dismiss();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
