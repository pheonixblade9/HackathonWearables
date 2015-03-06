package iot.slalom.com.hackathon;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.wearable.view.WearableListView;

public class SectionActivity extends Activity implements WearableListView.ClickListener {

    // Sample dataset for the list
    String[] elements = {"Section A", "Section B", "Section C", "Section D"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_section);

        // Get the list component from the layout of the activity
        WearableListView listView =
                (WearableListView) findViewById(R.id.sectionList);

        // Assign an adapter to the list
        listView.setAdapter(new ListAdapter(this, elements));

        // Set a click listener
        listView.setClickListener(this);
    }

    // WearableListView click listener
    @Override
    public void onClick(WearableListView.ViewHolder v) {
        ListAdapter.ItemViewHolder itemHolder = (ListAdapter.ItemViewHolder) v;
        Order order = new Order();
        order.section = itemHolder.getText();

        Intent intent = new Intent(this, RowActivity.class);
        intent.putExtra("order", order);
        startActivity(intent);
    }

    @Override
    public void onTopEmptyRegionClick() {
    }
}