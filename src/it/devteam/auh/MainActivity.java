/**
 * 
 */
package it.devteam.auh;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * @author Marco
 * 
 */
public class MainActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		ListView listView = (ListView) findViewById(R.id.listViewDemo);

		listView.setAdapter(new ArrayAdapter<String>(this, R.id.listViewDemo));
		listView.setTextFilterEnabled(true);
		listView.setOnItemClickListener(new OnItemClickListener() {

			// Catturo scelta.
			public void onItemClick(AdapterView<?> arg0, View v, int position,
					long id) {

				switch ((int) id) {
				case 0:
					launchTurismo();
					break;

				case 1:
					launchBiblioteche();
					break;

				case 2:
					launchMusei();
					break;

				case 3:
					launchCentriGiovanili();
					break;
				case 4:
					launchCentriEdicole();
					break;
				case 5:
					launchFarmacie();
					break;
				case 6:
					launchImpiantiSportivi();
				case 7:
					launchPiscine();
				case 8:
					launchTeatri();
				default:
					break;
				}

			}
		});

		// TODO: Lista Principale
		String[] array = { "Turismo", "*** Biblioteche ***", "*** Musei ***",
				"*** Centri Giovanili ***", "*** Edicole ---",
				"**** Farmacie ***", "*** ImpiantiSportivi ***", "*** Piscine ***",
				"Teatri" };

		ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,
				R.layout.row, R.id.textViewList, array);
		listView.setAdapter(arrayAdapter);

	}

	public void launchTurismo() {
		Intent i = new Intent(this, TurismoActivity.class);
		startActivity(i);
	}

	public void launchBiblioteche() {
		Intent i = new Intent(this, BibliotecheActivity.class);
		startActivity(i);
	}

	public void launchMusei() {
		Intent i = new Intent(this, MuseiActivity.class);
		startActivity(i);
	}

	public void launchCentriGiovanili() {
		Intent i = new Intent(this, CentriGiovaniliActivity.class);
		startActivity(i);
	}

	public void launchCentriEdicole() {
		Intent i = new Intent(this, EdicoleActivity.class);
		startActivity(i);
	}

	public void launchFarmacie() {
		Intent i = new Intent(this, FarmacieActivity.class);
		startActivity(i);
	}

	public void launchImpiantiSportivi() {
		Intent i = new Intent(this, ImpiantiSportiviActivity.class);
		startActivity(i);
	}

	public void launchPiscine() {
		Intent i = new Intent(this, PiscineActivity.class);
		startActivity(i);
	}

	public void launchTeatri() {
		Intent i = new Intent(this, TeatriActivity.class);
		startActivity(i);
	}

}
