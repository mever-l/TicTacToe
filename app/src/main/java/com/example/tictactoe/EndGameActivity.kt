package com.example.tictactoe;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class EndGameActivity: AppCompatActivity()  {
    override fun onCreate(savedInstanceState: Bundle?){
        // Generic start of activity
        super.onCreate(savedInstanceState)
        enableEdgeToEdge();
        setContentView(R.layout.activity_end_game)
    }
}
