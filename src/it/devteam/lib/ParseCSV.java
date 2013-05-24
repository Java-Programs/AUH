/**
 * 
 */
package it.devteam.lib;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author Marco
 *
 */
public class ParseCSV {

	public static void getCSVvalues (){
	    Scanner scanner = null;
		try {
			scanner = new Scanner(new File("/res/raw/Edicole.csv"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    scanner.useDelimiter(",");
	    while(scanner.hasNext()){
	        System.out.print(scanner.next()+"|");
	    }
	    scanner.close();
	}
	
	
}
