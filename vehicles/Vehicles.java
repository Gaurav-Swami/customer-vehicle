package vehicles;

import static printing.Printing.*;

public class Vehicles {
  public static void main(String args[]) {
    while (true) {
      String menu = """
          --------------------------------------------------------------
          1. Display all Vehicles
          2. Add a Vehicle
          3. Edit a Vehicle
          4. Delete a Vehicle
          5. Search a Vehicle
          6. Exit
          --------------------------------------------------------------
                      """;
      println(menu);
      int choice = inputInt("Enter a choice");

      try {
        switch (choice) {
          case 1:
            DisplayVehicles.main(null);
            break;
          case 2:
            AddVehicle.main(null);
            break;
          case 3:
            EditVehicle.main(null);
            break;
          case 4:
            DeleteVehicle.main(null);
            break;
          case 5:
            SearchVehicle.main(null);
            break;
          case 6:
            return;
          default:
            showMsg("Invalid choice! Please try again.");
        }
      } catch (NumberFormatException e) {
        showMsg("Some Error Occured");
      }
    }
  }
}