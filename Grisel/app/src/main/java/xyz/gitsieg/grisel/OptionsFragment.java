package xyz.gitsieg.grisel;


import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.util.SparseIntArray;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class OptionsFragment extends DialogFragment implements View.OnClickListener {
    Button btn20, btn30, btn40;

    public OptionsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate
        View view = inflater.inflate(R.layout.fragment_options, container, false);
        btn20 = view.findViewById(R.id.btn_lifeTotal20);
        btn30 = view.findViewById(R.id.btn_lifeTotal30);
        btn40 = view.findViewById(R.id.btn_lifeTotal40);

        btn20.setOnClickListener(this);
        btn30.setOnClickListener(this);
        btn40.setOnClickListener(this);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();

        int width = getResources().getDimensionPixelSize(R.dimen.options_fragment_width);
        int height = getResources().getDimensionPixelSize(R.dimen.options_fragment_height);

        getDialog().getWindow().setLayout(width, height);
        getDialog().getWindow().setGravity(Gravity.TOP);
    }

    @Override
    public void onClick(View view) {
        Button btn = (Button) view;
        String newTextValue = btn.getText().toString();
        TextView lifeTotalView;
        TextView infectView;
        SparseIntArray lifeTotalArray = MainActivity.getLifeTotalArray();
        SparseIntArray infectArray = MainActivity.getInfectArray();


        for (int i = 0; i < lifeTotalArray.size(); i++) {
            lifeTotalView = getActivity().findViewById(lifeTotalArray.valueAt(i));
            lifeTotalView.setText(newTextValue);
            infectView = getActivity().findViewById(infectArray.valueAt(i));
            infectView.setText("0");
        }
    }
}
