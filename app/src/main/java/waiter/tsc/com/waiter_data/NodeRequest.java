package waiter.tsc.com.waiter_data;

import android.content.Context;

import com.android.volley.Cache;
import com.android.volley.Network;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

/**
 * Created by ANTIROOKIE on 4/14/2018.
 */

class NodeRequest {
    private static NodeRequest nodeRequest;
    private RequestQueue requestQueue;
    private static Context context;

    // private constructor for singleton
    private  NodeRequest(Context context){
        this.context=context;
        requestQueue=getRequestQueue();

    }

    //returning the request queue
    public RequestQueue getRequestQueue() {
        if (requestQueue==null){
            requestQueue= Volley.newRequestQueue(context.getApplicationContext());
        }
        return requestQueue;
    }

    // returning the singleton Noderequest object
    public static synchronized NodeRequest getInstance(Context context) {
        if (nodeRequest==null){
            nodeRequest=new NodeRequest(context);
        }
        return nodeRequest;
    }

    public<T> void addToRequestQueue(Request<T> request){
        requestQueue.add(request);
    }
//    public void setArray(ViewAdapter viewAdapter, Context context) {
//
//        String url = "https://database-helper.herokuapp.com/FoodItems";
//        Cache cache =new DiskBasedCache(context.getCacheDir(),1024*1024);
//        Network network = new BasicNetwork(new HurlStack());
//        RequestQueue requestQueue = new RequestQueue(cache,network);
//        requestQueue.start();
//
//        StringRequest stringRequest;
//
      //error. printstacktrace
        //requestQueue.add(stringRequest);
 //   }
}

