/**
 *
 */
package it.devteam.lib;

import android.content.ContentValues;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * @author Marco
 */
public class LibUtil {
    public final static String KEY_NAME = "key_nome";
    public final static String KEY_INDIRIZZO = "key_ind";

    /**
     * Restituisce la posizione del carattere in cui si trova la n virgola.
     *
     * @param n    - nesima posizione della virgola.
     * @param line - String to analysing
     * @return - la posizione del carattere in cui si trova la n virgola.
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
     * Ritorna la stringa dopo la virgola passata.
     *
     * @param line - Stringa da analizzare.
     * @param index - index della virgola.
     * @return - la stringa dopo la virgola passata.
     */
    public static String getValue(String line, int index) {
        int pos1 = LibUtil.findVirgola(index, line);
        String value = line.substring(pos1 + 1);
        int pos2 = LibUtil.findVirgola(1, value);
        value = value.substring(1, pos2 + 1).toLowerCase();

        return value;
    }

    /**
     * @param inputStream - InputStream dal quale prendere i dati.
     * @param nome - posizione della virgola del nome.
     * @param indirizzo - posizione della virgola dell'indirizzo.
     * @return - Un ArrayList con i valori del presi dal CSV.
     */
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

    /**
     * Concatena la stringa del nome con la striga dell'indirizzo.
     * @param arrayList - Array list con tutti i valori da visualizzare.
     * @return un'array di strighe con tutti i valori concatenati.
     */
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

}
