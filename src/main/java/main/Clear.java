package main;

import local.parse4j.Parse;
import local.parse4j.ParseObject;

import java.util.List;

/**
 * Created by deplike on 28.3.2016.
 */
public class Clear {
    private static String LOCAL_APP_ID = "DEPLIKE";
    private static String LOCAL_APP_REST_API_ID = "DEPLIKE";
    private static String[] classArray= new String[]{"_Installation","_User","Event","Session"};
    /*private static String[] classArray= new String[]{"_Session"};*/

    public static void main(String[] args){

        Parse.initializeAsRoot(LOCAL_APP_ID, LOCAL_APP_REST_API_ID);
        System.out.println("STARTED TO LOCALIZE");
        try {
        for (String clazz : classArray) {

            int skipSize=0;
            while (true){
                local.parse4j.ParseQuery localQuery=new  local.parse4j.ParseQuery(clazz);

                localQuery.skip(skipSize);
                List<ParseObject> listOfClass = localQuery.find();

                for (ParseObject listOfClas : listOfClass) {
                    listOfClas.delete();
                }
                if(listOfClass.size()<100){
                    break;
                }
                skipSize=skipSize+100;
             }

            }


        }catch (Exception e ){
            e.printStackTrace();
        }

    }
}
