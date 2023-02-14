package com.example.intentschallenge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class newContact extends AppCompatActivity implements View.OnClickListener{

    EditText etName, etPhone, etWeb, etLocation;
    ImageView ivHappy, ivOK, ivSad;

    @Override
    public void onClick(View view) {

        if (etName.getText().toString().isEmpty() || etPhone.getText().toString().isEmpty() ||
                etWeb.getText().toString().isEmpty() || etLocation.getText().toString().isEmpty()) {
            Toast.makeText(this, "Enter all fields", Toast.LENGTH_SHORT).show();
        }

        else {
            Intent intent = new Intent();
            intent.putExtra("name", etName.getText().toString().trim());
            intent.putExtra("phone number", etPhone.getText().toString().trim());
            intent.putExtra("web", etWeb.getText().toString().trim());
            intent.putExtra("location", etLocation.getText().toString().trim());

            if(view.getId() == R.id.ivHappy){
                intent.putExtra("mood", "happy");
            }

            else if(view.getId() == R.id.ivOK){
                intent.putExtra("mood", "ok");
            }

            else{
                intent.putExtra("mood", "sad");
            }

            setResult(RESULT_OK, intent);
            newContact.this.finish();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_contact);

        etName = findViewById(R.id.etName);
        etPhone = findViewById(R.id.etPhone);
        etWeb = findViewById(R.id.etWeb);
        etLocation = findViewById(R.id.etLocation);

        ivHappy = findViewById(R.id.ivHappy);
        ivOK = findViewById(R.id.ivOK);
        ivSad = findViewById(R.id.ivSad);

        ivHappy.setOnClickListener(this);
        ivOK.setOnClickListener(this);
        ivSad.setOnClickListener(this);
    }
}