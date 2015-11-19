package br.edu.ifspsaocarlos.sdm.trabalhofinal.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import br.edu.ifspsaocarlos.sdm.trabalhofinal.R;
import br.edu.ifspsaocarlos.sdm.trabalhofinal.model.Dado;

public class JogoDadoActivity extends Activity {
    private ImageView imgDado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jogar_dado);

        imgDado = (ImageView) findViewById(R.id.imgDado);

    }

    public void OnClickJogarDado(View v) {

        Dado dado = new Dado();

        // Mostra na tela a face do dado que foi sorteada
        imgDado.setImageResource(dado.jogarDado(this));

    }


}

