package com.example.quakereport

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_quakes.*

class QuakesActivity : AppCompatActivity() {

    val quakes = listOf(
        Quake(1.83, "115km NNE of Arctic Village, Alaska", 1590316940836),
        Quake(6.4, "66km SE of Hawthorne, Nevada", 1590316886670),
        Quake(5.8, "8km E of Pahala, Hawaii", 1590316484080),
        Quake(7.7, "67km W of Tonopah, Nevada", 1590316469620),
        Quake(8.3, "57km WNW of Tonopah, Nevada", 1590316318880),
        Quake(2.3, "7km SE of Hawthorne, Nevada", 1590316294530),
        Quake(9.9, "23km ENE of Honaunau-Napoopoo, Hawaii", 1590316016300)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quakes)

        quakes_recycler_view.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            adapter = QuakeAdapter(quakes)
        }
    }
}
