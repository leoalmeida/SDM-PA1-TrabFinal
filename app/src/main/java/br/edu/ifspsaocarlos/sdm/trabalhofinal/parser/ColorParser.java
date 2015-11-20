package br.edu.ifspsaocarlos.sdm.trabalhofinal.parser;

/**
 * Created by Leonardo on 02/10/13.
 */
public abstract class ColorParser {
    static public String toRgba(int hex) {
        String h = Integer.toHexString(hex);
        int a = Integer.parseInt(h.substring(0, 2),16);
        int r = Integer.parseInt(h.substring(2, 4),16);
        int g = Integer.parseInt(h.substring(4, 6),16);
        int b = Integer.parseInt(h.substring(6, 8),16);
        return String.format("%d,%d,%d,%d", r, g, b, a);
    }
}
