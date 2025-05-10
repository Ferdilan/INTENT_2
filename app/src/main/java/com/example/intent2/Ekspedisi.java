package com.example.intent2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
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
    private Spinner spinner_dari, spinner_ke;



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

//        dari = findViewById(R.id.id_dari);
//        ke = findViewById(R.id.id_ke);
        radio_group_1 = findViewById(R.id.radio_group_1);
        rb1 = findViewById(R.id.rb1);
        rb2 = findViewById(R.id.rb2);
        rb3 = findViewById(R.id.rb3);
        berat = findViewById(R.id.id_berat);
        button_hitung = findViewById(R.id.button_hitung);
        button_clear = findViewById(R.id.button_clear);
        spinner_dari = findViewById(R.id.spinner_dari);
        spinner_ke = findViewById(R.id.spinner_ke);


        // Inisialisasi selectedEkspedisi dengan nilai default
        selectedEkspedisi = "";

        // Ambil array dari strings.xml
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.nama_kota,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner_dari.setAdapter(adapter);
        spinner_ke.setAdapter(adapter);

        spinner_dari.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedKotaAsal = parent.getItemAtPosition(position).toString();
                if (selectedKotaAsal.equals("Pilih Kota Asal")) {
                    // Jangan lanjutkan proses, dan tampilkan pesan
                    Toast.makeText(Ekspedisi.this, "Silakan pilih kota asal yang valid", Toast.LENGTH_SHORT).show();
                } else {
                    // Proses kota asal yang valid
                    Toast.makeText(Ekspedisi.this, "Kota Asal: " + selectedKotaAsal, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Tidak ada yang dipilih
            }
        });


        spinner_ke.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedKotaTujuan = parent.getItemAtPosition(position).toString();
                if (selectedKotaTujuan.equals("Pilih Kota Tujuan")) {
                    // Jangan lanjutkan proses, dan tampilkan pesan
                    Toast.makeText(Ekspedisi.this, "Silakan pilih kota tujuan yang valid", Toast.LENGTH_SHORT).show();
                } else {
                    // Proses kota tujuan yang valid
                    Toast.makeText(Ekspedisi.this, "Kota Tujuan: " + selectedKotaTujuan, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Tidak ada yang dipilih
            }
        });
    }

    public void HandleHitung(View view) {
        Intent intent = new Intent(this, TampilEkspedisi.class); //digunakan untuk membuka class TampilEkspedisi jika button hitung di klik
//        intent.putExtra("key", dari.getText().toString());
//        intent.putExtra("key2", ke.getText().toString());

        //menggunakan spinner untuk memilih kota dari dan ke
        String dariValue = spinner_dari.getSelectedItem().toString();
        String keValue = spinner_ke.getSelectedItem().toString();

        if (dariValue.equals("Pilih Kota Asal") || keValue.equals("Pilih Kota Tujuan")) {
            Toast.makeText(this, "Silakan pilih kota asal dan tujuan yang valid", Toast.LENGTH_SHORT).show();
            return;
        }

        intent.putExtra("key", dariValue);
        intent.putExtra("key2", keValue);


        int selectedId = radio_group_1.getCheckedRadioButtonId();
        if (selectedId == -1) { //jika selectedId tidak ada yang dipilih, maka memiliki nilai -1. karena nilai yang paling sedikit di pilihan adalah id 0
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