package com.example.lab4; // Проверь, чтобы это совпадало с папками

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Calendar;
// Если ID красные, попробуй добавить это вручную:
// import com.example.lab4.R;

public class Activity2 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2); // Должно совпадать с именем XML

        // Получаем данные из интента
        String name = getIntent().getStringExtra("user_name");

        // Инициализация View элементов
        TextView welcome = findViewById(R.id.welcome_text);
        DatePicker picker = findViewById(R.id.date_picker);
        Button okBtn = findViewById(R.id.ok_btn);

        if (name != null) {
            welcome.setText("Привет, " + name);
        }

        okBtn.setOnClickListener(v -> {
            Calendar calendar = Calendar.getInstance();
            calendar.set(picker.getYear(), picker.getMonth(), picker.getDayOfMonth());
            long millis = calendar.getTimeInMillis();

            Intent resultIntent = new Intent();
            resultIntent.putExtra("picked_date", millis);
            setResult(Activity.RESULT_OK, resultIntent);
            finish();
        });
    }
}