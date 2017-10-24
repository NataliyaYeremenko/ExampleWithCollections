package ua.kharkiv.yeremenko.exCollections.part7;

import java.util.Iterator;

public class Range implements Iterable{
    private static int n;
    private static int m;
    private static boolean reverse;

    public Range(int n, int m, boolean reverse) {
        this.n = n;
        this.m = m;
        this.reverse = reverse;
    }

    @Override
    public Iterator iterator() {
        return new MyIteratorImpl();
    }

    public class MyIteratorImpl implements Iterator<Object>{
        private int startNum = n;
        private int endNum = m;

        @Override
        public boolean hasNext() {
            if (reverse) return startNum <= endNum;
            else return endNum >= startNum;
        }

        @Override
        public Object next() {
            if (reverse){
                return startNum++;
            }
            else return endNum--;
        }

        @Override
        public void remove() {
            new UnsupportedOperationException();
        }
    }


}
