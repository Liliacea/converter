import java.util.*;

public class Converter {
    private Iterator<Integer> currentIterator;

    public Iterator<Integer> convert(Iterator<Iterator<Integer>> iterator) {
        return new Iterator<Integer>() {
            private void check() {

                if (currentIterator == null && iterator.hasNext())
                    currentIterator = iterator.next();
                if (!currentIterator.hasNext() && iterator.hasNext())
                    currentIterator = iterator.next();
            }

            @Override
            public boolean hasNext() {
                check();
                if (currentIterator == null)
                    return false;
                if (currentIterator.hasNext())
                    return true;
                if (iterator.hasNext())
                    currentIterator = iterator.next();
                return currentIterator.hasNext();
            }

            @Override
            public Integer next() {
                check();
                if (currentIterator == null) {
                    throw new NoSuchElementException();
                }
                return currentIterator.next();
            }
        };
    }
}
