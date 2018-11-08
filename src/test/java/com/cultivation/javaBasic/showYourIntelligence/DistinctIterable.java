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
    private E value[] =  (E[])new Object[50];
    private int count = 0;
    private boolean check = false;
    DistinctIterator(Iterator<E> iterator) {
        this.iterator = iterator;
        this.value[count] = iterator.next();
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
        //throw new NotImplementedException();
    }

    @Override
    public E next(){
        E temp = iterator.next();
        while (iterator.hasNext() && check == false) {
            //System.out.println(value[count] + " " + temp);
            for (int i = 0; i <= count; i++) {
                if (value[i] != temp)
                    check = false;
                else {
                    check = true;
                    break;
                }
                temp = iterator.next();
            }
        }
        check = false;
        value[count] = temp;
        return temp;
        //throw new NotImplementedException();
    }
    // --end->
}