package com.example.libowen.annotationdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

@BindId(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {

    @BindId(R.id.text)
    private TextView view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bind.bindId(this);
        BindClick.bindOnClick(this);
        view.setText("注解成功！");
    }

    @BindOnClick({R.id.text,R.id.button})
    public void onClick(View view){
        switch (view.getId()){
            case R.id.text:
                Toast.makeText(this,"点击text",Toast.LENGTH_SHORT).show();
                break;
            case R.id.button:
                Toast.makeText(this,"点击button",Toast.LENGTH_SHORT).show();
                break;
        }

    }
}
