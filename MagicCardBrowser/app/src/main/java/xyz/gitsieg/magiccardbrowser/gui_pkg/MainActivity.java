package xyz.gitsieg.magiccardbrowser.gui_pkg;

import android.net.Uri;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;

import java.util.ArrayList;

import xyz.gitsieg.magiccardbrowser.R;
import xyz.gitsieg.magiccardbrowser.card_pkg.Card;
import xyz.gitsieg.magiccardbrowser.net_pkg.RequestHandler;

public class MainActivity extends AppCompatActivity implements RequestHandler.OnRequestProcessedListener,
            RequestHandler.OnImageRequestProcessedListener, CardListFragment.OnFragmentInteractionListener, CardViewFragment.OnFragmentInteractionListener {

    private final static String TAG = MainActivity.class.getSimpleName();
    RequestHandler rqHandler;
    ArrayList<Card> cardList;

    // Fragment related variables
    CardListFragment cardListFragment;
    CardViewFragment cardViewFragment;
    FragmentTransaction transaction;

    // Testing
    ImageView cardImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        cardImage = findViewById(R.id.cardImage);

        rqHandler = new RequestHandler(this);
        rqHandler.createRequest(RequestHandler.RequestType.CARD_NAME, "Monastery");

        // Instantiate fragments and transaction, sets layout
        createAndSetFragments();


    }

    public void onCardListProcessed() {
        cardList = rqHandler.getCardList();
        Log.d(TAG, cardList.toString());
    }

    @Override
    public void onCardImageProcessed() {

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    private void createAndSetFragments() {
        cardListFragment = new CardListFragment();
        cardViewFragment = new CardViewFragment();
        transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.cardListFragment, cardListFragment);
        transaction.replace(R.id.cardViewFragment, cardViewFragment);
        transaction.commit();
    }
}
