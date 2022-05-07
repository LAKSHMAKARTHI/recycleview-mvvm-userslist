package com.example.rcvm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;

public class ProfileActivity extends AppCompatActivity {
    TextView email, name, uid;
    ImageView imageView;
    Button backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        email = findViewById(R.id.pEmail);
        uid = findViewById(R.id.pID);
        name = findViewById(R.id.pName);
        imageView = findViewById(R.id.profileImageView);
        backBtn = findViewById(R.id.backBtn);

        try {
            uid.setText(getIntent().getExtras().getString("id"));
            name.setText(getIntent().getExtras().getString("name"));
            email.setText(getIntent().getExtras().getString("email"));
            Glide.with(this.getBaseContext()).load(getIntent().getExtras().getString("avatar")).circleCrop().into(imageView);
        } catch (Exception e) {
            Log.e("Error", e.toString());
        }

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }
}