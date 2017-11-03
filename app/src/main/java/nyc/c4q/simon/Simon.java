package nyc.c4q.simon;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by amirahoxendine on 11/2/17.
 */

public class Simon {
    private int round;
    private ArrayList<String> simonPattern = new ArrayList<>();
    private String[] simonButtons = {"red","blue","green","yellow"};

    public void startSimon(){
        round++;
        Random rand = new Random();
        int x = rand.nextInt(3);

        for (int i= 0; i < round; i++){
            simonPattern.add(simonButtons[x]);
        }

    }

    public int getRound() {
        return round;
    }

    public ArrayList<String> getSimonPattern() {
        return simonPattern;
    }

}
