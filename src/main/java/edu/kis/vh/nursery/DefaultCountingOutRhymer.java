package edu.kis.vh.nursery;

public class DefaultCountingOutRhymer {

    public static final int CAPACITY = 12;
    public static final int MAX_INDEX = CAPACITY - 1;
    public static final int EMPTY_RHYMER_INDICATOR = -1;
    public static final int DEFAULT_RETURN_VALUE = -1;

    private final int[] NUMBERS = new int[CAPACITY];
    public int total = EMPTY_RHYMER_INDICATOR;

    public void countIn(int in) {
        if (!isFull())
            NUMBERS[++total] = in;
    }

    public boolean callCheck() {
        return total == EMPTY_RHYMER_INDICATOR;
    }

    public boolean isFull() {
        return total == MAX_INDEX;
    }

    protected int peekaboo() {
        if (callCheck())
            return DEFAULT_RETURN_VALUE;
        return NUMBERS[total];
    }

    public int countOut() {
        if (callCheck())
            return DEFAULT_RETURN_VALUE;
        return NUMBERS[total--];
    }
}