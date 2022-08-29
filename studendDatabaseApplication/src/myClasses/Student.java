package myClasses;

import java.util.*;

public final class Student implements IGradeYear, Comparable<Student>{
    private String name;
    private String surname;
    private Map<Integer, String> gradeYearList;
    private int gradeYear;
    private String studentID;
    private static int id = 1000;
    private Set<Module> courses;
    private double tuitionBalance;
    private Scanner in;
    private double feeBalance;

    public Student(){
        this.courses = new HashSet<>();
        in = new Scanner(System.in);
        System.out.print("Enter name: ");
        this.name = in.nextLine();
        System.out.print("Enter surname: ");
        this.surname = in.nextLine();
        setGradeYear();
        setStudentId();
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }
    
    @Override
    public void createGradeYearList(){
        gradeYearList = new HashMap<>();
        gradeYearList.put(1,"Freshman");
        gradeYearList.put(2,"Sophomore");
        gradeYearList.put(3,"Junior");
        gradeYearList.put(4,"Senior");
    }

    private void setGradeYear(){
        createGradeYearList();
        System.out.println("Available class levels");
        for(Map.Entry<Integer,String> entity : gradeYearList.entrySet()){
            System.out.println("Press " + entity.getKey() + " for " + entity.getValue());
        }
        System.out.print("Choose student class level: ");
        this.gradeYear = in.nextInt();

    }

    private void setStudentId(){
        id++;
        this.studentID = this.gradeYear + "" + this.id;
    }

    public void enrollStudent(){
        while(true){
            System.out.println("Enter module name to enroll");
            System.out.print("To finish enrollment enter q: ");
            in.nextLine();
            String module = in.nextLine();
            if(module.equals("q")){
                break;
            }
            else{
                System.out.print("Enter module cost: ");
                double price = in.nextDouble();
                if(!this.courses.add(new Module(module, price))){
                    System.out.println("myClasses.Student already enrolled to this course! Please enter new module.");
                }
                else{
                    this.feeBalance = feeBalance + price;
                }

            }
        }

        System.out.println("myClasses.Student enrolled to the following modules:");
        for(Module module : this.courses){
            System.out.println("\t" + module.getCourseName());
        }

        System.out.println("Total fees: " + this.feeBalance);

    }

    public void displayBalance(){
        System.out.println("Current student fee balance: " + this.feeBalance);
    }

    public void payTuitionFee(double amount){
        this.feeBalance -= amount;
        System.out.println("Payment of: " + amount + " received.");
        displayBalance();
    }

    public void payTuitionFee(){
        System.out.print("Enter amount you would like to pay: ");
        double amount = in.nextDouble();
        this.feeBalance -= amount;
        System.out.println("Payment of: " + amount + " received.");
        displayBalance();
    }

    public void showStatus(){
        System.out.println("Status of " + this.name + " " + this.surname +
                "\nmyClasses.Student id: " + this.studentID);

        System.out.println("Modules enrolled");
        for(Module module : this.courses){
            System.out.println("\t" + module.getCourseName());
        }

        displayBalance();
    }

    @Override
    public int hashCode(){
        return this.name.hashCode() + this.surname.hashCode() * 31;
    }

    @Override
    public final boolean equals(Object obj){
        if(this == obj){
            return true;
        }

        if(obj instanceof Student){
            Student student = (Student) obj;
            return this.name.equals(student.getName()) && this.surname.equals(student.getSurname());
        }

        return false;
    }

    @Override
    public int compareTo(Student o) {
        return this.name.compareTo(o.getName());
    }

    @Override
    public String toString() {
        return "Student: " + this.name + " " + this.surname;
    }
}
