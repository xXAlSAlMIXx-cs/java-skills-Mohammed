package src1.Task4.Part2;

public class VisitorCounter {
    // Static variable to count total visitors
    private static int totalVisitors = 0;

    // Non-static variable for individual session
    private int sessionVisits;
    private String visitorName;

    // Constructor
    public VisitorCounter(String name) {
        this.visitorName = name;
        this.sessionVisits = 0;
        totalVisitors++; // Increment total when new visitor is created
    }

    // Non-static method
    public void recordVisit() {
        sessionVisits++;
        System.out.println(visitorName + " visited. Session visits: " +
                sessionVisits);
    }

    // Static method
    public static void displayTotalVisitors() {
        System.out.println("Total visitors today: " + totalVisitors);
    }

    // Static method to get total (getter)
    public static int getTotalVisitors() {
        return totalVisitors;
    }

    public static void main(String[] args) {
        // Create 3 different visitors
        VisitorCounter visitorCounter = new VisitorCounter("Visitor");
        VisitorCounter visitorCounter1 = new VisitorCounter("Visitor1");
        VisitorCounter visitorCounter2 = new VisitorCounter("Visitor2");

        // Have each visitor record some visits
        visitorCounter.recordVisit();
        visitorCounter1.recordVisit();
        visitorCounter2.recordVisit();

        // Display total visitors using static method
        visitorCounter.displayTotalVisitors();
    }

}