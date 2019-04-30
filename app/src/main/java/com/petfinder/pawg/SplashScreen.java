package com.petfinder.pawg;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

/**
 * This class is used for displaying the Welcome Screen.
 */
public class SplashScreen extends AppCompatActivity {

    ImageView splash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        splash = (ImageView) findViewById(R.id.splash);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_screen);


        SplashLaunch sl = new SplashLaunch();
        sl.start();


    }

    private class SplashLaunch extends Thread {

        public void run() {
            try {
                sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Intent i = new Intent(SplashScreen.this, MainActivity.class);
            startActivity(i);
            SplashScreen.this.finish();

        }
    }


}

