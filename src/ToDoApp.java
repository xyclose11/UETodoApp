import java.util.Arrays;
import java.util.Scanner;

public class ToDoApp {
    public static void main(String[] args) {
        // START EXAMPLE DATA INIT
        todoItem myItem1 = new todoItem();
        myItem1.setName("Example Todo Item");
        myItem1.setBody("This is an example of what a todo item body can hold.");

        todoItem myItem2 = new todoItem();
        myItem2.setName("Try Removing Me.");
        myItem2.setBody("This is an example of what a todo item body can hold.");

        todoItem myItem3 = new todoItem();
        myItem3.setName("Try to update my name.");
        myItem3.setBody("This is an example of what a todo item body can hold.");

        arrayList<todoItem> userList = new arrayList<todoItem>(5);

        userList.append(myItem1);
        userList.append(myItem2);
        userList.append(myItem3);

        // END EXAMPLE DATA INIT

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
                    // Table Headers
                    // TODO Get longest length of each respective header value and dynamically shorten/lengthen headers OR set max len for each col
                    // TODO Create a table class that can input data and place it on a table

                    // Max hdr len in char
                    int nameHdrLen = 20;
                    int bodyHdrLen = 40;
                    int dueDateHdrLen = 24;
                    int createdHdrLen = 24;
                    int updatedHdrLen = 24;

                    System.out.print("*------Name------*&*----------body----------*&*-------Due Date-------*&*-------Created@-------*&*-------Last Updated@-------*&*");

                    for (int i = 0; i < userList.length; i++) {
                        todoItem temp = userList.get(i);
                        String tHdr = temp.name;
                        String bHdr = temp.body;
                        // add trailing whitespace
                        if (temp.name.length() > nameHdrLen) {
                            // cut off string to fit inside nameHdrLen
                            tHdr = temp.name.substring(0, nameHdrLen - 3);
                            tHdr = tHdr.concat("...");
                        }

                        if (temp.body.length() > nameHdrLen) {
                            // cut off string to fit inside nameHdrLen
                            bHdr = temp.body.substring(0, bodyHdrLen - 3);
                            bHdr = bHdr.concat("...");
                        }
                        System.out.println();
                        System.out.print(tHdr + " | ");
                        System.out.print(bHdr + " | ");
                        System.out.print(temp.dueDate + " | ");
                        System.out.print(temp.getCreatedAt() + " | ");
                        System.out.print(temp.getUpdatedAt() + " | ");
                    }

                    // Spacer
                    System.out.println("""
                            
                            
                            """);

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



// TODO: Undo feature with stack?
// TODO: Save data to file?
// TODO: Mark item as complete/uncomplete
// TODO: Search feature
// TODO: Sort feature
// TODO: Individual view feature


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
