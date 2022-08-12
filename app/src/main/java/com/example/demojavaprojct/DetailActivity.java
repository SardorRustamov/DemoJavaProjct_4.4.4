package com.example.demojavaprojct;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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
        Button b_exit= findViewById(R.id.b_exit);
        b_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Member member = new Member("Object", "Thank you!");
                backToFinish(member);
            }
        });
        User user = (User) getIntent().getSerializableExtra("user");
        tv_detail.setText(user.toString());
    }
    void backToFinish(Member member){
        Intent intent = new Intent();
        intent.putExtra("result", member);
        setResult(Activity.RESULT_OK, intent);
        finish();
    }
}