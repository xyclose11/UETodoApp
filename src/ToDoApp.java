import java.util.Arrays;
import java.util.Scanner;

public class ToDoApp {
    public static void main(String[] args) {
        int userCont = -1;
        int loopCtr = -1;
        int userChoice;
        Scanner userInput = new Scanner(System.in);

        while (userCont != 0) {
            loopCtr++;
            // Continue the program
            if (loopCtr == 0) {
                System.out.println("Hello User!, welcome to UETodo List!");
            }

            System.out.println("""
                        Please enter any number from the following list to continue:
                        1. View Todo list
                        2. Add new Todo item
                        3. Edit a todo item
                        4. Remove a todo item
                        
                        0. Exit program (ALL DATA WILL BE LOST!!)
                        """);
            userChoice = userInput.nextInt();

            switch (userChoice) {
                // View List
                case 1:
                    break;

                // Create new item
                case 2:
                    break;

                // Edit existing item
                case 3:
                    break;

                // Remove item
                case 4:
                    break;

                // Exit program
                case 0:
                    userCont = 0;
                    break;
            }

        }





//        todoItem myItem1 = new todoItem();
//        myItem1.setName("Example Todo Item");
//
//        todoItem myItem2 = new todoItem();
//        myItem2.setName("Second Item");
//
//        todoItem myItem3 = new todoItem();
//        myItem3.setName("Third Item");
//
//        arrayList<todoItem> myList = new arrayList<todoItem>(5);
//
//        myList.append(myItem1);
//        myList.append(myItem1);
//        myList.append(myItem1);
//        myList.append(myItem1);
//        myList.append(myItem1);
//        myList.append(myItem1);
//        myList.append(myItem1);
//        myList.prepend(myItem2);
//
//        myList.remove(myItem1);
//        myList.insertAt(7, myItem3);
//
//
//        System.out.println(myList.capacity);
//        System.out.println(myList.length);
//
//        for (int i = 0; i < myList.length ; i++) {
//            todoItem temp = myList.get(i);
//            System.out.println(temp.name);
//        }
    }
}
