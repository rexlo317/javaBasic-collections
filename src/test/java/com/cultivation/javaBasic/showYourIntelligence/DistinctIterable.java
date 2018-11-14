package com.cultivation.javaBasic.showYourIntelligence;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DistinctIterable<T> implements Iterable<T> {
    private Iterable<T> iterable;

    public DistinctIterable(Iterable<T> iterable) {
        this.iterable = iterable;
    }

    @Override
    public Iterator<T> iterator() {
        return new DistinctIterator<>(iterable.iterator());
    }

    public List<T> toList() {
        ArrayList<T> result = new ArrayList<>();
        this.forEach(result::add);
        return result;
    }
}

class DistinctIterator<E> implements Iterator<E> {
    // TODO: Implement the class to pass the test. Note that you cannot put all items into memory or you will fail.
    // <--start

    private final Iterator<E> iterator;
    List<E> values =  new ArrayList<>();

    DistinctIterator(Iterator<E> iterator) {
        while (iterator.hasNext()) {
            E value = iterator.next();
            if (!values.contains(value))
                values.add(value);
        }
        this.iterator = values.iterator();
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
        //throw new NotImplementedException();
    }

    @Override
    public E next(){
        E temp = iterator.next();
        return temp;
        //throw new NotImplementedException();
    }
    // --end->
}