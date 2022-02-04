package ru.lukmanov.kotlin_lesson1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val w = Weather("Москва", -17)
        val text1 : TextView = findViewById(R.id.feature1)
        val text2 : TextView = findViewById(R.id.feature2)
        val text3 : TextView = findViewById(R.id.ObjectCopy)
        val text4 : TextView = findViewById(R.id.Cycle1)
        val text5 : TextView = findViewById(R.id.Cycle2)
        val text6 : TextView = findViewById(R.id.Cycle3)
        val button1 : Button = findViewById(R.id.button1)
        val weatherList : List<Weather> = listOf(Weather("Краснодар", 15), Weather("Уфа", -25),
            Weather("Казань", -15))
        button1.setOnClickListener{
            text1.text = w.town
            text2.text = w.temperature.toString()
            text3.text = Weather.copy(town = "Санкт-Петербург") as String
            for (weather in weatherList) {
                text4.text=weather.town
                text4.text = weather.town+weather.temperature.toString()
                println(weather)
            }
            for (i in 0..2){
                text5.text = weatherList[0].town+"   "+weatherList[0].temperature.toString()
                text6.text = weatherList[1].town+"   "+weatherList[1].temperature.toString()
                println(weatherList[i])
            }
        }
    }


    data class Weather(val town: String = "", val temperature: Int = 0){
        companion object Object{
            fun copy(town: String): Any {
                return town
            }
        }

    }
}