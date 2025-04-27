package com.example.intent2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Ekspedisi extends AppCompatActivity {

    private EditText dari, ke, berat;
    private RadioGroup radio_group_1;
    private RadioButton rb1, rb2, rb3;
    private Button button_hitung, button_clear;
    private String selectedEkspedisi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_ekspedisi);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        dari = findViewById(R.id.id_dari);
        ke = findViewById(R.id.id_ke);
        radio_group_1 = findViewById(R.id.radio_group_1);
        rb1 = findViewById(R.id.rb1);
        rb2 = findViewById(R.id.rb2);
        rb3 = findViewById(R.id.rb3);
        berat = findViewById(R.id.id_berat);
        button_hitung = findViewById(R.id.button_hitung);
        button_clear = findViewById(R.id.button_clear);

        // Inisialisasi selectedEkspedisi dengan nilai default
        selectedEkspedisi = "";
    }

    public void HandleHitung(View view) {
        Intent intent = new Intent(this, TampilEkspedisi.class); //digunakan untuk membuka class TampilEkspedisi jika button hitung di klik
        intent.putExtra("key", dari.getText().toString());
        intent.putExtra("key2", ke.getText().toString());

        int selectedId = radio_group_1.getCheckedRadioButtonId();
        if (selectedId == -1) {
            Toast.makeText(this, "Tidak ada yang dipilih!", Toast.LENGTH_SHORT).show();
            return;
        }else {
            RadioButton rb = radio_group_1.findViewById(selectedId);
            intent.putExtra("key4", rb.getText());
            Toast.makeText(this, "Pilihan Anda adalah "+ rb.getText(), Toast.LENGTH_SHORT).show();
        }

        int w = Integer.parseInt(berat.getText().toString());
        intent.putExtra("key3", w);
        startActivity(intent);
    }

    public void HandleClear(View view) {
        dari.setText("");
        ke.setText("");
        berat.setText("");
        radio_group_1.clearCheck();

    }
}