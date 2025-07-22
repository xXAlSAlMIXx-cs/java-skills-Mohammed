package src1.Task5.Part1;

import java.util.Arrays;

public class ShoppingCart {

    // Calculate total price with discounts
    public static double calculateTotal(double[] prices, String customerType)
    {
        double total = 0;

        // First, calculate sum of all prices using a loop
        for (double price : prices)
        {
            total += price;
        }
        // Then apply discount based on customer type using switch:
        switch (customerType) {
            case "REGULAR":
                total = total;
                break;

            case "PREMIUM":
                total = total * 0.9;
                break;

            case "VIP":
                total = total * 0.2;
                break;
            default: // handle any other types if passible
                break;
        }
        return total;
    }
    // to inform the user that the array is empty I will return -1
    // Find most expensive item
    public static double findMostExpensive(double[] prices) {
        // Use loop to find highest price
        double mostExpensive = 0;
        if (prices.length != 0)
        {
               for(double price : prices)
               {
                   if (price > mostExpensive){
                       mostExpensive=price;
                   }
               }
        }else {
            mostExpensive = -1;
        }
        // Handle empty array
        return mostExpensive;
    }

    // Count items above a certain price
    public static int countExpensiveItems(double[] prices, double threshold)
    {
        // Count how many items cost more than threshold
        int count = 0;
        if (prices.length != 0){
            for (double price : prices){
                if (price > threshold){
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        double[] cart = {25.99, 45.50, 12.99, 89.99, 15.75};

        // Test with different customer types
        // Find most expensive item
        System.out.println(findMostExpensive(cart));

        // Count items over $30
        System.out.println(countExpensiveItems(cart, 30));

        System.out.println("Regular customer total: $" + calculateTotal(cart,
                "REGULAR"));
        System.out.println("Premium customer total: $" + calculateTotal(cart,
                "PREMIUM"));
        System.out.println("VIP customer total: $" + calculateTotal(cart,
                "VIP"));
        System.out.println(calculateTotal(cart, "VIP121231")); // as a mis typing from the user
    }
}
