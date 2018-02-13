package xyz.gitsieg.magiclifecounter;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


import java.util.HashMap;
import java.util.Random;


public class MainActivity extends AppCompatActivity {
    ImageButton btn_p1_infect;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_p1_infect = findViewById(R.id.ibtn_player1_infect);
        btn_p1_infect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Infecxt Clicked", Toast.LENGTH_SHORT).show();
            }
        });

//        btnDiceRoll.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Random rgen = new Random();
//                int randInt = rgen.nextInt(6)+1;
//                Toast.makeText(MainActivity.this, "Dice roll: " + randInt, Toast.LENGTH_SHORT).show();
//            }
//        });
//
//
//        // Fetch all Views, add listeners and fill values.
//        lifeTotals = new TextView[4];
//        btnSubtractLifeTotal = new Button[4];
//        btnAddLifeTotal = new Button[4];
//
//        // Create HashMap, mapping ids to player id's
//        addMap = new HashMap();
//        subMap = new HashMap();
//
//        for (int i = 0; i < lifeTotals.length; i++) {
//            String btnSubID = "button_player"+(i+1)+"_decrease";
//            String btnAddID = "button_player"+(i+1)+"_increase";
//            String lifeTextID = "text_player"+(i+1)+"_life";
//
//            // Fetches id
//            int subID = getResources().getIdentifier(btnSubID, "id", getPackageName());
//            int addID = getResources().getIdentifier(btnAddID, "id", getPackageName());
//            int txtID = getResources().getIdentifier(lifeTextID, "id", getPackageName());
//
//            addMap.put(addID, txtID);
//            subMap.put(subID, txtID);
//
//            // Fetches View
//            btnSubtractLifeTotal[i] = findViewById(subID);
//            btnAddLifeTotal[i] = findViewById(addID);
//            lifeTotals[i] = findViewById(txtID);
//
//            // Log for id
////            Log.d(LOG_TAG, "btnSubID has: " + btnSubID + " at i: " + i);
////            Log.d(LOG_TAG, "btnAddID has: " + btnAddID + " at i: " + i);
////            Log.d(LOG_TAG, "lifeTextID has: " + btnSubID + " at i: " + i);
////
////            // Log for int id
////            Log.d(LOG_TAG, "subID has: " + subID + " at i: " + i);
////            Log.d(LOG_TAG, "addID has: " + addID + " at i: " + i);
////            Log.d(LOG_TAG, "txtID has: " + txtID + " at i: " + i);
////
////            // Check view values
////            Log.d(LOG_TAG, "btnSubtractLifeTotal has: " + btnSubtractLifeTotal[i] + " at i: " + i);
////            Log.d(LOG_TAG, "btnAddLifeTotal has: " + btnAddLifeTotal[i] + " at i: " + i);
////            Log.d(LOG_TAG, "lifeTotals has: " + lifeTotals[i] + " at i: " + i);
//
//            // Set values lifeTotals
//            lifeTotals[i].setText(""+defaultLifeTotal);
//            btnSubtractLifeTotal[i].setOnClickListener(this);
//            btnAddLifeTotal[i].setOnClickListener(this);
//        }
    }

    public void onButtonDiceRollClicked(View view) {
        Random rgen = new Random();
        int randInt = rgen.nextInt(6)+1;
        Toast.makeText(MainActivity.this, "Dice roll: " + randInt, Toast.LENGTH_SHORT).show();
    }

    public void playerInfect(View view) {
        Toast.makeText(this, "Infect!", Toast.LENGTH_SHORT).show();
    }
//
//    @Override
//    public void onClick(View view) {
//        int viewID = view.getId();
//        int subAddID;
//        TextView txt;
//
//
//        if (addMap.containsKey(viewID)) {
//            subAddID = Integer.parseInt(addMap.get(viewID).toString());
//            txt = findViewById(subAddID);
//            txt.setText((Integer.parseInt(txt.getText().toString())+1) + "");
//        }
//        else {
//            subAddID = Integer.parseInt(subMap.get(viewID).toString());
//            txt = findViewById(subAddID);
//            txt.setText((Integer.parseInt(txt.getText().toString())-1) + "");
//        }
//    }
}
