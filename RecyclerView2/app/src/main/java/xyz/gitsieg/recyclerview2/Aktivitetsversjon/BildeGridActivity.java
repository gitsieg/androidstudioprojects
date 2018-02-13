package xyz.gitsieg.recyclerview2.Aktivitetsversjon;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

import xyz.gitsieg.recyclerview2.BildeAdapter;
import xyz.gitsieg.recyclerview2.R;

public class BildeGridActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bilde_grid);

        GridView gridView = findViewById(R.id.gridView);
        gridView.setAdapter(new BildeAdapter(this));


    }
}
