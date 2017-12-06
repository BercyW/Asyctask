package security.bercy.com.weed2day2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
    to avoid ANR, we need to run as little work as possible in the main thread, large work should be ran in the work thread,
    we can create AsyncTask class, let large work runs in doInbackgrand method.



 */
public class MainActivity extends AppCompatActivity {
    int i = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        MyAsyncTask thread1 = new MyAsyncTask();
        thread1.execute();
        MyAsyncTask thread2 = new MyAsyncTask();
        thread2.execute();

        executor();

        runThread();
    }
    public void executor() {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            Runnable simpleExcutor = new SImpleExcutor(""+i);
            executorService.execute(simpleExcutor);
        }
        executorService.shutdown();
        while(!executorService.isTerminated()) {
            
        }
        Log.e("Thread", "complete" );
    }

    private void runThread() {

        new Thread() {
            public void run() {
                while (i++ < 20) {
                    try {
                        runOnUiThread(new Runnable() {

                            @Override
                            public void run() {
                                Log.d("UI Thread", "run: "+i);
                            }
                        });
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }
}
