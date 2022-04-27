package cz.czechitas.kockamyssyr;

// cz.czechitas.kockamyssyr.HlavniProgram

import cz.czechitas.kockamyssyr.api.*;

import java.awt.*;
import java.util.Random;

/**
 * Hlaví třída pro hru Kočka–myš–sýr.
 */
public class HlavniProgram {
    private final Random random = new Random();
    private Cat tom;
    private Mouse jerry;


    /**
     * Spouštěcí metoda celé aplikace.
     *
     * @param args
     */
    public static void main(String[] args) {
        new HlavniProgram().run();
    }

    /**
     * Hlavní metoda obsahující výkonný kód.
     */
    public void run() {
        vytvorStromy(10);

        // TODO: Sem vepište svůj program

        tom = new Cat(vytvorNahodneSouradnice());
        tom.setBrain(new KeyboardBrain());

        new Cheese(new Point(200, 200));

        jerry = new Mouse(new Point(600, 200));
        jerry.setBrain(new KeyboardBrain(KeyCode.W, KeyCode.A, KeyCode.S, KeyCode.D));

        new Meat(new Point(200, 500));
    }

    private void vytvorStromy(int pocet) {
        for (int i = 0; i < pocet; i++) {
            new Tree(vytvorNahodneSouradnice());
        }
    }

    private Point vytvorNahodneSouradnice() {
        Point point = new Point(random.nextInt(950), random.nextInt(550));
        return point;
    }

}