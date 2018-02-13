package xyz.gitsieg.checkboxes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class ProcessOrderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_process_order);

        Intent intent = getIntent();
        ArrayList<String> toppinglist = intent.getStringArrayListExtra("toppinglist");
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        setContentView(layout);

        for (String s : toppinglist) {
            TextView tv = new TextView(getApplicationContext());
            tv.setText(s);
            layout.addView(tv);
        }
    }


}
