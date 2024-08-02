import java.util.Arrays;

public class arrayList<T> {
    public int length;
    public int capacity;
    public T[] items;

    public arrayList() {
        this.capacity = 3;
        this.length = 0;
        this.items = (T[])new Object[this.capacity];
        Arrays.fill(this.items, null);
    }

    public arrayList(int capacity) {
        if (capacity > this.length) {
            this.capacity = capacity;
        } else {
            throw new IllegalArgumentException("Capacity cannot be < length");
        }
        this.length = 0;
        this.items = (T[])new Object[capacity];
        Arrays.fill(this.items, null);
    }

    public arrayList(int capacity, T[] items) {
        if (capacity > this.length) {
            this.capacity = capacity;
        } else {
            throw new IllegalArgumentException("Capacity cannot be < length");
        }

        this.length = items.length;
        this.items = items;
    }

    public void append(T item) {
        if (this.length == this.capacity) {
            // expand array with 2x capacity
            arrayList<T> newList = new arrayList<T>((this.capacity * 2));

            // copy items from 1st array to 2nd array
            for (int i = 0; i < this.length; i++) {
                newList.items[i] = this.get(i);
            }

            // append new item
            newList.items[this.length] = item;
            newList.setLength(this.length + 1);

            this.setItems(newList.items);
            this.capacity = newList.getCapacity();
            this.setLength(newList.getLength());
            return;
        }

        // add to end of array
        this.items[this.length] = item;
        this.setLength(this.length + 1);
    }

    // Gets a single item at desired index
    public T get(int idx) {
        if (idx >= this.length) {
            throw new IllegalArgumentException("Retrieval Index cannot be larger than arrayList length");
        }

        return this.items[idx];
    }

    public T removeAt(int idx) {
        if (idx >= this.length) {
            throw new IllegalArgumentException("Removal Index cannot be larger than arrayList length");
        }

        // get return value
        T retV = this.get(idx);

        // overwrite array data @ index
        this.items[idx] = null;
        this.length--;

        return retV;
    }

//    public T remove(T item) {
//
//
//    }

    public T pop() {
        if (this.length <= 0) { throw new IllegalArgumentException("Cannot pop since length is <= 0"); }

        T retV = this.get(this.length);

        this.items[this.length] = null;
        this.length--;

        return retV;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getLength() {
        return length;
    }

    public T[] getItems() {
        return items;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setItems(T[] items) {
        this.items = items;
    }

    public void setLength(int length) {
        this.length = length;
    }
}
