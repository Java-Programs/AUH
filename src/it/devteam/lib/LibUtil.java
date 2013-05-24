/**
 * 
 */
package it.devteam.lib;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import android.content.ContentValues;

/**
 * @author Marco
 * 
 */
public class LibUtil {
	public final static String KEY_NAME = "key_nome";
	public final static String KEY_INDIRIZZO = "key_ind";

	/**
	 * Restituisce la posizione del carattere in cui si trova la n virgola.
	 * 
	 * @param n
	 *            - posizione n da trovare.
	 * @param line
	 *            - stringa da analizzare.
	 * @return int - con l'indice della virgola
	 */
	public static int findVirgola(int n, String line) {

		boolean virgole = false;
		int count_virgole = 0;
		int pos = 0;

		for (int i = 0; (i < line.length() && !virgole); i++) {

			/** Cerca la posizione della quinta virgola */

			if (line.charAt(i) == ',') {

				count_virgole++;

			}
			if (count_virgole == n) {
				pos = i;
				virgole = false;
			}
		}
		return pos;
	}

	/**
	 * 
	 * @param line
	 * @param index
	 * @return
	 */
	public static String getValue(String line, int index) {
		int pos1 = LibUtil.findVirgola(index, line);
		String value = line.substring(pos1 + 1);
		int pos2 = LibUtil.findVirgola(1, value);
		value = value.substring(1, pos2 + 1).toLowerCase();

		return value;
	}

	public static ArrayList<ContentValues> getValueFromCSV(
			InputStream inputStream, int nome, int indirizzo) {

		InputStream is = inputStream;
		BufferedReader reader = new BufferedReader(new InputStreamReader(is));

		ArrayList<ContentValues> values = new ArrayList<ContentValues>();

		try {
			String line;

			while ((line = reader.readLine()) != null) {
				ContentValues cv = new ContentValues();
				cv.put(LibUtil.KEY_NAME, getValue(line, nome));
				cv.put(LibUtil.KEY_INDIRIZZO, getValue(line, indirizzo));

				values.add(cv);
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				is.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return values;
	}

	public static String[] generaArrayToView(ArrayList<ContentValues> arrayList) {
		int count = arrayList.size();
		String[] arrayToView = new String[count];

		for (int i = 0; i < arrayList.size(); i++) {
			arrayToView[i] = (String) arrayList.get(i).get(LibUtil.KEY_NAME)
					+ "\n"
					+ (String) arrayList.get(i).get(LibUtil.KEY_INDIRIZZO);
		}
		return arrayToView;
	}

	public static String getNome(String line) {
		return LibUtil.getValue(line, 4);
	}

	public static String getIndirizzo(String line) {
		return LibUtil.getValue(line, 19);
	}

}
