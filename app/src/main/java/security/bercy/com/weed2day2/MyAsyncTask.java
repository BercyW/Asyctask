package security.bercy.com.weed2day2;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;


public class MyAsyncTask extends AsyncTask<String,Integer,String> {

    final String TAG ="MyAsyncTaskTag";




    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        Log.d(TAG, "onPreExecute: "+Thread.currentThread());
    }

    @Override
    protected String doInBackground(String... strings) {
        Log.d(TAG, "doInBackground:"+Thread.currentThread());
        delayTask();
        publishProgress(10);
        delayTask();

        return "Task complete";

    }
    public void delayTask() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        Log.d(TAG, "onPreExecute: "+Thread.currentThread());
        super.onProgressUpdate(values);

    }

    @Override
    protected void onPostExecute(String s) {
        Log.d(TAG, "onPostExecute: "+Thread.currentThread());
        super.onPostExecute(s);

    }


}
