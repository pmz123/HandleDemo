package com.example.pmz.handledemo;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;


public class MainActivity extends ActionBarActivity {
    private int currentImageId=0;
    int []images=new int[]{
      R.mipmap.boy,R.mipmap.girl
    };
    private Handler handler = new Handler() {


        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 100:
                    System.out.println("============1");

                    imageView.setImageResource(images[currentImageId++%images.length]);
                    break;
                case 200:
                    System.out.println("============2");
                    imageView.setImageResource(R.mipmap.boy);
                    break;
            }
        }
    };
    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView= (ImageView) findViewById(R.id.imageView);
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                //Message message=handler.obtainMessage();
//                while (true) {
//                    handler.sendEmptyMessageDelayed(100, 200);
//
//                    handler.sendEmptyMessageDelayed(200, 200);
//
//                }
//            }
//        }).start();
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                handler.sendEmptyMessage(100);
            }
        },0,500);
    }


}
