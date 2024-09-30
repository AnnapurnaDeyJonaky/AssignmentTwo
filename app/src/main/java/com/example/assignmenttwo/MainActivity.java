package com.example.assignmenttwo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    private EditText etName, etEmail;
    private CheckBox cbPasta, cbWedges, cbPizza;
    private RadioGroup radioGroup;
    private SeekBar seekBar;
    private TextView tvRatings;
    private RatingBar ratingBar;
    private Switch switchDelivery;
    private Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        etName = findViewById(R.id.et_name);
        etEmail = findViewById(R.id.et_email);
        cbPasta = findViewById(R.id.pasta);
        cbWedges = findViewById(R.id.wed);
        cbPizza = findViewById(R.id.piz);
        radioGroup = findViewById(R.id.radio_group_degree);
        seekBar = findViewById(R.id.seek_bar_spice);
        tvRatings = findViewById(R.id.tv_rating);
        ratingBar = findViewById(R.id.rating_bar);
        switchDelivery = findViewById(R.id.switch_theme);
        btnSubmit = findViewById(R.id.btn_submit);


        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tvRatings.setText("Spiciness: " + progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) { }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) { }
        });


        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitForm();
            }
        });
    }

    private void submitForm() {
        String name = etName.getText().toString();
        String email = etEmail.getText().toString();
        StringBuilder foodChoices = new StringBuilder();


        if (cbPasta.isChecked()) foodChoices.append("Pasta, ");
        if (cbWedges.isChecked()) foodChoices.append("Wedges, ");
        if (cbPizza.isChecked()) foodChoices.append("Pizza, ");


        int selectedDrinkId = radioGroup.getCheckedRadioButtonId();
        RadioButton selectedDrink = findViewById(selectedDrinkId);
        String drink = selectedDrink != null ? selectedDrink.getText().toString() : "None";


        boolean deliveryRequired = switchDelivery.isChecked();
        int spiceLevel = seekBar.getProgress();
        float rating = ratingBar.getRating();


        Intent intent = new Intent(MainActivity.this, DisplayActivity.class);
        intent.putExtra("name", name);
        intent.putExtra("email", email);
        intent.putExtra("preferences", foodChoices.toString());
        intent.putExtra("spiceLevel", spiceLevel);
        intent.putExtra("rating", rating);
        startActivity(intent);
    }
}