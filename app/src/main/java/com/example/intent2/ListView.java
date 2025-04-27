package com.example.intent2;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ListView extends AppCompatActivity {

    // deklarasi / inisialisasi komponen
    android.widget.ListView list_user;
    ArrayAdapter arrayAdapter;

    String[] users = {
            "Malang", "Kediri", "Surabaya", "Tulungagung", "Batu",
            "Pasuruan", "Probolinggo", "Bojonegoro", "Gresik", "Tuban",
            "Bandung", "Jakarta", "Semarang", "Jogja", "Cirebon", "Klaten", "Sumedang", "Sukabumi",
            "Bogor", "Banyuwangi", "Ngawi", "Madiun", "Purwakarta", "Purbalingga", "Jember", "Garut"

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        EdgeToEdge.enable(this);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // mengenali komponen
        list_user = findViewById(R.id.list_user);
        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, users);
        list_user.setAdapter(arrayAdapter);

        list_user.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String index = list_user.getItemAtPosition(position).toString();
                Toast.makeText(ListView.this, "Anda memilih " + index, Toast.LENGTH_SHORT).show();
            }
        });


    }
}