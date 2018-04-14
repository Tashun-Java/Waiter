package waiter.tsc.com.waiter_data;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkError;
import com.android.volley.NoConnectionError;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by ANTIROOKIE on 4/14/2018.
 */

public class GetFoodData {
    Context context;
    ArrayList<FoodItem> foodItems=new ArrayList<>();
    RecyclerView.Adapter adapter;

    public GetFoodData(Context context){
        this.context=context;
    }
    public ArrayList<FoodItem> getFoodItems(final RecyclerView recyclerView) {

            String url = "https://database-helper.herokuapp.com/FoodItems";
            Toast.makeText(context, "OBJ" + "2.6", Toast.LENGTH_SHORT).show();
            JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET,url,null,
                    new Response.Listener<JSONArray>() {
                        @Override
                        public void onResponse(JSONArray response) {
                            int count = 0;
                            Toast.makeText(context, "OBJ" + "2.7", Toast.LENGTH_SHORT).show();
                            while (count < response.length()) {
                                try {
                                    JSONObject jsonObject = response.getJSONObject(count);
                                    FoodItem foodItem = new FoodItem(jsonObject.getString("name"), jsonObject.getString("image"), jsonObject.getString("price"));
                                    foodItems.add(foodItem);
                                    Toast.makeText(context, "OBJ" + "2.611", Toast.LENGTH_SHORT).show();
                                    count++;
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                            adapter=new RecyclerAdapter(foodItems);
                            Toast.makeText(context,"OBJ"+"3.5",Toast.LENGTH_SHORT).show();
                            recyclerView.setAdapter(adapter);
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(context, "Error in responding data..." + error.toString(), Toast.LENGTH_LONG).show();
                    error.printStackTrace();
                    if (error instanceof TimeoutError || error instanceof NoConnectionError) {
                        Toast.makeText(context,
                                "Time out No Connection", Toast.LENGTH_LONG).show();
                    } else if (error instanceof AuthFailureError) {
                        Toast.makeText(context, "AuthFailureError", Toast.LENGTH_SHORT).show();
                        //TODO
                    } else if (error instanceof ServerError) {
                        Toast.makeText(context, "ServerError", Toast.LENGTH_SHORT).show();
                        //TODO
                    } else if (error instanceof NetworkError) {
                        Toast.makeText(context, "NetworkError", Toast.LENGTH_SHORT).show();
                        //TODO
                    } else if (error instanceof ParseError) {
                        Toast.makeText(context, "ParseError...", Toast.LENGTH_SHORT).show();
                        //TODO
                    }
                }
            });

            NodeRequest.getInstance(context).addToRequestQueue(jsonArrayRequest);

        Toast.makeText(context,"OBJ"+"2.9",Toast.LENGTH_SHORT).show();
        return foodItems;



    }
}
