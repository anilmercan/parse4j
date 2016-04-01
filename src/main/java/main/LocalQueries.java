package main;

import local.parse4j.ParseException;
import local.parse4j.ParseObject;
import local.parse4j.ParseQuery;
import local.parse4j.callback.FindCallback;


import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by deplike on 31.3.2016.
 */
public class LocalQueries {
    private static String LOCAL_APP_ID = "DEPLIKE";
    private static String LOCAL_APP_REST_API_ID = "DEPLIKE";



    public static void main(String args[]){
        //


        local.parse4j.Parse.initializeAsRoot(LOCAL_APP_ID,LOCAL_APP_REST_API_ID);
        ParseQuery<ParseObject> installaitonQuery=new ParseQuery<local.parse4j.ParseObject>("_Installation");
        Calendar cal=Calendar.getInstance();
        cal.set(Calendar.DAY_OF_MONTH,5);
        cal.add(Calendar.MONTH, -1);

        installaitonQuery.whereGreaterThan("crated_at", cal.getTime());


        Calendar cal2=Calendar.getInstance();
        cal2.set(Calendar.DAY_OF_MONTH,8);
        cal2.add(Calendar.MONTH,-1);

        installaitonQuery.whereLessThanOrEqualTo("crated_at", cal2.getTime());

        installaitonQuery.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> list, ParseException parseException) {
                if (parseException == null) {
                    for (ParseObject parseObject : list) {
                        System.out.println(parseObject.getObjectId());
                    }

                } else {
                    parseException.printStackTrace();
                }

            }
        });

    }
}
