package security.bercy.com.weed2day2;

import android.util.Log;

/**
 * Created by Bercy on 12/6/17.
 */

public class SImpleExcutor implements Runnable {

    String commant;





    public SImpleExcutor(String comment) {
        this.commant = comment;
    }



    @Override
    public void run() {

        Log.e("Start comment = "+commant, "run: "+Thread.currentThread().getName() );
        processCommand();
        Log.e("End = "+commant, "run: "+Thread.currentThread().getName() );

    }


    public void processCommand() {
        try {
            Thread.sleep(1000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return this.commant;
    }
}
