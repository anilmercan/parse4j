package main;


import local.parse4j.Parse;
import local.parse4j.ParseException;
import local.parse4j.ParseObject;
import local.parse4j.ParseQuery;
import local.parse4j.callback.SaveCallback;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import remote.parse4j.ParseUser;

import java.util.*;

/**
 * Created by deplike on 23.3.2016.
 */
public class Main {
    private static String LOCAL_APP_ID = "DEPLIKE";
    private static String LOCAL_APP_REST_API_ID = "DEPLIKE";


    private static String REMOTE_APP_ID = "CUHWQ34fhVERCkAhQZdtZ5QOMrT6FQ6uGyY2TG3j";
    private static String REMOTE_APP_MASTER_KEY= "WUuQks3UM2YRG2sSzH1lSvC3kiNC3M909UcXw2zV";
    private static String REMOTE_APP_REST_API_KEY= "eXdfGXtkds4T7xl8MreE7s55flmeVlX9DOUFr9kN";


    private static String[] classArray= new String[]{"_Installation","_User","Event","Session"};



    public static void main(String[] args) throws ParseException, remote.parse4j.ParseException {

       Map<String,List<local.parse4j.ParseObject>> localBag=new HashMap<String, List<local.parse4j.ParseObject>>();
        remote.parse4j.Parse.initializeAsRoot(REMOTE_APP_ID,REMOTE_APP_MASTER_KEY);





        try {


            for (String clazz : classArray) {
                remote.parse4j.ParseQuery queryRemote=new  remote.parse4j.ParseQuery(clazz);

                queryRemote.limit(100);
                Integer startOfQuery=0;
                List<local.parse4j.ParseObject> localList=new ArrayList<ParseObject>();
                while (true){

                    queryRemote.skip(startOfQuery);
                    List<remote.parse4j.ParseObject> listOfClass = queryRemote.find();

                    for (remote.parse4j.ParseObject parseObject : listOfClass) {

                        local.parse4j.ParseObject parseLocalObject=new local.parse4j.ParseObject(clazz);

                        parseLocalObject.setCreatedAt(parseObject.getCreatedAt());
                        parseLocalObject.setObjectId(parseObject.getObjectId());
                        parseLocalObject.setUpdatedAt(parseObject.getUpdatedAt());


                        Map<String, Object> data = parseObject.getData();
                        data.put("crated_at",parseObject.getCreatedAt());
                        data.put("updated_at",parseObject.getUpdatedAt());


                        Set<String> keySey = data.keySet();
                        for (String key : keySey) {
                            System.out.println("Key -> " + key + "  Data -> " + data.get(key));

                            if(data.get(key) instanceof remote.parse4j.ParseObject){

                                System.out.println("Relation -> " + parseObject.getRelation(key));
                                remote.parse4j.ParseObject o = (remote.parse4j.ParseObject) data.get(key);

                                Mapper mapper = new DozerBeanMapper();

                                local.parse4j.ParseUser destObject =
                                        mapper.map(data.get(key), local.parse4j.ParseUser.class);
                                parseLocalObject.put(key,destObject);

                            }else{
                                parseLocalObject.put(key,data.get(key));
                            }

                        }
                        localList.add(parseLocalObject);

                    }

                    startOfQuery=startOfQuery+100;
                    if(listOfClass.size()<100){
                        break;
                    }
                }
                localBag.put(clazz,localList);


            }

        } catch (remote.parse4j.ParseException e) {
            e.printStackTrace();
        }







        Set<String> localBagKeySet = localBag.keySet();

       Parse.initializeAsRoot(LOCAL_APP_ID, LOCAL_APP_REST_API_ID);
        System.out.println("STARTED TO LOCALIZE");









        for (String key : localBagKeySet) {

            List<local.parse4j.ParseObject> parseObjects = localBag.get(key);

            for (ParseObject parseObject : parseObjects) {
                try {
                    parseObject.setUpdatedAt(null);
                    parseObject.setCreatedAt(null);
                    parseObject.setObjectId(null);
                    parseObject.save();
                }catch (ParseException parseException){
                    Map<String,Object> t=new HashMap<String, Object>();

                    Map<String, Object> data = parseObject.getData();
                    data.put("password","test");

                    parseObject.setData(data);
                    try {
                        parseObject.save();
                    }catch (Exception e ){
                        e.printStackTrace();
                    }


                }


            }

        }

 }





}