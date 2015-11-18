package br.edu.ifspsaocarlos.sdm.trabalhofinal.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import br.edu.ifspsaocarlos.sdm.trabalhofinal.R;
import br.edu.ifspsaocarlos.sdm.trabalhofinal.model.GameInfo;

public class ConfigXadrezActivity extends AppCompatActivity {

    private static final int INTENT_CRONO_XADREZ = 2;
    private GameInfo gameInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracao_xadrez);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_configuracao_xadrez, menu);
        return true;
    }

    public void newGame(MenuItem menuItem) {
        // Handle navigation view item clicks here.
        Intent intentConfiguracaoXadrez = new Intent(this, JogoXadrezActivity.class);
        startActivityForResult(intentConfiguracaoXadrez,INTENT_CRONO_XADREZ);

    }
}
