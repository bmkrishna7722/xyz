package project;

import java.util.Scanner;

public class ComputerStore {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        System.out.println("//////  Hello!! Welcome to Computer Store //////");
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
            int computercount;
            switch (mainMenu) {
                case 1:
                    int numOfCreatedComputers = Computer.findNumberOfCreatedComputers();
                    if (ValidatePassword() == true) {
                        do {
                            System.out.println("Enter computers you wish to enter : ");
                            computercount = kb.nextInt();
                        } while (maxComputers < computercount || computercount <= 0);
                        for (int i = 0; i < computercount ; i++) {
                            System.out.println("Enter Computer's brand:");
                            String brnd = kb.next();
                            System.out.println("Enter Computer's model:");
                            String mdl = kb.next();
                            double price = 0;
                            do {
                                System.out.println("Enter Computer's price:");
                                price = kb.nextDouble();
                                if (price <= 0) {
                                    System.out.println("Price can't be negative. Enter positive number");
                                }
                            }while (price <= 0);
                            inventory[numOfCreatedComputers+ i] = new Computer(brnd,mdl,price);
                            Computer.displayComputer(inventory[numOfCreatedComputers+i]);
                        }
                        }
                    break;
                case 2:
                    if (ValidatePassword() == true) {
                        String quit = "";
                        do {
                            System.out.println("Enter computer number he/she wishes to update");
                            int computerNum = kb.nextInt();

                            if (computerNum <= 0 || computerNum > Computer.findNumberOfCreatedComputers()) {
                                System.out.println("Invalid value");
                                System.out.print("Do you want to enter another computer (Y/N)? ");
                                quit = kb.next();
                                if (!quit.equalsIgnoreCase("Y")) {
                                    break;
                                }
                            }
                            else {
                                computerNum = computerNum-1;
                                System.out.println("Computer " + computerNum +"\nBrand: "+ inventory[computerNum].getBrand()+"\nModel: " + inventory[computerNum].getModel()+
                                        "\nSN: "+inventory[computerNum].getSN() +"\nPrice: $" + inventory[computerNum].getPrice());

                                int updateMenu;
                                do {
                                    System.out.println("What information would you like to change?\n" +
                                            "1.\tbrand\n" +
                                            "2.\tmodel\n" +
                                            "3.\tSN\n" +
                                            "4.\tprice\n" +
                                            "5.\tQuit\n" +
                                            "Enter your choice >\n");
                                    updateMenu = kb.nextInt();
                                    switch (updateMenu) {
                                        case 1:
                                            System.out.println("Give Brand: ");
                                            String brand = kb.next();
                                            inventory[computerNum].setBrand(brand);
                                            Computer.displayComputer(inventory[computerNum]);
                                            break;
                                        case 2:
                                            System.out.println("Give Model: ");
                                            String model = kb.next();
                                            inventory[computerNum].setModel(model);
                                            Computer.displayComputer(inventory[computerNum]);
                                            break;
                                        case 3:
                                            int SN;
                                            do{
                                            System.out.println("Give serial number: ");
                                            SN = kb.nextInt();
                                            if(SN <= 0) {
                                                System.out.println("Serial number can't be negative. Enter positive number");
                                            }
                                            }while (SN <= 0);
                                            inventory[computerNum].setSN(SN);
                                            Computer.displayComputer(inventory[computerNum]);
                                            break;
                                        case 4:
                                            double price = 0;
                                            do {
                                                System.out.println("Give price: ");
                                                price = kb.nextDouble();
                                                if(price <= 0) {
                                                    System.out.println("Price can't be negative. Enter positive number");
                                                }
                                            }while (price <= 0);

                                            inventory[computerNum].setPrice(price);
                                            Computer.displayComputer(inventory[computerNum]);
                                            break;
                                        case 5:
                                            break;
                                        default:
                                            System.out.println("Enter a number between 1 and 5");
                                            break;
                                    }
                                } while (updateMenu != 5 );
                            }
                        }while(quit.equalsIgnoreCase("Y"));
                    }
                    break;
                case 3:
                    System.out.println("Give brand: ");
                    String brnd = kb.next();
                    findComputersBy(brnd, inventory);
                    break;
                case 4:
                    double price = 0;
                    do {
                        System.out.println("Give price: ");
                        price = kb.nextDouble();
                        if(price <= 0) {
                            System.out.println("Price can't be negative. Enter positive number");
                        }
                        findCheaperThan(price, inventory);
                    }while (price <= 0);
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
        for (int i = 0; i < Computer.findNumberOfCreatedComputers(); i++) {
            if(inventory[i].getBrand().equals(brand)){
                Computer.displayComputer(inventory[i]);
            }
        }
    }
    public static void findCheaperThan(double price, Computer[] inventory){
        for (int i = 0; i < Computer.findNumberOfCreatedComputers(); i++) {
            if(inventory[i].getPrice()<= price){
                Computer.displayComputer(inventory[i]);
            }
        }
        
        
    }

}
