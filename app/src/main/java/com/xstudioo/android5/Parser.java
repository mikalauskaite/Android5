package com.xstudioo.android5;

import android.util.Log;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class Parser {

    private static String TAG="XmlParser class";

    public static ArrayList<String> getRateFromECB( InputStream stream ) throws IOException {
        Log.i(TAG, "getRateFromECB method was created");
       ArrayList <String> result = new ArrayList <> (  );
        String currencyName;
        try {
            DocumentBuilderFactory xmlDocFactory = DocumentBuilderFactory.newInstance ();
            DocumentBuilder xmlDocBuilder = xmlDocFactory.newDocumentBuilder ();
            Document doc = xmlDocBuilder.parse(stream);

            NodeList rateNodes = doc.getElementsByTagName (Constants.RATE_NODE);
            for(int i=0; i<rateNodes.getLength (); i++) {
                Element rate = (Element) rateNodes.item(i);
                currencyName = rate.getAttribute ( Constants.CURRENCY_NAME_ATTRIBUTE );
                if(currencyName.length ()>0){
                    result.add( currencyName + " - " + rate.getAttribute ( Constants.RATE_ATTRIBUTE ));
                }
            }
        } catch ( ParserConfigurationException e ){
            Log.e(TAG, "getRateFromECB method failed");
            e.printStackTrace ();
        } catch ( SAXException e ){
            Log.e(TAG, "getRateFromECB method failed");
            e.printStackTrace ();
        }
        return result;
    }
}
