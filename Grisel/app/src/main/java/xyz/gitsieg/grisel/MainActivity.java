package xyz.gitsieg.grisel;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.DragEvent;
import android.view.HapticFeedbackConstants;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, View.OnLongClickListener {

    // Used in place of HashMap, similar functionality except O(logN) performance.
    // Difference negligible with dataset this small (4 mappings each array)
    private ArrayList<ImageButton> infectButtons;
    private Button btn4Infect;
    private static SparseIntArray subLifeMap;
    private static SparseIntArray addLifeMap;
    private static SparseIntArray subInfectMap;
    private static SparseIntArray addInfectMap;
    private static SparseIntArray infectOpenMap;
    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    final int PLAYERS = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        linkCounterViews();
        setOnClickAndLongClickListeners();

        Log.d(LOG_TAG, "" + subInfectMap.toString());
        Log.d(LOG_TAG, "" + addInfectMap.toString());


    }

    private void setOnClickAndLongClickListeners() {
        infectButtons = new ArrayList<>();
        infectButtons.add((ImageButton) findViewById(R.id.ibtn_player1_infect));
        infectButtons.add((ImageButton) findViewById(R.id.ibtn_player2_infect));
        infectButtons.add((ImageButton) findViewById(R.id.ibtn_player3_infect));
        infectButtons.add((ImageButton) findViewById(R.id.ibtn_player4_infect));

        for (ImageButton btn : infectButtons) {
            btn.setOnLongClickListener(this);
            btn.setOnClickListener(this);
        }
    }

    private void linkCounterViews() {
        addLifeMap = new SparseIntArray();
        subLifeMap = new SparseIntArray();
        subInfectMap = new SparseIntArray();
        addInfectMap = new SparseIntArray();
        infectOpenMap = new SparseIntArray();

        for (int i = 0; i < PLAYERS; i++) {
            String strSub = "btn_player"+(i+1)+"_decrement";
            String strAdd = "btn_player"+(i+1)+"_increment";
            String strLife = "text_player"+(i+1)+"_lifetotal";


            String strSubInfect = "btn_player"+(i+1)+"_infect_decrement";
            String strInfect = "text_player"+(i+1)+"_infect";
            String strAddInfect = "btn_player"+(i+1)+"_infect_increment";

            String strIbtnInfect = "ibtn_player"+(i+1)+"_infect";
            String strInfectLayout = "player"+(i+1)+"_infect_data";


            // Fetches id
            int subID = getResources().getIdentifier(strSub, "id", getPackageName());
            int addID = getResources().getIdentifier(strAdd, "id", getPackageName());
            int txtID = getResources().getIdentifier(strLife, "id", getPackageName());

            int subInfectID = getResources().getIdentifier(strSubInfect, "id", getPackageName());
            int addInfectID = getResources().getIdentifier(strAddInfect, "id", getPackageName());
            int txtInfectID = getResources().getIdentifier(strInfect, "id", getPackageName());

            int ibtnInfectID = getResources().getIdentifier(strIbtnInfect, "id", getPackageName());
            int layoutInfectID = getResources().getIdentifier(strInfectLayout, "id", getPackageName());

            // Maps increment and decrement buttons to their respective life total TextView
            addLifeMap.put(addID, txtID);
            subLifeMap.put(subID, txtID);
            addInfectMap.put(addInfectID, txtInfectID);
            subInfectMap.put(subInfectID, txtInfectID);
            infectOpenMap.put(ibtnInfectID, layoutInfectID);

        }


    }

    /**
     * Finds and updates the connected life total TextView to the new life total.
     * @param view The view that is clicked, either a decrement or increment button
     */
    public void onLifeCounterClicked(View view) {
        int viewId = view.getId();
        int newLifeTotal;
        TextView txt;

        // Checks if mapping has been made
        if (addLifeMap.get(viewId) > 0) {
            txt = findViewById(addLifeMap.get(viewId)); // Fetches the life total view to be updated
            newLifeTotal = Integer.parseInt(txt.getText().toString());
            newLifeTotal++;
            txt.setText(newLifeTotal+"");
        } else {
            txt = findViewById(subLifeMap.get(viewId));
            newLifeTotal = Integer.parseInt(txt.getText().toString());
            newLifeTotal--;
            txt.setText(newLifeTotal+"");
        }

        txt.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
    }

    public void onInfectCounterClicked(View view) {
        int viewId = view.getId();
        int newLifeTotal;
        TextView txt;

        // Checks if mapping has been made
        if (addInfectMap.get(viewId) > 0) {
            txt = findViewById(addInfectMap.get(viewId)); // Fetches the life total view to be updated
            newLifeTotal = Integer.parseInt(txt.getText().toString());
            newLifeTotal++;
            txt.setText(newLifeTotal+"");
        } else {
            txt = findViewById(subInfectMap.get(viewId));
            newLifeTotal = Integer.parseInt(txt.getText().toString());
            newLifeTotal--;
            txt.setText(newLifeTotal+"");
        }
        txt.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
    }

    public void openOptionsFragment(View view) {
        FragmentManager fm = getSupportFragmentManager();
        OptionsFragment fragment = new OptionsFragment();
        fragment.show(fm, "optionsfragment");
    }

    public static SparseIntArray getLifeTotalArray() {
        return subLifeMap;
    }
    public static SparseIntArray getInfectArray() { return subInfectMap;}

    public void rollDice(View view) {
        Random rgen = new Random();
        int randInt = rgen.nextInt(6)+1;
        Toast.makeText(MainActivity.this, "Dice roll: " + randInt, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View view) {
        int viewId = view.getId();
        RelativeLayout viewGroup = findViewById(infectOpenMap.get(viewId));

        if (viewGroup.getVisibility() == View.VISIBLE) {
            viewGroup.setVisibility(View.INVISIBLE);
        } else {
            viewGroup.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public boolean onLongClick(View view) {
        int viewId = view.getId();
        return false;
    }


    //        btnDiceRoll.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Random rgen = new Random();
//                int randInt = rgen.nextInt(6)+1;
//                Toast.makeText(MainActivity.this, "Dice roll: " + randInt, Toast.LENGTH_SHORT).show();
//            }
//        });


}
