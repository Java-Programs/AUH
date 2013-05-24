package it.devteam.location;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import it.devteam.auh.R;
import it.devteam.lib.LibUtil;
import it.elbuild.jcoord.*;
import it.elbuild.jcoord.resolver.GeoCodeResolver;

public class MapDevActivity extends Activity {
	private static final String comune = "Milano";
	private static final String provincia = "Milano";

	private String indirizzo = "";

	private WebView mappa;
	

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.map_dev);

		Intent i = getIntent();
		this.indirizzo = (String)i.getStringExtra(LibUtil.KEY_INDIRIZZO);
		
		
		mappa = (WebView) findViewById(R.id.mapview);

		
		mappaCreate();

	}

	/* Request updates at startup */
	@Override
	protected void onResume() {
		super.onResume();
	}

	/* Remove the locationlistener updates when Activity is paused */
	@Override
	protected void onPause() {
		super.onPause();
	}

	
	
	public void onStatusChanged(String provider, int status, Bundle extras) {
		// TODO Auto-generated method stub
	}

	

	

	public double getDestLongitude() {

		String adress = new String();

		adress = provincia + " " + comune + " " + indirizzo;
		LatLng coord = GeoCodeResolver.findCoordForAddress(adress);

		double longitude = (double) coord.getLng().doubleValue();

		return longitude;
	}

	public double getDestLatitude() {

		String adress = new String();

		adress = provincia + " " + comune + " " + indirizzo;
		LatLng coord = GeoCodeResolver.findCoordForAddress(adress);

		double latitude = (double) coord.getLat().doubleValue();

		return latitude;

	}

	public void mappaCreate() {
		
	/*		double lat = this.getLatitude();
			double lng = this.getLongitude();
	*/
			double lat_dest = this.getDestLatitude();
			double lng_dest = this.getDestLongitude();

/*	String stringUrl = "http://maps.google.it/maps?f=d&source=s_d&saddr=";
			String stringUrl2 = "&hl=it&geocode=&mra=ls&sll=&z=14";
*/
			mappa.getSettings().setJavaScriptEnabled(true); // abilitiamo il
															// javascript per
															// poter caricare la
															// mappa
			mappa.getSettings().setPluginsEnabled(true); // abilitiamo
															// l'utilizzo di
															// plugin per poter
															// utilizzare le
															// funzionalità di
															// google map

			mappa.setWebChromeClient(new WebChromeClient());
			// String url =
			// "http://maps.google.it/maps?f=d&source=s_d&saddr="+lat+"%2C"+lng+"&daddr="+lat_des+"%2C"+lng_des+"&hl=it&geocode=&mra=ls&sll=&z=14";
			//String url = stringUrl + lat + "%2C" + lng + "&daddr=" + lat_dest
			String String_url = "http://maps.google.com/maps/api/staticmap?center=" + lat_dest + "," + lng_dest+ "&zoom=10&size=400x400&sensor=false";
					//+ "%2C" + lng_dest + stringUrl2;

			// mappa.getSettings().setUserAgentString("Mozilla/5.0 (Windows; U; Windows NT 6.0; de; rv:1.9.0.5) Gecko/2008120122 Firefox/3.0.5 (.NET CLR 3.5.30729)");
			// String usrA = mappa.getSettings().getUserAgentString();
			mappa.getSettings()
					.setUserAgentString(
							"Mozilla/5.0 (Windows; U; Windows NT 6.0; de; rv:1.9.0.5) Gecko/2008120122 Firefox/3.0.5 (.NET CLR 3.5.30729)"); // settaggio
																																				// dello
																																				// UserAgent
			mappa.loadUrl(String_url);
			mappa.getSettings().setLoadWithOverviewMode(true);
			mappa.getSettings().setUseWideViewPort(true);

	}

}
