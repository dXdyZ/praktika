package com.example.library;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private Map<String, String> users = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Инициализация данных пользователей
        users.put("user@example.com", "password123"); // Пример правильных данных

        // Инициализация элементов
        EditText emailEditText = findViewById(R.id.Email);
        EditText passwordEditText = findViewById(R.id.Password);
        Button loginButton = findViewById(R.id.button);

        // Устанавливаем обработчик клика на кнопку "Войти"
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Получаем введенные данные
                String email = emailEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                // Проверка данных
                if (checkCredentials(email, password)) {
                    // Если данные верны, переходим на новое активити
                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                    startActivity(intent);
                    finish(); // Закрываем текущее активити
                } else {
                    // Если данные неверны, показываем сообщение
                    Toast.makeText(MainActivity.this, "Неверный email или пароль", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    // Метод для проверки данных
    private boolean checkCredentials(String email, String password) {
        // Проверка, существует ли такой email и совпадает ли пароль
        return users.containsKey(email) && users.get(email).equals(password);
    }
}
