package csci.apsu.tictactoe;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class GameEndActivity extends AppCompatActivity {

    public static Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_game);

        TextView textView = findViewById(R.id.winner_textView);

        intent = getIntent();
        if (intent.getExtras() != null) {
            if (getIntent().hasExtra("Player 1")) {
                textView.setText(R.string.player1_wins);
            } else {
                textView.setText(R.string.player2_wins);
            }
        } else {
            textView.setText(R.string.tie);
        }

        // Restart the game
        Button replayButton = findViewById(R.id.replayButton);
        replayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(getApplicationContext(), PlayNumericalActivity.class);
                startActivity(intent);
            }
        });

        // Return to main menu
        Button menuButton = findViewById(R.id.menuButton);
        menuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }
}