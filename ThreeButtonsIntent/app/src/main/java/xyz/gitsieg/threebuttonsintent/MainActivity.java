package xyz.gitsieg.threebuttonsintent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    public static final String EXTRA_MESSAGE = "xyz.gitsieg.threebuttonsintent.MainActivity";
    private static final int[] PASSAGE_CODE = {0, 1, 2};

    private Button button1, button2, button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
    }

    public void btn1click(View view) {
        Intent intent = new Intent(this, ShowPassageActivity.class);
        intent.putExtra(EXTRA_MESSAGE, PASSAGE_CODE[0]);
        startActivity(intent);
    }

    public void btn2click(View view) {
        Intent intent = new Intent(this, ShowPassageActivity.class);
        intent.putExtra(EXTRA_MESSAGE, PASSAGE_CODE[1]);
        startActivity(intent);
    }

    public void btn3click(View view) {
        Intent intent = new Intent(this, ShowPassageActivity.class);
        intent.putExtra(EXTRA_MESSAGE, PASSAGE_CODE[2]);
        startActivity(intent);
    }
}
