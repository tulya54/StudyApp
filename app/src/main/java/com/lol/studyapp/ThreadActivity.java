package com.lol.studyapp;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class ThreadActivity extends AppCompatActivity {

    private static final String URL = "https://sun2.dataix-kz-akkol.userapi.com/impg/IqrLsqGvyeAd7d8cpMsiwOdLnMjepygVr14OOQ/yZZk1UPhb0s.jpg?size=1280x720&quality=96&sign=c73eda5e2aff2c9b6c8cf848d3b3ba5b&type=album";
    private ImageView ivImage;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread);
        ivImage = findViewById(R.id.ivImage);
        ((Button)findViewById(R.id.btnLoadImage)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //  Error
//                onThreadLoadImage1();
                //  Not error
               //     onThread();
                //  Async task
//                    onThreadAsyncTask();
                //  Rx (Reactive)
//                  onThreadRx();

              //  onThreadLooper();
//                onThreadLooper();

            }
        });
    }

    private void onThreadLoadImage1() {
        InputStream is;
        //start a background thread for networking
        new Thread(new Runnable() {
            public void run(){
                try {
//                    //download the drawable
//                    final Drawable drawable = Drawable.createFromStream((InputStream) new URL(URL).getContent(), "src");
//                    //edit the view in the UI thread
//                    ivImage.post(new Runnable() {
//                        public void run() {
//                            ivImage.setImageDrawable(drawable);
//                        }
//                    });

                    URL url = new URL(URL);
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    conn.setReadTimeout(60000 /* milliseconds */);
                    conn.setConnectTimeout(65000 /* milliseconds */);
                    conn.setRequestMethod("GET");
                    conn.setDoInput(true);
                    conn.connect();
                    int response = conn.getResponseCode();
                    //Log.d(TAG, "The response is: " + response);
                    InputStream is = conn.getInputStream();


                    BufferedInputStream bufferedInputStream = new BufferedInputStream(is);

                    Bitmap bmpImage = BitmapFactory.decodeStream(bufferedInputStream);

//                    Handler handler = new Handler(Looper.getMainLooper());
//                    handler.post(new Runnable() {
//                        @Override
//                        public void run() {
//                            ivImage.setImageBitmap(bmpImage);
//                        }
//                    });

                    ivImage.post(new Runnable() {
                        public void run() {
                            ivImage.setImageBitmap(bmpImage);
                        }
                    });

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private void onThread() {
        String first = "First Thread ";
        String second = "Second Thread ";
        Thread thread1 = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    try {
                        Log.d("TAG_THREAD", first + i);
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    // Log.d("TAG_THREAD", second + i);
                }
            }
        };
        Thread thread2 = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    try {
                        Log.d("TAG_THREAD", second + i);
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    // Log.d("TAG_THREAD", second + i);
                }
            }
        };


        thread1.start();
        thread2.start();
    }

    private void onThreadAsyncTask() {
        DownloadImageTask task = new DownloadImageTask(ivImage);
        task.execute(URL);

    }

    private void onThreadRx() {
        Picasso.with(this)
                .load(URL)
              //  .placeholder(R.drawable.placeholder) //optional
                .resize(200, 200)         //optional
           //     .centerCrop()                        //optional
                .into(ivImage);
    }

    private void sendMSG(int msg) {
        Toast.makeText(this, "Msg " + msg, Toast.LENGTH_SHORT).show();
    }

    private void onThreadLooper() {
        mHandler = new Handler() {
            public void handleMessage(android.os.Message msg) {
                sendMSG(msg.what);
                Log.d("Handle", "");
                // process incoming messages here
                // this will run in non-ui/background thread
            }
        };

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    try {
                        //  Thread.sleep(0);
                        TimeUnit.MILLISECONDS.sleep(1500);
                        mHandler.sendEmptyMessage(i);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        t.start();
    }
    public Handler mHandler;














    private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
        ImageView bmImage;
        public DownloadImageTask(ImageView bmImage) {
            this.bmImage = bmImage;
        }

        protected Bitmap doInBackground(String... urls) {
            String urldisplay = urls[0];
            Bitmap mIcon11 = null;
            try {
                InputStream in = new java.net.URL(urldisplay).openStream();
                mIcon11 = BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return mIcon11;
        }

        protected void onPostExecute(Bitmap result) {
            bmImage.setImageBitmap(result);
        }
    }
}