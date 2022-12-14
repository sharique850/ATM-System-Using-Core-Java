import java.util.Scanner;
class Atm1
{
	static int balance=50000;
	static int array[]=new int[100];
	static int status=-1,i;
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int n,pin,gpin,chpin;
		char ch;
		int withdrawl_amount,deposit_amount,remain,k=0;
		System.out.println("\t\t\t****** Welcome to CODE Bank ATM ******\n");
		System.out.println("\t\t\tGenerate your pin:- ");
		gpin=sc.nextInt();
		System.out.println("\n\t\t\tConfirm your pin:- ");
		pin=sc.nextInt();
		if(pin==gpin)
		{
		do{
			System.out.println("\n\t\t\t1.Balance_Enquiry");
			System.out.println("\t\t\t2.Cash_withdrawal");
			System.out.println("\t\t\t3.Add your balance");
			System.out.println("\t\t\t4.Check your status");
			System.out.println("\n\t\t\tSelect your choice:- ");
			n=sc.nextInt();
			switch(n)
			{
			case 1: System.out.println("\t\t\tYour avilable balance is "+balance);
					break;
			case 2: System.out.println("\t\t\tEnter your withdrawl_amount:- ");
					withdrawl_amount=sc.nextInt();
					try
					{
						if(balance<withdrawl_amount)
			
						throw new ArithmeticException("\t\t\tInsufficient balance");
						System.out.println("\t\t\tTransaction Successfully completed");
						System.out.println("\t\t\tThank you");
						k=1;
					}
					catch(ArithmeticException e)
					{
					System.out.println("Error: "+e.getMessage());
					}
					finally
					{	
						if(k==1)
						{
							remain=balance-withdrawl_amount;
							System.out.println("\t\t\tYour Remaining balance is "+remain);
							balance=remain;
							
							status++;
							array[status]=balance;
							
							
						}
						else
						{
							System.out.println("\t\t\tYour total balance is:- "+balance);
						}
					}
					break;
			case 3: System.out.println("\t\t\tEnter your pin");
					chpin=sc.nextInt();
					if(chpin==pin)
					{
						System.out.println("\t\t\tEnter your deposit amount");
						deposit_amount=sc.nextInt();
						balance=balance+deposit_amount;
						status++;
						array[status]=balance;
						System.out.println("\t\t\tYour amount has been successfully deposited");
					}
					else
					{
						System.out.println("\t\t\tSorry!!! You have entered a wrong pin");
					}
					break;
			case 4: System.out.println("\t\t\tYour current Status is");
					for(i=status;i>=0;i--)
						System.out.println("\t\t\t"+array[i]);
					break;
			default : System.out.println("\t\t\tInvalid input");
			}
			System.out.println("\n\t\t\tIf you want to continue then press Y otherwise press any key");
			ch=sc.next().charAt(0);
		}
		while(ch=='y');
		}
		else
		{
			System.out.println("\t\t\tSorry!!! You have entered a wrong pin");
		}
		
	}
}