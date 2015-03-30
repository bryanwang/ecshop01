package com.eb.ecshop;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;


public class Category extends Activity {

    private WebView categoryWebView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_tab_category);


        categoryWebView = (WebView)findViewById(R.id.categoryWebView);
        categoryWebView.getSettings().setJavaScriptEnabled(true);
        categoryWebView.getSettings().setUseWideViewPort(true);
        categoryWebView.getSettings().setLoadWithOverviewMode(true);
        categoryWebView.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        categoryWebView.setWebViewClient(new WebViewClient());
        categoryWebView.loadUrl(getResources().getString(R.string.url_category));

	}

    public void btnmainright(View v) {
        Intent intent = new Intent (Category.this,MainWindow.class);
        startActivity(intent);
    }

}
