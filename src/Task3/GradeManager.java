package src1.Task3;

import java.util.Arrays;

public class GradeManager {

    public static void main(String[] args) {
        String[] students = {"Alice", "Bob", "Charlie", "Diana"};
        int[] scores = {95, 67, 45, 78};
        // Test all your methods
        String[] reversed = reverseStudentNames(students);
        Character[] Grades = new Character[students.length];
        for (int i = 0; i < scores.length; i++) {
            Grades[i] = getLetterGrade(scores[i]);
        }
        String[] retakers = findFailingStudents(students,scores);

        // Display results clearly
        System.out.println("Students names:");
        Arrays.stream(students).forEach(System.out::println);
        System.out.println("\n----------------------------------------------\nStudent Names that need to retake exam");
        Arrays.stream(retakers).filter(str -> str != null).forEach(System.out::println);
        System.out.println("\n----------------------------------------------\nReversed Student Names ");
        Arrays.stream(reversed).forEach(System.out::println);
        System.out.println("\n----------------------------------------------\nStudent Grades");
        Arrays.stream(Grades).forEach(System.out::println);
    }

    // Method to reverse student names in an array
    public static String[] reverseStudentNames(String[] names) {
        // Reverse each individual name (like "John" becomes "nhoJ")
        // Keep the array order the same
        // Return the modified array
        String[] reversedNames = new String[names.length];
        for (int i = 0; i < names.length; i++) {
            String name =names[i];
            String reversedName= "";
            for (int j =  name.length()-1; j >=0 ; j--) {
                reversedName += name.charAt(j);
            }
            reversedNames[i] = reversedName;
        }
        return reversedNames;
    }

    // Method to calculate letter grades
    public static char getLetterGrade(int score) {
        // Use if-else conditions:
        // 90-100: 'A', 80-89: 'B', 70-79: 'C', 60-69: 'D', below 60: 'F'
        char grade;
        if (score >= 90 && score <= 100) {
            grade = 'A';
        }else if (score >= 80 && score <= 89) {
            grade = 'B';
        }else if (score >= 70 && score <= 79) {
            grade = 'C';
        }else if (score >= 60 && score <= 69) {
            grade = 'D';
        }else {
            grade = 'F';
        }
        return grade;
    }

    // Method to find students who need to retake exam
    public static String[] findFailingStudents(String[] names, int[] scores)
    {
        String[] Retakestudents = new String[names.length];

        // Return array of names where score is below 60
        // Use loops to check each student
        for (int i = 0; i < names.length; i++) {
            if(scores[i] <60) {
                Retakestudents[i] = names[i];
            }
        }

        return Retakestudents;
    }

}
