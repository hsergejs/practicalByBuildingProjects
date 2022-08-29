import myClasses.Student;
import myUtilities.MyUtilities;
import myUtilities.SortBySurname;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class StudentDatabaseApplication {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter students amount to enroll: ");
        int studentAmount = in.nextInt();
        List<Student> studentList = new ArrayList<>();
        for(int i=0; i<studentAmount; i++){
            Student st = new Student();
            if(studentList.contains(st)){
                System.out.println("myClasses.Student already enrolled, pleas enter new credentials");
                i--;
            }
            else{
                studentList.add(st);
                st.enrollStudent();
                st.payTuitionFee();
                st.showStatus();
            }
        }

        Collections.sort(studentList);
        System.out.println("All enrolled students: ");
        MyUtilities.printList(studentList);

        System.out.println("Sorted list by student surname:");
        Collections.sort(studentList, new SortBySurname());
        MyUtilities.printList(studentList);

    }
}
