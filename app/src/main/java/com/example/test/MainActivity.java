package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onBackPressed() {
        Toast.makeText(this, "Hello World", Toast.LENGTH_LONG).show(); //Toast, .(도트)연산자는 속성 중 하나(MakeText)를 불러와서 함수를 실행
    }
}
