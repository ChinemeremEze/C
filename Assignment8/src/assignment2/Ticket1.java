
/*
 *Programming in Java COMP-10062-02 Feb 29, 2007
 * This is my code and was not copied from anyone else and no one copied from me
 *Assignment 3
 */

/**
 *
 * @author David Ezeakudolu 000778050
 */
public class Ticket1 {
//Fields
   private String Route;
    private int numofchild;
    private int numofadult;
    private int numofloonies;
    private int numoftoonies;
   private double numofquarters;
   
//Getting route
    public String getRoute() {
        return Route;
    }
//Setting route
    public void setRoute(String Route) {
        this.Route = Route;

    }
//Method to find the amount of n number of adults
    public double getAmountofAdult() {
        double amountofadult = numofadult * 8;
        return amountofadult;
    }
//Method to check the total amount 
    double getTotal(double amountofadult, double amountofchildren) {
        double total = (amountofadult + amountofchildren);
        return total;
    }
//Method to check how much you are owing
    double getCredit(double amountofadult, double amountofchildren) {
        double credit = (amountofadult + amountofchildren) - (numofloonies + numoftoonies + numofquarters);
        return credit;
    }
// Method to check how much is paid
    double getPaid() {
        double paid = numofloonies + numoftoonies + numofquarters;
        return paid;
    }
//Get the cost for the n numbers of children
    public double getAmountofChild() {
        double amountofchildren = numofchild * 2.25;
        return amountofchildren;
    }
//Get number of child
    public int getNumofchild() {
        return numofchild;
    }
//Get number of adults
    public int getNumofadult() {
        return numofadult;
    }
//Method for adding adult
    public int addAdult() {
        int adults = (numofadult += 1);
        return adults;
    }
//Method for subtracting adult
    public int minusAdult() {
        int adults = (numofadult -= 1);
        return adults;
    }
//Method for adding child
    public int addChild() {
        int childrens = numofchild += 1;
        return childrens;
    }
// Method for subracting child
    public int minusChild() {
        int childrens = (numofchild--);
        return childrens;
    }
//Get Number of loonies
    public int getNumofloonies() {
        return numofloonies;
    }
// Get Number of toonies
    public int getNumoftoonies() {
        return numoftoonies;
    }
//Get Number of quarters
    public double getNumofquarters() {
        return numofquarters;
    }
//Merhod for adding toonies
    public double gettoonie() {
        double toonie = (numoftoonies += 2);
        return toonie;
    }
//Method for adding quarters
    public double getquarter() {
        double quarter = numofquarters += 0.25;
        return quarter;
    }
//Method for adding loonies
    public double getloonie() {
        double loonie = (numofloonies++);
        return loonie;
    }

   // Method for printing the ticket
    public String getPrint() {
       
        String print = "";
        print += "  ";
        if((0.0) >= (getCredit(getAmountofAdult(), getAmountofChild()))){
            System.out.println("=================================\n");
            System.out.println("CONGRATULATIONS YOU GET A TICKET\n");
            System.out.println("=================================\n");
        } else {
            System.out.println("===============");
            System.out.println("NO TICKET ");
            System.out.println("==========");
        }
        
        return print;
    }
// Decision for machine 1
    public String choose() {
        String choose = "";
        choose += "1. Select  route 'Main Street'\n";
        choose += ("2. Select route 'West street'\n");
        choose += ("3. Add adult\n");
        choose += ("4. Remove Adult\n");
        choose += ("5. Add Child\n");
        choose += ("6. Remove Child\n");
        choose += ("7. Insert Quarter\n");
        choose += ("8. Insert Loonie\n");
        choose += ("9. Insert Toonie\n");
        choose += ("10. Print Ticket\n");
        choose += "11. Step away from machine 1 \n";
        choose += "Your choice: ";

        return choose;
    }
    // Decisions for machine 2
    public String choose2() {
        String choose = "";
        choose += "1. Select  route 'Uptown'\n";
        choose += ("2. Select route 'DownTown'\n");
        choose += ("3. Add adult\n");
        choose += ("4. Remove Adult\n");
        choose += ("5. Add Child\n");
        choose += ("6. Remove Child\n");
        choose += ("7. Insert Quarter\n");
        choose += ("8. Insert Loonie\n");
        choose += ("9. Insert Toonie\n");
        choose += ("10. Print Ticket\n");
        choose += "11. Step away from machine 2 \n";
        choose += "Your choice: ";

        return choose;
    }
//Printing of the ticket
    String getTicket() {
        String ticket = "";
        ticket += "==================================\n";
        ticket += "Route: " + getRoute() + ".       " + " Child $2.25     Adult $8.00  " + "\n";
        ticket += "Children: $" + getAmountofChild() + "    Adult: $" + getAmountofAdult() + " \n";
        ticket += "Children: " + getNumofchild() + "   Adult: " + getNumofadult() + "\n";
        ticket += "Total $" + getTotal(getAmountofAdult(), getAmountofChild()) + "\n";
        ticket += "Credit $" + getCredit(getAmountofAdult(), getAmountofChild()) + "\n";
        ticket += "Paid $" + getPaid() + "\n";
        ticket += "==================================\n";
        return ticket;
    }

}
