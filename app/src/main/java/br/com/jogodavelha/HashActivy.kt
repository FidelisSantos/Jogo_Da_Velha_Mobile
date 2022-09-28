package br.com.jogodavelha

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import br.com.jogodavelha.R.layout
import br.com.jogodavelha.data.GameRepository
import br.com.jogodavelha.data.storyGame


class HashActivy : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_hash_activy)
    }

    fun btnClick(view: View) {
        val btSelecionado = view as Button
        var cellID = 0

        when(btSelecionado.id){
            R.id.btn1 -> cellID = 1
            R.id.btn2 -> cellID = 2
            R.id.btn3 -> cellID = 3
            R.id.btn4 -> cellID = 4
            R.id.btn5 -> cellID = 5
            R.id.btn6 -> cellID = 6
            R.id.btn7 -> cellID = 7
            R.id.btn8 -> cellID = 8
            R.id.btn9 -> cellID = 9
            R.id.btn_restart -> cellID = -1
            R.id.btn_exit -> cellID = -2
        }
        //Toast.makeText(this, "ID "+cellID, Toast.LENGTH_LONG).show()
        if(cellID == -1)
        {
            Restart()
        }
        else if(cellID == -2){
            Exit()
        }
        else{
            playGame(cellID,btSelecionado)
        }


    }

    var player1= ArrayList<Int>()
    var player2= ArrayList<Int>()
    var activeplayer = 1
    var count = 0
    fun playGame(cellID:Int, btselecionado: Button) {
        if(activeplayer == 1){
            btselecionado.text ="X"
            player1.add(cellID)
            activeplayer = 2
        }else{
            btselecionado.text = "O"
            player2.add(cellID)
            activeplayer = 1
        }

        btselecionado.isEnabled = false
        checkWiner()
    }


    fun checkWiner(){
        var winer = -1
        count ++
        if(count >= 9)
        {
            result(winer)
            saveGame(winer)
        }
        if(player1.contains(1) && player1.contains(2) && player1.contains(3) || player1.contains(4) &&  player1.contains(5) &&  player1.contains(6) || player1.contains(7) &&  player1.contains(8) &&  player1.contains(9)){
            winer = 1
            saveGame(winer)
            result(winer)
        }
        if(player2.contains(1) && player2.contains(2) && player2.contains(3) || player2.contains(4) &&  player2.contains(5) &&  player2.contains(6) || player2.contains(7) &&  player2.contains(8) &&  player2.contains(9)){
            winer = 2
            saveGame(winer)
            result(winer)
        }
        if(player1.contains(1) && player1.contains(4) && player1.contains(7) || player1.contains(2) && player1.contains(5) && player1.contains(8)|| player1.contains(3) && player1.contains(6) && player1.contains(9)){
            winer = 1
            saveGame(winer)
            result(winer)
        }
        if(player2.contains(1) && player2.contains(4) && player2.contains(7) || player2.contains(2) && player2.contains(5) && player2.contains(8) || player2.contains(3) && player2.contains(6) && player2.contains(9)){
            winer = 2
            saveGame(winer)
            result(winer)
        }
        if(player1.contains(1) && player1.contains(5) && player1.contains(9) || player1.contains(3) && player1.contains(5) && player1.contains(7)){
            winer = 1
            saveGame(winer)
            result(winer)
        }
        if(player2.contains(1) && player2.contains(5) && player2.contains(9) || player2.contains(3) && player2.contains(5) && player2.contains(7)){
            winer = 2
            saveGame(winer)
            result(winer)
        }

    }

    fun Restart(){
        var textResult = findViewById<Button>(R.id.btn1);
        textResult.text = ""
        var btnReset = findViewById<Button>(R.id.btn1);
        btnReset.isEnabled = true
        btnReset.text = ""
        btnReset = findViewById<Button>(R.id.btn2);
        btnReset.isEnabled = true
        btnReset.text = ""
        btnReset = findViewById<Button>(R.id.btn3);
        btnReset.isEnabled = true
        btnReset.text = ""
        btnReset = findViewById<Button>(R.id.btn4);
        btnReset.isEnabled = true
        btnReset.text = ""
        btnReset = findViewById<Button>(R.id.btn5);
        btnReset.isEnabled = true
        btnReset.text = ""
        btnReset = findViewById<Button>(R.id.btn6);
        btnReset.isEnabled = true
        btnReset.text = ""
        btnReset = findViewById<Button>(R.id.btn7);
        btnReset.isEnabled = true
        btnReset.text = ""
        btnReset = findViewById<Button>(R.id.btn8);
        btnReset.isEnabled = true
        btnReset.text = ""
        btnReset = findViewById<Button>(R.id.btn9);
        btnReset.isEnabled = true
        btnReset.text = ""
    }

    fun Exit(){
        Restart()
        finish()
    }
    fun result (winner: Int)
    {
        var TextResult = findViewById<TextView>(R.id.textResult);
        if (winner == 1)
        {
            TextResult.text = "Player 1 ganhou"
        }
        else if (winner == 2)
        {
            TextResult.text = "Player 2 ganhou"
        }
        else
        {
            TextResult.text = "Deu velha"
        }

        var textResult = findViewById<Button>(R.id.btn1);
        textResult.isEnabled = false
        textResult = findViewById<Button>(R.id.btn2);
        textResult.isEnabled = false
        textResult = findViewById<Button>(R.id.btn3);
        textResult.isEnabled = false
        textResult = findViewById<Button>(R.id.btn4);
        textResult.isEnabled = false
        textResult = findViewById<Button>(R.id.btn5);
        textResult.isEnabled = false
        textResult = findViewById<Button>(R.id.btn6);
        textResult.isEnabled = false
        textResult = findViewById<Button>(R.id.btn7);
        textResult.isEnabled = false
        textResult = findViewById<Button>(R.id.btn8);
        textResult.isEnabled = false
        textResult = findViewById<Button>(R.id.btn9);
        textResult.isEnabled = false

    }
    fun saveGame(winer : Int)
    {
        if(winer == 1 ||winer == 2)
        {
            val game = storyGame(
                game = "Jogo Recente",
                winner = "Player" + winer + "venceu o jogo"
            )
            GameRepository.getInstance().save(game)
        }
        else{
            val game = storyGame(
                game = "Jogo Recente",
                winner = "Deu Velha"
            )
            GameRepository.getInstance().save(game)
        }
        onBackPressed()
    }
}