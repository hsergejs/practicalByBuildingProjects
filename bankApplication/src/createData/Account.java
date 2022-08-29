package createData;

public abstract class Account implements IRateIAPI {
    private String accName;
    private String taxNumber;
    private double initBalance;
    protected String initAccountNumber;
    private static int uniqueID = 10000;
    protected double rate;

    public Account(String name, String taxNum, double initBal){
        this.accName = name;
        this.taxNumber = taxNum;
        this.initBalance = initBal;
        this.initAccountNumber = generateAccNumber();
        System.out.println("Account created successfully");
        setRate();
    }

    private String generateAccNumber(){
        this.uniqueID++;
        String fromTaxNumber = this.taxNumber.substring(this.taxNumber.length()-2, this.taxNumber.length());
        int randomNumber = (int)(Math.random() * Math.pow(10,3));
        return fromTaxNumber + this.uniqueID + randomNumber;
    }

    public void compoundRate(){
        double interest = this.initBalance * (this.rate/100);
        System.out.println("Account current interest balance: " + interest);
        this.initBalance += interest;
        printBalance();
    }

    public abstract void setRate();

    public void showInfo(){
        System.out.println("Name on account: " + this.accName +
                "\nTax number: " + this.taxNumber +
                "\nCurrent balance: " + this.initBalance +
                "\nAccount rate: " + rate + "%");
    }

    public void deposit(double amount){
        this.initBalance += amount;
        System.out.println(amount + " deposited to account.");
        printBalance();
    }

    public void withdraw(double amount){
        this.initBalance -= amount;
        System.out.println(amount + " is withdraw from account.");
        printBalance();
    }

    public void transfer(double amount, String person){
        this.initBalance -= amount;
        System.out.println("Transferring to " + person + " " + amount);
        printBalance();
    }

    public void printBalance(){
        System.out.println("Current balance: " + this.initBalance);
    }
}
