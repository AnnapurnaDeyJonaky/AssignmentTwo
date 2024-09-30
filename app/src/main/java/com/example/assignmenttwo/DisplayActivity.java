package com.example.assignmenttwo;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class DisplayActivity extends AppCompatActivity {

    private TextView tvName, tvEmail, tvPreferences, tvSpiceLevel, tvRating;
    private Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);


        tvName = findViewById(R.id.tv_name);
        tvEmail = findViewById(R.id.tv_email);
        tvPreferences = findViewById(R.id.tv_preferences);
        tvSpiceLevel = findViewById(R.id.spiceLevel);
        tvRating = findViewById(R.id.tv_rating);
        btnSubmit = findViewById(R.id.btn_submit);

        // Get data from the Intent
        String name = getIntent().getStringExtra("name");
        String email = getIntent().getStringExtra("email");
        String preferences = getIntent().getStringExtra("preferences");
        int spiceLevel = getIntent().getIntExtra("spiceLevel", 0);
        float rating = getIntent().getFloatExtra("rating", 0);


        tvName.setText("Name: " + (name != null ? name : "N/A"));
        tvEmail.setText("Email/Phone: " + (email != null ? email : "N/A"));
        tvPreferences.setText("Preferences: " + (preferences != null ? preferences : "N/A"));
        tvSpiceLevel.setText("Spice Level: " + spiceLevel);
        tvRating.setText("Rating: " + rating);


        btnSubmit.setOnClickListener(v -> {

        });
    }
}