package xyz.gitsieg.recyclerdemorepeat;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by gitsieg on 07.02.18.
 */

public class Kommune {
    int kommunenr, befolkning;
    double areal;
    String kommuneNavn, fylke, ordforer;

    public Kommune(int kommunenr, int befolkning, double areal, String kommuneNavn, String fylke, String ordforer) {
        this.kommunenr = kommunenr;
        this.befolkning = befolkning;
        this.areal = areal;
        this.kommuneNavn = kommuneNavn;
        this.fylke = fylke;
        this.ordforer = ordforer;
    }

    public Kommune(JSONObject jsonKommune) {
        this.kommunenr = jsonKommune.optInt("Kommunenr", -1);
        this.befolkning = jsonKommune.optInt("Folketall", -1);
        this.areal = jsonKommune.optDouble("Areal", -1);
        this.kommuneNavn = jsonKommune.optString("Kommunenavn", "Ukjent");
        this.fylke = jsonKommune.optString("Fylke", "Ukjent");
        this.ordforer = jsonKommune.optString("Ordfører", "Ukjent");
    }

    protected static ArrayList<Kommune> createKommuneData(String jsonKommuner) throws JSONException {
        ArrayList<Kommune> kommuneliste = new ArrayList<>();
        JSONObject obj = new JSONObject(jsonKommuner);
        JSONArray jsonKommuneArray = obj.getJSONArray("kommuner");

        for (int i = 0; i < jsonKommuneArray.length(); i++) {
            JSONObject jsonKommune = jsonKommuneArray.getJSONObject(i);
            Kommune kommune = new Kommune(jsonKommune);
            kommuneliste.add(kommune);
        }

        return kommuneliste;
    }
}
