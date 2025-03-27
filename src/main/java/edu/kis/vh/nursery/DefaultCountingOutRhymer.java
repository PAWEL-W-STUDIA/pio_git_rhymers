package edu.kis.vh.nursery;

public class DefaultCountingOutRhymer {

    private static final int _11 = 11;

    private static final int INT = -1;

    private int[] numbers = new int[12];

    public int total = INT;

    public void countIn(int in) {
        if (!isFull())
            numbers[++total] = in;
    }

    public boolean callCheck() {
        return total == INT;
    }

    public boolean isFull() {
        return total == _11;
    }

    protected int peekaboo() {
        if (callCheck())
            return INT;
        return numbers[total];
    }

    public int countOut() {
        if (callCheck())
            return INT;
        return numbers[total--];
    }

}
