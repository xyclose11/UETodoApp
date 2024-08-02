import java.util.Arrays;

public class ToDoApp {
    public static void main(String[] args) {

        todoItem myItem1 = new todoItem();
        myItem1.setName("Example Todo Item");
        myItem1.setBody("THIS IS THE BODY OF A TODO ITEM");

        todoItem[] initList = new todoItem[]{myItem1};

        arrayList<todoItem> myList = new arrayList<todoItem>(5);
//        System.out.println(myList.capacity);

        myList.append(myItem1);
        myList.append(myItem1);
        myList.append(myItem1);
        myList.append(myItem1);
        myList.append(myItem1);
        myList.append(myItem1);
        myList.append(myItem1);


        System.out.println(myList.capacity);
        System.out.println(myList.length);

        for (int i = 0; i < myList.length ; i++) {
            todoItem temp = myList.get(i);
            System.out.println(temp.name);
            System.out.println(temp.body);
            System.out.println(temp.getCreatedAt());
        }
    }
}
