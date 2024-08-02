import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
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

    public void prepend(T item) {
        if (this.length == 0) {
            this.items[0] = item;
            this.length++;
        }

        if (this.length == this.capacity) {
            // expand array with 2x capacity
            arrayList<T> newList = new arrayList<T>((this.capacity * 2));

            // copy items from 1st array to 2nd array
            // && shift all values -> 1
            for (int i = 0; i < this.length; i++) {
                newList.items[i + 1] = this.get(i);
                newList.length++;
            }

            // add item to 0 pos
            newList.items[0] = item;
            newList.length++;

            this.capacity = newList.capacity;
            this.length = newList.length;
            this.setItems(newList.items);
            return;
        }

        // shift items starting from end of array
        for (int i = this.length; i >= 0; i--) {
            this.items[i + 1] = this.items[i];
        }

        // add new item
        this.items[0] = item;
        this.length++;
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
        // Shift items over removed item
        for (int i = idx; i < this.length; i++) {
            this.items[i] = this.items[i + 1];
            this.items[i + 1] = null;
        }

        this.length--;

        return retV;
    }

    public T remove(T item) {
        if (this.length == 0) {
            throw new IllegalArgumentException("ArrayList currently has no elements.");
        }

        // search array for item
        for (int i = 0; i < this.length; i++) {
            if (this.items[i].equals(item)) {
                // remove item
                T retV = this.items[i];
                this.items[i] = null;
                for (int k = i; k < this.length; k++) {
                    this.items[k] = this.items[k + 1];
                    this.items[k + 1] = null;
                }
                this.length--;

                return retV;
            }
        }

        throw new RuntimeException("Item does not exist!");

    }

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
