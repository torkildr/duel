package markild.no.android.duel.rest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;
 
public class RestClient {
 
    private static String convertStreamToString(InputStream is) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
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
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }
 
    public static String getResult(String url)
    {
        HttpClient httpclient = new DefaultHttpClient();
         
        HttpPost post = new HttpPost(url);
        post.addHeader("User-Agent", "AndroidDuelClient/0.1");

        List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
        
        nameValuePairs.add(new BasicNameValuePair("user", "root"));
        nameValuePairs.add(new BasicNameValuePair("bjoranrs", "lukter ¾sj!"));
        
        try {
            post.setEntity(new UrlEncodedFormEntity(nameValuePairs));
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        }
        
        HttpResponse response;

        try {
            response = httpclient.execute(post);

            HttpEntity entity = response.getEntity();
 
            if (entity != null) {
                InputStream instream = entity.getContent();
                String result = convertStreamToString(instream);
 
                return result;
            }
 
 
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return null;
    }
    
    public static JSONObject stringToJSON(String input) {
        try {
            JSONObject json = new JSONObject(input);
            
            return json;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        
        return null;
    }
}
