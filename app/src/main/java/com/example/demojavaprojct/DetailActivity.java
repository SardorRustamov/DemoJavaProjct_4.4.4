package com.example.demojavaprojct;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        initViews();
    }
    void initViews(){
        TextView tv_detail = findViewById(R.id.tv_detail);
        User user = (User) getIntent().getSerializableExtra("user");
        tv_detail.setText(user.toString());
    }
}