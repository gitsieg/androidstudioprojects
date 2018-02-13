package xyz.gitsieg.recyclerview2.Aktivitetsversjon;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import xyz.gitsieg.recyclerview2.R;

public class FylkeListeActivity extends AppCompatActivity {

    public static final String VALGT_FYLKE = "xyz.gitsieg.recyclerview2.ValgtFylke";

    private String[] arrFylke;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fylke_liste);

        Intent intent = getIntent();
        if (intent != null) {
            Bundle bundle = intent.getBundleExtra(MainActivity.BUNDLE_FYLKE_NAME);
            if (bundle != null) {
                arrFylke = bundle.getStringArray(MainActivity.ARR_FYLKE_LIST);
            }
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                R.layout.fylke_list_item, arrFylke);

        ListView listView = findViewById(R.id.fylke_list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {
//                visFylkeWeb(arrFylke[pos]);
                returnerFylke(arrFylke[pos]);
            }
        });

    }

    private void returnerFylke(String fylke) {
        Intent resultIntent = new Intent();
        resultIntent.putExtra(VALGT_FYLKE, fylke);
        setResult(Activity.RESULT_OK, resultIntent);
        finish();

    }

//    private void visFylkeWeb(String s) {
//        String strUrl = "https://no.wikipedia.org/wiki/" + s.replace(" ", "_");
//        Uri uri = Uri.parse(strUrl);
//        Intent webIntent = new Intent(Intent.ACTION_VIEW, uri);
//
//        if (webIntent.resolveActivity(getPackageManager()) != null)
//            startActivity(webIntent);
//    }
}
