//3 switch,1 static block,6 for, 5 while,9 ifelse/if.
import java.util.*;
class Admin
{
	static Scanner sc=new Scanner(System.in);
	int stock;
	String ingredients[];
	static int n=5;
	static String menu[]=new String[25];
	static double price[]=new double[25];
	static 
	{
		menu[0]="Maggi";
		menu[1]="Pasta";
		menu[2]="Pizza";
		menu[3]="Club-Sandwich";
		menu[4]="Noodles";
		price[0]=60;
		price[1]=120;
		price[2]=150;
		price[3]=180;
		price[4]=120;
	}
	void displayMenu()
	{
		System.out.println("*************MENU*************");
		for(int i=0;i<n;i++)
		{
			System.out.println(menu[i]+"-->"+price[i]);
		}
		System.out.println("******************************");
	}
	void addMenu()
	{
		int check=0;
		n+=1;
		int flag=0;
		System.out.print("Enter name of item(use '-' instead of spaces):");
		menu[n-1]=sc.next();
		menu[n-1]=menu[n-1].trim();
		System.out.print("Enter price of item:");
		price[n-1]=sc.nextDouble();
		System.out.println("Item added successfully!!");
		System.out.println("******************************");
		System.out.println();
		displayMenu();
	}
	void searchMenu()
	{
		int flag=0;
		System.out.print("Enter name of the item:");
		String s=sc.next();
		s=s.trim();
		for(int i=0;i<n;i++)
		{
			if(s.equalsIgnoreCase(menu[i]))
			{
				flag++;
				System.out.println("*************************");
				System.out.println(menu[i]+"-->"+price[i]);
				System.out.println("*************************");
				break;
			}
		}
		if(flag==0)
		{
			System.out.println("No data found!!");
		}
	}
	void updateMenu()
	{
		int flag=0;
		System.out.print("Enter name of the item:");
		String s=sc.next();
		s=s.trim();
		for(int i=0;i<n;i++)
		{
			if(s.equalsIgnoreCase(menu[i]))
			{
				flag++;
				System.out.println("*****CURRENT DETAILS*****");
				System.out.println(menu[i]+"-->"+price[i]);
				System.out.println("*************************");
				System.out.println("Press 1 to update name.");
				System.out.println("Press 2 to update price.");
				System.out.print("Enter your choice:");
				int c=sc.nextInt();
				System.out.print("Are you sure you want to update?(Y/N):");
				char ch=sc.next().charAt(0);
				if(ch=='Y'|| ch=='y')
				{
					switch(c)
					{
						case 1: sc.nextLine();
								System.out.print("Enter updated name:");
								menu[i]=sc.next();
								System.out.println("Updated Successfully!");
								System.out.println(menu[i]+"-->"+price[i]);
								break;
						case 2: System.out.print("Enter updated price:");
								price[i]=sc.nextInt();
								System.out.println("Updated Successfully!");
								System.out.println(menu[i]+"-->"+price[i]);
								break;
						default: System.out.println("Invalid choice!!");
					}
				}
				else
				{
					System.out.println("Thank You!!");
				}
				break;
			}
		}
		if(flag==0)
		{
			System.out.println("No data found!!");
		}
	}
}
class Customer extends Admin
{
	void menu()
	{
		this.displayMenu();
	}
	void order()
	{
		System.out.println();
		System.out.println("ONLY 10 ITEMS AT MAX CAN BE ORDERED AT ONCE.");
		System.out.println("PRESS * TO STOP ORDERING IF YOU ARE ORDERING LESS THAN 10 ITEMS.");
		System.out.println("DO NOT USE SPACES WHILE ENTERING ITEM NAME INSTEAD USE '-'.");
		System.out.println();
		boolean orderLoop=true;
		String order[]=new String[10];
		double bill[]=new double[10];
		int counter=0;
		while(orderLoop==true)
		{
			System.out.print("Enter item "+(counter+1)+"of order:");
			order[counter]=sc.next();
			order[counter]=order[counter].trim();
			if(order[counter].equals("*"))
			{
				System.out.println("Order placed successfully!");
				this.generateBill(order,bill,counter);
				orderLoop=false;
			}
			else
			{
				int flag=0;
				for(int i=0;i<n;i++)
				{
					if(order[counter].equalsIgnoreCase(menu[i]))
					{
						flag+=1;
						bill[counter]=price[i];
					}
				}
			}
			counter+=1;
		}
	}
	void generateBill(String order[],double bill[],int counter)
	{
		double total=0;
		for(int i=0;i<counter;i++)
		{
			total+=bill[i];
		}
		System.out.println("******* BILL *******");
		for(int i=0;i<counter;i++)
		{
			System.out.println(order[i]+"-->"+bill[i]);
		}
		System.out.println("********************");
		System.out.println("Total-->"+total);
		System.out.println("********************");
		System.out.println();
		System.out.println("Please take a print out and pay at the pay window");
		System.out.println();
	}
}
class Run
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("*****WELCOME TO PAL'S CAFE*****");
		boolean mloop=true;
		while(mloop==true)
		{
			System.out.print("1.Admin\n2.Customer\n3.Exit\nEnter your choice:");
			int choice=sc.nextInt();
			switch(choice)
			{
				case 1: boolean checkPass=false;
						while(checkPass==false)
						{
							System.out.print("Enter password:");
							String password=sc.next();
							if(password.equals("BestCafe1234"))
							{
								checkPass=true;
								Admin a=new Admin();
								System.out.println("Access Granted!!");
								boolean adminLoop=true;
								while(adminLoop==true)
								{
									System.out.println();
									System.out.println("Press 1 to check the menu.");
									System.out.println("Press 2 to add an item to menu.");
									System.out.println("Press 3 to search an item to menu.");
									System.out.println("Press 4 to update an item to menu.");
									System.out.println("Press 5 to exit.");
									System.out.println();
									System.out.print("Enter your choice:");
									int choice1=sc.nextInt();
									System.out.println();
									switch(choice1)
									{
										case 1: a.displayMenu();break;
										case 2: a.addMenu();break;
										case 3: a.searchMenu();break;
										case 4: a.updateMenu();break;
										case 5: System.out.print("Are you sure you want to exit(Y/N)?:");
												char sure=sc.next().charAt(0);
												if(sure=='Y' || sure=='y')
												{
													System.out.println("Thank You!!");
													adminLoop=false;
												}
												else
												{
													adminLoop=true;
												}
												break;
										default: System.out.println("Invalid choice!");
									}
								}
							}
							else
							{
								System.out.println("Incorrect password!\nTry again!!");
							}
						}
						break;
				case 2: System.out.println();
						System.out.println("Welcome dear customer.");
						System.out.println("I am Cafebot, How may I help you today?");
						System.out.println();
						boolean customerLoop=true;
						while(customerLoop==true)
						{
							System.out.println("Press 1 to see the menu.");
							System.out.println("Press 2 to order any item.");
							System.out.println("Press 3 to exit.");
							System.out.print("Enter your choice:");
							int choice2=sc.nextInt();
							Customer c=new Customer();
							switch(choice2)
							{
								case 1: c.menu();break;
								case 2: c.order();break;
								case 3: System.out.println("Thank You for using our CafeBot!");customerLoop=false;
								default: System.out.println("Invalid choice!");
							}
						}
						break;
				case 3: System.out.print("Are you sure you want to exit(Y/N)?:");
						char sure=sc.next().charAt(0);
						if(sure=='Y' || sure=='y')
						{
							System.out.println("Thank You for using our CafeBot!!");
							mloop=false;
						}
						else
						{
							mloop=true;
						}
						break;
				default: System.out.println("Invalid selection!\n Enter valid choice!");
			}
		}
	}
}