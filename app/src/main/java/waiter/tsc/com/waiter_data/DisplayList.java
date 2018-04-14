package waiter.tsc.com.waiter_data;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;

public class DisplayList extends AppCompatActivity {
    //NodeRequest nodeRequest;
    // ViewAdapter viewAdapter;
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;

    ArrayList<FoodItem> foodItems=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_list);
        recyclerView = (RecyclerView) findViewById(R.id.recycleView);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        Toast.makeText(this,"OBJ"+"2.5",Toast.LENGTH_SHORT).show();
        GetFoodData getFoodData=new GetFoodData(this);
          getFoodData.getFoodItems(recyclerView);
        Toast.makeText(this,"OBJ"+"3",Toast.LENGTH_SHORT).show();

        Toast.makeText(this,"OBJ"+"4",Toast.LENGTH_SHORT).show();
    }
}