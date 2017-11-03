package nyc.c4q.simon;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    private Button green;
    private Button red;
    private Button blue;
    private Button yellow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        green = (Button) findViewById(R.id.green_button);
        red = (Button) findViewById(R.id.red_button);
        blue = (Button) findViewById(R.id.blue_button);
        yellow = (Button) findViewById(R.id.yellow_button);

        //delay code. Put button light pattern inside the runnable

        /*new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                // this code will be executed after 2 seconds
            }
        }, 2000);*/


    }
    public void start(View v){
        Simon startSimon = new Simon();
//TODO connect method to buttons, edit startSimon method

        /*green.setBackgroundResource(R.drawable.button_green_light);

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                red.setBackgroundResource(R.drawable.button_red_light);
            }
        }, 1000);
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                yellow.setBackgroundResource(R.drawable.button_yellow_light);
            }
        }, 2000);
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                blue.setBackgroundResource(R.drawable.button_blue_light);
            }
        }, 3000);*/
    }

    public void userInput(View v){
        //TODO read and evaluate user input. can create new method in Simon class.

    }
}
