package xyz.gitsieg.recyclerview2.Fragmentversjon;

import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import xyz.gitsieg.recyclerview2.Aktivitetsversjon.FylkeListeActivity;
import xyz.gitsieg.recyclerview2.R;

public class Main2Activity extends AppCompatActivity implements KnappeFragment.OnMenyButtonListener, FylkeListeFragment.OnFragmentInteractionListener {

    public static final String FYLKE_TAB_NAVN = "xyz.gitsieg.recyclerview2.fylke_tab";
    private String[] fylkeTabell;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        Resources r = getResources();
        fylkeTabell = r.getStringArray(R.array.norske_fylker);

        if (findViewById(R.id.fragment_container) != null) {
            KnappeFragment knappeFragment = new KnappeFragment();
            knappeFragment.setArguments(getIntent().getExtras());

            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.fragment_container, knappeFragment);
            transaction.commit();

        } else {

        }
    }

    @Override
    public void onMenyButtonClicked(int buttonId) {
        switch (buttonId) {
            case R.id.fylkeKnapp:
                visFylkeListe();
                break;
        }
    }

    private void visFylkeListe() {
        // Klargjør data og bundle
        FylkeListeFragment fylkeListeFragment = new FylkeListeFragment();
        Bundle args = new Bundle();
        args.putStringArray("fylkeTabell", fylkeTabell);

        fylkeListeFragment.setArguments(args);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, fylkeListeFragment);
        transaction.addToBackStack(null);
        transaction.commit();



    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
