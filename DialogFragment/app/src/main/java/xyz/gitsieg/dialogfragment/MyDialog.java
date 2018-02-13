package xyz.gitsieg.dialogfragment;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by gitsieg on 27.01.18.
 */

public class MyDialog extends DialogFragment implements View.OnClickListener {
    Button btn20, btn30, btn40;
    View view;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.my_dialog, null);
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
        int width = getResources().getDimensionPixelSize(R.dimen.popup_width);
        int height = getResources().getDimensionPixelSize(R.dimen.popup_height);
        getDialog().getWindow().setLayout(width, height);
    }

    @Override
    public void onClick(View view) {

        // Have to use getActivity. The activity the fragment lives in. This fragment does not exist
        // inside the layout for main_activity.
        TextView tview = getActivity().findViewById(R.id.p1_id);
        if (view.getId() == R.id.btn_lifeTotal20) {
            tview.setText(20+"");
            Toast.makeText(getActivity(), "20 clicked", Toast.LENGTH_SHORT).show();
        }
        if (view.getId() == R.id.btn_lifeTotal30) {
            tview.setText(30+"");
            Toast.makeText(getActivity(), "30 clicked", Toast.LENGTH_SHORT).show();
        }
        if (view.getId() == R.id.btn_lifeTotal40) {
            tview.setText(40+"");
            Toast.makeText(getActivity(), "40 clicked", Toast.LENGTH_SHORT).show();
        }
        dismiss();
    }
}
