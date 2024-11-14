package com.example.library;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class SecondActivity extends AppCompatActivity {

    private List<String> books = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // Инициализация данных книг
        books.add("Книга 1 - Автор 1");
        books.add("Книга 2 - Автор 2");
        books.add("Книга 3 - Автор 3");

        // Инициализация элементов интерфейса
        EditText searchName = findViewById(R.id.searchName);
        EditText searchAuthor = findViewById(R.id.searchAuthor);
        Button searchButton = findViewById(R.id.searchButton);
        LinearLayout bookListLayout = findViewById(R.id.bookListLayout);

        // Отображаем список книг
        displayBooks(bookListLayout);

        // Поиск по имени или автору
        searchButton.setOnClickListener(v -> {
            String name = searchName.getText().toString();
            String author = searchAuthor.getText().toString();
            bookListLayout.removeAllViews(); // Очищаем список перед поиском
            displayBooks(bookListLayout, name, author);
        });
    }

    // Метод для отображения книг
    private void displayBooks(LinearLayout bookListLayout) {
        for (String book : books) {
            // Создаем элемент списка книги с кнопкой
            LinearLayout bookItemLayout = new LinearLayout(this);
            bookItemLayout.setOrientation(LinearLayout.HORIZONTAL);
            bookItemLayout.setPadding(16, 16, 16, 16);

            TextView bookText = new TextView(this);
            bookText.setText(book);
            bookText.setLayoutParams(new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, 1f));

            Button addButton = new Button(this);
            addButton.setText("+");
            addButton.setOnClickListener(v -> openBookingActivity());

            // Добавляем элементы в layout
            bookItemLayout.addView(bookText);
            bookItemLayout.addView(addButton);
            bookListLayout.addView(bookItemLayout);
        }
    }

    // Перегруженный метод для поиска по имени или автору
    private void displayBooks(LinearLayout bookListLayout, String name, String author) {
        for (String book : books) {
            if (book.contains(name) && book.contains(author)) {
                // Создаем элемент списка книги с кнопкой
                LinearLayout bookItemLayout = new LinearLayout(this);
                bookItemLayout.setOrientation(LinearLayout.HORIZONTAL);
                bookItemLayout.setPadding(16, 16, 16, 16);

                TextView bookText = new TextView(this);
                bookText.setText(book);
                bookText.setLayoutParams(new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, 1f));

                Button addButton = new Button(this);
                addButton.setText("+");
                addButton.setOnClickListener(v -> openBookingActivity());

                // Добавляем элементы в layout
                bookItemLayout.addView(bookText);
                bookItemLayout.addView(addButton);
                bookListLayout.addView(bookItemLayout);
            }
        }
    }

    // Метод для перехода в активити бронирования
    private void openBookingActivity() {
        Intent intent = new Intent(SecondActivity.this, BookingActivity.class);
        startActivity(intent);
    }
}
