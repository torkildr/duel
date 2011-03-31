package markild.no.android.duel.rest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

public class TestRestClient {

    public void PrintJSON(JSONObject json) {
        try {
            JSONArray nameArray=json.names();
            JSONArray valArray=json.toJSONArray(nameArray);
            
            for(int i=0;i<valArray.length();i++) {
                Log.i("Duel",
                        "<jsonname"+i+">\n"+nameArray.getString(i)+"\n</jsonname"+i+">\n"
                        +"<jsonvalue"+i+">\n"+valArray.getString(i)+"\n</jsonvalue"+i+">");
            }
        } catch (JSONException e) {
            // poo!
        }
    }
    
}
