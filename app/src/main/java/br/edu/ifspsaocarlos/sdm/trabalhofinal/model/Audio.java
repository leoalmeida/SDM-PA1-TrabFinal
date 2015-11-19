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
        mp = MediaPlayer.create(view, arquivo);

        mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener(){
            public void onCompletion(MediaPlayer mp) {
                mp.stop();
                mp.release();
                mp = null;
            }
        });
        mp.start();
    }
}
