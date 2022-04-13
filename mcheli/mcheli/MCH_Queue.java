package mcheli.mcheli;

import java.util.ArrayList;
import java.util.List;

public class MCH_Queue<T>
{
    private int current;
    private List<T> list;
    
    public MCH_Queue(int filterLength, T initVal) {
        if (filterLength <= 0)
            filterLength = 1;

        this.list = new ArrayList<T>();
        for (int i = 0; i < filterLength; i++)
            this.list.add(initVal);
        this.current = 0;
    }
    
    public void clear(T clearVal) {
        for (int i = 0; i < size(); i++)
            this.list.set(i, clearVal);
    }
    
    public void put(T t) {
        this.list.set(this.current, t);
        
        this.current++;
        this.current %= size();
    }
    
    private int getIndex(int offset) {// This method is only used once + it's private sooo...
        int size = this.size();// Get the size once
        int index = this.current + (offset % size);
        if (index < 0)
            return index + size;
        return index % size;
    }
    
    public T oldest() {
        return this.list.get(getIndex(1));
    }
    public T get(int i) {
        return this.list.get(i);
    }
    public int size() {
        return this.list.size();
    }
}