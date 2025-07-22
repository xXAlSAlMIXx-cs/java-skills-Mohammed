package src1.Task4.Part1;
// Main class to test everything
public class Library {
    public static void main(String[] args) {
        // Create 2 regular books
        Book book1= new Book("Calculas1","Mohammed Alsalmi",255);
        Book book2= new Book("Calculas2","Mohammed Alsalmi",500);
        // Create 1 textbook
        Textbook textbook= new Textbook("Physics","Mohammed Alsalmi",800,"Physics",1);
        // Test borrowing and returning
        book1.borrowBook();
        book1.returnBook();
        // Display information for all books
        book1.displayInfo();
        book2.displayInfo();
        textbook.displayInfo();
    }
}

