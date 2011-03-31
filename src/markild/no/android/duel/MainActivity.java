package markild.no.android.duel;

import markild.no.android.duel.rest.RestClient;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends Activity {
    
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
    
    @Override
    public void onStart() {
        super.onStart();
        
        TextView view = (TextView) findViewById(R.id.text_container);
        
        if (view == null) {
            Log.d("Duel", "FUCK!");
            return;
        }
        
        String url = "http://tranq.snoksrud.no/hello";
        
        String result = RestClient.getResult(url);
        view.setText(result);
    }
    
}
