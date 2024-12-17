package com.example.tictactoe

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity2 : AppCompatActivity() {
    private var currentPlayer = "X"
    private val board = arrayOf(
        arrayOf("", "", ""),
        arrayOf("", "", ""),
        arrayOf("", "", "")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        // Generic start of activity
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        findViewById<TextView>(R.id.turn).text = "X turn";
        // Init all buttons
        findViewById<ImageView?>(R.id.box_top_start).apply {
            setOnClickListener {
                if(openBox(0, 0)) {
                    setImageResource(R.drawable.ic_launcher_foreground);
                    turn(0,0);
                }
                //add function call for logic
            }
        }
    }

    fun moveTurn() {
        if(this.currentPlayer.equals("X")) {
            this.currentPlayer = "O"
            findViewById<TextView>(R.id.turn).text = "O turn";
        } else {
            this.currentPlayer = "X"
            findViewById<TextView>(R.id.turn).text = "X turn";
        }
    }

    fun turn(row: Int, col: Int) {
        this.board[row][col] = currentPlayer
        val winner = checkWinner(row, col)
        if(winner != null) {
            val intent = Intent(this, EndGameActivity::class.java).apply {
                putExtra("winner", winner)
            };
            startActivity(intent);
        }
        moveTurn();
    }

    fun openBox(row: Int, col: Int): Boolean {
        return this.board[row][col] === ""
    }

    fun checkWinner(row: Int, col: Int): String? {
        if (this.board[row][0] == currentPlayer && this.board[row][1] == currentPlayer  && this.board[row][2] == currentPlayer) {
            return currentPlayer
        }

        if (this.board[0][col] == currentPlayer && this.board[1][col] == currentPlayer  && this.board[2][col] == currentPlayer) {
            return currentPlayer
        }

        // Check diagonals
        if (this.board[0][0] == currentPlayer && this.board[1][1] == currentPlayer && board[2][2] == currentPlayer) {
            return currentPlayer
        }
        if (this.board[2][2] == currentPlayer && this.board[1][1] == currentPlayer && board[0][2] == currentPlayer) {
            return currentPlayer
        }

        return null
    }
}