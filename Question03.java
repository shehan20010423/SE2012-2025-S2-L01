import java.util.Scanner;

public class Marks {
    static final int SUBJECTS = 3;
    static final String[] SUBJECT_NAMES = {"Mathematics", "Chemistry", "Physics"};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        int[][] marks = new int[n][SUBJECTS];

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add student marks: add [studentID]");
            System.out.println("2. Update student mark: update [studentID] [subjectID]");
            System.out.println("3. Get student average: average [studentID]");
            System.out.println("4. Get subject average: average_s [subjectID]");
            System.out.println("5. Get total of student: total [studentID]");
            System.out.println("6. Show grades: grades [studentID]");
            System.out.println("7. Exit");
            System.out.print("Enter command: ");
            String command = sc.next();

            if (command.equals("add")) {
                int id = sc.nextInt();
                if (isValidStudent(id, n)) {
                    System.out.print("Enter marks for Math, Chemistry, Physics: ");
                    for (int i = 0; i < SUBJECTS; i++) {
                        marks[id - 1][i] = sc.nextInt();
                    }
                } else {
                    System.out.println("Invalid student ID!");
                }

            } else if (command.equals("update")) {
                int id = sc.nextInt();
                int sub = sc.nextInt();
                if (isValidStudent(id, n) && isValidSubject(sub)) {
                    System.out.print("Enter new mark: ");
                    marks[id - 1][sub - 1] = sc.nextInt();
                } else {
                    System.out.println("Invalid student or subject ID!");
                }

            } else if (command.equals("average")) {
                int id = sc.nextInt();
                if (isValidStudent(id, n)) {
                    int sum = 0;
                    for (int i = 0; i < SUBJECTS; i++) {
                        sum += marks[id - 1][i];
                    }
                    System.out.println("Average: " + (sum / 3.0));
                } else {
                    System.out.println("Invalid student ID!");
                }

            } else if (command.equals("average_s")) {
                int sub = sc.nextInt();
                if (isValidSubject(sub)) {
                    int sum = 0;
                    for (int i = 0; i < n; i++) {
                        sum += marks[i][sub - 1];
                    }
                    System.out.println("Average for " + SUBJECT_NAMES[sub - 1] + ": " + (sum / (double) n));
                } else {
                    System.out.println("Invalid subject ID!");
                }

            } else if (command.equals("total")) {
                int id = sc.nextInt();
                if (isValidStudent(id, n)) {
                    int sum = 0;
                    for (int i = 0; i < SUBJECTS; i++) {
                        sum += marks[id - 1][i];
                    }
                    System.out.println("Total Marks: " + sum);
                } else {
                    System.out.println("Invalid student ID!");
                }

            } else if (command.equals("grades")) {
                int id = sc.nextInt();
                if (isValidStudent(id, n)) {
                    System.out.println("Grades for Student " + id + ":");
                    for (int i = 0; i < SUBJECTS; i++) {
                        int score = marks[id - 1][i];
                        System.out.println(SUBJECT_NAMES[i] + ": " + score + " - " + getGrade(score));
                    }
                } else {
                    System.out.println("Invalid student ID!");
                }

            } else if (command.equals("7")) {
                System.out.println("Exiting...");
                break;

            } else {
                System.out.println("Invalid command!");
            }
        }

        sc.close();
    }

    static boolean isValidStudent(int id, int n) {
        return id >= 1 && id <= n;
    }

    static boolean isValidSubject(int sub) {
        return sub >= 1 && sub <= SUBJECTS;
    }

    static String getGrade(int score) {
        if (score >= 90) return "Grade A";
        else if (score >= 80) return "Grade B";
        else if (score >= 70) return "Grade C";
        else if (score >= 60) return "Grade D";
        else return "Grade F";
    }
}
