package xyz.gitsieg.checkboxes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    private ArrayList<String> extraToppingsSet;
    private ArrayList<CheckBox> checkBoxes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fetchCheckBoxControls();
        extraToppingsSet = new ArrayList<>();
    }

    private void fetchCheckBoxControls() {
        checkBoxes = new ArrayList<>();
        ViewGroup root = findViewById(R.id.linearLayout_chk_container);
        int childCount = root.getChildCount();

        for (int i = 0; i < childCount; i++) {
            checkBoxes.add((CheckBox) root.getChildAt(i));
        }


    }

    public void sendPizzaOrder(View view) {
        Intent intent = new Intent(this, ProcessOrderActivity.class);
        intent.putStringArrayListExtra("toppinglist", extraToppingsSet);
        startActivity(intent);
    }

    public void onCheckBoxClicked(View view) {

        CheckBox checkBox = (CheckBox) view;
        boolean checked = checkBox.isChecked();
        String toppingText = checkBox.getText().toString();

        if (checked) {
            // add item to list
            extraToppingsSet.add(toppingText);
        } else {
            // remove item from list
            extraToppingsSet.remove(toppingText);
        }

        for (String s : extraToppingsSet) {
            System.out.println(s);
        }
    }
}
