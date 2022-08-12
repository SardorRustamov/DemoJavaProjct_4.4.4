package com.example.demojavaprojct;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int LAUNCH_DETAIL=1001;
    TextView tv_home;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }
    ActivityResultLauncher<Intent> detailLauncher= registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if(result.getResultCode()==Activity.RESULT_OK){
                        Intent data= result.getData();
                        Member member = (Member) data.getSerializableExtra("result");
                        tv_home.setText(member.toString());
                    }
                }
            }
    );

    void initViews(){
        tv_home= findViewById(R.id.tv_home);
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
        detailLauncher.launch(intent);
    }
}