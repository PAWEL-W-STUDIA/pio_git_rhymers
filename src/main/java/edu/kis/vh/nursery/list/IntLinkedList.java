package edu.kis.vh.nursery.list;

public class IntLinkedList {

    private static final int DEFAULT_RETURN_VALUE = -1;

    private Node last;
    private int i;

    public boolean isEmpty() {
        return last == null;
    }

    public boolean isFull() {
        return false;
    }

    public int top() {
        if (isEmpty())
            return DEFAULT_RETURN_VALUE;
        return last.value;
    }

    public int pop() {
        if (isEmpty())
            return DEFAULT_RETURN_VALUE;
        int ret = last.value;
        last = last.prev;
        return ret;
    }
}
