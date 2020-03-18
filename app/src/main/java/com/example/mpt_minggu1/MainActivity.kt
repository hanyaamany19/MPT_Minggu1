package com.example.mpt_minggu1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var jam=15
//
//        if (jam <= 12)
//        {
//            Log.i("Hasil", "Selamat Pagi")
//        }
//        else
//        {
//            Log.i("Hasil", "Selamat Petang")
//        }

//        var nilai=70
//
//        if (nilai >= 90 && nilai <= 100)
//        {
//            Log.i("Hasil " ,"A")
//            tampil1.text="Nilai A"
//        }
//        else if (nilai >= 80 && nilai <= 89)
//        {
//            Log.i("Hasil ", "AB")
//            tampil1.text="Nilai AB"
//        }
//        else if (nilai >= 70 && nilai <= 79)
//        {
//            Log.i("Hasil ", "B")
//            tampil1.text="Nilai B"
//        }
//        else if (nilai >= 60 && nilai <= 69)
//        {
//            Log.i("Hasil ", "BC")
//            tampil1.text="Nilai BC"
//        }
//        else
//        {
//            Log.i("Hasil ", "C")
//            tampil1.text="Nilai C"
//        }

//        for (x in 0..10)
//            Log.i("Hasil", "$x")

//        var i = 1
//        while (i <= 5){
//            println("Line $i")
//            ++i
//        }

//        var num = 2
//        var i = 1
//
//        do {
//            Log.i("Hasil", "2 * $i = " +num*i)
//            i++
//        }while (i<11)

//        var a=7
//        var b=5
//        penjumlahan(a,b)

        var a=5
        var b=6
        var c=10
        percobaan(a,b,c)
    }

//    fun penjumlahan(a:Int, b:Int)
//    {
//        var c: Int
//        c=a+b
//        Log.i("Hasil", "$c")
//    }

    fun percobaan(a:Int, b:Int, c:Int)
    {
        var d: Int
        d = (a * b - 10) / c
        Log.i("Hasil", "$d")
    }
}
