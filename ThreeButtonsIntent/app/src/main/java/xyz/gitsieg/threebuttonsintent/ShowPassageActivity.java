package xyz.gitsieg.threebuttonsintent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ShowPassageActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_passage);


        TextView textView = findViewById(R.id.text_passage);

        Intent intent = getIntent();
        int data = intent.getIntExtra(MainActivity.EXTRA_MESSAGE,0);

        if (data == 0) {
            textView.setText(R.string.passage1);
        } else if (data == 1) {
            textView.setText(R.string.passage2);
        } else if (data == 2) {
            textView.setText(R.string.passage3);
        }

    }
}
