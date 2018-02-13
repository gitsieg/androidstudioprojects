package xyz.gitsieg.helloworld;

import android.app.DialogFragment;
import android.content.DialogInterface;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.support.v7.app.AlertDialog;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements DialogInterface.OnClickListener {
    private static final String[] TELEFON_TYPER = {"Hjemme", "Jobb", "Mobil", "Annet"};
    private ArrayList<RadioButton> btns;
    private LinearLayout linearLayout;
    private Button btn_clickMe;
    private EditText datoFelt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        linearLayout = findViewById(R.id.textlayout_id);
        fetchButtons();

        datoFelt = findViewById(R.id.text_dato);

//        byggVisJaNeiDialog("Blablabla", "blabla");
        // Erstatt final string array, med getResources().getStringArray(R.array.....)
//        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.telefon_typer));

        // Lage Adapter direkte fra ressurs.
        ArrayAdapter<CharSequence> spinnerAdapter = ArrayAdapter.createFromResource(this, R.array.telefon_typer, android.R.layout.simple_spinner_dropdown_item);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        final Spinner typeSpinner = findViewById(R.id.spin_number_type);
        if (typeSpinner != null)
            typeSpinner.setAdapter(spinnerAdapter);


        typeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                int[] fargetabell = {Color.BLUE, Color.CYAN, Color.LTGRAY, Color.GREEN};
                EditText telefonText = findViewById(R.id.edit_tlfNr);
                telefonText.setBackgroundColor(fargetabell[i]);

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        btn_clickMe = findViewById(R.id.click_me_button);
    }

    private void byggVisJaNeiDialog(String tittel, String sporsmaal) {
        AlertDialog.Builder myAlertBuilder = new AlertDialog.Builder(this);
        if (myAlertBuilder != null) {
            myAlertBuilder.setTitle(tittel);
            myAlertBuilder.setMessage(sporsmaal);
            myAlertBuilder.setPositiveButton("Ja", MainActivity.this);
            myAlertBuilder.setNeutralButton("Avbryt", MainActivity.this);
            myAlertBuilder.setNegativeButton("Nei", MainActivity.this);
            myAlertBuilder.show();

        }
    }

    public void visDatoVelgerDialog(View view) {
        DatePickerFragment fragment = new DatePickerFragment();
        fragment.show(getSupportFragmentManager(), "datePicker");
    }

    @Override
    public void onClick(DialogInterface dialogInterface, int i) {

        switch (i) {
            case DialogInterface.BUTTON_POSITIVE:
                System.out.println("Positive");
                break;
            case DialogInterface.BUTTON_NEGATIVE:
                System.out.println("Negative");
                break;
            case DialogInterface.BUTTON_NEUTRAL:
                System.out.println("Neutral");
                break;
        }
    }


    public void fetchButtons() {
        ViewGroup root = findViewById(R.id.radioGroup);
        btns = new ArrayList<>();
        int childCount = root.getChildCount();

        for (int i = 0; i < childCount; i++)
            btns.add((RadioButton) root.getChildAt(i));
    }

    public void isChecked(View view) {
        linearLayout.removeAllViews();
        for (RadioButton rb : btns) {
            if (rb.isChecked()) {
                TextView tw = new TextView(getApplicationContext());
                tw.setText(rb.getText());
                linearLayout.addView(tw);
            }
        }

    }


}
