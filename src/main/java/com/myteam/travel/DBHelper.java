/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myteam.travel;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;
import com.mongodb.client.model.Sorts;
import com.myteam.travel.model.TbUser;
import java.util.Arrays;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author uoc
 */
public class DBHelper {

    public DBHelper() {
    }

    public TbUser findUser(String userName) {
        TbUser user = new TbUser();
        try {
            MongoCredential credential;
            credential = MongoCredential.createCredential("abcd", "mongo_test",
                    "xyz".toCharArray());

            MongoClient mongo_client = new MongoClient(new ServerAddress("localhost", 27017), Arrays.asList(credential));
            MongoDatabase database = mongo_client.getDatabase("mongo_test");

            String collectionCurent = "users";

            MongoCollection<Document> collection = database.getCollection(collectionCurent);

//            Bson projectionFields = Projections.fields(
//                    Projections.include("title"),
//                    Projections.excludeId());
            Document doc = collection.find(eq("userName", userName))
                    //.projection(projectionFields)
                    .sort(Sorts.descending("imdb.rating"))
                    .first();
            if (doc != null) {
                user.setId(doc.getObjectId("_id").toString());
                user.setUserName(doc.getObjectId("userName").toString());
                user.setPwd(doc.getObjectId("pwd").toString());
            } else {

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    public String insertUser(String user, String pwd) {
        String id = "";
        try {
            MongoCredential credential;
            credential = MongoCredential.createCredential("abcd", "mongo_test",
                    "xyz".toCharArray());

            MongoClient mongo_client = new MongoClient(new ServerAddress("localhost", 27017), Arrays.asList(credential));
            MongoDatabase database = mongo_client.getDatabase("mongo_test");

            String collectionCurent = "users";
            Document document = new Document();
            document.append("userName", user);
            document.append("pwd", pwd);

            database.getCollection(collectionCurent).insertOne(document);
            ObjectId _id = document.getObjectId("_id");
            id = _id.toString();
        } catch (Exception e) {

        }
        return id;
    }

    public String insertLog(String user, String text) {
        String id = "";
        try {
            MongoCredential credential;
            credential = MongoCredential.createCredential("abcd", "mongo_test",
                    "xyz".toCharArray());

            MongoClient mongo_client = new MongoClient(new ServerAddress("localhost", 27017), Arrays.asList(credential));
            MongoDatabase database = mongo_client.getDatabase("mongo_test");

            String collectionCurent = "logs";
            Document document = new Document();
            document.append("userName", user);
            document.append("log", text);

            database.getCollection(collectionCurent).insertOne(document);
            ObjectId _id = document.getObjectId("_id");
            id = _id.toString();
        } catch (Exception e) {

        }
        return id;
    }

//    public List<Log> readLog() {
//        List<Log> listLog = new LinkedList<>();
//        try {
//            MongoCredential credential;
//            credential = MongoCredential.createCredential("abcd", "mongo_test",
//                    "xyz".toCharArray());
//
//            MongoClient mongo_client = new MongoClient(new ServerAddress("localhost", 27017), Arrays.asList(credential));
//            MongoDatabase database = mongo_client.getDatabase("mongo_test");
//
//            String collectionCurent = "logs";
//            MongoCollection<Document> collection = database.getCollection(collectionCurent);
//            
//            //Retrieving the documents
//            FindIterable<Document> iterDoc = collection.find();
//            Iterator it = iterDoc.iterator();
//            while (it.hasNext()) {
//                Log log = new Log();
//                log.setUser(it.getC);
//                System.out.println(it.next());
//                listLog.add(log);
//            }
//
//        } catch (Exception e) {
//
//        }
//        return listLog;
//    }
}
