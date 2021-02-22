package com.example.foodapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public EditText ed1, ed2, ed3, ed4, ed5, ed6, ed7, ed8,ed11;
    public Button b1,b2,b3,b4,b5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed1 = findViewById((R.id.editText2)); //dosa
        ed2 = findViewById((R.id.editText3)); //biryani
        ed3 = findViewById((R.id.editText4)); //Paneer
        ed4 = findViewById((R.id.editText5)); //burger
        ed5 = findViewById((R.id.editText6)); //dosa rs
        ed7 = findViewById((R.id.editText7)); //paneer rs
        ed6 = findViewById((R.id.editText8)); //biryani rs
        ed8 = findViewById((R.id.editText9)); //burger rs

        b1 = findViewById(R.id.button4); //dosa
        b2 = findViewById(R.id.button2); //biryani
        b3 = findViewById(R.id.button5); //paneer
        b4 = findViewById(R.id.button3); //burger
        b5 = findViewById(R.id.button);
    }

    public void count(View view)
    {
        Intent it = new Intent(getBaseContext(), OrderService.class);
        switch (view.getId()) {
            case R.id.button4:
                it.putExtra("food", "1. Masala Dosa");
                it.putExtra("rate", "60");
                Toast.makeText(this, "Dosa Added to card", Toast.LENGTH_LONG).show();
                break;
            case R.id.button2:
                it.putExtra("food", "2. Chicken Biriyani");
                it.putExtra("rate", "150");
                Toast.makeText(this, "Biryani Added to card", Toast.LENGTH_LONG).show();
                break;
            case R.id.button5:
                it.putExtra("food", "3. Paneer Butter Masala");
                it.putExtra("rate", "130");
                Toast.makeText(this, "Paneer Added to card", Toast.LENGTH_LONG).show();
                break;
            case R.id.button3:
                it.putExtra("food", "4. Burger combo");
                it.putExtra("rate", "110");
                Toast.makeText(this, "Burger Added to card", Toast.LENGTH_LONG).show();
                break;
            case R.id.button:
                it.putExtra("food", "Submit");
                it.putExtra("rate", "1");
                break;
        }
        startService(it);

    }


}
