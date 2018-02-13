package xyz.gitsieg.listdatatwoactivities;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String FYLKE_TAB_NAVN = "xyz.gitsieg.ListDataTwoActivities.p_fylke_tab";
    public static final String FYLKE_BUNDLE_NAVN = "xyz.gitsieg.ListDataTwoActivities.p_fylke_bundle";
    public static final int FYLKE_LISTE_REQUEST= 1;
    private String[] fylkeTabell;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Resources r = getResources();
        fylkeTabell = r.getStringArray(R.array.norske_fylker);

    }

    public void onFylkerClicked(View view) {
        visFylkeListe();
    }

    private void visFylkeListe() {
        Intent fylkeIntent = new Intent(this, FylkeActivity.class);
        Bundle bundle = new Bundle();
        bundle.putStringArray(FYLKE_TAB_NAVN, fylkeTabell);
        fylkeIntent.putExtra(FYLKE_BUNDLE_NAVN, bundle);
        startActivityForResult(fylkeIntent, FYLKE_LISTE_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == FYLKE_LISTE_REQUEST && resultCode == Activity.RESULT_OK) {
            String valgtFylke = data.getStringExtra(FylkeActivity.VALGTFYLKE);
            Toast.makeText(this, valgtFylke, Toast.LENGTH_SHORT).show();
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
