import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Tax {

    public static void main(String[] args) {

         System.out.println(taxCounter(costsArray()));
    }

    private static String taxCounter(double[] costsArray) {

        double[] taxesArray = new double[costsArray.length];
        double tax;

        for(int i = 0; i < costsArray.length; i++) {
            if(costsArray[i] > 0 && costsArray[i] <= 100) {
                tax = costsArray[i] * 0.1;
                taxesArray[i] = tax;
            } else if(costsArray[i] > 100 && costsArray[i] <= 1000) {
                tax = costsArray[i] * 0.2;
                taxesArray[i] = tax;
            } else if(costsArray[i] > 1000 && costsArray[i] <= 10000) {
                tax = costsArray[i] * 0.3;
                taxesArray[i] = tax;
            }
        }

        return Arrays.toString(taxesArray);
    }//calculate costs taxes from array and show it in console
    private static double[] costsArray() {
        Scanner reader = new Scanner(System.in);
        String s = null;

        int costsCount;
        System.out.print("Please enter the count of costs: ");

        while(true) {
            if(reader.hasNextInt()) {
                costsCount = reader.nextInt();
                break;
            } else {
                System.out.print("Please enter the number: ");
                reader.next();
            }
        }

        double[] costs = new double[costsCount];


        for(int i = 0; i < costs.length; i++) {

            if(i == 0) {
                System.out.print("Please enter the cost: ");
            } else {
                System.out.print("Please enter the cost or if you want to end please enter 'exit':");
            }
            s = reader.next();
            if(!Objects.equals(s, "exit")) {
                double cost = Double.parseDouble(s);
                costs[i] = cost;
            } else {
                break;
            }
        }

        return costs;
    }//create an array with costs
}
