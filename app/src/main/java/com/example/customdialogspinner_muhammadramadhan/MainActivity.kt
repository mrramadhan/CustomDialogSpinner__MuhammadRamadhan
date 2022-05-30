package com.example.customdialogspinner_muhammadramadhan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    val nama = arrayOf(
        "Kota Pangkalpinang", "Kabupaten Bangka", "Kabupaten Bangka Barat",
        "Kabupaten Bangka Tengah", "Kabupaten Bangka Selatan", "Kabupaten Belitung",
        "Kabupaten Belitung Timur"
    )
    val logo = intArrayOf(
        R.drawable.logo_pangkalpinang, R.drawable.logo_bangka, R.drawable.logo_babar,
        R.drawable.logo_bateng, R.drawable.logo_basel, R.drawable.logo_belitung,
        R.drawable.logo_beltim
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val spnKabKota = findViewById<Spinner>(R.id.spnKabKota)

        val adpKabKota =  AdapterKabKota(this@MainActivity, logo, nama)
        spnKabKota.adapter = adpKabKota


        val btnKenalan = findViewById<Button>(R.id.btnKenalan)

        btnKenalan.setOnClickListener {
            val inflateView = layoutInflater.inflate(R.layout.layout_alert, null)
            val etNama = inflateView.findViewById<EditText>(R.id.etNama)
            val alb = AlertDialog.Builder(this@MainActivity)
            with(alb){
                setTitle("Mau kenalan?")
                setIcon(R.drawable.maskot_kotlin)
                setView(inflateView)
                setCancelable(false)
                setPositiveButton("Selesai") { _, _ ->
                    val nama = if("${etNama.text}".isNotEmpty()) "${etNama.text}" else "orang asing"
                    Toast.makeText(this@MainActivity, "Salam kenal, $nama!", Toast.LENGTH_SHORT).show()
                }
                setNegativeButton("Siape lu?") { _, _ ->
                    Toast.makeText(this@MainActivity, "Sombong amat sih!", Toast.LENGTH_SHORT).show()
                }
                setNeutralButton("Maaf, cuma numpang lewat", null) //tidak ada feedback dari aplikasi
                create().show()
            }
        }

    }
}