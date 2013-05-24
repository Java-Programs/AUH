package it.devteam.auh;

import java.io.InputStream;
import java.util.ArrayList;

import it.devteam.lib.LibUtil;
import android.app.Activity;
import android.content.ContentValues;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class EdicoleActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		ListView listView = (ListView) findViewById(R.id.listViewDemo);

		// -- Ottengo i valori.
		InputStream is = this.getResources().openRawResource(R.raw.edicole);
		ArrayList<ContentValues> arrayList = LibUtil.getValueFromCSV(is, 0, -1);
		String[] arrayToView = LibUtil.generaArrayToView(arrayList);
		ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,
				R.layout.row_posti, R.id.nameTextView, arrayToView);
		listView.setAdapter(arrayAdapter);
	}

}
