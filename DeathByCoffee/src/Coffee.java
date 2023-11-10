import java.util.Scanner;
public class Coffee {

    private int h; // YYYYMMDD

    private int CAFE = 2054;
    private int DECAF = 342054;
    private int DEAD = 3403;
    private boolean isCafeDead = false;
    private boolean isDecafeDead = false;
    private int[] coffee = new int[2]; // CAFE, DECAF
    private final int MIN_COFFEE = 1;
    private final int MAX_COFFEE = 5000;
    private int noCafe, noDecaf;

    public void readUserInput(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter your date of birth in the format YYYYMMDD: ");
        h = scan.nextInt();

        System.out.println("Please enter the number of caffeinated coffees you have per year: ");
        noCafe = scan.nextInt();
        if(noCafe < MIN_COFFEE){
            System.out.println("Number of coffees must be 1 or above");
            System.out.println("Please enter the number of caffeinated coffees you have per year: ");
            noCafe = scan.nextInt();
        }

        System.out.println("Please enter the number of decaffeinated coffees you have per year: ");
        noDecaf = scan.nextInt();
        if(noDecaf < MIN_COFFEE){
            System.out.println("Number of coffees must be 1 or above");
            System.out.println("Please enter the number of caffeinated coffees you have per year: ");
            noDecaf = scan.nextInt();
        }

        maxCafe(noCafe);
        maxDecaf(noDecaf);
    }

    public void maxCafe(int noCafe){
        h = h + (CAFE * noCafe);
        String s = String.valueOf(h);
        if(!s.contains(String.valueOf(DEAD)) && noCafe < MAX_COFFEE){
            isCafeDead = true;
            coffee[0] = noCafe;
        }
        else{
            isCafeDead = false;
            coffee[0] = 0;
        }
    }

    public void maxDecaf(int noDecaf){
        h = h + (DECAF * noDecaf);
        String s = String.valueOf(h);
        if(!s.contains(String.valueOf(DEAD)) && noDecaf < MAX_COFFEE){
            isDecafeDead = true;
            coffee[1] = noDecaf;
        }
        else{
            isDecafeDead = false;
            coffee[1] = 0;
        }
    }

    public void printResults(){
        System.out.printf(" Cafe: %d \t\t Decafe: %d \n Cafe: %b \t Decafe: %b", coffee[0], coffee[1], isCafeDead, isDecafeDead);
    }
}