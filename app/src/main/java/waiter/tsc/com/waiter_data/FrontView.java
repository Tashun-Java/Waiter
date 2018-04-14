package waiter.tsc.com.waiter_data;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class FrontView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_front_view);
        Toast.makeText(this,"OBJ"+"1",Toast.LENGTH_SHORT).show();
    }

    public void goToIntent(View view) {
        Intent intent=new Intent(this, DisplayList.class);
        startActivity(intent);
        Toast.makeText(this,"OBJ"+"2",Toast.LENGTH_SHORT).show();
    }
}
