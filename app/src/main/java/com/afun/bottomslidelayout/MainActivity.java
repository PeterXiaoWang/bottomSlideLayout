package com.afun.bottomslidelayout;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.afun.bottomslidelayout.ui.BottomSlideLayout;

public class MainActivity extends AppCompatActivity {

    private BottomSlideLayout bottomSlideLayout;
    private Button open;
    private Button close;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        initView();
    }

    private void initView() {
        bottomSlideLayout= (BottomSlideLayout) findViewById(R.id.slide_layout);
        View view= View.inflate(this,R.layout.silde_layout,null);

        bottomSlideLayout.setSlideLayout(view);
        bottomSlideLayout.setAutoSlideDown(true);

        open= (Button) findViewById(R.id.open);
        close= (Button) view.findViewById(R.id.to_close);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomSlideLayout.slideDown();
            }
        });

        open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomSlideLayout.slideUp();
            }
        });
    }
}
