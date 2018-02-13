package xyz.gitsieg.recyclerdemorepeat;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by gitsieg on 07.02.18.
 */

public class KommuneAdapter extends RecyclerView.Adapter<KommuneAdapter.KommuneViewHolder> {

    private static final String TAG = KommuneAdapter.class.getSimpleName();

    private ArrayList<Kommune> kommunelisten;
    private LayoutInflater mInflater;

    public KommuneAdapter(Context context, ArrayList<Kommune> countyList) {
        Log.d(TAG, "KommuneAdapter created");
        this.mInflater = LayoutInflater.from(context);
        kommunelisten = countyList;
    }

    @Override
    public KommuneViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder");
        View mItemView = mInflater.inflate(R.layout.kommune_item_list, parent, false);
        return new KommuneViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(KommuneViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder");
        Kommune denneKommunen = kommunelisten.get(position);
        holder.ordforer.setText(denneKommunen.ordforer);
        holder.befolkning.setText(String.valueOf(denneKommunen.befolkning));
        holder.kommunenavn.setText(denneKommunen.kommuneNavn);
        holder.fylke.setText(denneKommunen.fylke);
    }

    @Override
    public int getItemCount() {
        Log.d(TAG, "getItemCount");
        return kommunelisten.size();
    }

    public class KommuneViewHolder extends RecyclerView.ViewHolder {
        private final String TAG = KommuneViewHolder.class.getSimpleName();
        public final TextView  befolkning,  kommunenavn, fylke, ordforer;
        final KommuneAdapter kAdapter;

        public KommuneViewHolder(View itemView, KommuneAdapter adapter) {
            super(itemView);
            Log.d(TAG, "KommuneViewHolder created");
            kommunenavn = itemView.findViewById(R.id.txt_kommuneNavn);
            befolkning = itemView.findViewById(R.id.txt_befolkning);
            fylke = itemView.findViewById(R.id.txt_fylke);
            ordforer = itemView.findViewById(R.id.txt_ordfører);
            kAdapter = adapter;
        }

    }
}
