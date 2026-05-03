package com.example.lab4;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText nameInput = findViewById(R.id.name_input);
        Button btn = findViewById(R.id.open_activity2_btn);

        btn.setOnClickListener(v -> {
            // Создаем интент и кладем в него текст из EditText
            Intent intent = new Intent(this, Activity2.class);
            intent.putExtra("user_name", nameInput.getText().toString());
            startActivity(intent);
        });
    }
}