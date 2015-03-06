package iot.slalom.com.hackathon;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.wearable.view.WearableListView;

public class ItemActivity extends Activity implements WearableListView.ClickListener {

    // Sample dataset for the list
    String[] elements = {"Burger", "Hot Dog", "Popcorn"};
    Order order;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);

        // Get the list component from the layout of the activity
        WearableListView listView =
                (WearableListView) findViewById(R.id.itemList);

        // Assign an adapter to the list
        listView.setAdapter(new ListAdapter(this, elements));

        // Set a click listener
        listView.setClickListener(this);
        Intent intent = this.getIntent();
        order = (Order) intent.getExtras().getParcelable("order");
    }

    // WearableListView click listener
    @Override
    public void onClick(WearableListView.ViewHolder v) {
        ListAdapter.ItemViewHolder itemHolder = (ListAdapter.ItemViewHolder) v;

        order.item = itemHolder.getText();

        Intent intent = new Intent(this, QuantityActivity.class);
        intent.putExtra("order", order);
        startActivity(intent);
    }

    @Override
    public void onTopEmptyRegionClick() {
    }
}