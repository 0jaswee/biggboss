package com.example.hotstarbackground;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.webkit.CookieManager;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
    private static final String HOTSTAR = "https://www.hotstar.com/in";
    private WebView web;
    private boolean backgroundAttempt = false;
    private Button backgroundButton;

    @Override public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout root = new LinearLayout(this);
        root.setOrientation(LinearLayout.VERTICAL);
        Button open = new Button(this);
        open.setText("Open JioHotstar / Login");
        root.addView(open);
        backgroundButton = new Button(this);
        backgroundButton.setText("Try Background Audio: OFF");
        root.addView(backgroundButton);
        TextView info = new TextView(this);
        info.setText("Sign in on the official JioHotstar website. Background audio is experimental and may be blocked by JioHotstar. No passwords are collected by this app.");
        info.setPadding(16, 8, 16, 8);
        root.addView(info);
        web = new WebView(this);
        root.addView(web, new LinearLayout.LayoutParams(-1, 0, 1));
        setContentView(root);
        WebSettings settings = web.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setMediaPlaybackRequiresUserGesture(true);
        CookieManager.getInstance().setAcceptCookie(true);
        CookieManager.getInstance().setAcceptThirdPartyCookies(web, true);
        web.setWebViewClient(new WebViewClient());
        web.setWebChromeClient(new WebChromeClient());
        open.setOnClickListener(v -> web.loadUrl(HOTSTAR));
        backgroundButton.setOnClickListener(v -> {
            backgroundAttempt = !backgroundAttempt;
            backgroundButton.setText(backgroundAttempt ? "Try Background Audio: ON (experimental)" : "Try Background Audio: OFF");
            Toast.makeText(this, backgroundAttempt ? "Experimental mode on. Audio may still stop when screen locks." : "Experimental mode off", Toast.LENGTH_LONG).show();
        });
        if (savedInstanceState == null) web.loadUrl(HOTSTAR);
        else web.restoreState(savedInstanceState);
    }
    @Override protected void onSaveInstanceState(Bundle outState) {
        web.saveState(outState);
        super.onSaveInstanceState(outState);
    }
    @Override protected void onPause() {
        // Do not forcibly pause WebView media when switching apps.
        super.onPause();
        if (!backgroundAttempt) web.onPause();
    }
    @Override protected void onResume() {
        super.onResume();
        web.onResume();
    }
    @Override public void onBackPressed() {
        if (web.canGoBack()) web.goBack(); else super.onBackPressed();
    }
    @Override protected void onDestroy() {
        web.destroy();
        super.onDestroy();
    }
}
