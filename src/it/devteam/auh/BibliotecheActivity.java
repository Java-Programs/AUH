/**
 * DATA IERI
 */
package it.devteam.auh;

import it.devteam.lib.LibUtil;
import it.devteam.location.MapDevActivity;
import it.devteam.location.MappaAcivity;

import java.io.InputStream;
import java.util.ArrayList;


import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

/**
 * @author Marco
 *
 * 
 */
public class BibliotecheActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		ListView listView = (ListView) findViewById(R.id.listViewDemo);

		// -- Ottengo i valori.
		InputStream is = this.getResources().openRawResource(R.raw.biblioteche);
		final ArrayList<ContentValues> arrayList = LibUtil.getValueFromCSV(is,
				-1, 2);
		String[] arrayToView = LibUtil.generaArrayToView(arrayList);
		ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,
				R.layout.row_posti, R.id.nameTextView, arrayToView);
		listView.setAdapter(arrayAdapter);

		listView.setOnItemClickListener(new OnItemClickListener() {

			
			// Catturo scelta.
			public void onItemClick(AdapterView<?> arg0, View v, int position,
					long id) {
				//launchMapDev(arrayList, (int) id);
				//launch();
			}

		});
	}

	public void launchMapDev(ArrayList<ContentValues> arrayList, int id) {
		ArrayList<ContentValues> al = arrayList;
		String indirizzo = (String) arrayList.get(id).get(LibUtil.KEY_NAME);
		Intent i = new Intent(this, MapDevActivity.class);
		i.putExtra(LibUtil.KEY_INDIRIZZO, indirizzo);
		startActivity(i);
	}
	
	public void launch (){
		Intent i = new Intent(this, MappaAcivity.class);
		startActivity(i);
	}

}
