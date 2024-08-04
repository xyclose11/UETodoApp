public class History {
    private static class TodoNode<todoItem> {
        todoItem value;
        TodoNode<todoItem> next;
        TodoNode<todoItem> prev;

        public TodoNode() {
            this.value = null;
            this.next = null;
            this.prev = null;
        }

        public TodoNode(todoItem value) {
            this.value = value;
            this.next = null;
            this.prev = null;
        }

        public TodoNode<todoItem> getNext() {
            return next;
        }

        public TodoNode<todoItem> getPrev() {
            return prev;
        }

        public todoItem getValue() {
            return value;
        }

        public void setNext(TodoNode<todoItem> next) {
            this.next = next;
        }

        public void setPrev(TodoNode<todoItem> prev) {
            this.prev = prev;
        }

        public void setValue(todoItem value) {
            this.value = value;
        }
    }

    private TodoNode<todoItem> head;

    public History() {
        this.head = null;
    }

    public void append(todoItem item) {
        // create new item
        TodoNode<todoItem> todoNode = new TodoNode<>(item);

        // create new instance of DS
        if (this.head == null) {
            this.head = todoNode;
            this.head.next = this.head.prev = null;
        }

        // append to list
        // create a traverser
        TodoNode<todoItem> ptr = this.head;
        while(ptr.getNext() != null) {
            ptr.setNext(ptr.getNext());
        }

        ptr.setNext(null);
        todoNode.setPrev(ptr);
    }

    public void prepend(todoItem item) {

    }

    public todoItem find(todoItem item) {
        return null;
    }

    public boolean delete() {
        return false;
    }

    public int size() {
        if (this.head == null) {
            return -1;
        }

        int ctr = 0;
        TodoNode<todoItem> sizePtr = this.head;
        System.out.println(sizePtr.next);
        while (sizePtr.next != null) {
            ctr++;
            sizePtr = sizePtr.next;
        }

        return ctr;
    }

}
