package xyz.gitsieg.recyclerview2.Aktivitetsversjon;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.Toast;

import xyz.gitsieg.recyclerview2.R;

public class MainActivity extends AppCompatActivity {

    public static final String ARR_FYLKE_LIST = "xyz.gitsieg.recyclerview2.Fylkeliste";
    public static final String BUNDLE_FYLKE_NAME = "xyz.gitsieg.recyclerview2.FylkeBundle";
    public static final int FYLKE_REQUEST_CODE = 1;

    private String[] arrFylke;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        Resources r = getResources();
        arrFylke = r.getStringArray(R.array.norske_fylker);



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onFylkerClick(View view) {
        visFylke();
    }

    private void visFylke() {
        Intent intent = new Intent(this, FylkeListeActivity.class);
        Bundle bundle = new Bundle();
        bundle.putStringArray(ARR_FYLKE_LIST, arrFylke);
        intent.putExtra(BUNDLE_FYLKE_NAME, bundle);
        startActivityForResult(intent, FYLKE_REQUEST_CODE);


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == FYLKE_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            String fylke = data.getStringExtra(FylkeListeActivity.VALGT_FYLKE);
            Toast.makeText(this, fylke, Toast.LENGTH_SHORT).show();
            Snackbar snack = Snackbar.make(findViewById(R.id.main_layout), fylke, Snackbar.LENGTH_SHORT);
            snack.setAction("Action", null);
            snack.show();
        }

        super.onActivityResult(requestCode, resultCode, data);
    }

    public static void visSnackbar(ViewGroup vg, int id, String msg) {
        Snackbar snack = Snackbar.make(vg.findViewById(id), msg, Snackbar.LENGTH_SHORT);
        snack.setAction("Action", null);
        snack.show();
    }

    public void onBilderClicked(View view) {
        Intent intent = new Intent(this, BildeGridActivity.class);
        startActivity(intent);
    }

    public void onKommunerClicked(View view) {
        Intent intent = new Intent(this, KommuneListeActivity.class);
        startActivity(intent);

    }
}
