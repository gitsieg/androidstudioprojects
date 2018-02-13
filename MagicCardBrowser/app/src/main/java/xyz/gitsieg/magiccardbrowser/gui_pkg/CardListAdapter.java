package xyz.gitsieg.magiccardbrowser.gui_pkg;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.zip.Inflater;

import xyz.gitsieg.magiccardbrowser.R;
import xyz.gitsieg.magiccardbrowser.card_pkg.Card;

/**
 * Created by gitsieg on 12.02.18.
 */

public class CardListAdapter extends RecyclerView.Adapter<CardListAdapter.CardViewHolder> {

    Context context;
    ArrayList<Card> cardList;
    LayoutInflater mInflater;
    public CardListAdapter(Context context, ArrayList<Card> cardlist) {
        this.context = context;
        this.cardList = cardlist;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public CardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.card_list_item, parent, false);
        return new CardViewHolder(view,this);
    }

    @Override
    public void onBindViewHolder(CardViewHolder holder, int position) {
        Card thisCard = cardList.get(position);
        holder.cardName.setText(thisCard.getName());
        holder.cardType.setText(thisCard.getType());
        holder.cardManaCost.setText(thisCard.getManaCost());
    }

    @Override
    public int getItemCount() {
        return cardList.size();
    }


    // Binds layouts/views to variables
    public class CardViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        final TextView cardName, cardType, cardManaCost;
        final CardListAdapter cardAdapter;

        public CardViewHolder(View itemView, CardListAdapter adapter) {
            super(itemView);
            cardName = itemView.findViewById(R.id.txt_cardName);
            cardType = itemView.findViewById(R.id.txt_cardType);
            cardManaCost = itemView.findViewById(R.id.txt_manaCost);
            cardAdapter = adapter;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Toast.makeText(context, "Herrroooo", Toast.LENGTH_SHORT).show();
        }
    }
}
