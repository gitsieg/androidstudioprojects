package xyz.gitsieg.simpleshoppinglist;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class ItemsActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String EXTRA_ITEM_REPLY = "xyz.gitsieg.simpleshoppinglist.extra.REPLY";
    private static final String LOG_TAG = ItemsActivity.class.getSimpleName();
    private ArrayList<Button> buttons =  new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_items);
        setButtonListeners();

        for (Button btn : buttons) {
            System.out.println("Has button " + btn.toString());
        }
    }

    @Override
    public void onClick(View view) {
        Button btn = (Button) view;
        String text = btn.getText().toString();
        Log.d(LOG_TAG, "String is: " + text);
        Intent itemIntent = new Intent();
        itemIntent.putExtra(EXTRA_ITEM_REPLY, text);
        setResult(RESULT_OK, itemIntent);
        finish();
    }

    private void setButtonListeners() {
        LinearLayout root = findViewById(android.R.id.content).findViewById(R.id.items_id);
        int childCount = root.getChildCount();
        Object object = "itemButton";
        for (int i = 0; i < childCount; i++) {
            View view = root.getChildAt(i);
            if (view instanceof Button && view.getTag().equals(object)) {
                view.setOnClickListener(this);
                buttons.add((Button) view);
            }

        }
    }
}
