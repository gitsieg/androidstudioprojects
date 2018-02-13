package xyz.gitsieg.magiccardbrowser.net_pkg;

import android.support.v4.app.Fragment;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.widget.ImageView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;

import java.util.ArrayList;

import xyz.gitsieg.magiccardbrowser.gui_pkg.MainActivity;
import xyz.gitsieg.magiccardbrowser.card_pkg.Card;

/**
 * Created by Nikolai on 2/8/2018.
 * This class requires:
 * - internet permission in android manifest
 * Dependencies in build.grade(Module:app):
 * - compile 'com.android.volley:volley:1.1.0'
 */

public class RequestHandler {

    private final static String TAG = RequestHandler.class.getSimpleName();

    public ArrayList<Card> getCardList() {
        return arrCards;
    }

    // Interface for notification..
    public interface OnRequestProcessedListener {
        public void onCardListProcessed();
    }

    public interface OnImageRequestProcessedListener {
        public void onCardImageProcessed();
    }


    // Static members
    static final int NUMBER_OF_REQUEST_TYPES = 4;
    static final String[] base_urls = new String[NUMBER_OF_REQUEST_TYPES];
    public final static RequestType REQUEST_TYPE = new RequestType();


    // Instance member
    ArrayList<Card> arrCards;
    RequestQueue rqQueue;
    Context context;
    Fragment fragment;


    //    https://api.magicthegathering.io/v1/cards?name=Monastery
    public RequestHandler(Context context) {
        // Initialize the base urls
        arrCards = new ArrayList<Card>();
        rqQueue = Volley.newRequestQueue(context);
        this.context = context;
        setRequestTypes();
    }


    /**
     * Constant static members provided by the RequestType class. Options are:
     * RequestType.CARD_ID
     * RequestType.CARD_NAME
     * RequestType.SET_ID
     * RequestType.SET_NAME
     *
     * @param requestType       The type of request to be made
     * @param requestedResource The name of the resource request, e.g Monastery Swiftspear
     */
    public void createRequest(int requestType, String requestedResource) {
        String url = base_urls[requestType] + requestedResource.replace(" ", "+");
        Log.d(TAG, "Requesting: " + url);

        StringRequest request = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            arrCards = Card.createCards(response);
                            ((MainActivity)context).onCardListProcessed(); // Callback to mainthread, load cards
                            processImages();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d(TAG, "Error: " + error.toString());
            }
        });

        rqQueue.add(request);
    }

    // Todo finish imageRequest
    public void createImageRequest(final Card card) {

        if (card.getImageUrl() == null)
            return;

        ImageRequest imgRequest = new ImageRequest(card.getImageUrl(),
                new Response.Listener<Bitmap>() {
                    @Override
                    public void onResponse(Bitmap response) {
                        Drawable bmpDrawable = new BitmapDrawable(context.getResources(), response);
                        card.setCardImage(bmpDrawable);
                    }
                },
                0,
                0,
                ImageView.ScaleType.FIT_CENTER,
                Bitmap.Config.RGB_565,
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                    }
                }
        );
        rqQueue.add(imgRequest);

    }

    public void processImages() {
        for (Card card:arrCards) {
            createImageRequest(card);
        }


    }

    // Enum type requests to be used for this class.
    public static class RequestType {
        public static final int CARD_ID = 0;
        public static final int CARD_NAME = 1;
        public static final int SET_ID = 2;
        public static final int SET_NAME = 3;
    }

    private void setRequestTypes() {
        base_urls[REQUEST_TYPE.CARD_ID] = null;
        base_urls[REQUEST_TYPE.CARD_NAME] = "https://api.magicthegathering.io/v1/cards?name=";
        base_urls[REQUEST_TYPE.SET_ID] = null;
        base_urls[REQUEST_TYPE.SET_NAME] = null;
    }

}
