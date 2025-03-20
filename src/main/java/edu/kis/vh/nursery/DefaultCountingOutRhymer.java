private final int MAX_SIZE = 100;

package edu.kis.vh.nursery;


public class DefaultCountingOutRhymer {
    int final size = 12;
    int final err = -1;
    private int[] numbers = new int[size];

    public int total = -1;

    public void countIn(int in) {
        if (!isFull())
            numbers[++total] = in;
    }

    public boolean callCheck() {
        return total == -1;
    }

    public boolean isFull() {
        return total == 11;
    }

    protected int peekaboo() {
        if (callCheck())
            return err;
        return numbers[total];
    }

    public int countOut() {
        if (callCheck())
            return err;
        return numbers[total--];
    }

}
