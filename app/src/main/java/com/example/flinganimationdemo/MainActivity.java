package com.example.flinganimationdemo;

import android.content.Intent;
import android.support.animation.DynamicAnimation;
import android.support.animation.FlingAnimation;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //A cool thing is that you can manually declare an onclick event in the text view of the xml
    //and by clicking the red light bulb, you can tell it to create the onClick listener automatically.
    public void flingIt(View view) {
        ImageView neutral = findViewById(R.id.neutral);


        //This constructor will grab our emoji icon, as well as the X-coordinate of our layout's ImageView
        FlingAnimation flingAnimation = new FlingAnimation(neutral, DynamicAnimation.X);

        //By default, an instance is configured to use 0 pixels/second as its initial velocity.
        //That means the animation would stop as soon as it's started.

        //Lets give flingAnimation some values
        flingAnimation.setStartVelocity(100f);
        flingAnimation.setFriction(0.5f);

        //By default, Friction is set to 1.0f

        flingAnimation.start();
    }

    public void flipIt(View view) {
        ImageView happy = findViewById(R.id.happy);

        FlingAnimation flipAnimation = new FlingAnimation(happy, DynamicAnimation.ROTATION_X);

        flipAnimation.setStartVelocity(250f);
        flipAnimation.setFriction(0.2f);

        flipAnimation.start();
    }

    public void displaySpringAnimation(View view) {
        Intent intent = new Intent(this, SpringAnimationDemo.class);
        startActivity(intent);
    }
}
