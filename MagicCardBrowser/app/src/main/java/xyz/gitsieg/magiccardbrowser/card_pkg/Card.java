package xyz.gitsieg.magiccardbrowser.card_pkg;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by Nikolai on 2/8/2018.
 */

public class Card {
    // Debugging purposes
    private final static String TAG = Card.class.getSimpleName();

    String name;
    String manaCost;


    String imageUrl;
    String originText;
    String type;
    String rarity;
    String[][] legality, ruling;
    int cmc, multiverseId;
    Drawable cardImage;

    public Card(String name, String manaCost, String imageUrl, String originText, String type, String rarity, String[][] legality, String[][] ruling, int cmc, int multiverseId) {
        this.name = name;
        this.manaCost = manaCost;
        this.imageUrl = imageUrl;
        this.originText = originText;
        this.type = type;
        this.rarity = rarity;
        this.legality = legality;
        this.ruling = ruling;
        this.cmc = cmc;
        this.multiverseId = multiverseId;
    }

    public Card(JSONObject jsonCard) throws JSONException {
        this.name = jsonCard.getString("name");
        this.manaCost = jsonCard.optString("manaCost", null);
        this.imageUrl = jsonCard.getString("imageUrl");
        this.originText = jsonCard.getString("originalText");
        this.type = jsonCard.getString("type");
        this.rarity = jsonCard.getString("rarity");
//        this.legality = getLegality();
//        this.ruling = getRulings();
        this.cmc = jsonCard.getInt("cmc");
        this.multiverseId = jsonCard.getInt("multiverseid");
        cardImage = null; // Has not been fetched yet.
    }

    /**
     * Takes a string in json-format and returns an arraylist of Card-objects for given input.
     * Removes dupllicates by cardname
     * @param jsonStringCards
     * @return ArrayList containing the cards
     */
    public static ArrayList<Card> createCards(String jsonStringCards) throws JSONException {
        HashSet<String> hashCards = new HashSet<>();
        JSONArray jsonCards = new JSONObject(jsonStringCards).getJSONArray("cards");
        ArrayList<Card> cardlist = new ArrayList<>();
        for (int i = 0; i < jsonCards.length(); i++) {
            JSONObject jsonCard = jsonCards.getJSONObject(i);
            String nameString = jsonCard.getString("name");
            if (!hashCards.contains(nameString)) {
                cardlist.add(new Card(jsonCard));
                hashCards.add(nameString);
            }
        }
        return cardlist;
    }

    @Override
    public String toString() {
        return "Card{" +
                "name='" + name + '\'' +
                ", manaCost='" + manaCost + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }

    // Getters and Setters

    public void setCardImage(Drawable cardImage) {
        this.cardImage = cardImage;
    }


    public String getImageUrl() {
        return imageUrl;
    }

    public static String getTAG() {
        return TAG;
    }

    public String getName() {
        return name;
    }

    public String getManaCost() {
        return manaCost;
    }

    public String getOriginText() {
        return originText;
    }

    public String getType() {
        return type;
    }

    public String getRarity() {
        return rarity;
    }

    public String[][] getLegality() {
        return legality;
    }

    public String[][] getRuling() {
        return ruling;
    }

    public int getCmc() {
        return cmc;
    }

    public int getMultiverseId() {
        return multiverseId;
    }

    public Drawable getCardImage() {
        return cardImage;
    }
}
