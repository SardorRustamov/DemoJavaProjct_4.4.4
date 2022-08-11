package com.example.demojavaprojct;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }
    void initViews(){
        Button b_open_details = findViewById(R.id.b_detail);
        b_open_details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User user = new User("Sardor", 22);
                openDetailActivity(user);
            }
        });
    }
    void openDetailActivity(User user){
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra("user", user);
        startActivity(intent);
    }
}