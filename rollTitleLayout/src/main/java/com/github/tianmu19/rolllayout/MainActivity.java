package com.github.tianmu19.rolllayout;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private boolean showPrevious;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        //1
        View view1 = LayoutInflater.from(this).inflate(R.layout.title_header1, null);
        View view2 = LayoutInflater.from(this).inflate(R.layout.title_header2, null);
        //2
        final RollTitleLayout rollTitleLayout = findViewById(R.id.rolllayout);
        rollTitleLayout.addViews(view1,view2);
        findViewById(R.id.btn_flipper).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(showPrevious){
                    rollTitleLayout.showPrevious();
                }else{
                    rollTitleLayout.showNext();
                }
                showPrevious = !showPrevious;
            }
        });

    }
}
