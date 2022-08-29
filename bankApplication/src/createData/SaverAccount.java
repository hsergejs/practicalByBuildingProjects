package createData;

public class SaverAccount extends Account{
    private int sateDepositBoxId;
    private int safetyDepositBoxKey;

    public SaverAccount(String name, String taxNum, double initBal){
        super(name, taxNum, initBal);
        this.initAccountNumber = "1" + this.initAccountNumber;
        this.sateDepositBoxId = generateSafetyDepositBoxId();
        this.safetyDepositBoxKey = generateSafetyDepositBoxKey();
    }

    @Override
    public void setRate() {
        this.rate = getBaseRate() - 0.25;
    }

    private int generateSafetyDepositBoxId(){
        return (int)(Math.random() * Math.pow(10, 3));
    }

    private int generateSafetyDepositBoxKey(){
        return (int)(Math.random() * Math.pow(10, 4));
    }

    public void showInfo(){
        super.showInfo();
        System.out.println("Account type: Savings account." +
                "\n Account number: " + this.initAccountNumber +
                "\n Deposit box number: " + this.sateDepositBoxId +
                "\n Deposit box pin: " + this.safetyDepositBoxKey);
    }
}
