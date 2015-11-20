package br.edu.ifspsaocarlos.sdm.trabalhofinal.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;

import br.edu.ifspsaocarlos.sdm.trabalhofinal.R;

/**
 * Created by Leonardo on 06/09/13.
 */
public class SplashActivity extends Activity implements Runnable{

    private Thread mSplashThread;
    private boolean mblnClicou = false;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);

        //android.os.SystemClock.sleep(0);
        //Handler handler = new Handler();
        //handler.postDelayed(this,0);
        //thread para mostrar uma tela de Splash

        mSplashThread = new Thread(this);
        mSplashThread.start();

    }
    @Override
    public void onPause()
    {
        super.onPause();

        //garante que quando o usuário clicar no botão
        //"Voltar" o sistema deve finalizar a thread
        mSplashThread.interrupt();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            //o método abaixo está relacionado a thread de splash
            synchronized(mSplashThread){
                mblnClicou = true;

                //o método abaixo finaliza o comando wait
                //mesmo que ele não tenha terminado sua espera
                mSplashThread.notifyAll();
            }
        }
        return true;
    }
    @Override
    public void run() {
        try {
            synchronized(this){
                //Espera por 5 segundos or sai quando
                //o usuário tocar na tela
                wait(5000);
                mblnClicou = true;
            }
        }
        catch(InterruptedException ex){
        }

        if (mblnClicou){
            //fechar a tela de Splash
            finish();

            //Carrega a Activity Principal
            Intent i = new Intent();
            i.setClass(this, MainActivity.class);
            startActivity(i);
        }
    }
}
