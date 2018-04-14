package waiter.tsc.com.waiter_data;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by ANTIROOKIE on 4/14/2018.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {

    ArrayList<FoodItem> foodItems=new ArrayList<>();
    public RecyclerAdapter (ArrayList<FoodItem> foodItems){
        this.foodItems=foodItems;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item,parent,false);
        MyViewHolder myViewHolder=new MyViewHolder(view);
        return myViewHolder;

    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.name.setText(foodItems.get(position).getName());
        holder.image.setText(foodItems.get(position).getImage());
        holder.price.setText(foodItems.get(position).getPrice());


    }

    @Override
    public int getItemCount() {
        return foodItems.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView name,image,price;
        public MyViewHolder(View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.rname);
            image=itemView.findViewById(R.id.rimage);
            price=itemView.findViewById(R.id.rprice);
        }
    }
}
