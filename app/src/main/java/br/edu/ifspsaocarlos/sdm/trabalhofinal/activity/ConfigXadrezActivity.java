package br.edu.ifspsaocarlos.sdm.trabalhofinal.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import br.edu.ifspsaocarlos.sdm.trabalhofinal.R;

public class ConfigXadrezActivity extends AppCompatActivity {

    private static final int INTENT_JOGO_XADREZ = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config_xadrez);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
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
    }
}
