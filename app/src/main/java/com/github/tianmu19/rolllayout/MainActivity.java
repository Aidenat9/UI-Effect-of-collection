package com.github.tianmu19.rolllayout;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {
    private boolean showPrevious;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        final ViewFlipper viewFlipper = findViewById(R.id.viewflipper);
        View view1 = LayoutInflater.from(this).inflate(R.layout.title_header1, null);
        View view2 = LayoutInflater.from(this).inflate(R.layout.title_header2, null);
        viewFlipper.addView(view1);
        viewFlipper.addView(view2);
        viewFlipper.setAutoStart(false);

        findViewById(R.id.btn_flipper).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(showPrevious){
                    viewFlipper.setInAnimation(getBaseContext(),R.anim.flipper_bottom_in);
                    viewFlipper.setOutAnimation(getBaseContext(),R.anim.flipper_bottom_out);
                    viewFlipper.showPrevious();
                }else{
                    viewFlipper.setInAnimation(getBaseContext(),R.anim.flipper_top_in);
                    viewFlipper.setOutAnimation(getBaseContext(),R.anim.flipper_top_out);
                    viewFlipper.showNext();
                }
                showPrevious = !showPrevious;
            }
        });
    }
}
