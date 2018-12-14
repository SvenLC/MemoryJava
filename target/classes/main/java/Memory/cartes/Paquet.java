package Memory.cartes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public abstract class Paquet<T> implements IPaquet<T> {

    protected List<T> elements = new ArrayList<T>();

    public boolean add(T element) {
        return elements.add(element);
    }

    public T get(int i) {
        return elements.get(i);
    };

    public T remove(int i) {
        return elements.remove(i);
    };

    public boolean remove(T element) {
        return elements.remove(element);
    }

    public int size() {
        return elements.size();
    };

    public void melanger() {
        Collections.shuffle(elements);
    }

    public Iterator<T> iterator() {

        return elements.iterator();
    }

}