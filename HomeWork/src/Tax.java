import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tax {

    public static void main(String[] args) {

         System.out.println(taxCounter(costsArray()));
    }

    //calculate costs taxes from array and show it in console
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
    }

    //create an array with costs
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
                while(true) {
                    if(checkingCosts(s) && Double.parseDouble(s) <= 10000.0) {
                        double cost = Double.parseDouble(s);
                        costs[i] = cost;
                        break;
                    } else {
                        System.out.print("Please enter the right number less than 11000 and with cents, for example like this 25.40, 9.00 etc : ");
                        s = reader.next();
                    }
                }
            } else {
                break;
            }
        }

        return costs;
    }

    public static boolean checkingCosts(String cost) {
        Pattern pattern = Pattern.compile("[1-9]+[.,]*[0-9]*");
        Matcher matcher = pattern.matcher(cost);
        return matcher.matches();
    }
}
