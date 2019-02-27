package assignment2;

//Programming in Java COMP-10062-02 Feb 29, 2007
//This is my code and was not copied from anyone else and no one copied from me
//Assignment 3 Main class
/**
 * @author David Ezeakudolu 000778050
 */
import java.util.Scanner;

public class TicketMain1 {

    public static void main(String[] args) {
        // Creating Scanners
        Scanner scan = new Scanner(System.in);
        Scanner input = new Scanner(System.in);
        // Welcoming the user
        System.out.println("Welcome to the Ticket machine");
        System.out.println("Press 1 for Machine 1 ");
        System.out.println("Press 2 for Machine 2");
        System.out.println("Press 3 to quit");
        int machine = scan.nextInt();
        //Making machines
        Ticket1 m1 = new Ticket1();
        Ticket1 m2 = new Ticket1();
        //Initializing choice variable
        int choice;

        // While machine != 3 run
        while (machine != 3) {
            while (machine < 1 || machine > 3) {
                System.out.println("!!!ERORR");
                System.out.println("Press 1 for Machine 1 ");
                System.out.println("Press 2 for Machine 2");
                System.out.println("Press 3 to quit");
                machine = scan.nextInt();
            }
            // Machine 1
            while (machine == 1) {
                System.out.println("Welcome to Machine 1!!");
                System.out.println(m1.choose());
                choice = scan.nextInt();

                // The ten buttons
                while (choice <= 10) {
                    switch (choice) {
                        // For a Main St route
                        case 1:
                            m1.setRoute("Main st");
                            System.out.println(m1.getTicket());
                            System.out.println(m1.choose());
                            choice = input.nextInt();
                            break;
                        // For a West st Route
                        case 2:
                            m1.setRoute("West st");
                            System.out.println(m1.getTicket());
                            System.out.println(m1.choose());
                            choice = input.nextInt();
                            break;
                        // To add adult
                        case 3:
                            m1.addAdult();
                            System.out.println(m1.getTicket());
                            System.out.println(m1.choose());
                            choice = input.nextInt();
                            break;
                        // To minus adult
                        case 4:
                            m1.minusAdult();
                            System.out.println(m1.getTicket());
                            System.out.println(m1.choose());
                            choice = input.nextInt();
                            break;
                        // To add child
                        case 5:
                            m1.addChild();
                            System.out.println(m1.getTicket());
                            System.out.println(m1.choose());
                            choice = input.nextInt();
                            break;
                        // To minus child
                        case 6:
                            m1.minusChild();
                            System.out.println(m1.getTicket());
                            System.out.println(m1.choose());
                            choice = input.nextInt();
                            break;
                        // To add a quarter 
                        case 7:
                            m1.getquarter();
                            System.out.println(m1.getTicket());
                            System.out.println(m1.choose());
                            choice = input.nextInt();
                            break;
                        // To add a dollar
                        case 8:
                            m1.getloonie();
                            System.out.println(m1.getTicket());
                            System.out.println(m1.choose());
                            choice = input.nextInt();
                            break;
                        // To add two dollars
                        case 9:
                            m1.gettoonie();
                            System.out.println(m1.getTicket());
                            System.out.println(m1.choose());
                            choice = input.nextInt();
                            break;
                        // To print Ticket
                        case 10:
                            System.out.println(m1.getTicket());
                            m1.getPrint();
                            System.out.println(m1.choose());
                            choice = input.nextInt();
                            break;

                        default:
                            break;
                    }

                }
                // if choice is 11 step away from machine
                if (choice == 11) {
                    System.out.println("============================");
                    System.out.println("Thanks for patronizing us!!!");
                    System.out.println("Press 1 for Machine 1 ");
                    System.out.println("Press 2 for Machine 2");
                    System.out.println("Press 3 to quit");
                    machine = scan.nextInt();
                }
            }
            //Machine 2
            while (machine == 2) {
                System.out.println("Welcome to Machine 2!!!");
                System.out.println(m2.choose2());
                choice = input.nextInt();

                while (choice <= 10) {
                    switch (choice) {
                        // For a Uptown route
                        case 1:
                            m2.setRoute("Uptown");
                            System.out.println(m2.getTicket());
                            System.out.println(m2.choose2());
                            choice = input.nextInt();
                            break;
                        // For Downtown route
                        case 2:
                            m2.setRoute("Downtown");
                            System.out.println(m2.getTicket());
                            System.out.println(m2.choose2());
                            choice = input.nextInt();
                            break;
                        // To add adult
                        case 3:
                            m2.addAdult();
                            System.out.println(m2.getTicket());
                            System.out.println(m2.choose2());
                            choice = input.nextInt();
                            break;
                        // To minus adult
                        case 4:
                            m2.minusAdult();
                            System.out.println(m2.getTicket());
                            System.out.println(m2.choose2());
                            choice = input.nextInt();
                            break;
                        // To add child
                        case 5:
                            m2.addChild();
                            System.out.println(m2.getTicket());
                            System.out.println(m2.choose2());
                            choice = input.nextInt();
                            break;
                        // To minus child
                        case 6:
                            m2.minusChild();
                            System.out.println(m2.getTicket());
                            System.out.println(m2.choose2());
                            choice = input.nextInt();
                            break;
                        //To add quarter
                        case 7:
                            m2.getquarter();
                            System.out.println(m2.getTicket());
                            System.out.println(m2.choose2());
                            choice = input.nextInt();
                            break;
                        //To add a dollar
                        case 8:
                            m2.getloonie();
                            System.out.println(m2.getTicket());
                            System.out.println(m2.choose2());
                            choice = input.nextInt();
                            break;
                        // To add two dollars
                        case 9:
                            m2.gettoonie();
                            System.out.println(m2.getTicket());
                            System.out.println(m2.choose2());
                            choice = input.nextInt();
                            break;
                        //To print the ticket
                        case 10:
                            System.out.println(m2.getTicket());
                            m2.getPrint();
                            System.out.println(m2.choose2());
                            choice = input.nextInt();
                            break;
                        default:
                            break;
                    }

                }
                //Step away from the machine when choice 11
                if (choice == 11) {
                    System.out.println("============================");
                    System.out.println("Thanks for patronizing us!!!");
                    System.out.println("Press 1 for Machine 1 ");
                    System.out.println("Press 2 for Machine 2");
                    System.out.println("Press 3 to quit");
                    machine = scan.nextInt();
                }
            }
            // Machine 3 is to quit
            if (machine == 3) {
                System.out.println("BYE");
            }
        }
    }
}
