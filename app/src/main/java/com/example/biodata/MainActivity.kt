package com.example.biodata

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var dta_nim: EditText
    private lateinit var dta_nama: EditText
    private lateinit var dta_nilai: EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dta_nim = findViewById(R.id.respon_nim)
        dta_nama = findViewById(R.id.respon_nama)
        dta_nilai = findViewById(R.id.respon_nilai)

        supportActionBar?.title = ("Input Data")
        btn_submit.setOnClickListener {
            if (respon_nim.text.isEmpty()) {
                toast("Nim tidak boleh kosong", Toast.LENGTH_LONG)
            } else if (respon_nama.text.isEmpty()) {
                toast("Nama tidak boleh kosong", Toast.LENGTH_LONG)
            } else if (respon_nilai.text.toString().toInt() > 100) {
                toast("Nilai tidak boleh kosong", Toast.LENGTH_LONG)
            } else if (respon_nilai.text.isEmpty()) {
                toast("Nilai tidak boleh lebih dari 100", Toast.LENGTH_LONG)
            } else if (respon_nama.text.isNotEmpty() || respon_nim.text.isNotEmpty() || respon_nilai.text.isNotEmpty()) {
                toast("Sukses Input Data", Toast.LENGTH_LONG)

                val intent = Intent(this, ActivityHasil::class.java)
                intent.putExtra("data_nim", dta_nim.text.toString())
                intent.putExtra("data_nama", dta_nama.text.toString())
                intent.putExtra("data_nilai", dta_nilai.text.toString())
                intent.putExtra("data_grade", dta_nilai.text.toString())
                startActivity(intent)


            }
        }
    }
    private fun toast(message: String, length: Int = Toast.LENGTH_LONG){
        Toast.makeText(this,message,length).show()
    }
}

