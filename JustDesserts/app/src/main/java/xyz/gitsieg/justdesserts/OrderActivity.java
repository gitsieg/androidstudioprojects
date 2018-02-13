package xyz.gitsieg.justdesserts;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class OrderActivity extends AppCompatActivity {
    RadioGroup orderOptionsGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        orderOptionsGroup = findViewById(R.id.order_options);


    }

    public void showPickupOption(View view) {
        int checkedId = orderOptionsGroup.getCheckedRadioButtonId();

        switch (checkedId) {
            case R.id.next_year_delivery:
                showOrderMessage("Next year oke");
                break;
            case R.id.unknown_time_delivery:
                showOrderMessage("Dunno oke");
                break;
            case R.id.pickup:
                showOrderMessage("Order never picked up");
                break;
        }
    }

    public void showOrderMessage(String message) {
        MainActivity.displayToast(this, message);
    }
}
