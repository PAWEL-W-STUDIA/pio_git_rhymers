package edu.kis.vh.nursery;

import edu.kis.vh.nursery.DefaultCountingOutRhymer;
import edu.kis.vh.nursery.HanoiRhymer;
import edu.kis.vh.nursery.factory.DefaultRhymersFactory;
import edu.kis.vh.nursery.factory.Rhymersfactory;

class RhymersDemo {

    public static void main(String[] args) {
        Rhymersfactory factory = new DefaultRhymersFactory();
        
        DefaultCountingOutRhymer[] rhymers = createRhymers(factory);
        
        fillRhymers(rhymers);
        
        fillHanoiRhymerWithRandomValues(rhymers);
        
        printRhymers(rhymers);
        
        printTotalRejected((HanoiRhymer) rhymers[3]);
    }

    private static DefaultCountingOutRhymer[] createRhymers(Rhymersfactory factory) {
        return new DefaultCountingOutRhymer[] {
            factory.getStandardRhymer(),
            factory.getFalseRhymer(),
            factory.getFifoRhymer(),
            factory.getHanoiRhymer()
        };
    }

    private static void fillRhymers(DefaultCountingOutRhymer[] rhymers) {
        for (int i = 1; i < 15; i++) {
            for (int j = 0; j < 3; j++) {
                rhymers[j].countIn(i);
            }
        }
    }

    private static void fillHanoiRhymerWithRandomValues(DefaultCountingOutRhymer[] rhymers) {
        java.util.Random rn = new java.util.Random();
        for (int i = 1; i < 15; i++) {
            rhymers[3].countIn(rn.nextInt(20));
        }
    }

    private static void printRhymers(DefaultCountingOutRhymer[] rhymers) {
        for (int i = 0; i < rhymers.length; i++) {
            while (!rhymers[i].callCheck()) {
                System.out.print(rhymers[i].countOut() + "  ");
            }
            System.out.println();
        }
    }

    private static void printTotalRejected(HanoiRhymer hanoiRhymer) {
        System.out.println("total rejected is " + hanoiRhymer.reportRejected());
    }
}
