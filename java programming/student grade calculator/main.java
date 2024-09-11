import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner  scanner = new Scanner(System.in);
        System.out.print("Enter the number of subjects : ");
        int subjects = scanner.nextInt();
        int[] marks = new int[subjects];
        int totalmarks = 0;
        for(int i = 0;i<subjects;i++){
            System.out.print("Enter marks obtained in subject "+(i+1)+" (out of 100):");
            marks[i] = scanner.nextInt();
            totalmarks += marks[i];
        }

        double average = (double) totalmarks/subjects;

        String grade;
        if(average >= 90){
            grade = "A+";
        }else if(average >=80){
            grade = "A";
        }else if(average >=70){
            grade = "A";
        }else if(average >=60){
            grade = "A";
        }else if(average >=50){
            grade = "A";
        }else if(average >=40){
            grade = "A";
        }else {
            grade = "F";
        }

        System.out.println("\n-------- Results -------");
        System.out.println("Total Marks : " + totalmarks + "/" + (subjects * 100));
        System.out.println("Average Percentage : "+ average);
        System.out.println("Grade : "+grade);

        scanner.close();
    }
}
