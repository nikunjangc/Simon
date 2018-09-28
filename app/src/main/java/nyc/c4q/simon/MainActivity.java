package nyc.c4q.simon;

import android.content.SharedPreferences;
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
    private Button reset;
    private TextView hint;
    private boolean userPressed;
    private int counter = 1;
    private TextView scoreDisplay, bestScoreDisplay;

    AlphaAnimation animation;
    boolean test = true;

    String s="";

    int x;
    boolean keepProgramRunning = true;
    Random random;
    ArrayList<Integer> randomStore = new ArrayList<>();
    ArrayList<Integer> userStore = new ArrayList<>();
    Handler handler = new Handler();
    int count = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        animation = new AlphaAnimation(1f, 0f);
        setupView();
        animation.setDuration(800);
    }

    public void setupView() {
        hint=(TextView) findViewById(R.id.hint);
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
        reset = (Button) findViewById(R.id.reset);
        reset.setOnClickListener(this);
        bestScoreDisplay = (TextView) findViewById(R.id.best_score_display);
        scoreDisplay = (TextView) findViewById(R.id.score_display);


    }

    @Override
    public void onClick(View view) {


        int i = 0;
        Button button=(Button) view;

        switch (button.getId()) {
            case R.id.reset:
           //     Log.d(TAG, "reset up was pressed");
                randomStore.clear();
                userStore.clear();
                start.setVisibility(View.VISIBLE);
                reset.setVisibility(View.GONE);
                test=true;


                break;
            case R.id.start:
                randomStore.clear();
                userStore.clear();
                start.setVisibility(View.GONE);
                reset.setVisibility(View.VISIBLE);
                beginGameAnimation();
            //    Log.d(TAG, "onClick: Start was clicked!");
                Toast.makeText(this, "Simon says, Level number :" + 1, Toast.LENGTH_SHORT).show();
                gamelunch(view);
                break;
            case R.id.yellow_button:
                userStore.add(0);
            //    Log.d(TAG, "userstore 0");
                testAnswer(view);
                break;
            case R.id.green_button:

                userStore.add(1);
              //  Log.d(TAG, "userstore 1");
                testAnswer(view);
                break;

            case R.id.blue_button:

                userStore.add(2);
             //   Log.d(TAG, "userstore 2");
                testAnswer(view);
                break;

            case R.id.red_button:
                userStore.add(3);
            //    Log.d(TAG, "userstore 3");
                testAnswer(view);
                break;

            default:
                    break;
          }



    }

    String TAG = "infinite loop";

    public void gamelunch(View view) {

           int i=0;
           random = new Random();
            int pickcolor = random.nextInt(4) ; //0,1,2,3

            Log.d(TAG, "random number "+pickcolor);

            randomStore.add(pickcolor);     //stores the number
           int b=randomStore.size();
        //     Log.d(TAG,"randomstore size "+b);
             counter=1;

    do {
        switch (randomStore.get(i)) {
            case 0:
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        yellow.startAnimation(animation);
                    }
                }, 1600 * counter);
                counter++;
          //      Log.d(TAG, "random number 0" );
                break;
            case 1:
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        green.startAnimation(animation);
                    }
                }, 1600 * counter);
                counter++;
          //      Log.d(TAG, "random number 1" );
                break;


            case 2:
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        blue.startAnimation(animation);
                    }
                }, 1600 * counter);
                counter++;
         //       Log.d(TAG, "random number 2" );
                break;
            case 3:
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        red.startAnimation(animation);
                    }
                }, 1600 * counter);
                counter++;
           //     Log.d(TAG, "random number 3");
                break;

        }

        i++;
        b--;
    }

        while ( b>0);

      // hint.setText(s);
      //  Log.d(TAG,"random."+ String.valueOf(randomStore.size()));

     //   Log.d(TAG, "Simon says your turn");
        userStore.clear();
    }

   public void testAnswer(View view){
        if(test) {
            if ((randomStore.size() > 0 && userStore.size() > 0)) {

                for (int l = 0; l < userStore.size(); l++) {
                    if (randomStore.get(l).equals(userStore.get(l))) {
                        //    Log.d(TAG, "size:r" + randomStore.size() + "u" + userStore.size());
                        //   Log.d(TAG, "r" + randomStore.get(l) + "u" + userStore.get(l));
                    } else {
                        test = false;
                        Toast.makeText(this, "Simon says, You failed :", Toast.LENGTH_SHORT).show();
                        // Log.d(TAG, "size:r" + randomStore.size() + "u" + userStore.size());
                        //  Log.d(TAG, "r" + randomStore.get(l) + "u" + userStore.get(l));
                        count = 0;
                        userStore.clear();
                        randomStore.clear();
                        scoreDisplay.setText(String.valueOf(0));
                        gamelunch(view);

                    }
                }
            }
        }
    if(userStore.size()==randomStore.size() && test){

               count += 1;
               Log.d(TAG, "userstore " + userStore.size());
               Toast.makeText(this, "  Level: " + count, Toast.LENGTH_LONG).show();
               scoreDisplay.setText(String.valueOf(randomStore.size()));
             //  bestScoreDisplay.setText(String.valueOf(randomStore.size()));
               userStore.clear();
               gamelunch(view);
           }

   }

   public void beginGameAnimation(){
        int j=0;
       do {

           handler.postDelayed(new Runnable() {
               @Override
               public void run() {
                   yellow.startAnimation(animation);
                   counter++;
                   green.startAnimation(animation);
                   counter++;
                   blue.startAnimation(animation);
                   counter++;
                   red.startAnimation(animation);
                   counter++;

               }
           }, 800 * counter);
           counter++;


           //     Log.d(TAG, "random number 3");

        j++;
       }
       while(j<3);
       try {
           if(j==3){

           }else {
               wait();
           }

       } catch (InterruptedException e) {
           e.printStackTrace();
       }
   }


}







