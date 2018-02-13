package xyz.gitsieg.recyclerdemorepeat;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Kommune> kommuner;
    RecyclerView rcView;
    KommuneAdapter kommuneAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            kommuner = Kommune.createKommuneData(readCountyDataFromFile());
        } catch (JSONException e) {
            e.printStackTrace();
        }

        System.out.println(kommuner.toString());

        rcView = findViewById(R.id.rcv_kommuneRecycler);
        rcView.setAdapter(new KommuneAdapter(this, kommuner));
        rcView.setLayoutManager(new LinearLayoutManager(this));

    }


    private String readCountyDataFromFile() {
        InputStream stream;
        BufferedReader reader;
        String line;
        StringBuilder fileData = new StringBuilder();

        try {
            Resources r = getResources();
            stream = r.openRawResource(R.raw.kommunedata);
            reader = new BufferedReader(new InputStreamReader(stream));

            while ((line = reader.readLine()) != null) {
                fileData.append(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileData.toString();
    }
}
