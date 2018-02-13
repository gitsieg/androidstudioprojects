package xyz.gitsieg.listdatatwoactivities;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.Arrays;

public class FylkeActivity extends AppCompatActivity {

    public final static String VALGTFYLKE = "p_valgt_fylke";
    private final static String TAG = FylkeActivity.class.getSimpleName();
    private ListView listView;
    private String[] fylkeTab;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fylke);

        Intent intent = getIntent();
        if (intent != null) {
            Log.d(TAG, "has intent");
            Bundle bundle = intent.getBundleExtra(MainActivity.FYLKE_BUNDLE_NAVN);
            if (bundle != null) {
                Log.d(TAG, "has bundle");
                fylkeTab = bundle.getStringArray(MainActivity.FYLKE_TAB_NAVN);
            }
        }

        Log.d(TAG, Arrays.toString(fylkeTab));

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.fylke_list_item, fylkeTab);
        listView = findViewById(R.id.fylke_listView);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new ListView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                returnerValgtFylke(fylkeTab[i]);
            }
        });
    }

    private void returnerValgtFylke(String s) {
        Log.d(TAG, s);
        Intent intent = new Intent();
        intent.putExtra(VALGTFYLKE, s);
        setResult(Activity.RESULT_OK, intent);
        finish();
    }
}
