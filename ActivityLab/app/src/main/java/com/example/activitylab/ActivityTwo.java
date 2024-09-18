package com.example.activitylab;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ActivityTwo extends AppCompatActivity {
    private int createCounter = 0;
    private int startCounter = 0;
    private int resumeCounter = 0;
    private int restartCounter = 0;

    private TextView tvCreateCounter;
    private TextView tvStartCounter;
    private TextView tvResumeCounter;
    private TextView tvRestartCounter;

    private Button btnCloseActivity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_two);
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });

        tvCreateCounter = findViewById(R.id.tvCreateCounter);
        tvStartCounter = findViewById(R.id.tvStartCounter);
        tvResumeCounter = findViewById(R.id.tvResumeCounter);
        tvRestartCounter = findViewById(R.id.tvRestartCounter);

        btnCloseActivity = findViewById(R.id.btnCloseActivity);
        btnCloseActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        tvCreateCounter.setText(++createCounter + "");
    }

    @Override
    protected void onStart() {
        super.onStart();
        tvStartCounter.setText(++startCounter + "");
    }

    @Override
    protected void onResume() {
        super.onResume();
        tvResumeCounter.setText(++resumeCounter + "");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        tvRestartCounter.setText(++restartCounter + "");
    }
}