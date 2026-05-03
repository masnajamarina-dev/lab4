package com.example.lab4;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    private TextView dateResult;

    // Регистратор, который поймает результат из Activity 2
    private final ActivityResultLauncher<Intent> startForResult = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                if (result.getResultCode() == Activity.RESULT_OK && result.getData() != null) {
                    long millis = result.getData().getLongExtra("picked_date", 0);
                    dateResult.setText("Выбранная дата: " + new Date(millis).toString());
                }
            });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText nameInput = findViewById(R.id.name_input);
        Button btn = findViewById(R.id.open_activity2_btn);
        dateResult = findViewById(R.id.date_result_text);

        btn.setOnClickListener(v -> {
            Intent intent = new Intent(this, Activity2.class);
            intent.putExtra("user_name", nameInput.getText().toString());
            // Используем лаунчер вместо простого startActivity
            startForResult.launch(intent);
        });
    }
}