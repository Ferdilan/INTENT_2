/************************************************************
 * Ditulis oleh : Ferdilan Ramadhani
 * ListView adalah jendela yang menyusun informasi dalam barisan, memberi pengguna kendali untuk memilih dan mengeksplorasi.
 * DialogMessage berfungsi sebagai pengingat yang menyampaikan informasi penting dengan cara yang tenang namun jelas, mengarahkan pengguna menuju keputusan yang tepat.
 * Bersama-sama, keduanya menyatukan logika aplikasi dengan alur interaksi yang harmonis.
 ************************************************************/

package com.example.intent2;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button radiobutton, listview, dialogmessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        radiobutton = findViewById(R.id.radiobutton);
        listview = findViewById(R.id.listview);
        dialogmessage = findViewById(R.id.dialogmessage);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void handleRadioButton(View view) {
        Intent intent = new Intent(this, Ekspedisi.class);
        startActivity(intent);
    }

    public void handleListView(View view) {
        Intent intent = new Intent(this, ListView.class);
        startActivity(intent);
    }

    public void handleDialogMessage(View view) {
//        DialogMessage.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Belajar Android")
                        .setMessage("Apakah mau belajar Android?")
                        .setCancelable(true)
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(MainActivity.this, "Tampilan ketika button OK ditekan", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton("Not Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(MainActivity.this, "Tampilan ketika button Not Ok ditekan", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast cancelToast = Toast.makeText(MainActivity.this, "Tampilan ketika button Cancel ditekan", Toast.LENGTH_SHORT);
                                cancelToast.setGravity(Gravity.TOP, 0, 50);
                                cancelToast.show();
                            }
                        })
                        .show();
        }

    }