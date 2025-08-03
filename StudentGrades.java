import java.util.Scanner;

public class StudentGrades {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int numStudents = sc.nextInt();

        System.out.print("Enter number of subjects: ");
        int numSubjects = sc.nextInt();

        sc.nextLine(); 

        String[] studentNames = new String[numStudents];
        int[][] marks = new int[numStudents][numSubjects];
        String[][] grades = new String[numStudents][numSubjects];

        for (int i = 0; i < numStudents; i++) {
            System.out.print("\nEnter name of student " + (i + 1) + ": ");
            studentNames[i] = sc.nextLine();

            for (int j = 0; j < numSubjects; j++) {
                System.out.print("Enter marks for Subject " + (j + 1) + ": ");
                marks[i][j] = sc.nextInt();
            }
            sc.nextLine(); 
        }

        for (int i = 0; i < numStudents; i++) {
            for (int j = 0; j < numSubjects; j++) {
                int score = marks[i][j];
                if (score >= 90) {
                    grades[i][j] = "Grade A";
                } else if (score >= 80) {
                    grades[i][j] = "Grade B";
                } else if (score >= 70) {
                    grades[i][j] = "Grade C";
                } else if (score >= 60) {
                    grades[i][j] = "Grade D";
                } else {
                    grades[i][j] = "Fail";
                }
            }
        }

        System.out.println("\nGrades Summary:");
        System.out.print("Student\t\t");

        for (int s = 1; s <= numSubjects; s++) {
            System.out.print("Sub" + s + "\t\t");
        }
        System.out.println();

        for (int i = 0; i < numStudents; i++) {
            System.out.print(studentNames[i] + "\t\t");
            for (int j = 0; j < numSubjects; j++) {
                System.out.print(grades[i][j] + "\t");
            }
            System.out.println();
        }

        sc.close();
    }
}
