package xyz.gitsieg.recyclerview2;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by gitsieg on 01.02.18.
 */

public class KommuneListAdapter extends RecyclerView.Adapter<KommuneListAdapter.KommuneViewHolder> {

    private ArrayList<Kommune> kommuneListen;
    private LayoutInflater mInflater;

    public KommuneListAdapter(Context context, ArrayList<Kommune> kList) {
        mInflater = LayoutInflater.from(context);
        this.kommuneListen = kList;
    }


    @Override
    public KommuneListAdapter.KommuneViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.recycler_kommune_item, parent, false);
        return new KommuneViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(KommuneListAdapter.KommuneViewHolder holder, int position) {
        System.out.println("POSITION " + position);
        Kommune denneKommunen = kommuneListen.get(position);
        holder.kommuneNavnView.setText(denneKommunen.kommunenavn);
        holder.kommuneNrView.setText(String.valueOf(denneKommunen.kommunenr));
        holder.fylkeView.setText(denneKommunen.fylke);

        System.out.println(denneKommunen.kommunenavn + " ");
    }

    @Override
    public int getItemCount() {
        Log.d("KLISTADAPTER", kommuneListen.size()+"");
        return kommuneListen.size();
    }


    class KommuneViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public final TextView kommuneNrView, kommuneNavnView,fylkeView;
        final KommuneListAdapter komAdapter;

        public KommuneViewHolder(View itemView, KommuneListAdapter kAdapter) {
            super(itemView);
            kommuneNrView = itemView.findViewById(R.id.kommunenr);
            kommuneNavnView = itemView.findViewById(R.id.kommunenavn);
            fylkeView = itemView.findViewById(R.id.fylke);
            this.komAdapter = kAdapter;
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {

        }
    }
}
