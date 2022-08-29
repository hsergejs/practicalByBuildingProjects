import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Email {
    private User user;
    private Scanner in;
    private String email;
    private String alterEmail;
    private String password;
    private int capacity;
    private Map<Integer,String> departmentList;
    private final String COMPANYDOMAIN = "company.com";

    public Email() {
        in = new Scanner(System.in);
        System.out.print("Please enter name: ");
        String name = in.nextLine();
        System.out.print("Please enter surname: ");
        String surname = in.nextLine();
        this.user = new User(name,surname,getDepartment());
        generateEmail();
        setCapacity();
        System.out.print("Please enter password length: ");
        generatePassword(in.nextInt());
        System.out.println("Email password: " + this.password);
    }

    private String getDepartment() {
        setDepartments();
        System.out.println("Available departments list: ");
        for(HashMap.Entry<Integer,String> entry : departmentList.entrySet()){
            System.out.println("Use " + entry.getKey() + " for " + entry.getValue());
        }

        System.out.print("Please enter department code: ");
        return departmentList.get(in.nextInt());
    }

    private void setDepartments(){
        departmentList = new HashMap<>();
        departmentList.put(0, "none");
        departmentList.put(1,"Sales");
        departmentList.put(2,"Development");
        departmentList.put(3,"Accounting");
    }

    private void generateEmail(){
        String department = this.user.getDepartment();
        if(department.equals("none")){
            department = "";
        }
        else{
            department = department.toLowerCase() + ".";
        }

        System.out.println("Email created for: " + this.user.getName() + " " + this.user.getSurname());

        this.email = this.user.getName().toLowerCase() + "." + this.user.getSurname().toLowerCase() +
                "@" + department + this.COMPANYDOMAIN;
    }

    private void generatePassword(int length){
        String charSet = "QWERTYUIOPASDFGHJKLZXCVBNM1234567890!@*";
        char[] password = new char[length];
        for(int i=0; i<length; i++){
            int rnd = (int) (Math.random() * charSet.length());
            password[i] = charSet.charAt(rnd);
        }

        this.password = new String(password);
    }

    public void setCapacity() {
        System.out.print("Please set email box capacity in mb: ");
        this.capacity = in.nextInt();
    }

    public void changePassword(){
        this.password = in.nextLine();
    }

    public void setAlterEmail(){
        System.out.println("Enter alternate email: ");
        this.alterEmail = in.nextLine();
    }

    public int getCapacity(){
        return this.capacity;
    }

    public String getAltEmail(){
        return this.alterEmail;
    }

    public String getPassword() {
        return this.password;
    }

    public void showInfo(){
        System.out.println("Email data for user: " + this.user.getName() + " " + this.user.getSurname());
        System.out.println("Company email: " + this.email);
        System.out.println("Mailbox capacity: " + this.capacity + "MB");
    }

    private class User {
        private String name;
        private String surname;
        private String department;

        public User(String name, String surname, String department){
            this.name = name;
            this. surname = surname;
            this.department = department;
        }

        public String getName() {
            return name;
        }

        public String getSurname() {
            return surname;
        }

        public String getDepartment() {
            return department;
        }
    }
}

