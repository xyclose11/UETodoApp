import java.util.Arrays;

public class ToDoApp {
    public static void main(String[] args) {

        todoItem myItem1 = new todoItem();
        myItem1.setName("Example Todo Item");

        todoItem myItem2 = new todoItem();
        myItem2.setName("Second Item");

        todoItem myItem3 = new todoItem();
        myItem3.setName("Third Item");

        arrayList<todoItem> myList = new arrayList<todoItem>(5);

        myList.append(myItem1);
        myList.append(myItem1);
        myList.append(myItem1);
        myList.append(myItem1);
        myList.append(myItem1);
        myList.append(myItem1);
        myList.append(myItem1);
        myList.prepend(myItem2);

        myList.remove(myItem1);
        myList.insertAt(7, myItem3);


        System.out.println(myList.capacity);
        System.out.println(myList.length);

        for (int i = 0; i < myList.length ; i++) {
            todoItem temp = myList.get(i);
            System.out.println(temp.name);
        }
    }
}
