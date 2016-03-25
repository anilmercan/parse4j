package main;

import org.parse4j.Parse;
import org.parse4j.ParseException;
import org.parse4j.ParseObject;
import org.parse4j.ParseUser;
import org.parse4j.callback.SaveCallback;
import org.parse4j.callback.SignUpCallback;

/**
 * Created by deplike on 23.3.2016.
 */
public class Main {
    private static String APP_ID = "DEPLIKE";
    private static String APP_REST_API_ID = "DEPLIKE";
    public static void main(String[] args) {
        Parse.initializeAsRoot(APP_ID, APP_REST_API_ID);
        ParseObject po = new ParseObject("parse4j");
        po.put("anil", "mercan");
        po.saveInBackground(new SaveCallback() {

            @Override
            public void done(ParseException parseException) {
                if(parseException==null){
                    System.out.println("Test");
                }else{
                    System.out.println("sicar");
                    parseException.printStackTrace();
                }
            }
        });
    }
}