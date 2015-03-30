package com.eb.ecshop;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainTopRightDialog extends Activity {

	private LinearLayout layout01;
    private LinearLayout layout02;
    private LinearLayout layout03;
    private LinearLayout layout04;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_top_right_dialog);
		layout01=(LinearLayout)findViewById(R.id.layer01);
        layout01.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
                finish();
                Intent intent = new Intent (MainTopRightDialog.this,Category.class);
                startActivity(intent);
			}
		});

        layout02=(LinearLayout)findViewById(R.id.layer02);
        layout02.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Toast.makeText(getApplicationContext(), "test02",
                        Toast.LENGTH_SHORT).show();
            }
        });

        layout03=(LinearLayout)findViewById(R.id.layer03);
        layout03.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Toast.makeText(getApplicationContext(), "test03",
                        Toast.LENGTH_SHORT).show();
            }
        });

        layout04=(LinearLayout)findViewById(R.id.layer04);
        layout04.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Toast.makeText(getApplicationContext(), "test04",
                        Toast.LENGTH_SHORT).show();
            }
        });
	}

	@Override
	public boolean onTouchEvent(MotionEvent event){
		finish();
		return true;
	}
}
