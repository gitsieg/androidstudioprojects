package xyz.gitsieg.recyclerview2.Aktivitetsversjon;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import xyz.gitsieg.recyclerview2.Kommune;
import xyz.gitsieg.recyclerview2.KommuneListAdapter;
import xyz.gitsieg.recyclerview2.R;

public class KommuneListeActivity extends AppCompatActivity {

    private ArrayList<Kommune> arrKommune;
    private RecyclerView recycler_Kommune;
    private KommuneListAdapter kommuneAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kommune_liste);

        String kommuneData = lesKommuneDataFraFil();
        recycler_Kommune = findViewById(R.id.recycler_kommuneView);

        try {
            arrKommune = Kommune.createKommuneliste(kommuneData);
        } catch (JSONException je) {
            je.printStackTrace();
        }

        System.out.println(arrKommune.toString());

        kommuneAdapter = new KommuneListAdapter(this, arrKommune);
        recycler_Kommune.setAdapter(kommuneAdapter);
        recycler_Kommune.setLayoutManager(new LinearLayoutManager(this));
    }

    private String lesKommuneDataFraFil() {
        InputStream is;
        BufferedReader reader;
        String enLinje;
        StringBuilder heleFilen = new StringBuilder();

        try {
            is = getResources().openRawResource(R.raw.kommunedata);
            reader = new BufferedReader(new InputStreamReader(is));

            while ((enLinje = reader.readLine()) != null) {
                heleFilen.append(enLinje);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return heleFilen.toString();
    }
}
