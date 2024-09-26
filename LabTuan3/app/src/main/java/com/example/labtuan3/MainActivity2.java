package com.example.labtuan3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.squareup.picasso.Picasso;

public class MainActivity2 extends AppCompatActivity {
    private TextView tvUrl, tvEmail, tvSms;
    private Button btnBack;
    private ImageView ivImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        tvUrl = findViewById(R.id.tvUrl);
        tvEmail = findViewById(R.id.tvEmail);
        tvSms = findViewById(R.id.tvSms);
        ivImage = findViewById(R.id.imageView);
        btnBack = findViewById(R.id.btnBack);


        String url = getIntent().getStringExtra("url");
        String email = getIntent().getStringExtra("email");
        String sms = getIntent().getStringExtra("sms");
        String link_image = getIntent().getStringExtra("link_image");

        tvUrl.setText(url);
        tvEmail.setText(email);
        tvSms.setText(sms);
        Picasso.get().load(link_image).into(ivImage);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });



    }
}