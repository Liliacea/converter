
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Testing convert iterate.
 */
public class ConverterTest {
    /**
     * Standard interface Iterator.
     */
    private Iterator<Integer> it;

    /**
     * Create an iterator from nested iterators and convert it.
     */
    @Before
    public void setUp() {
        Iterator<Integer> it1 = Arrays.asList(1, 2, 3).iterator();
        Iterator<Integer> it2 = Arrays.asList(4, 5, 6).iterator();
        Iterator<Integer> it3 = Arrays.asList(7, 8, 9).iterator();
        Iterator<Iterator<Integer>> its = Arrays.asList(it1, it2, it3).iterator();
        Converter iteratorOfIterators = new Converter();
        it = iteratorOfIterators.convert(its);

    }

    /**
     * Testing hasNext() and next() methods.
     */
    @Test
    public void hasNextNextSequentialInvocation() {

        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(2));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(3));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(4));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(5));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(6));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(7));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(8));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(9));
        assertThat(it.hasNext(), is(false));
    }

    /**
     * Testing next() method.
     */
    @Test
    public void testsThatNextMethodDoesntDependsOnPriorHasNextInvocation() {
        assertThat(it.next(), is(1));
        assertThat(it.next(), is(2));
        assertThat(it.next(), is(3));
        assertThat(it.next(), is(4));
        assertThat(it.next(), is(5));
        assertThat(it.next(), is(6));
        assertThat(it.next(), is(7));
        assertThat(it.next(), is(8));
        assertThat(it.next(), is(9));
    }

    /**
     * Testing hasNext() twice the result should be the same.
     */
    @Test
    public void sequentialHasNextInvocationDoesntAffectRetrievalOrder() {
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1));
        assertThat(it.next(), is(2));
        assertThat(it.next(), is(3));
        assertThat(it.next(), is(4));
        assertThat(it.next(), is(5));
        assertThat(it.next(), is(6));
        assertThat(it.next(), is(7));
        assertThat(it.next(), is(8));
        assertThat(it.next(), is(9));
    }

    /**
     * Testing on empty list.
     * hasNext() should be false.
     */
    @Test
    public void hasNextShouldReturnFalseInCaseOfEmptyIterators() {
        Iterator<Integer> it1 = (new ArrayList<Integer>()).iterator();
        Iterator<Integer> it2 = (new ArrayList<Integer>()).iterator();
        Iterator<Integer> it3 = (new ArrayList<Integer>()).iterator();
        Iterator<Iterator<Integer>> its = Arrays.asList(it1, it2, it3).iterator();
        Converter iteratorOfIterators = new Converter();
        it = iteratorOfIterators.convert(its);
        assertThat(it.hasNext(), is(false));
    }

    /**
     * If the element does not exist then an exception NoSuchElementException is thrown.
     */
    @Test(expected = NoSuchElementException.class)
    public void invocationOfNextMethodShouldThrowNoSuchElementException() {
        Iterator<Integer> it1 = Arrays.asList(1, 2, 3).iterator();
        Iterator<Iterator<Integer>> its = Arrays.asList(it1).iterator();
        Converter iteratorOfIterators = new Converter();
        it = iteratorOfIterators.convert(its);
        assertThat(it.next(), is(1));
        assertThat(it.next(), is(2));
        assertThat(it.next(), is(3));
        it.next();
    }

    /**
     * multiply invocation of hasNext
     */
    @Test
    public void hasNextShouldReturnTheSameValuesInCaseOfMultiplyInvocation() {
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
    }

    /**
     *
     */
    @Test()
    public void currentIteratorNotNull() {

        Iterator<Integer> it1 = (new ArrayList<Integer>()).iterator();
        Iterator<Integer> it2 = (new ArrayList<Integer>()).iterator();
        Iterator<Integer> it3 = (new ArrayList<Integer>()).iterator();
        Iterator<Iterator<Integer>> its = Arrays.asList(it1, it2, it3).iterator();
        Converter iteratorOfIterators = new Converter();
        it = iteratorOfIterators.convert(its);


        assertThat(it, is(notNullValue()));
    }

    @Test()
    public void moreIterators() {
        Iterator<Integer> it1 = Arrays.asList(1, 2, 3).iterator();
        Iterator<Integer> it2 = Arrays.asList(4, 5, 6).iterator();
        Iterator<Integer> it3 = Arrays.asList(7, 8, 9).iterator();
        Iterator<Integer> it4 = Arrays.asList(10, 11, 12).iterator();
        Iterator<Iterator<Integer>> its = Arrays.asList(it1, it2, it3, it4).iterator();
        Converter iteratorOfIterators = new Converter();
        it = iteratorOfIterators.convert(its);
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1));
        assertThat(it.next(), is(2));
        assertThat(it.next(), is(3));
        assertThat(it.next(), is(4));
        assertThat(it.next(), is(5));
        assertThat(it.next(), is(6));
        assertThat(it.next(), is(7));
        assertThat(it.next(), is(8));
        assertThat(it.next(), is(9));
        assertThat(it.next(), is(10));
        assertThat(it.next(), is(11));
        assertThat(it.next(), is(12));
    }

    @Test()
    public void nextReturnTheSameValueIndependentlyTheMultiplyInvocationHasNext() {

        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1));
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(2));

    }
}