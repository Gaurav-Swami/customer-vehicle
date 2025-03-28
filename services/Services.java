package services;

import static printing.Printing.*;

public class Services {
    public static void main(String args[]) {
        while (true) {
            String menu = """
--------------------------------------------------------------
1. Display all Services
2. Add a Service
3. Edit a Service
5. Exit
--------------------------------------------------------------
                    """;
            println(menu);
            int choice = inputInt("Enter a choice");

            try {
                switch (choice) {
                    case 1:
                        DisplayServices.main(null);
                        break;
                    case 2:
                        AddService.main(null);
                        break;
                    case 3:
                        EditService.main(null);
                        break;
                    case 5:
                        return;
                    default:
                        println("Invalid choice! Please try again.");
                }
            } catch (NumberFormatException e) {
                println("Some Error Occurred");
            }
        }
    }
}