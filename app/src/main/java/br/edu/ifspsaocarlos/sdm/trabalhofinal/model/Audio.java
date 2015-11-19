package br.edu.ifspsaocarlos.sdm.trabalhofinal.model;

import android.app.Activity;
import android.media.MediaPlayer;

import br.edu.ifspsaocarlos.sdm.trabalhofinal.R;

/**
 * Created by rodrigues on 12/11/15.
 */
public class Audio {
    private static MediaPlayer mp;

    public static void play(Activity view, int arquivo){
<<<<<<< HEAD
        mp = MediaPlayer.create(view, arquivo);
=======

        mp = MediaPlayer.create(view, arquivo);

        // Implementa metodo para que o audio possa ser executado multiplas vezes
>>>>>>> 315cea18a2d92afb49083bd375b259d9f7d19710
        mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener(){
            public void onCompletion(MediaPlayer mp) {
                mp.stop();
                mp.release();
<<<<<<< HEAD
                mp = null;
=======
>>>>>>> 315cea18a2d92afb49083bd375b259d9f7d19710
            }
        });
        mp.start();
    }
}
<<<<<<< HEAD
=======

>>>>>>> 315cea18a2d92afb49083bd375b259d9f7d19710
