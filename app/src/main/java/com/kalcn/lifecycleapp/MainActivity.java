package com.kalcn.lifecycleapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnDial = findViewById(R.id.btnDial);
        Button btnSecond = findViewById(R.id.btnSecond);
        Button btnFinish = findViewById(R.id.btnFinish);

        btnDial.setOnClickListener(myLinstener);
        btnSecond.setOnClickListener(myLinstener);
        btnFinish.setOnClickListener(myLinstener);

        Toast.makeText(this,"onCreate(1)",Toast.LENGTH_LONG).show();
    }
    @Override
    protected void onStart(){
        super.onStart();
        Toast.makeText(this,"onStart(1)",Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onResume(){
        super.onResume();
        Toast.makeText(this,"啟動系統",Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onRestart(){
        super.onRestart();
        Toast.makeText(this,"onRestart(1)",Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onPause(){
        super.onPause();
        Toast.makeText(this,"執行程式",Toast.LENGTH_LONG).show();
    }
    protected void onStop(){
        super.onStop();
        Toast.makeText(this,"執行完成",Toast.LENGTH_LONG).show();
    }
    protected void onDestroy(){
        super.onDestroy();
        Toast.makeText(this,"關閉程式",Toast.LENGTH_LONG).show();
    }
    private Button.OnClickListener myLinstener = new Button.OnClickListener() {
        @Override
        public void onClick(View view) {

            switch (view.getId()){
                case R.id.btnDial:
                    Uri uri = Uri.parse("tel:0987123456");
                    Intent intent = new Intent(Intent.ACTION_DIAL,uri);
                    startActivity(intent);
                    break;
                case R.id.btnSecond:
                    Intent intent1 = new Intent(MainActivity.this,Main2Activity.class);
                    startActivity(intent1);
                    break;
                case R.id.btnFinish:
                    finish();
                    break;
            }

        }
    };
}
