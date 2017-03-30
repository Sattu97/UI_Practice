package hemantgtx950.com.ui_practice.Activities;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.support.v4.app.ActivityOptionsCompat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.Pair;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.Window;

import hemantgtx950.com.ui_practice.R;

public class LandingActivity extends Activity {
    private CardView card1, card2;
    private View myView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);
        card1 = (CardView) findViewById(R.id.card_1);
        card2 = (CardView) findViewById(R.id.card_2);
        myView = findViewById(R.id.card_1);
        card1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                circularReveal();
            }
        });
        card2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                trans();
            }
        });
    }
    private void circularReveal(){


// Getting the Center for clipping circle
        final int cx = myView.getWidth() / 2;
        final int cy = myView.getHeight() / 2;

// getting the final radius for the clipping circle
        final float finalRadius = (float) Math.hypot(cx, cy);

// create the animator for this view (the start radius here is half of the total height and width)
        Animator anim =
                ViewAnimationUtils.createCircularReveal(myView, cx, cy, finalRadius, finalRadius/2);

        anim.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                Animator animator =
                        ViewAnimationUtils.createCircularReveal(myView, cx, cy,finalRadius/2, finalRadius);
                animator.start();
            }
        });

// make the view visible and start the animation
        myView.setVisibility(View.VISIBLE);
        anim.start();
    }

    private void trans(){
        //Screen transition with shared element
        Intent intent = new Intent(this, MainActivity.class);
// Pass data object in the bundle and populate details activity.

        ActivityOptionsCompat options = ActivityOptionsCompat.
                makeSceneTransitionAnimation(this,card1, "hello");
//with multiple shared elements
/*
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this,
                Pair.create((View)card1, "Hello"),
                Pair.create((View)card2, "hell"));
*/
        startActivity(intent, options.toBundle());
    }


}
