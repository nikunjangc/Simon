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


    String TAG = "infinite loop";

    public void gamelunch(View view) {
        random = new Random();
        int pickcolor = random.nextInt(4) + 1;
        randomStore.add(pickcolor);
        Toast.makeText(this, "Level number :" + randomStore.size(), Toast.LENGTH_SHORT).show();
        for (int i : randomStore) {
            switch (pickcolor) {
                case 1:
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            yellow.startAnimation(animation);
                        }
                    }, 2000 * counter);
                    counter++;
                    break;
                case 2:
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            green.startAnimation(animation);
                        }
                    }, 2000 * counter);
                    counter++;
                    break;

                case 3:
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            red.startAnimation(animation);
                        }
                    }, 2000 * counter);
                    counter++;
                    break;
                case 4:
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            blue.startAnimation(animation);
                        }
                    }, 2000 * counter);
                    counter++;
                    break;

            }
        }

        Log.d(TAG, "gamelunch: " + counter);

    }

//    public void userPressedCheck(View view) {
//        boolean test = false;
//        switch (view.getId()) {
//            case R.id.yellow_button:
//                userStore.add(1);
//                break;
//            case R.id.green_button:
//
//                userStore.add(2);
//                break;
//            case R.id.red_button:
//
//                userStore.add(3);
//                break;
//            case R.id.blue_button:
//
//                userStore.add(4);
//                break;
//        }
//        for (int i = 0; i < randomStore.size(); i++) {
//            if (randomStore.get(i).equals(userStore.get(i))) {
//                test = true;
//            } else {
//
//                test = false;
//                break;
//            }
//
//
//        }
//        if (test == true) {
//            Toast.makeText(this, "Got a  good memory, Next level: " + userStore.size() + 1, Toast.LENGTH_LONG).show();
//            gamelunch(view);
//        } else if (test == false) {
//            Toast.makeText(this, "Not matched: Game Over " + userStore.size() + 1, Toast.LENGTH_LONG).show();
//            randomStore.clear();
//        }
//
//
//    }

    @Override
    public void onClick(View view) {
        boolean test = false;
        switch (view.getId()){
            case R.id.start:
                gamelunch(view);
                Log.d(TAG, "onClick: Start was clicked!");
                Toast.makeText(this, "Your turn now ", Toast.LENGTH_LONG).show();

        }


            switch (view.getId()) {
                case R.id.yellow_button:
                    userStore.add(1);
                    break;
                case R.id.green_button:

                    userStore.add(2);
                    break;
                case R.id.blue_button:

                    userStore.add(3);
                    break;
                case R.id.red_button:
                    userStore.add(4);
                    break;
            }
        if (randomStore.size() <= 0) {
                userStore.clear();
        }


        if (userStore.size() ==randomStore.size()) {
            for (int i = 0; i < randomStore.size(); i++) {
                if (randomStore.get(i).equals(userStore.get(i))) {
                    test = true;
                } else {
                    test = false;
                    break;
                }
            }
        }

        if (test) {
            Toast.makeText(this, "Got a  good memory, Next level: " + userStore.size() + 1, Toast.LENGTH_LONG).show();
            gamelunch(view);
        } else {
            Toast.makeText(this, "Not matched: Game Over " + userStore.size() + 1, Toast.LENGTH_LONG).show();
            randomStore.clear();
        }
    }
}



