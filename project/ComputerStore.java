package project;

import java.util.Scanner;

public class ComputerStore {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        System.out.println("Hello!! Welcome to Computer Store ");
        int maxComputers = 0;
        do {
            System.out.println("the maximum number of computers (maxComputers) his/her computer store can contain: ");
            maxComputers = kb.nextInt();
            if (maxComputers <= 0)
                System.out.println("Invalid");
        } while (maxComputers <= 0);

        Computer[] inventory = new Computer[maxComputers];

        int mainMenu;
        do {
            System.out.println("What do you want to do?\n" + "1.\tEnter new computers (password required)\n"
                    + "2.\tChange information of a computer (password required)\n"
                    + "3.\tDisplay all computers by a specific brand\n"
                    + "4.\tDisplay all computers under a certain a price.\n" + "5.\tQuit\n"
                    + "Please enter your choice >\n");
            mainMenu = kb.nextInt();
            String password;
            String brand;
            int computercount;
            switch (mainMenu) {
                case 1:
                    if (ValidatePassword() == true) {
                        do {
                            System.out.println("How many computers you want to enter : ");
                            computercount = kb.nextInt();
                        } while (maxComputers <= computercount || computercount <= 0);
                        for (int i = 0; i < computercount ; i++) {
                            System.out.println("Enter Computer's brand:");
                            String brnd = kb.next();
                            System.out.println("Enter Computer's model:");
                            String mdl = kb.next();
                            System.out.println("Enter Computer's price:");
                            double price = kb.nextDouble();
                            inventory[i] = new Computer(brnd,mdl,price);
                            Computer.displayComputer(inventory[i]);
                        }
                        }
                    break;
                case 2:
                    if (ValidatePassword() == true) {

                    }
                    break;
                case 3:
                    System.out.println("Enter brand name: ");
                    String brnd = kb.next();
                    findComputersBy(brnd, inventory);
                    break;
                case 4:
                    System.out.println("Enter price value: ");
                    double price = kb.nextDouble();
                    findCheaperThan(price, inventory);
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Please enter between 1 and 5");
                    break;
            }

        } while (mainMenu != 5);

    }

    public static boolean ValidatePassword() {
        Scanner kb = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            System.out.println("Enter the password: ");
            String password = kb.next();
            if (password.equals("password")) {
                return true;
            }
        }
        return false;
    }
    public static void findComputersBy(String brand, Computer[] inventory){
        for (int i = 0; i < inventory.length; i++) {
            if(inventory[i].getBrand().equals(brand)){
                Computer.displayComputer(inventory[i]);
            }
        }
    }
    public static void findCheaperThan(double price, Computer[] inventory){
        for (int i = 0; i < inventory.length; i++) {
            if(inventory[i].getPrice()<= price){
                Computer.displayComputer(inventory[i]);
            }
        }
    }

}
