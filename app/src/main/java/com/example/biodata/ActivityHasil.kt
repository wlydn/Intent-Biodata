package com.example.biodata


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_hasil.*

class ActivityHasil : AppCompatActivity() {

    private lateinit var view_nim  : TextView
    private lateinit var view_nama : TextView
    private lateinit var view_nilai: TextView
    private lateinit var view_grade: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hasil)

        view_nim= findViewById(R.id.akhir_nim)
        view_nama = findViewById(R.id.akhir_nama)
        view_nilai= findViewById(R.id.akhir_nilai)
        view_grade= findViewById(R.id.akhir_grade)

        supportActionBar?.title="Hasil Output"

        view_nim.setText(intent.getStringExtra("data_nim"))
        view_nama.setText(intent.getStringExtra("data_nama"))
        view_nilai.setText(intent.getStringExtra("data_nilai"))
//        grade_nilai.setText(intent.getStringExtra("data_ket"))
        if (intent.getStringExtra("data_grade").toInt()>=80){
            akhir_grade.text = "A"
        }else if ((intent.getStringExtra("data_grade").toInt()>=60)){
            akhir_grade.text = "B"
        }else if((intent.getStringExtra("data_grade").toInt()>=40)){
            akhir_grade.text = "C"
        }else if((intent.getStringExtra("data_grade").toInt()>=20)){
            akhir_grade.text = "D"
        }else if((intent.getStringExtra("data_grade").toInt()>=0)){
            akhir_grade.text = "E"
        }
        btn_back.setOnClickListener(){
            intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
    }
}
