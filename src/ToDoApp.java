import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;
import java.text.SimpleDateFormat;

public class ToDoApp {

    private static Date dateTimeParser(String dateTimeString) {

        try {
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            return df.parse(dateTimeString);
        } catch (Exception e) {
            System.out.println("ERROR PARSING DATE: HERE IS THE LAST USED INPUT-> " + dateTimeString);
            return null;
        }

    }

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

        // START HISTORY TESTING
        History myHistory = new History();
        myHistory.append(myItem1);
        myHistory.append(myItem1);
        myHistory.append(myItem1);
        System.out.println(myHistory.size());
        // END HISTORY TESTING

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

                    // For later use
//                    int dueDateHdrLen = 24;
//                    int createdHdrLen = 24;
//                    int updatedHdrLen = 24;

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
                    System.out.println("""
                            
                            
                            """);
                    todoItem userItem = new todoItem();

                    try {
                        userInput.nextLine();
                        System.out.println("Please enter name of todo task: ");
                        String itemName = userInput.nextLine();
                        userItem.setName(itemName);
                    } catch (Exception e) {
                        System.out.println("ERROR ATTEMPTING TO SET NAME FOR TODO ITEM. PLEASE TRY AGAIN.");
                    }

                    try {
                        System.out.println("Please enter the body of todo task: ");
                        userItem.setBody(userInput.nextLine());
                    } catch (Exception e) {
                        System.out.println("ERROR ATTEMPTING TO SET BODY FOR TODO ITEM. PLEASE TRY AGAIN.");
                    }

                    try {
                        System.out.println("Please enter the due date of the task in the following format 'yyyy-mm-dd  hh:mm:ss': ");
                        String dueDateUserInput = userInput.nextLine();
                        userItem.setDueDate(dateTimeParser(dueDateUserInput));
                    } catch (Exception e) {
                        System.out.println("ERROR ATTEMPTING TO SET DUE DATE FOR TODO ITEM. PLEASE TRY AGAIN.");
                    }

                    System.out.println("""
                            
                            
                            """);

                    // append todoItem to list
                    userList.append(userItem);

                    break;

                // Edit existing item
                case 3:
                    System.out.println("""
                            
                            
                            """);
                    for (int i = 0; i < userList.length; i++) {
                        System.out.println(i + ": " + userList.get(i).name);
                    }

                    System.out.println("Please enter the number of the task for which you want to edit: ");
                    int editNum = userInput.nextInt();
                    todoItem editItem;

                    try {
                        editItem = userList.get(editNum);
                    } catch (Exception e) {
                        System.out.println("ERROR TRYING TO ACCESS DESIRED ITEM. ITEM NUMBER: " + editNum);
                        return;
                    }

                    System.out.println("""
                            Please enter the number for the field you want to modify:
                            1. Name
                            2. Body
                            3. Due Date
                            """);

                    int editField = userInput.nextInt();
                    userInput.nextLine();
                    switch (editField) {

                        case 1:
                            System.out.println("Please enter the new name here: ");
                            editItem.setName(userInput.next());
                            break;
                        case 2:
                            System.out.println("Please enter the new body here: ");
                            editItem.setBody(userInput.next());
                            break;
                        case 3:
                            System.out.println("Please enter the new due date here in the following format 'yyyy-MM-dd  hh:mm:ss': ");
                            editItem.setDueDate(dateTimeParser(userInput.nextLine()));
                            break;
                    }
                    break;

                // Remove item
                case 4:
                    System.out.println("""
                            
                            
                            """);
                    for (int i = 0; i < userList.length; i++) {
                        System.out.println(i + ": " + userList.get(i).name);
                    }

                    System.out.println("Please enter the number of the task for which you want to remove: ");
                    int removeNum = userInput.nextInt();

                    try {
                        userList.removeAt(removeNum);
                        System.out.println("Todo Item Successfully Removed!");
                    } catch (Exception e) {
                        System.out.println("ERROR OCCURRED WHILE TRYING TO DELETE ITEM NUMBER: " + removeNum);
                    }

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
// TODO: Feature to allow user to have multiple todo lists

    }
}
