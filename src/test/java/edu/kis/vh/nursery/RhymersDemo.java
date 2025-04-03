package edu.kis.vh.nursery;

import edu.kis.vh.nursery.factory.DefaultRhymersFactory;
import edu.kis.vh.nursery.factory.Rhymersfactory;

public class RhymersDemo {

    public static void main(String[] args) {
        Rhymersfactory factory = new DefaultRhymersFactory();
        testRhymers(factory);
    }

    /**
     * Testuje różne typy stosów, wykonując na nich operacje.
     *
     * @param factory Fabryka stosów do utworzenia różnych implementacji stosów.
     */
    public static void testRhymers(Rhymersfactory factory) {
        DefaultCountingOutRhymer[] rhymers = {
                factory.getStandardRhymer(),
                factory.getFalseRhymer(),
                factory.getFIFORhymer(),
                factory.getHanoiRhymer()
        };

        fillRhymers(rhymers);
        randomFillHanoiRhymer(rhymers[3]);
        printRhymersContent(rhymers);

        System.out.println("Total rejected is " + ((HanoiRhymer) rhymers[3]).reportRejected());
    }

    /**
     * Wypełnia wszystkie stosy liczbami od 1 do 14.
     *
     * @param rhymers Tablica stosów do wypełnienia.
     */
    private static void fillRhymers(DefaultCountingOutRhymer[] rhymers) {
        for (int i = 1; i < 15; i++) {
            for (int j = 0; j < 3; j++) {
                rhymers[j].countIn(i);
            }
        }
    }

    /**
     * Losowo wypełnia HanoiRhymer liczbami.
     *
     * @param hanoiRhymer Stos typu HanoiRhymer.
     */
    private static void randomFillHanoiRhymer(DefaultCountingOutRhymer hanoiRhymer) {
        java.util.Random rn = new java.util.Random();
        for (int i = 1; i < 15; i++) {
            hanoiRhymer.countIn(rn.nextInt(20));
        }
    }

    /**
     * Wypisuje zawartość wszystkich stosów na ekranie.
     *
     * @param rhymers Tablica stosów do wypisania.
     */
    private static void printRhymersContent(DefaultCountingOutRhymer[] rhymers) {
        for (int i = 0; i < rhymers.length; i++) {
            while (!rhymers[i].callCheck()) {
                System.out.print(rhymers[i].countOut() + "  ");
            }
            System.out.println();
        }
    }
}
