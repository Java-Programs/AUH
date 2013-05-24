package it.devteam.location;

import it.devteam.auh.R;
import android.app.Activity;
import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.Toast;

public class LocationsActivity extends Activity implements LocationListener {

	
	private LocationManager locationManager;
    private String provider;
    
    private Location location;
    private double latitude; // Latitudine
    private double longitude; // Longitudine
    Criteria criteria = new Criteria();
    
    
	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_locations);
	     
		setLocation();
		 
	}
	
	 
	public void setLocation() {

		locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
		provider = locationManager.getBestProvider(criteria, false);
        
		if (provider != null ) {
        	
        	location = locationManager.getLastKnownLocation(provider);
        
        
        	if (location != null) {
        	
        		latitude = location.getLatitude();
        		longitude = location.getLongitude();
   
        
        	}
        }
        
	}

	
	public Location getLocation () {
		
		return location;
		
	}
	

	public double getLongitude() {
		
		return longitude;
	
	}
	
	
	public double getLatitude() {
	
		return latitude;
	
	}
	
	
	public String getProvider () {
		
		return provider;
		
	}
	

	


	/* Request updates at startup */
    @Override
    protected void onResume() {
    
    	super.onResume();
        locationManager.requestLocationUpdates(provider, 400, 1, this);
      
    }
 
    
    /* Remove the locationlistener updates when Activity is paused */
    @Override
    protected void onPause() {
    
    	super.onPause();
        locationManager.removeUpdates(this);
      
    }
	
    
    @Override
    public void onLocationChanged(Location location) {
    	
            setLocation();
      
    }
 
    
    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
            // TODO Auto-generated method stub
      }
 
    
    @Override
    public void onProviderEnabled(String provider) {
    
    	Toast.makeText(this, "Enabled new provider " + provider, Toast.LENGTH_SHORT).show();
 
      
    }
 
    
    @Override
    public void onProviderDisabled(String provider) {
    
    	Toast.makeText(this, "Disenabled provider " + provider, Toast.LENGTH_SHORT).show();
      
    }

	


}

