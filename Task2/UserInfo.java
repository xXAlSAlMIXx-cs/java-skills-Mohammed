package src1.Task2;

public class UserInfo {
    // Create these variables with proper access modifiers
    // - name (String)
    // - age (int)
    // - email (String)
    // - isActive (boolean)
    private String name;
    private int age;
    private String email;
    private boolean isActive;


    // Create constructor that takes all parameters
    UserInfo(String name, int age, String email, boolean isActive) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.isActive = isActive;
    }
    // Create getter and setter methods for all variables

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    // Create a method that displays user info nicely formatted
    public void displayInfo() {
        System.out.println("---------------------"+"\nName: " + name + "\nAge: " + age + "\nEmail: " + email + "\nActive: " + isActive+"\n---------------------");
        // Print user information in a nice format
    }

    // Main method for testing
    public static void main(String[] args) {
        // Create 3 different users
        UserInfo userInfo = new UserInfo("Mohammed Alsalmi",23,"s133334@student.squ.edu.om",true);
        UserInfo userInfo1= new UserInfo("Ali Alhabsi" ,23 , "ali.alhabsi@gmail.com" , false);
        UserInfo userInfo2= new UserInfo("Asim Alsalmi",19,"asim.alsalmi@gmail.com" , false);
        // Display their information
        userInfo.displayInfo();
        userInfo1.displayInfo();
        userInfo2.displayInfo();
        // Test your getters and setters
        System.out.println("Change the user 2 and user 3 to be Active");
        userInfo2.setActive(true);
        userInfo2.setActive(true);

        userInfo.displayInfo();
        userInfo1.displayInfo();
        userInfo2.displayInfo();
        }
}
