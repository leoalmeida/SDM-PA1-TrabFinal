package br.edu.ifspsaocarlos.sdm.trabalhofinal.model;

/**
 * Created by Leonardo on 19/09/13.
 */
public class SaveGame {
    private int id;
    private String user;

    public int getFase() {
        return fase;
    }

    public void setFase(int fase) {
        this.fase = fase;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private int fase;
}
