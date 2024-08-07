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
            return this.next;
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
        // save ref to head
        TodoNode<todoItem> ref = this.head;

        if (this.head == null) {
            TodoNode<todoItem> todoNode = new TodoNode<>(item);
            this.head = todoNode;
            this.head.next = this.head.prev = null;
            return;
        }

        while(this.head.next != null) {
            this.head = this.head.next;
        }

        TodoNode<todoItem> todoNode = new TodoNode<>(item);
        this.head.next = todoNode;
        todoNode.prev = this.head;

        // set head back to OG head
        this.head = ref;
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

        // Start at one since we don't count the starting head val
        int ctr = 1;
        TodoNode<todoItem> sizePtr = this.head;
        System.out.println(sizePtr.next);
        while (sizePtr.getNext() != null) {
            ctr++;
            sizePtr = sizePtr.getNext();
        }

        return ctr;
    }

}
