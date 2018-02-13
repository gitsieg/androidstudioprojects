package xyz.gitsieg.datepicker;

import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.DialogFragment;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText dateField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dateField = findViewById(R.id.dato_text);

    }

    public void visDatoVelgerFragment(View v) {
        DatoVelgerFragment newFragment = new DatoVelgerFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker");

    }

    public void behandleDatePickerResult(int year, int month, int day) {
        String datotekst = Integer.toString(year) + "." + Integer.toString(month+1) + "." + Integer.toString(day);
        dateField.setText(datotekst);
    }
}
