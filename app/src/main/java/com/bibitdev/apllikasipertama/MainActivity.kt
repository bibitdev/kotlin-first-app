package com.bibitdev.apllikasipertama

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Inisialisasi komponen
        val edtTanggal = findViewById<EditText>(R.id.edt_tanggal)
        val btnKlik = findViewById<Button>(R.id.btn_klik)
        val tvResults = findViewById<TextView>(R.id.tv_result)
        val toolbar: Toolbar = findViewById(R.id.toolbar)

        // Mengatur Toolbar sebagai ActionBar
        setSupportActionBar(toolbar)

        // Set listener untuk button
        btnKlik.setOnClickListener {
            val input = edtTanggal.text.toString()
            // Cek apakah input valid dan tentukan generasi
            val result = when (input.toIntOrNull()) {
                in 1946..1964 -> "Baby Boomers"
                in 1965..1980 -> "Gen-X"
                in 1981..1995 -> "Millennials"
                in 1996..2010 -> "Gen-Z"
                else -> "Unknown"
            }
            tvResults.text = "Your Generation: $result"
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
