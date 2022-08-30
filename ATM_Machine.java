//Patil Deepraj Bharat
//Task-3 ATM Machine
//Java Programming

import java.util.Scanner;

public class ATM_Machine {

    static Scanner sc = new Scanner(System.in);
        
    static String userId;
    static String password;
    static int acc_no;
    static int pin;
    static float balance = 10000f;
    static int trans = 0;
    static String transHis = "";

    public static void register(){

        System.out.println("\nEnter your Username  :");
        userId = sc.next();
        System.out.println("ENTER YOUR PASSWORD  :");
        password = sc.next();
        System.out.println("ENTER YOUR ACCOUNT NUMBER  :");
        acc_no = sc.nextInt();
        System.out.println("ENTER YOUR ATM PIN  :");
        pin=sc.nextInt();
        System.out.println("\nRegistration completed. Successfully!!");
        System.out.println("Kindly login to your account.");
    }


    public static boolean login(){
        boolean isLogin = false;
        while(!isLogin)
        {
            System.out.println("\nEnter your Account Number : ");
            int actno = sc.nextInt();
            if(actno == acc_no)
            {
               System.out.println("Enter your ATM pin : ");
               int pin1 = sc.nextInt();
               while(!isLogin)
               {
                   if(pin1 == pin)
                   {
                      System.out.println("\nLogged in Successfully");
                      isLogin = true;
                   }
                   else
                   {
                      System.out.println("\nInvalid ATM pin");
                      break;
                   }
            
                }
            }
            else
            {
               System.out.println("\nInvalid Account Number");
            }
        }
        return isLogin;

    }


    public static void checkBalance(){
        System.out.println("\nYour balance is : "+balance);
    }


    public static void deposit(){
        System.out.println("\nEnter the amount to be deposited : ");
        float depamnt = sc.nextFloat();
        balance = balance+depamnt;
        System.out.println("\nYour money has been successfully deposited");
        System.out.println("After depositing "+depamnt+", balance is "+balance);
        trans+=1;
        String s = "Rs. "+depamnt+" deposited to account\n";
        transHis = transHis.concat(s);
    }


    public static void withdraw(){
        System.out.println("\nEnter the amount you want to withdraw :");
        float wdamnt = sc.nextFloat();
        if(wdamnt<=balance)
        {
            System.out.println("\nSuccessfully withdrawn Rs. "+wdamnt);
            balance = balance-wdamnt;
            System.out.println("Your current balance is : "+balance);
            trans+=1;
            String s = "Rs. "+wdamnt+" withdrawn from account\n";
            transHis = transHis.concat(s);
        }
        else
        {
            System.out.println("\nSorry can't withdraw. Insufficient balance");
            System.out.println("Your current balance is : "+balance);
        }
    }


    public static void transfer(){
        System.out.println("\nEnter the Account No. you want to transfer to : ");
        String accno = sc.next();
        System.out.println("Enter the amount you want to transfer : ");
        float tamnt = sc.nextInt();

            if(tamnt<=balance)
            {
                System.out.println("\nMoney Transfered Successfully");
                balance = balance-tamnt;
                System.out.println("Your current balance is : "+balance);
                trans+=1;
                String s = "Rs. "+tamnt+" transfered from account\n";
                transHis = transHis.concat(s);
            }
            else
            {
                System.out.println("\nSorry can't transfer. Insufficient balance");
                System.out.println("Your current balance is : "+balance);
            }
    }


    public static void transHistory(){
        if(trans==0){
            System.out.println("No Transactions");
        }
        else
        {
            System.out.println(transHis);
        }
    }


    public static void main(String args[]){

        System.out.println("\nWELCOME TO ATM!!!");
        System.out.println("\nSelect any one option!");
        System.out.println("1.REGISTER\n2.EXIT");
        System.out.println("\nEnter your option :");

        int choice = sc.nextInt();

        if(choice == 1)
        {
            register();
            while(choice == 1){
                System.out.println("\nSelect any one option!");
                System.out.println("1.LOGIN\n2.EXIT");
                System.out.println("\nEnter your option :");
                int op=sc.nextInt();
                if (op==1)
                {
                    if(login())
                    {
                        boolean isFin = false;
                        while(!isFin)
                        {
                            System.out.println("\nSelect any option : ");
                            System.out.println("1.CHECK BALANCE\n2.DEPOSIT\n3.WITHDRAW\n4.TRANSFER\n5.TRANSACTION HISTORY\n6.EXIT");
                            System.out.println("\nEnter your option :");
                            int c=sc.nextInt();
                            switch(c){
                                case 1 : checkBalance();
                                        break;
                                case 2 : deposit();
                                        break;
                                case 3 : withdraw();
                                        break;
                                case 4 : transfer();
                                        break;
                                case 5 : transHistory();
                                        break;
                                case 6 : isFin=true;
                                        System.out.println("\nPlease collect your card");
                                        break;
                                default: System.out.println("Invalid option!");
                            }
                        }
                    }
                }
                else
                {
                    System.out.println("\nPlease collect your card");
                    System.exit(0);
                }
                break;
            }

        }
        else
        {
            System.out.println("\nPlease collect your card");
            System.exit(0);
        }
    }   
}
