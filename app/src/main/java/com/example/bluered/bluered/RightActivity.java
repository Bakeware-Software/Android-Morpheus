package com.example.bluered.bluered;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;

import static com.example.bluered.bluered.MainActivity.MIN_DISTANCE;

public class RightActivity extends AppCompatActivity {
    private float x1, x2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_right);
    }

    public void swapRight() {
        finish();
        overridePendingTransition(R.anim.right_left_in, R.anim.right_left_out);
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
                    if (x2 > x1)
                    {
                        swapRight();
                    }
                }
                else
                {

                }
                break;
        }
        return super.onTouchEvent(event);
    }
}
