package com.example.labtuan3;

import static android.content.pm.PackageManager.PERMISSION_GRANTED;
import static android.provider.ContactsContract.*;
import static android.provider.ContactsContract.Contacts.*;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;


public class MainActivity extends AppCompatActivity {
    private Button btnCallContacts;
    private Button btnCallQR;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btnCallContacts = findViewById(R.id.btnCallContacts);
        btnCallQR = findViewById(R.id.btnCallQR);




        btnCallContacts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, CONTENT_URI);
                startActivity(intent);

            }
        });




        btnCallQR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IntentIntegrator integrator = new IntentIntegrator(MainActivity.this);
                integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE);
                integrator.setPrompt("Quét mã QR");
                integrator.setCameraId(0);  // Dùng camera sau
                integrator.setBeepEnabled(true);  // Phát âm thanh khi quét xong
                integrator.setBarcodeImageEnabled(true);  // Lưu lại ảnh mã QR
                integrator.initiateScan();  // Bắt đầu quét
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null) {
            if (result.getContents() == null) {
                // Người dùng hủy quét
                Toast.makeText(this, "Bạn đã hủy quét", Toast.LENGTH_SHORT).show();
            } else {
                String[] dataQR = result.getContents().split(";");

                Intent intent = new Intent(MainActivity.this, MainActivity2.class);

                intent.putExtra("url", dataQR[0]);
                intent.putExtra("email", dataQR[1]);
                intent.putExtra("sms", dataQR[2]);
                intent.putExtra("link_image", dataQR[3]);

                startActivity(intent);


            }
        }
    }
}