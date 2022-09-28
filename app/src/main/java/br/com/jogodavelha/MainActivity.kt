package br.com.jogodavelha

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.jogodavelha.adapter.GameAdapter
import br.com.jogodavelha.data.GameRepository

class MainActivity : AppCompatActivity() {
    var repository : GameRepository = GameRepository();
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnPlay = findViewById<Button>(R.id.btnPlay)
        btnPlay.setOnClickListener(){
            startActivity(Intent(this@MainActivity,HashActivy::class.java))


        }
    }
    override fun onResume() {
        super.onResume()

        var games = repository.listGames()
        var textGameNull = findViewById<TextView>(R.id.textGameNull)
        textGameNull.visibility = if (games.size > 0) View.INVISIBLE else View.VISIBLE
        var recyclerViewGames = findViewById<RecyclerView>(R.id.recyclerGame)
        recyclerViewGames.adapter= GameAdapter(games)
        recyclerViewGames.layoutManager = LinearLayoutManager(this)
    }
}