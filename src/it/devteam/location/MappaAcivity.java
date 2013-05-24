package it.devteam.location;

import it.devteam.auh.R;
import android.os.Bundle;
import android.app.Activity;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MappaAcivity extends Activity {
 
 WebView myWebView;
 
 String mapPath = "https://maps.google.com/?ll=37.0625,-95.677068&spn=29.301969,56.513672&t=h&z=4";

 @Override
 protected void onCreate(Bundle savedInstanceState) {
  super.onCreate(savedInstanceState);
  setContentView(R.layout.mappa_activity);
  myWebView = (WebView)findViewById(R.id.mapview2);
  myWebView.getSettings().setJavaScriptEnabled(true);
  myWebView.setWebViewClient(new WebViewClient());
  
  myWebView.loadUrl(mapPath);
 }

}