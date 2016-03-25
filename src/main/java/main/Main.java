package main;


import org.parse4j.*;

import org.parse4j.callback.SaveCallback;

import java.util.List;

/**
 * Created by deplike on 23.3.2016.
 */
public class Main {
    private static String APP_ID = "DEPLIKE";
    private static String APP_REST_API_ID = "DEPLIKE";
    public static void main(String[] args) {
/*        ParseRemote.initialize(APP_ID, APP_REST_API_ID);
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
        ParseQuery query=new ParseQuery("AIDL_V1");
        query.whereEqualTo("text","enter text");
        try {
            List<ParseObject> list = query.find();
            for (ParseObject parseObject : list) {
                System.out.println(parseObject.get("hasFound"));

            }


        } catch (ParseException e) {
            e.printStackTrace();
        }*/

        Parse.initialize("5W8UobctUfbJrCSqUjuoor3fWW5JrHAFSWn8u2M8","QVckpT3cb2bNLrh1gSka6jta0QXIAswUkJPNbk2P");


        ParseUser pu=new ParseUser();
        pu.setUsername("anil");
        pu.setPassword("mercan");
        try {
            pu.signUp();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        ParseQuery queryRemote=new ParseQuery("TestObject");
        queryRemote.whereEqualTo("foo","bar");
        try {
            List<ParseObject> list = queryRemote.find();
            for (ParseObject parseObject : list) {
                System.out.println(parseObject.get("foo"));

            }


        } catch (ParseException e) {
            e.printStackTrace();
        }
    }





}