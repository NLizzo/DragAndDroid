package draganddroid;

import global.Constants;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;

/**
 * This class will generate a formatted file of all of the elements that
 * have been dragged and dropped onto the canvas when finished.
 * 
 * The file will be passed to the android part and that will, parse this file
 * and create those specified elements 
 * 
 * @author Anthony Favia
 *
 */
public class AppElementListGenerator {

    Vector<AndroidElement> elements;

    public AppElementListGenerator(Vector<AndroidElement> elements) {
        this.elements = elements;
    }

    public void GenerateElementList() {
        try {
        	File file = new File(Constants.filename);
        	BufferedWriter out = new BufferedWriter(new FileWriter(file));

            out.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
            out.write("<ElementList>\n");
            
            for (int i = 0; i < elements.size(); i++) {
                out.write(elements.elementAt(i).outputElementXML());
            }
               
            out.write("</ElementList>\n");
            out.close();
            System.out.println("file loc -> " + file.getAbsolutePath());
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
}
