package br.edu.ifspsaocarlos.sdm.trabalhofinal.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import br.edu.ifspsaocarlos.sdm.trabalhofinal.R;
<<<<<<< HEAD
import br.edu.ifspsaocarlos.sdm.trabalhofinal.model.GameInfo;

public class ConfigXadrezActivity extends AppCompatActivity {

    private static final int INTENT_CRONO_XADREZ = 2;
    private GameInfo gameInfo;
=======

public class ConfigXadrezActivity extends AppCompatActivity {

    private static final int INTENT_JOGO_XADREZ = 2;
>>>>>>> 315cea18a2d92afb49083bd375b259d9f7d19710

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
<<<<<<< HEAD
        setContentView(R.layout.activity_configuracao_xadrez);
=======
        setContentView(R.layout.activity_config_xadrez);
>>>>>>> 315cea18a2d92afb49083bd375b259d9f7d19710
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
<<<<<<< HEAD
        getMenuInflater().inflate(R.menu.menu_configuracao_xadrez, menu);
        return true;
    }

    public void newGame(MenuItem menuItem) {
        // Handle navigation view item clicks here.
        Intent intentConfiguracaoXadrez = new Intent(this, JogoXadrezActivity.class);
        startActivityForResult(intentConfiguracaoXadrez,INTENT_CRONO_XADREZ);

=======
        getMenuInflater().inflate(R.menu.menu_config_xadrez, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.newGame:
                Intent intentJogoXadrez2 = new Intent(this, JogoXadrezActivity2.class);
                startActivityForResult(intentJogoXadrez2, INTENT_JOGO_XADREZ);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
>>>>>>> 315cea18a2d92afb49083bd375b259d9f7d19710
    }
}
