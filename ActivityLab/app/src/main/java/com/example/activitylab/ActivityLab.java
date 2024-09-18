package com.example.activitylab;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


public class ActivityLab extends AppCompatActivity {
    private int createCounter = 0;
    private int startCounter = 0;
    private int resumeCounter = 0;
    private int restartCounter = 0;

    private TextView tvCreateCounter;
    private TextView tvStartCounter;
    private TextView tvResumeCounter;
    private TextView tvRestartCounter;

    private Button btnLaunchActivityTwo;

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("createCounter", createCounter);
        outState.putInt("startCounter", startCounter);
        outState.putInt("resumeCounter", resumeCounter);
        outState.putInt("restartCounter", restartCounter);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_lab);
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });

        tvCreateCounter = findViewById(R.id.tvCreateCounter);
        tvStartCounter = findViewById(R.id.tvStartCounter);
        tvResumeCounter = findViewById(R.id.tvResumeCounter);
        tvRestartCounter = findViewById(R.id.tvRestartCounter);

        btnLaunchActivityTwo = findViewById(R.id.btnLaunchActivityTwo);
        btnLaunchActivityTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ActivityLab.this, ActivityTwo.class);
                startActivity(intent);
            }
        });
        if (savedInstanceState != null) {
            createCounter = savedInstanceState.getInt("createCounter", 0);
            startCounter = savedInstanceState.getInt("startCounter", 0);
            resumeCounter = savedInstanceState.getInt("resumeCounter", 0);
            restartCounter = savedInstanceState.getInt("restartCounter", 0);

        }

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