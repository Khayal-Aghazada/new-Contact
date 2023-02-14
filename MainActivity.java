package com.example.intentschallenge;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tvTitle;
    Button btCreate;
    ImageView ivMood, ivWeb, ivPhone, ivMap;
    final int NEW_CONTACT = 1;
    String name = "", phone = "", web = "", location = "", mood = "";

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == NEW_CONTACT){

            if(resultCode == RESULT_OK){
                ivMood.setVisibility(View.VISIBLE);
                ivPhone.setVisibility(View.VISIBLE);
                ivWeb.setVisibility(View.VISIBLE);
                ivMap.setVisibility(View.VISIBLE);

                name = data.getStringExtra("name");
                phone = data.getStringExtra("phone number");
                web = data.getStringExtra("web");
                location = data.getStringExtra("location");
                mood = data.getStringExtra("mood");

                if (mood.equals("happy")){
                    ivMood.setImageResource(R.drawable.happy);
                }

                else if (mood.equals("sad")){
                    ivMood.setImageResource(R.drawable.sad);
                }

                else{
                    ivMood.setImageResource(R.drawable.ok);
                }
            }
        }

        else{
            Toast.makeText(this, "No data passed through", Toast.LENGTH_SHORT);
        }
    }

    @SuppressLint({"WrongViewCast", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvTitle = findViewById(R.id.tvTitle);
        btCreate = findViewById(R.id.btCreate);
        ivPhone = findViewById(R.id.ivPhone);
        ivMood = findViewById(R.id.ivMood);
        ivWeb = findViewById(R.id.ivWeb);
        ivMap = findViewById(R.id.ivMap);

        ivMood.setVisibility(View.GONE);
        ivPhone.setVisibility(View.GONE);
        ivWeb.setVisibility(View.GONE);
        ivMap.setVisibility(View.GONE);

        btCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this,
                        com.example.intentschallenge.newContact.class);
                startActivityForResult(intent, NEW_CONTACT);
            }
        });

        ivPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: " + phone));
                startActivity(intent);
            }
        });

        ivWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http:// " + web));
                startActivity(intent);
            }
        });

        ivMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo: 0.0?q=" + location));
                startActivity(intent);
            }
        });



    }
}