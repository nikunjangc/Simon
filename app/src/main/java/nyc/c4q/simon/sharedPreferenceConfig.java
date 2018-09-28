package nyc.c4q.simon;

import android.content.Context;
import android.content.SharedPreferences;

public class sharedPreferenceConfig {
    private SharedPreferences sharedPreferences;
    private Context context;

    public sharedPreferenceConfig(Context context){
        this.context=context;
        sharedPreferences= context.getSharedPreferences(context.getResources().getString(R.string.best_score_display),Context.MODE_PRIVATE);

    }

}
