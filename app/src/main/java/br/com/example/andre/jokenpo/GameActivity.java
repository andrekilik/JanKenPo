package br.com.example.andre.jokenpo;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class GameActivity extends AppCompatActivity {

    private Button btnPedra, btnPapel, btnTesoura;
    private ImageView ivPlayPc;
    private int jogada;
    private TextView tvResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        btnPedra = (Button) findViewById(R.id.btnPedra);
        btnPapel = (Button) findViewById(R.id.btnPapel);
        btnTesoura = (Button) findViewById(R.id.btnTesoura);
        ivPlayPc = (ImageView) findViewById(R.id.ivPlayPc);
        tvResultado = (TextView) findViewById(R.id.tvResultado);

        btnPedra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jogada = 0;
                PlayRound(jogada);
            }
        });
        btnPapel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jogada = 1;
                PlayRound(jogada);
            }
        });
        btnTesoura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jogada = 2;
                PlayRound(jogada);
            }
        });

    }

    private void PlayRound(int jogada){
        int jogadaCom = new Random().nextInt(3);
        switch (jogadaCom){
            case 0:
                ivPlayPc.setImageDrawable(ContextCompat.getDrawable(GameActivity.this,R.drawable.pedra));
                switch (jogada){
                    case 0:
                        empate();
                        break;
                    case 1:
                        vitoria();
                        break;
                    case 2:
                        derrota();
                        break;

                }
                break;
            case 1:
                ivPlayPc.setImageDrawable(ContextCompat.getDrawable(GameActivity.this,R.drawable.papel));
                switch (jogada){
                    case 0:
                        derrota();
                        break;
                    case 1:
                        empate();
                        break;
                    case 2:
                        vitoria();
                        break;
                }
                break;
            case 2:
                ivPlayPc.setImageDrawable(ContextCompat.getDrawable(GameActivity.this,R.drawable.tesoura));
                switch (jogada){
                    case 0:
                        vitoria();
                        break;
                    case 1:
                        derrota();
                        break;
                    case 2:
                        empate();
                        break;
                }
                break;
        }
    }
    private void derrota(){
        tvResultado.setText(R.string.derrota);

    }
    private void vitoria(){
        tvResultado.setText(R.string.vitoria);

    }
    private void empate(){
        tvResultado.setText(R.string.empate);

    }
}
