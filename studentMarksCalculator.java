import java.util.Scanner;

public class studentMarksCalculator {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Input: Number of subjects
        System.out.print("Enter total number of subjects: ");
        int subjectCount = input.nextInt();

        // Array to store marks
        int[] subjectMarks = new int[subjectCount];

        // Input: Marks for each subject
        for (int i = 0; i < subjectCount; i++) {
            System.out.print("Enter marks for subject " + (i + 1) + " (out of 100): ");
            subjectMarks[i] = input.nextInt();
        }

        // Calculate total marks, average, and grade
        int total = calculateTotal(subjectMarks);
        double average = calculateAverage(total, subjectCount);
        char grade = determineGrade(average);

        // Display Results
        printResults(total, average, grade);

        input.close();
    }

    // Method to calculate the total marks
    private static int calculateTotal(int[] marks) {
        int totalSum = 0;
        for (int mark : marks) {
            totalSum += mark;
        }
        return totalSum;
    }

    // Method to calculate the average percentage
    private static double calculateAverage(int total, int count) {
        return (double) total / count;
    }

    // Method to determine grade based on average percentage
    private static char determineGrade(double avg) {
        if (avg >= 90) {
            return 'A';
        } else if (avg >= 80) {
            return 'B';
        } else if (avg >= 70) {
            return 'C';
        } else if (avg >= 60) {
            return 'D';
        } else {
            return 'F';
        }
    }

    // Method to print results
    private static void printResults(int total, double avg, char grade) {
        System.out.println("\n--- Final Results ---");
        System.out.println("Total Marks: " + total);
        System.out.printf("Average Percentage: %.2f%%\n", avg);
        System.out.println("Final Grade: " + grade);
    }
}
