package edu.kis.vh.nursery;

import org.junit.Assert;
import org.junit.Test;

public class RhymersJUnitTest {

    public static final int TEST_VALUE = 4;
    public static final int IN = 888;
    public static final int STACK_CAPACITY = 12;
    public static final int I = 0;
    public static final int EMPTY_STACK_VALUE = -1;

    @Test
    public void testCountIn() {
        DefaultCountingOutRhymer rhymer = new DefaultCountingOutRhymer();
        int testValue = TEST_VALUE;
        rhymer.countIn(testValue);

        int result = rhymer.peekaboo();
        Assert.assertEquals(testValue, result);
    }

    @Test
    public void testCallCheck() {
        DefaultCountingOutRhymer rhymer = new DefaultCountingOutRhymer();
        boolean result = rhymer.callCheck();
        Assert.assertTrue(result); // Zamiast assertEquals(true, result)

        rhymer.countIn(IN);

        result = rhymer.callCheck();
        Assert.assertFalse(result); // Zamiast assertEquals(false, result)
    }

    @Test
    public void testIsFull() {
        DefaultCountingOutRhymer rhymer = new DefaultCountingOutRhymer();
        final int STACK_CAPACITY = RhymersJUnitTest.STACK_CAPACITY;
        for (int i = I; i < STACK_CAPACITY; i++) {
            boolean result = rhymer.isFull();
            Assert.assertEquals(false, result);
            rhymer.countIn(IN);
        }

        boolean result = rhymer.isFull();
        Assert.assertEquals(true, result);
    }

    @Test
    public void testPeekaboo() {
        DefaultCountingOutRhymer rhymer = new DefaultCountingOutRhymer();
        final int EMPTY_STACK_VALUE = RhymersJUnitTest.EMPTY_STACK_VALUE;

        int result = rhymer.peekaboo();
        Assert.assertEquals(EMPTY_STACK_VALUE, result);

        int testValue = TEST_VALUE;
        rhymer.countIn(testValue);

        result = rhymer.peekaboo();
        Assert.assertEquals(testValue, result);
        result = rhymer.peekaboo();
        Assert.assertEquals(testValue, result);
    }

    @Test
    public void testCountOut() {
        DefaultCountingOutRhymer rhymer = new DefaultCountingOutRhymer();
        final int EMPTY_STACK_VALUE = RhymersJUnitTest.EMPTY_STACK_VALUE;

        int result = rhymer.countOut();
        Assert.assertEquals(EMPTY_STACK_VALUE, result);

        int testValue = TEST_VALUE;
        rhymer.countIn(testValue);

        result = rhymer.countOut();
        Assert.assertEquals(testValue, result);
        result = rhymer.countOut();
        Assert.assertEquals(EMPTY_STACK_VALUE, result);
    }

    @Test
    public void testHanoiRhymerRejected() {
        HanoiRhymer rhymer = new HanoiRhymer();
        rhymer.countIn(5); // Można założyć, że 5 będzie akceptowane
        rhymer.countIn(3); // 3 powinno być odrzucone, ponieważ jest mniejsze niż 5
        rhymer.countIn(8); // 8 będzie akceptowane

        int rejected = rhymer.reportRejected();
        Assert.assertEquals(1, rejected); // Jeden odrzucony element
    }

    @Test
    public void testLargeInput() {
        DefaultCountingOutRhymer rhymer = new DefaultCountingOutRhymer();
        for (int i = 0; i < 1000; i++) {
            rhymer.countIn(i);
        }

        for (int i = 999; i >= 0; i--) {
            int result = rhymer.countOut();
            Assert.assertEquals(i, result); // Sprawdzamy, czy wartości są poprawnie wypisane
        }
    }

}