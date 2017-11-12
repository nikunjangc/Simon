package nyc.c4q.simon;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button green;
    private Button red;
    private Button blue;
    private Button yellow;
    private Button start;
    private Button giveUp;
    private boolean userPressed;
    private int counter = 1;
    private TextView scoreDisplay, bestScoreDisplay;
    // AlphaAnimation buttonAnimation;
    AlphaAnimation animation;

    int x;
    boolean keepProgramRunning = true;
    Random random;
    ArrayList<Integer> randomStore = new ArrayList<>();
    ArrayList<Integer> userStore = new ArrayList<>();
    Handler handler = new Handler();

    //  Button buttons[] = new Button[4];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        animation = new AlphaAnimation(1f, 0f);
        setupView();

        animation.setDuration(1000);
    }

    public void setupView() {
        green = (Button) findViewById(R.id.green_button);
        green.setOnClickListener(this);
        red = (Button) findViewById(R.id.red_button);
        red.setOnClickListener(this);
        blue = (Button) findViewById(R.id.blue_button);
        blue.setOnClickListener(this);
        yellow = (Button) findViewById(R.id.yellow_button);
        yellow.setOnClickListener(this);
        start = (Button) findViewById(R.id.start);
        start.setOnClickListener(this);
        giveUp = (Button) findViewById(R.id.giveUp);
        giveUp.setOnClickListener(this);
        bestScoreDisplay = (TextView) findViewById(R.id.best_score_display);
        scoreDisplay = (TextView) findViewById(R.id.score_display);


    }

    @Override
    public void onClick(View view) {
        boolean test = false;
        int count = 1;
        int i = 0;


            switch (view.getId()) {
                case R.id.giveUp:
                    Log.d(TAG, "give up was pressed");
                    randomStore.clear();
                    userStore.clear();
                    start.setVisibility(View.VISIBLE);
                    giveUp.setVisibility(View.GONE);
                    break;
                case R.id.start:
                    start.setVisibility(View.GONE);
                    giveUp.setVisibility(View.VISIBLE);
                    Log.d(TAG, "onClick: Start was clicked!");

                    gamelunch(view);
                    Log.d(TAG, "what's the problem");

                    Toast.makeText(this, "Simon says, Level number :" + randomStore.size(), Toast.LENGTH_SHORT).show();
                    // a=randomStore.size();
                    break;

                case R.id.yellow_button:
                    userStore.add(0);
                    Log.d(TAG, "userstore 0");

                    break;
                case R.id.green_button:

                    userStore.add(1);
                    Log.d(TAG, "userstore 1");

                    break;
                case R.id.blue_button:

                    userStore.add(2);
                    Log.d(TAG, "userstore 2");

                    break;
                case R.id.red_button:
                    userStore.add(3);
                    Log.d(TAG, "userstore 3");

                    break;
            }
            for (int counter = 0; counter < randomStore.size()-1; counter++) {
                if (randomStore.get(counter).equals(userStore.get(counter))) {
                    test = true;
                } else {
                    test = false;
                    userStore.clear();
                    randomStore.clear();
                    // Log.d(TAG, "Not matched ,the random numbre" + randomStore.get(i) + "the user clicked number" + userStore.get(i))
                }
            }

        if (true) {
            scoreDisplay.setText(String.valueOf(userStore.size()));
            count += 1;
            // Log.d(TAG, "userstore " +userStore.size());
            userStore.clear();
            Toast.makeText(this, " matched: Next Level: " + count, Toast.LENGTH_LONG).show();
            gamelunch(view);
        }
    }

    String TAG = "infinite loop";

    public void gamelunch(View view) {

            int i=0;


           random = new Random();
            int pickcolor = random.nextInt(4) ; //,2,3,4

            Log.d(TAG, "random number "+pickcolor);

            randomStore.add(pickcolor);     //stores the number
           int b=randomStore.size();
             Log.d(TAG,"randomstore size "+b);



    do {
        switch (randomStore.get(i)) {
            case 0:
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        yellow.startAnimation(animation);
                    }
                }, 2000 * counter);
                counter++;
                Log.d(TAG, "random number 0" );
                break;
            case 1:
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        green.startAnimation(animation);
                    }
                }, 2000 * counter);
                counter++;
                Log.d(TAG, "random number 1" );
                break;


            case 2:
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        blue.startAnimation(animation);
                    }
                }, 2000 * counter);
                counter++;
                Log.d(TAG, "random number 2" );
                break;
            case 3:
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        red.startAnimation(animation);
                    }
                }, 2000 * counter);
                counter++;
                Log.d(TAG, "random number 3");
                break;

        }
        i++;
        b--;
    }
        while ( b>0);



        Toast.makeText(this, "Simon says,Your turn now ", Toast.LENGTH_LONG).show();
        userStore.clear();
        Log.d(TAG, "ramdom store is running");

    }


}







