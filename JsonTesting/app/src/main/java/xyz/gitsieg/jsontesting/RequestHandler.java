package xyz.gitsieg.jsontesting;

import android.content.Context;
import android.databinding.ObservableArrayList;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;


/**
 * Created by gitsieg on 02.02.18.
 */

public class RequestHandler {


    private static final String TAG = RequestHandler.class.getSimpleName();

    ObservableArrayList<Card> cards;
    RequestQueue queue;
    String url = "https://api.magicthegathering.io/v1/cards?name=";

    public RequestHandler(Context c, ObservableArrayList<Card> cards) {
        queue = Volley.newRequestQueue(c);
        this.cards = cards;
    }

    /**
     * Takes card name parameter. Returns matches as an arraylist
     *
     * @param cardName
     * @return The ArrayList of Cards matched by cardName
     */
    public void requestCard(final String cardName) {
        String url = this.url.concat(cardName.replace(" ", "+"));
        StringRequest request = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            cards = Card.createCardList(cards, response);
                        } catch (JSONException jsonException) {
                            jsonException.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                    }
                });

        queue.add(request);
    }
}
