package main;


import remote.parse4j.ParseException;
import remote.parse4j.ParseObject;
import remote.parse4j.ParseQuery;
import remote.parse4j.callback.FindCallback;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by deplike on 1.4.2016.
 */
public class RemoteQueries {

    private static String REMOTE_APP_ID = "rN4DxNv6mW0HrcLtJHFO9ageKDXcM76KNASxT3N4";
    private static String REMOTE_APP_MASTER_KEY= "KAm0JfPKVyWHu4P7xHu0ICGM4mABBi0FCqOxXI7I";



    public static void main(String args[]){
        //


        remote.parse4j.Parse.initializeAsRoot(REMOTE_APP_ID,REMOTE_APP_MASTER_KEY);
        ParseQuery<ParseObject> installaitonQuery=new ParseQuery<ParseObject>("_User");
        Calendar cal=Calendar.getInstance();
        cal.set(Calendar.DAY_OF_MONTH,1);
        cal.add(Calendar.MONTH, -1);

        installaitonQuery.whereGreaterThan("createdAt", cal.getTime());


        Calendar cal2=Calendar.getInstance();
        cal2.set(Calendar.DAY_OF_MONTH,10);
        cal2.add(Calendar.MONTH,-1);




        installaitonQuery.whereLessThanOrEqualTo("createdAt", cal2.getTime());
        Boolean stillGoesOn=true;
        int skipSize=0;
        List<ParseObject> totalList=new ArrayList<ParseObject>();
        while (stillGoesOn){

            try {
                installaitonQuery.skip(skipSize);
                List<ParseObject> parseObjects = installaitonQuery.find();
                totalList.addAll(parseObjects);
                if(parseObjects.size()<100){

                    stillGoesOn=false;
                }else{
                    skipSize+=100;
                }

            } catch (ParseException e) {
                e.printStackTrace();
            }


        }
        System.out.println("Total _User List Size : " + totalList.size());



    }

}
