package com.jeya.database.graph.neo4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.message.BasicNameValuePair;

import android.net.http.AndroidHttpClient;
import android.util.Log;

import com.google.gson.GsonBuilder;

public class Neo4jRestInterface {
    public static final String SERVER_ROOT_URI = "http://10.0.2.2:7474/";
    public static void connect(String url)
    {
    	url = SERVER_ROOT_URI;
    	AndroidHttpClient httpclient = AndroidHttpClient.newInstance("");
        // Prepare a request object
        HttpGet request = new HttpGet(url); 
        // Execute the request
        HttpResponse response;
        try {
            response = httpclient.execute(request);
            // Examine the response status
            Log.i("OK",response.getStatusLine().toString());
            // Get hold of the response entity
            HttpEntity entity = response.getEntity();
            // If the response does not enclose an entity, there is no need
            // to worry about connection release
            if (entity != null) {

                // A Simple JSON Response Read
                InputStream instream = entity.getContent();
                String result= convertStreamToString(instream);
                // now you have the string representation of the HTML request
                instream.close();
            }
        } 
        catch (Exception e) 
        {
        	e.printStackTrace();
        }
    }
    
    private static String convertStreamToString(InputStream instream) {
        /*
         * To convert the InputStream to String we use the BufferedReader.readLine()
         * method. We iterate until the BufferedReader return null which means
         * there's no more data to read. Each line will appended to a StringBuilder
         * and returned as String.
         */
        BufferedReader reader = new BufferedReader(new InputStreamReader(instream));
        StringBuilder sb = new StringBuilder();

        String line = null;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
            	instream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
	}
    
    public static void createNode()
    {
    	String ss = "CREATE n RETURN n";
    	/**{
    		  "statements" : [ {
    		    "statement" : "CREATE n RETURN n"
    		  } ]
    		}*/
    	List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
    	String[]statements = new String[]{ss};
    	urlParameters.add(new BasicNameValuePair("statements",new GsonBuilder().create().toJson(statements)));
    	AndroidHttpClient httpclient = AndroidHttpClient.newInstance("");
        // Prepare a request object
        HttpPost request = new HttpPost(SERVER_ROOT_URI + "db/data/node/"); 
        // Execute the request
        HttpResponse response;
        try {
    		request.setEntity(new UrlEncodedFormEntity(urlParameters));
            response = httpclient.execute(request);
            // Examine the response status
            Log.i("Omg",response.getStatusLine().toString());
            // Get hold of the response entity
            HttpEntity entity = response.getEntity();
            // If the response does not enclose an entity, there is no need
            // to worry about connection release
            if (entity != null) {

                // A Simple JSON Response Read
                InputStream instream = entity.getContent();
                String result= convertStreamToString(instream);
                // now you have the string representation of the HTML request
                instream.close();
            }
        } 
        catch (Exception e) 
        {
        	e.printStackTrace();
        }
    }
    
    public static void getNode()
    {
    	String ss = "MATCH(nodes) WHERE nodes.id = 12 RETURN nodes";
    	AndroidHttpClient httpclient = AndroidHttpClient.newInstance("");
        // Prepare a request object
        HttpGet request = new HttpGet(SERVER_ROOT_URI); 
        // Execute the request
        HttpResponse response;
        try {
            response = httpclient.execute(request);
            // Examine the response status
            Log.i("Miyaav",response.getStatusLine().toString());
            // Get hold of the response entity
            HttpEntity entity = response.getEntity();
            // If the response does not enclose an entity, there is no need
            // to worry about connection release
            if (entity != null) {

                // A Simple JSON Response Read
                InputStream instream = entity.getContent();
                String result= convertStreamToString(instream);
                // now you have the string representation of the HTML request
                instream.close();
            }
        } 
        catch (Exception e) 
        {
        	e.printStackTrace();
        }
    }
    
    public static void updateNode(/*String place,String busStopOrTrailwayStation*/)
    {
    	// wrong
    	/*String ss = "MATCH(nodes {id:12}) SET nodes += " + 
    				"{name: nodeName}";
    	*//**{
    		  "statements" : [ {
    		    "statement" : "CREATE n RETURN n"
    		  } ]
    		}*//*
    	AndroidHttpClient httpclient = AndroidHttpClient.newInstance("");
        // Prepare a request object
        HttpPost request = new HttpPost(SERVER_ROOT_URI); 
        // Execute the request
        HttpResponse response;
        try {
            response = httpclient.execute(request);
            // Examine the response status
            Log.i("Done",response.getStatusLine().toString());
            // Get hold of the response entity
            HttpEntity entity = response.getEntity();
            // If the response does not enclose an entity, there is no need
            // to worry about connection release
            if (entity != null) {

                // A Simple JSON Response Read
                InputStream instream = entity.getContent();
                String result= convertStreamToString(instream);
                // now you have the string representation of the HTML request
                instream.close();
            }
        } 
        catch (Exception e) 
        {
        	e.printStackTrace();
        }*/
    }
}