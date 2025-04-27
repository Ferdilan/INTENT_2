package com.example.intent2;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class TampilEkspedisi extends AppCompatActivity {

    private TextView text1, text2, text3, text4, text5, tampil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tampil_ekspedisi);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        tampil = findViewById(R.id.id_tampil);
        text1 =  findViewById(R.id.text1);
        text2 = findViewById(R.id.text2);
        text3 = findViewById(R.id.text3);
        text4 = findViewById(R.id.text4);
        text5 = findViewById(R.id.text5);

        Bundle bundle = getIntent().getExtras();

        String asal = bundle.getString("key");
        String tujuan = bundle.getString("key2");
        String paket = bundle.getString("key4");
        int berat = bundle.getInt("key3");

        tampil.setText("Selamat Datang di Ferdilan Ekspedisi");
//        textView.setText("Terima Kasih Telah Menggunakan Aplikasi Kami");
        text1.setText("Dari : " + asal);
        text2.setText("Ke : " + tujuan);
        text3.setText("Jenis Paket : " + paket);
        text4.setText("Berat : " + berat + " Kg");

        int biaya;
        if (paket.equalsIgnoreCase("Express")){
            biaya = berat * 15000;
        }
        else if (paket.equalsIgnoreCase("Reguler")) {
            biaya = berat * 10000;
        }
        else {
            biaya = berat * 80000;
        }
        text5.setText("Biaya : " + biaya);

    }
}