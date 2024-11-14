package com.example.library;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BookingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);

        // Инициализация элементов
        EditText nameEditText = findViewById(R.id.nameEditText);
        EditText phoneEditText = findViewById(R.id.phoneEditText);
        EditText bookingDateEditText = findViewById(R.id.bookingDateEditText);
        EditText returnDateEditText = findViewById(R.id.returnDateEditText);
        Button submitButton = findViewById(R.id.submitButton);

        submitButton.setOnClickListener(v -> {
            String name = nameEditText.getText().toString();
            String phone = phoneEditText.getText().toString();
            String bookingDate = bookingDateEditText.getText().toString();
            String returnDate = returnDateEditText.getText().toString();

            // Проверка на пустые поля
            if (name.isEmpty() || phone.isEmpty() || bookingDate.isEmpty() || returnDate.isEmpty()) {
                Toast.makeText(BookingActivity.this, "Пожалуйста, заполните все поля.", Toast.LENGTH_SHORT).show();
            } else {
                // Подтверждение бронирования
                Toast.makeText(BookingActivity.this, "Бронирование успешно!", Toast.LENGTH_SHORT).show();
                finish(); // Закрыть экран бронирования
            }
        });
    }
}
