package waiter.tsc.com.waiter_data;

/**
 * Created by ANTIROOKIE on 4/15/2018.
 */

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by ANTIROOKIE on 3/28/2018.
 */

public class ViewAdapter extends PagerAdapter {
    private LayoutInflater layoutInflater;
    private Context cxt;
    private ArrayList<FoodItem> foodItems;

    public ViewAdapter(Context context,ArrayList<FoodItem> foodItems){
        this.cxt=context;
        this.foodItems=foodItems;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return false;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        layoutInflater=(LayoutInflater)cxt.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view=layoutInflater.inflate(R.layout.viewpager_activity,container,false);
        ImageView imageView=(ImageView)view.findViewById(R.id.imageView);
        Picasso.with(cxt).load((foodItems.get(position)).getImage()).into(imageView);

        return view;
    }

}