package projectAspects.homeChoresManagement;

import java.util.*;

public class HCMMain {
    private static String homechores;
    private static String names;

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);

        System.out.println("\n\t~~~~~Home chores~~~~~");

        System.out.print("Please enter family names: ");

        if (userInput.hasNext()) {
            names = userInput.next();
        }

        System.out.print(
                "Please enter home chores separated by commas: ");

        if (userInput.hasNext()) {
            homechores = userInput.next();
        }


        String amountArray[] = homechores.split(",");
        String nameArray[] = names.split(",");

        award(nameArray, amountArray);
    }

    // Method that awards the amounts to the winners
    public static void award(String names[], String amounts[]) {
        int randomAmount;
        int randomName;

        for (int i = 0; i < amounts.length; i++) {
            randomAmount = (int) (Math.random() * amounts.length);
            int usedValue[] = new int[amounts.length];
            usedValue[i] = randomAmount;
            if (checkValueUsed(randomAmount, usedValue)) {

                randomName = (int) (Math.random() * names.length);
                int usedName[] = new int[names.length];

                System.out.println(names[randomName] + " = "
                        + amounts[randomAmount]);
            } else {
                break;
            }
        }
    }

    private static boolean checkValueUsed(int currentState, int[] myArray) {
        boolean found = false;

        for (int i = 0; !found && (i < myArray.length); i++) {
            if (myArray[i] == currentState) {
                found = true;
            }
        }
        return found;
    }

    private void checkUsedValue(int currentState, int[] myArray) {
        for (int i = 0; (i < myArray.length); i++) {

            if (myArray[i] == currentState) {

            }
        }
    }
}
