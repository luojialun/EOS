package com.android.eos.ui.activity;

import android.net.http.SslError;
import android.text.TextUtils;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import com.android.eos.R;
import com.android.eos.base.BaseActivity;
import com.android.eos.net.UrlHelper;
import com.android.eos.utils.ConstantUtils;

import butterknife.BindView;
import butterknife.OnClick;

public class H5Activity extends BaseActivity {

    @BindView(R.id.title_tv)
    TextView titleTv;
    @BindView(R.id.webview)
    WebView webview;

    private String title;  //标题
    private String type;   //类型
    private String webUrl;  //H5链接   除self_web的H5链接，其他根据type判断

    @Override
    public int setViewId() {
        return R.layout.activity_h5;
    }

    @Override
    public void initView() {
        initParams();
        initTitle();

    }

    private void initParams() {
        title = getIntent().getStringExtra(ConstantUtils.TITLE);
        type = getIntent().getStringExtra(ConstantUtils.H5_TYPE);
        if(type.equals(ConstantUtils.SELF_WEB)){
            webUrl=getIntent().getStringExtra(ConstantUtils.SELF_WEB_URL);
        }
    }

    private void initTitle() {
        if (!TextUtils.isEmpty(title)) {
            titleTv.setText(title);
        }
    }

    @Override
    public void initData() {
        switch (type) {
            case ConstantUtils.UP_LOG:  //更新日志
                webUrl = UrlHelper.upLog;
                break;
        }

        initWebView();
    }

    public void initWebView() {
        WebSettings webSettings = webview.getSettings();
        webSettings.setJavaScriptEnabled(true);//如果访问的页面中要与Javascript交互，则webview必须设置支持Javascript

        webview.loadUrl(webUrl);
        webview.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }

            @Override
            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
                //super.onReceivedSslError(view, handler, error);
                handler.proceed();
            }

        });
    }

    @OnClick({R.id.back_iv})
    public void OnClick(View view) {
        switch (view.getId()) {
            case R.id.back_iv:
                finish();
                break;
        }
    }

    @Override
    protected void onDestroy() {
        if (null != webview) {
            webview.removeAllViews();
            webview.destroy();
        }
        super.onDestroy();
    }
}
