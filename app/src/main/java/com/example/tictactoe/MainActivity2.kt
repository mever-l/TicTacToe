package com.example.tictactoe

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity2 : AppCompatActivity() {
    var currentPlayer = "X"
    var currentPlayerDrawable = R.drawable.x_icon
    var board = arrayOf(
        arrayOf("", "", ""),
        arrayOf("", "", ""),
        arrayOf("", "", "")
    )
    val turnText: TextView by lazy {
        findViewById(R.id.turn)  // Replace with your actual view ID
    }
    val restartButton: Button by lazy {
        findViewById(R.id.restart)
    }


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

        // Init all buttons
        findViewById<ImageView?>(R.id.box_top_start).apply {
            setOnClickListener {
                if(openBox(0, 0)) {
                    setImageResource(currentPlayerDrawable);
                    turn(0,0);
                }
            }
        }
        findViewById<ImageView?>(R.id.box_center_start).apply {
            setOnClickListener {
                if(openBox(1, 0)) {
                    setImageResource(currentPlayerDrawable);
                    turn(1,0);
                }
            }
        }
        findViewById<ImageView?>(R.id.box_bottom_start).apply {
            setOnClickListener {
                if(openBox(2, 0)) {
                    setImageResource(currentPlayerDrawable);
                    turn(2,0);
                }
            }
        }
        findViewById<ImageView?>(R.id.box_top_center).apply {
            setOnClickListener {
                if(openBox(0, 1)) {
                    setImageResource(currentPlayerDrawable);
                    turn(0,1);
                }
            }
        }
        findViewById<ImageView?>(R.id.box_center_center).apply {
            setOnClickListener {
                if(openBox(1, 1)) {
                    setImageResource(currentPlayerDrawable);
                    turn(1,1);
                }
            }
        }
        findViewById<ImageView?>(R.id.box_bottom_center).apply {
            setOnClickListener {
                if(openBox(2, 1)) {
                    setImageResource(currentPlayerDrawable);
                    turn(2,1);
                }
            }
        }
        findViewById<ImageView?>(R.id.box_top_end).apply {
            setOnClickListener {
                if(openBox(0, 2)) {
                    setImageResource(currentPlayerDrawable);
                    turn(0,2);
                }
            }
        }
        findViewById<ImageView?>(R.id.box_center_end).apply {
            setOnClickListener {
                if(openBox(1, 2)) {
                    setImageResource(currentPlayerDrawable);
                    turn(1,2);
                }
            }
        }
        findViewById<ImageView?>(R.id.box_bottom_end).apply {
            setOnClickListener {
                if(openBox(2, 2)) {
                    setImageResource(currentPlayerDrawable);
                    turn(2,2);
                }
            }
        }
    }

    fun moveTurn() {
        if(this.currentPlayer.equals("X")) {
            this.currentPlayer = "O"
            this.currentPlayerDrawable = R.drawable.o_icon
            this.turnText.text = "O turn"
        } else {
            this.currentPlayer = "X"
            this.currentPlayerDrawable = R.drawable.x_icon
            this.turnText.text = "X turn"

        }
    }

    fun turn(row: Int, col: Int) {
        this.board[row][col] = currentPlayer
        val winner = checkWinner(row, col)
        if(winner != null) {
            this.turnText.text = "won"
            this.restartButton.text = "Restart game"
            this.restartButton.apply {
            setOnClickListener{
               restartGame()
            }
            }
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

    fun restartGame() {
        this.board = arrayOf(
            arrayOf("", "", ""),
            arrayOf("", "", ""),
            arrayOf("", "", "")
        )
        findViewById<ImageView?>(R.id.box_top_start).apply {
            setImageResource(0)
        }
        findViewById<ImageView?>(R.id.box_center_start).apply {
            setImageResource(0)
        }
        findViewById<ImageView?>(R.id.box_bottom_start).apply {
            setImageResource(0)
        }
        findViewById<ImageView?>(R.id.box_center_end).apply {
            setImageResource(0)
        }
        findViewById<ImageView?>(R.id.box_top_center).apply {
            setImageResource(0)
        }
        findViewById<ImageView?>(R.id.box_center_center).apply {
            setImageResource(0)
        }
        findViewById<ImageView?>(R.id.box_bottom_center).apply {
            setImageResource(0)
        }
        findViewById<ImageView?>(R.id.box_top_end).apply {
            setImageResource(0)
        }
        findViewById<ImageView?>(R.id.box_bottom_end).apply {
            setImageResource(0)
        }
        this.currentPlayer = "X";
        this.currentPlayerDrawable = R.drawable.x_icon
        this.turnText.text = "X turn"
        restartButton.text= ""

    }
}