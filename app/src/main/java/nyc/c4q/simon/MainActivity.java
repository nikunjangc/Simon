package nyc.c4q.simon;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
private Button test;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //@NIKE: this is how you change the button with java
        test = (Button) findViewById(R.id.green_btn_top_left);
        test.setBackgroundResource(R.drawable.button_top_left_alt);


    }
}
