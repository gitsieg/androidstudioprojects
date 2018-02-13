package xyz.gitsieg.simpleshoppinglist;

import android.content.Intent;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Iterator;

public class MainActivity extends AppCompatActivity {

    /**
     * When fetching items, append id number to this constant.
     */
    private final static String PRE_ITEM_LIST_ID = "main_itemList";
    private final int TEXT_REQUEST = 1;
    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    private Iterator<TextView> it;

    private ArrayList<TextView> textViews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null) {
            populateShopList();
        } else {
            fetchItemTextViews();
            it = textViews.iterator();
        }


        for (TextView tw : textViews) {
            System.out.println(tw.toString());
        }

    }

    private void populateShopList() {
        for (TextView tw : textViews) {
            Log.d(LOG_TAG, tw.getText().toString());
        }
    }



    public void addItems(View view) {
        Intent intent = new Intent(this, ItemsActivity.class);
        startActivityForResult(intent, TEXT_REQUEST);
    }

    private void fetchItemTextViews() {
        Log.d(LOG_TAG, "fetchItemTextViews");
        // TODO application logic
        textViews = new ArrayList<>();
        ViewGroup root = findViewById(android.R.id.content);
        LinearLayout linear_root = root.findViewById(R.id.main_id);
        int childCount = linear_root.getChildCount();
        Log.d(LOG_TAG, "--childcount = " + childCount);
        for (int i = 0; i < childCount; i++) {
            int twid = root.getResources().getIdentifier(PRE_ITEM_LIST_ID + i, "id", getPackageName());
            View view = findViewById(twid);
            if (!(view instanceof TextView))
                continue;
            textViews.add((TextView) view);
        }


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == TEXT_REQUEST)
            if (resultCode == RESULT_OK) {
                TextView textView = it.next();
                textView.setText(data.getStringExtra(ItemsActivity.EXTRA_ITEM_REPLY));
                textView.setVisibility(View.VISIBLE);
            }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
//        if (textViews.get(0).getVisibility() == View.VISIBLE) {
//            outState.putBoolean("list_visible", true);
//            for (TextView tw : textViews) {
//                if (tw.getVisibility() == View.VISIBLE) {
//                    outState.putString("list_obj");
//            }
//        }
    }
}
