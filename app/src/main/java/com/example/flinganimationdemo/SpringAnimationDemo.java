package com.example.flinganimationdemo;

import android.support.animation.DynamicAnimation;
import android.support.animation.SpringAnimation;
import android.support.animation.SpringForce;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class SpringAnimationDemo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spring_animation);
    }

    //This is similar to the ones in the Main Activity, however the key difference is the
    //Spring Force class.
    public void bounce(View view) {
        final ImageView androidBob = findViewById(R.id.bob);

        SpringAnimation springAnimation = new SpringAnimation(androidBob, DynamicAnimation.Y);

        //In order to animate a spring, it needs three values.  The Position of the Spring,
        //Its Damping Ratio, and the stiffness of the spring.
        SpringForce springForce = new SpringForce();
        springForce.setFinalPosition(androidBob.getY());

        //Damping is similar to friction, which slows down the animation.
        springForce.setDampingRatio(SpringForce.DAMPING_RATIO_HIGH_BOUNCY);

        //The Stiffness is how much force is required to stretch the string.  Higher Stiffness = Less bounce.
        springForce.setStiffness(SpringForce.STIFFNESS_VERY_LOW);

        springAnimation.setSpring(springForce);

        springAnimation.setStartVelocity(2000f);
        springAnimation.start();
    }
}
