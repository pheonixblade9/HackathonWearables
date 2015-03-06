package iot.slalom.com.hackathon;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ConfirmActivity extends Activity {
    Order order;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm);
        Intent intent = this.getIntent();
        order = (Order) intent.getExtras().getParcelable("order");

        TextView finalOrderDisplay = (TextView) findViewById(R.id.final_order_display);

        finalOrderDisplay.setText(order.toString());

        Button confirmOrder = (Button) findViewById(R.id.orderConfirmation);

        confirmOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //make API call and show order complete screen
            }
        });
    }
}
