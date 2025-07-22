package src1.Task2;

import java.util.LinkedList;

public class PayrollCalculator {

    public static void main(String[] args) {
        // Test data:
        String[] types = {"FULL_TIME", "PART_TIME", "CONTRACTOR", "INTERN", "FULL_TIME"};
        double[] hours = {45, 20, 35, 15, 50};
        double[] rates = {25.0, 18.0, 40.0, 12.0, 30.0};
        String[] names = {"Alice", "Bob", "Charlie", "Diana", "Eve"};

        // Test individual calculations first
        for (int i = 0; i < types.length; i++) {
            double pay = calculateWeeklyPay(types[i], hours[i], rates[i]);
            System.out.println(names[i] + " weekly pay: $" + pay);
        }

        // Then process the entire payroll
        processPayroll(types, hours, rates, names);

        // Show all results clearly
    }

    // Method to calculate weekly pay based on employee type and hours
    public static double calculateWeeklyPay(String employeeType, double hoursWorked, double hourlyRate) {
        double weeklyPay;
        if (hoursWorked < 0) {
            System.out.println("Hours worked must be greater than 0");
            return -1;
        } else if (hourlyRate < 0) {
            System.out.println("Hourly rate must be greater than 0");
            return -1;
        } else {
            switch (employeeType) {
                case "FULL_TIME":
                    // FULL_TIME: Regular pay for 40 hours, overtime (1.5x) for hours > 40
                    if (hoursWorked > 40) {
                        weeklyPay = hourlyRate * 40 + hourlyRate * 1.5 * (hoursWorked - 40);
                    } else {
                        weeklyPay = hourlyRate * hoursWorked;
                    }
                    return weeklyPay;
                case "PART_TIME":
                    // PART_TIME: Regular pay, no overtime, max 25 hours
                    if (hoursWorked <= 25) {
                        weeklyPay = hoursWorked * hourlyRate;
                    } else {
                        weeklyPay = 25 * hourlyRate;
                    }
                    return weeklyPay;
                case "CONTRACTOR":
                    // CONTRACTOR: Flat rate, no overtime rules
                    weeklyPay = hoursWorked * hourlyRate;
                    return weeklyPay;
                case "INTERN":
                    // INTERN: 20% discount from hourly rate, max 20 hours
                    if (hoursWorked <= 20) {
                        weeklyPay = hourlyRate * 0.8 * hoursWorked;
                    } else {
                        weeklyPay = hourlyRate * 0.8 * 20;
                    }
                    return weeklyPay;
                default:
                    System.out.println("Invalid Employee Type");
                    return -1;
            }
        }
    }

    // Method to calculate tax deduction based on pay brackets
    // This should be placed OUTSIDE of the calculateWeeklyPay method
    public static double calculateTaxDeduction(double grossPay, boolean hasHealthInsurance) {
        // Tax brackets using nested if-else:
        // $0-500: 10% tax
        // $501-1000: 15% tax
        // $1001-2000: 20% tax
        // Above $2000: 25% tax
        // If hasHealthInsurance is true, reduce tax by $50

        double taxDeductionRate;

        if (grossPay >= 0 && grossPay <= 500) {
            taxDeductionRate = 0.1;
        } else if (grossPay <= 1000) {
            taxDeductionRate = 0.15;
        } else if (grossPay <= 2000) {
            taxDeductionRate = 0.2;
        } else {
            taxDeductionRate = 0.25;
        }

        double totalTaxDeduction = grossPay * taxDeductionRate;
        if (hasHealthInsurance) {
            totalTaxDeduction -= 50;
        }

        return totalTaxDeduction;
    }

    // Method to process multiple employees and find statistics
    public static void processPayroll(String[] employeeTypes, double[] hours, double[] rates, String[] names) {
        if (employeeTypes.length == hours.length && employeeTypes.length == rates.length && employeeTypes.length == names.length) {
            // Calculate pay for each employee
            LinkedList<Double> paysForEmployee = new LinkedList<>();
            for (int i = 0; i < hours.length; i++) {
                paysForEmployee.add(calculateWeeklyPay(employeeTypes[i], hours[i], rates[i]));
            }

            // Find: highest paid employee, lowest paid employee, average pay
            // I use here the streams rather than loops to make the code small as possible
            double max = paysForEmployee.stream().max(Double::compare).get();
            double min = paysForEmployee.stream().min(Double::compare).get();
            double avg = paysForEmployee.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);

            // Count how many employees worked overtime (>40 hours)
            int counter = 0;
            for (double h : hours) {
                if (h > 40) {
                    counter++;
                }
            }

            // Display results in a formatted table
            System.out.println("\n================== Payroll Summary ==================");
            for (int i = 0; i < paysForEmployee.size(); i++) {
                System.out.printf("%-10s | %-12s | Weekly Pay: $%.2f\n", names[i], employeeTypes[i], paysForEmployee.get(i));
            }
            System.out.println("------------------------------------------------------");
            System.out.println("Max Salary: $" + max);
            System.out.println("Min Salary: $" + min);
            System.out.printf("Avg Salary: $%.2f\n", avg);
            System.out.println("Number of employees with overtime: " + counter);
            System.out.println("======================================================");

        } else {
            // Handle arrays of different lengths gracefully
            System.out.println("Invalid Length --> the arrays are not of the same length");
        }
    }
}
