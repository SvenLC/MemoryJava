package Memory.cartes;

import java.util.Iterator;

public interface IPaquet<T> {
    public boolean add(T element);
    public T get(int i);
    public boolean remove(T element);
    public T remove(int i);
    public int size();
    public void melanger();
    public Iterator<T> iterator();

}