package br.edu.ifspsaocarlos.sdm.trabalhofinal.activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import br.edu.ifspsaocarlos.sdm.trabalhofinal.R;


public class JogoXadrezActivity2 extends Activity implements View.OnClickListener {

    private boolean tempoIniciado = false;
    private boolean jogador1Ativo = true;
    private Button btnTrocar; //// TODO: 18/11/15 Incliur botão para parar 
    public TextView txtTempoJogador1, txtTempoJogador2;
    private long tempoJogador1 = 120 * 1000; //// TODO: 18/11/15 Buscar tempo da tela de configuração 
    private long tempoJogador2 = 120 * 1000;
    private final long intervalo = 1000;
    private CountDownTimer countDownTimer1, countDownTimer2;
    //// TODO: 18/11/15 Incluir nome dos jogadores que foram inseridos na tela de configuração

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jogo_xadrez2);

        btnTrocar = (Button) this.findViewById(R.id.btnIniciarXadrez);
        btnTrocar.setOnClickListener(this);

        txtTempoJogador1 = (TextView) this.findViewById(R.id.txtTempoJogador1);
        txtTempoJogador2 = (TextView) this.findViewById(R.id.txtTempoJogador2);

        // Cria temporizador para os jogadores
        countDownTimer1 = new MyCountDownTimer(tempoJogador1, intervalo);
        countDownTimer2 = new MyCountDownTimer(tempoJogador2, intervalo);

        
        // Apresenta na tela os tempos
        txtTempoJogador1.setText(txtTempoJogador1.getText() + String.valueOf(tempoJogador1 / 1000));
        txtTempoJogador2.setText(txtTempoJogador2.getText() + String.valueOf(tempoJogador2 / 1000));
    }

    @Override
    public void onClick(View v) {

        // Se o jogo ainda não foi iniciado
        if (!tempoIniciado) {

            // marca jogo como iniciado
            tempoIniciado = true;
            // marca jogador 1 como ativo
            jogador1Ativo = true;

            // inicia contagem regressiva do jogador 1
            countDownTimer1.start();


        }
        // Se o jogo já foi iniciado
        else {

            // Se o Jogador 1 é quem estava ativo
            if(jogador1Ativo){

                // Jogador 2 é quem vai jogar
                jogador1Ativo = false;
                // Cancela contador do Jogador 1
                countDownTimer1.cancel();

                // Reinicia temporizador do Jogador 2
                countDownTimer2 = new MyCountDownTimer(tempoJogador2, intervalo);
                countDownTimer2.start();

            }
            // Se o Jogador 2 é quem estava jogando
            else {

                // Jogador 1 é quem vai jogar
                jogador1Ativo = true;
                // Cancela contador do Jogador 2
                countDownTimer2.cancel();

                // Reinicia temporizador do Jogador 1
                countDownTimer1 = new MyCountDownTimer(tempoJogador1, intervalo);
                countDownTimer1.start();

            }

        }
        btnTrocar.setText(R.string.trocar);
    }

    public class MyCountDownTimer extends CountDownTimer {
        public MyCountDownTimer(long startTime, long interval) {
            super(startTime, interval);
        }

        @Override
        public void onFinish() {

            // Apresenta mensagem para o jogador ganhador e perdedor
            if (jogador1Ativo){
                txtTempoJogador1.setText(R.string.perdeu);
                txtTempoJogador2.setText(R.string.ganhou);
            }
            else
            {
                txtTempoJogador2.setText(R.string.perdeu);
                txtTempoJogador1.setText(R.string.ganhou);
            }

        }

        @Override
        public void onTick(long millisUntilFinished) {

            // Atualiza na tela o tempo e guarda o tempo atual para ser utilizado na troca de jogadores
            if (jogador1Ativo) {

                txtTempoJogador1.setText("" + millisUntilFinished / 1000);
                tempoJogador1 = millisUntilFinished;

            } else {

                txtTempoJogador2.setText("" + millisUntilFinished / 1000);
                tempoJogador2 = millisUntilFinished;

            }
        }
    }

}