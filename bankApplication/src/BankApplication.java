import createData.Account;
import createData.CheckingAccount;
import createData.SaverAccount;
import myUtilities.MyUtilities;

import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;

public class BankApplication {
    public static void main(String[] args) {
        /*
        SaverAccount save = new SaverAccount("Sergejs Holostovs", "123456789", 10000.00);
        save.showInfo();
        save.compoundRate();
        System.out.println("***********************");
        CheckingAccount checking = new CheckingAccount("Ekaterina Kan", "987654321", 10000);
        checking.showInfo();
        checking.compoundRate();
         */

        String filePath = "C:\\Projects\\Java_Intellij\\udemyPracticeJavaByBuildingProjects\\bankApplication\\src\\data\\customerList.csv";
        List<String[]> dataList;
        List<Account> accountsList = new LinkedList<>();
        try {
            dataList = MyUtilities.readData(filePath);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        for(String[] data : dataList){
            String name = data[0];
            String taxNumber = data[1];
            String accType = data[2];
            double initDep = Double.parseDouble(data[3]);

            if(accType.equals("Savings")){
                SaverAccount saverAccount = new SaverAccount(name,taxNumber,initDep);
                saverAccount.showInfo();
                System.out.println("------------------\n");
                accountsList.add(saverAccount);
            }
            else if(accType.equals("Checking")){
                CheckingAccount checkingAccount = new CheckingAccount(name,taxNumber,initDep);
                checkingAccount.showInfo();
                System.out.println("------------------\n");
                accountsList.add(checkingAccount);
            }
            else{
                System.out.println("Error reading CSV file!");
            }
        }

        for(Account account : accountsList){
            account.showInfo();
            System.out.println("***************\n");
        }
    }
}
