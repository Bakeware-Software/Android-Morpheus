package com.example.bluered.bluered;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private float x1, x2;
    static final int MIN_DISTANCE = 150;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void swapLeft() {
        Intent intent = new Intent(this, LeftActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.right_left_in, R.anim.right_left_out);
    }

    public void swapRight() {
        Intent intent = new Intent(this, RightActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.left_right_in, R.anim.left_right_out);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch(event.getAction())
        {
            case MotionEvent.ACTION_DOWN:
                x1 = event.getX();
                break;
            case MotionEvent.ACTION_UP:
                x2 = event.getX();
                float deltaX = x2 - x1;

                if (Math.abs(deltaX) > MIN_DISTANCE)
                {
                    // Left to Right swipe action
                    if (x2 > x1)
                    {
                        swapLeft();
                    }
                    // Right to left swipe action
                    else
                    {
                        swapRight();
                    }
                }
                else
                {
                    // consider as something else - a screen tap for example
                }
                break;
        }
        return super.onTouchEvent(event);
    }


}
