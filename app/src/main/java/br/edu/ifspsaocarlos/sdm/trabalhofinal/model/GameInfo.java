package br.edu.ifspsaocarlos.sdm.trabalhofinal.model;


import java.util.HashMap;
import java.util.Map;

import br.edu.ifspsaocarlos.sdm.trabalhofinal.R;

/**
 * Created by LeonardoAlmeida on 18/11/15.
 */
public class GameInfo {
    private Map<Integer, String>  jogadores = new HashMap<Integer, String>();;
    private int tempoJogo;

    public GameInfo(Map<Integer, String> jogadores, Integer tempoJogo){
        this.jogadores = jogadores;
        this.tempoJogo = tempoJogo;
    }

}
