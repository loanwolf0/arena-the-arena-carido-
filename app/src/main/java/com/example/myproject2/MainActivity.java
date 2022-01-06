package com.example.myproject2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import com.google.firebase.auth.FirebaseAuth;

public class  MainActivity extends AppCompatActivity {
    public static int SPLASH_SCREEN=2500;

    Animation topAnim ,bottomAnim,pbA;
    LinearLayout lt;
    ImageView img;
    ProgressBar pb;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        // animation
        topAnim = AnimationUtils.loadAnimation(this, R.anim.my_animation);
        bottomAnim = AnimationUtils.loadAnimation(this, R.anim.my_bottom_animation);
        pbA = AnimationUtils.loadAnimation(this, R.anim.progress_bar_anim);

        // hooks all variable
        lt = findViewById(R.id.linearBottom);
        img = findViewById(R.id.imageView2);
        pb = findViewById(R.id.progess_bar);

        //set Animation
        img.setAnimation(topAnim);
        lt.setAnimation(bottomAnim);
        pb.setAnimation(pbA);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                if (mAuth.getCurrentUser() != null){

                    Intent intent = new Intent(MainActivity.this , user_main_interface.class);
                    startActivity(intent);
                    finish();

                }else {

                Intent intent = new Intent(MainActivity.this, log_in.class);
                startActivity(intent);
                finish();

                }

            }
        }, SPLASH_SCREEN);


    }
}