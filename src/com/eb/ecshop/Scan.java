package com.eb.ecshop;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;


public class Scan extends Activity {

    private Button button;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_tab_scan);

        button = (Button) findViewById(R.id.scan_start_btn);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, 1);
            }
        });
    }

    public void btnmainright(View v) {
        Intent intent = new Intent (Scan.this,MainWindow.class);
        startActivity(intent);
    }

}
