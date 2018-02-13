package xyz.gitsieg.recyclerview2;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by gitsieg on 01.02.18.
 */
// "Kommunenr":0101,"Kommunenavn":"Halden","Adm. senter":"Halden","Fylke":"Østfold","Folketall":30790,"Areal":642.34,"Målform":"Bokmål","Ordfører":"Thor Edquist","Parti":"Høyre"
public class Kommune {
    int kommunenr, folketall;
    double areal;
    String kommunenavn, fylke;

    public Kommune(JSONObject jsonKommune) {
        this.kommunenr = jsonKommune.optInt("Kommunenr");
        this.folketall = jsonKommune.optInt("Folketall");
        this.areal = jsonKommune.optDouble("Areal");
        this.kommunenavn = jsonKommune.optString("Kommunenavn", null);
        this.fylke = jsonKommune.optString("Fylke");
    }

    @Override
    public String toString() {
        return this.kommunenavn;
    }

    public static ArrayList<Kommune> createKommuneliste(String jsonFile)
            throws JSONException, NullPointerException {

        ArrayList<Kommune> kList = new ArrayList<>();
        JSONObject jsonKommuner = new JSONObject(jsonFile);
        JSONArray jsonArrKommuner = jsonKommuner.getJSONArray("kommuner");

        for (int i = 0; i < jsonArrKommuner.length(); i++) {
            kList.add( new Kommune(jsonArrKommuner.getJSONObject(i)));
        }
        return kList;
    }

}
