package br.edu.ifspsaocarlos.sdm.trabalhofinal.activity;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.DialogFragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import br.edu.ifspsaocarlos.sdm.trabalhofinal.R;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, OptionsDialogFragment.NoticeDialogListener{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_dado) {
            Intent intentJogarDado = new Intent(this, JogoDadoActivity.class);
            startActivityForResult(intentJogarDado, R.string.INTENT_JOGAR_DADO);
            return true;

        }
        else if (id == R.id.nav_xadrez) {
            Intent intentConfiguracaoXadrez = new Intent(this, JogoXadrezActivity.class);
            startActivityForResult(intentConfiguracaoXadrez, R.string.INTENT_CONFIGURACAO_XADREZ);
            return true;
        }

        else if (id == R.id.nav_xadrez2) {
            Intent intentConfigXadrez = new Intent(this, ConfigXadrezActivity.class);
            startActivity(intentConfigXadrez);
            return true;
        }
        else if (id == R.id.nav_quiz) {
            // Create an instance of the dialog fragment and show it
            DialogFragment dialog = new OptionsDialogFragment();
            dialog.show(getSupportFragmentManager(), "OptionsDialogFragment");
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    @Override
    public void onDialogItemClick(DialogFragment dialog, int selection ) {
        switch(selection){
            case 0:
                Intent easyIntent = new Intent(this,EasyQuizActivity.class);
                startActivity(easyIntent);
                break;
            case 1:
                Intent hardIntent=new Intent(this,HardQuizActivity.class);
                startActivity(hardIntent);
                break;
            default:
                return;
        }

    }
}
