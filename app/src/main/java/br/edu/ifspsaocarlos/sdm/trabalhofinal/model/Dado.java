package br.edu.ifspsaocarlos.sdm.trabalhofinal.model;

import android.app.Activity;
import android.media.MediaPlayer;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import br.edu.ifspsaocarlos.sdm.trabalhofinal.R;


/**
 * Created by rodrigues on 12/11/15.
 */
public class Dado implements Serializable {
    private final int faceMenor = 1;
    private final int faceMaior = 6;
    private final int arquivoAudio = R.raw.dado;
    private Map<Integer, Integer> faces = new HashMap<Integer, Integer>();

    public Dado(){

        faces.put(1,R.drawable.dado1);
        faces.put(2,R.drawable.dado2);
        faces.put(3,R.drawable.dado3);
        faces.put(4,R.drawable.dado4);
        faces.put(5,R.drawable.dado5);
        faces.put(6,R.drawable.dado6);
    }

    public int jogarDado(Activity view) {

        Audio.play(view, arquivoAudio);

        Random random = new Random();

        int numero = random.nextInt((faceMaior - faceMenor) + 1) + faceMenor;

        return faces.get(numero);


    }
}
