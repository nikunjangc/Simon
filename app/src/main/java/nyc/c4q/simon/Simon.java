package nyc.c4q.simon;

import android.widget.Button;

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Random;

/**
 * Created by amirahoxendine on 11/2/17.
 */

public class Simon {
    private int round;
    private ArrayList<Button> simonPattern = new ArrayList<>();
    //private String[] simonButtons = {"red","blue","green","yellow"};
    private Button green;
    private Button red;
    private Button blue;
    private Button yellow;
    private Button [] simonButtons = {green, red, blue, yellow};

    public void startSimon(){
        round++;
        Random rand = new Random();
        int x = rand.nextInt(3);
        green = (Button) green.findViewById(R.id.green_button);
        red = (Button) red.findViewById(R.id.red_button);
        blue = (Button) blue.findViewById(R.id.blue_button);
        yellow = (Button) yellow.findViewById(R.id.yellow_button);

        for (int i= 0; i < round; i++){
            simonPattern.add(simonButtons[x]);
        }

//TODO add in timer function, lol check to see if this even almost works
        for (Button button: simonPattern){
            do {
                switch (button.getTag().toString()) {
                    case "green":
                        green.setBackgroundResource(R.drawable.button_green_light);
                        break;
                    case "red":
                        red.setBackgroundResource(R.drawable.button_red_light);
                        break;
                    case "blue":
                        blue.setBackgroundResource(R.drawable.button_blue_light);
                        break;
                    case "yellow":
                        yellow.setBackgroundResource(R.drawable.button_yellow_light);
                        break;
                }
            }while (simonPattern.iterator().hasNext());{

            }
        }

    }

    public int getRound() {
        return round;
    }

    public ArrayList<Button> getSimonPattern() {
        return simonPattern;
    }

}
