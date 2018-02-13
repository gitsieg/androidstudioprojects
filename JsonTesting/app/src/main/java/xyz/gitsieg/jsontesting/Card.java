package xyz.gitsieg.jsontesting;

import android.databinding.ObservableArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by gitsieg on 02.02.18.
 */


public class Card {
    String cardName;
    int cmc;
    String imageUrl;

    public Card(JSONObject jsonCard) {
        this.cardName = jsonCard.optString("name");
        this.cmc = jsonCard.optInt("cmc");
        this.imageUrl = jsonCard.optString("imageUrl");
    }

    public Card(String engCardName, int cmc, String imageUrl) {
        this.cardName = engCardName;
        this.cmc = cmc;
        this.imageUrl = imageUrl;
    }

    protected static Card createCard(JSONObject jsonObject) throws JSONException, NullPointerException {
        JSONObject cardObject = jsonObject.getJSONObject("card");
        System.out.println(cardObject.toString());
        return new Card(cardObject);
    }

    protected static ObservableArrayList<Card> createCardList(ObservableArrayList<Card> cardList, String jsonString) throws JSONException, NullPointerException {
        JSONObject topLevelObject = new JSONObject(jsonString);
        JSONArray jsonCardList = topLevelObject.optJSONArray("cards");

        System.out.println("List length: " + jsonCardList.length());
        for (int i = 0; i < jsonCardList.length(); i++) {
            cardList.add(new Card(jsonCardList.getJSONObject(i)));
        }
        return cardList;
    }

    @Override
    public String toString() {
        return "Card{" +
                "cardName='" + cardName + '\'' +
                ", cmc=" + cmc +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}