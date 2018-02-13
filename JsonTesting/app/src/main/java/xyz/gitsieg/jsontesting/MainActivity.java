package xyz.gitsieg.jsontesting;


import android.databinding.ObservableArrayList;
import android.databinding.ObservableList;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private final static String TAG = MainActivity.class.getSimpleName();
    ObservableArrayList<Card> cards;
    String cardData;
    Card card;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView textView = findViewById(R.id.label_cardName);
//        cards.addOnListChangedCallback(new ObservableList.OnListChangedCallback<ObservableList<Card>>() {
//            @Override
//            public void onChanged(ObservableList<Card> cards) {
//                textView.setText(cards.get(0).toString());
//            }
//
//            @Override
//            public void onItemRangeChanged(ObservableList<Card> cards, int i, int i1) {
//
//            }
//
//            @Override
//            public void onItemRangeInserted(ObservableList<Card> cards, int i, int i1) {
//
//            }
//
//            @Override
//            public void onItemRangeMoved(ObservableList<Card> cards, int i, int i1, int i2) {
//
//            }
//
//            @Override
//            public void onItemRangeRemoved(ObservableList<Card> cards, int i, int i1) {
//
//            }
//        });

        cards = new ObservableArrayList<>();
        RequestHandler requestHandler = new RequestHandler(this, cards);
        requestHandler.requestCard("Goblin Guide");

        cards.addOnListChangedCallback(new ObservableList.OnListChangedCallback<ObservableList<Card>>() {
            @Override
            public void onChanged(ObservableList<Card> cards) {
                Log.d(TAG, "onChanged");
                textView.setText(cards.get(0).toString());
            }

            @Override
            public void onItemRangeChanged(ObservableList<Card> cards, int i, int i1) {
                Log.d(TAG, "onItemRangeChanged");
                textView.setText(cards.get(i).toString());
            }

            @Override
            public void onItemRangeInserted(ObservableList<Card> cards, int i, int i1) {
                Log.d(TAG, "onItemRangeInserted");
                textView.setText(cards.get(i).toString());
            }

            @Override
            public void onItemRangeMoved(ObservableList<Card> cards, int i, int i1, int i2) {

            }

            @Override
            public void onItemRangeRemoved(ObservableList<Card> cards, int i, int i1) {

            }
        });
    }


}

