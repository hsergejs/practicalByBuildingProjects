package createData;

public class CheckingAccount extends Account{
    private String cardNumber;
    private int debitCardPin;

    public CheckingAccount(String name, String taxNum, double initBal){
        super(name, taxNum, initBal);
        this.initAccountNumber = "2" + this.initAccountNumber;
        generateDebitCardData();
    }

    @Override
    public void setRate() {
        this.rate = getBaseRate() * 0.15;
    }

    private void generateDebitCardData(){
        this.cardNumber = "";
        for(int i=0; i<12; i++){
            this.cardNumber = this.cardNumber + "" + (int)(Math.random() * Math.pow(10,1));
        }
        this.debitCardPin = (int)(Math.random() * Math.pow(10, 4));
    }

    public void showInfo(){
        super.showInfo();
        System.out.println("Account type: Checking account." +
                "\n Account number: " + this.initAccountNumber +
                "\n Debit card number: " + this.cardNumber +
                "\n Debit card pin: " + this.debitCardPin);
    }
}
