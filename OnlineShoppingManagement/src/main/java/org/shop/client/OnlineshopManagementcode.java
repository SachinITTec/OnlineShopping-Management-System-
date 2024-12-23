package org.shop.client;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

import org.shop.model.productmodel;
import org.shop.model.usermodel;
import org.shop.service.userservice;
import org.shop.service.userserviceImpl;

public class OnlineshopManagementcode {

    public static void main(String[] args) {
        userservice userService = new userserviceImpl();
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("====== Online Shopping Management System ======");
            System.out.println("1:Register As New User");
            System.out.println("2:Login As User");
            System.out.println("3:Login As Admin");
            System.out.println("4:Update the Profile");
            
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                	System.out.println("=============================== Welcome to Online Shop =========================================");
                    System.out.print("Enter User Name: ");
                    String name = sc.next();
                    System.out.print("Enter Password: ");
                    String password = sc.next();
                    System.out.print("Enter Role CUSTOMER: ");
                    String role = sc.next();

                    usermodel newUser = new usermodel(0, name, role, password); // `id` will be auto-generated
                    boolean isAdded = userService.isAddNewuser(newUser);

                    if (isAdded) {
                        System.out.println("User added successfully!");
                    } else {
                        System.out.println("Failed to add user. Please try again.");
                    }
                    break;

                    
                case 2:
                	System.out.println("=============================== Welcome to Login Panel =========================================");
                	sc.nextLine();
                	System.out.println("Enter the username for the login !!!!!!!!!!!");
                	String username=sc.nextLine();
                	System.out.println("Enter the  password for the login !!!!!!!!!!");
                	String pass=sc.nextLine();
                	
                	boolean isvaliduser=userService.validateUser(username,pass);
                	if(isvaliduser)
                	{
                		System.out.println("Login Successfully........");
                	}
                	else
                	{
                		System.out.println("Login Failed..........");
                	}
                	break;
                	
                case 3:
                	System.out.println("=============================== Welcome to Admin Panel =========================================");
                	sc.nextLine();
                	System.out.println("Enter the username for the login !!!!!!!!!!!");
                	String username1=sc.nextLine();
                	System.out.println("Enter the  password for the login !!!!!!!!!!");
                	String pass1=sc.nextLine();
                	System.out.println("Enter the  role for the login !!!!!!!!!!");
                	String role1=sc.nextLine();
                	
                	boolean isvalidateadmin=userService.validateadmin(username1,pass1,role1);
                	
                	if(isvalidateadmin)
                	{
                		System.out.println("Admin Login Successfully........");
                		
                		do
                		{
                			System.out.println("==================================Perform Admin Operation==========================");
                			System.out.println("1:Veiw All The User");
                			System.out.println("2:View All The Categories");
                			System.out.println("3:Add the Products");
                			
                		    System.out.println("Enter Your Chioce:");
                		    int choice1=sc.nextInt();
                		    
                		    switch(choice1)
                		    {
                		    	case 1:
                		    		List<usermodel> viewuser=userService.viewAllusers();
                    		    	if(viewuser!=null)
                    		    	{
                    		    	for(usermodel a:viewuser)
                    		    	{
                    		    	   System.out.println(a.getId()+"\t"+a.getName()+"\t"+a.getPassword()+"\t"+a.getRole());
                    		    	}
                    		    	}
                    		    	else
                    		    	{
                    		    		System.out.println("List is Emplty!");
                    		    	}
                		    		break;
                		    	case 2:
                		    		userService.isshowcategory(null);
                		    		break;
                		    		
                		    	case 3: // Add Product
                		    			    	   
                		    		System.out.print("Enter Product Price: ");
                		    	    BigDecimal price = sc.nextBigDecimal();
                		    	    sc.nextLine();
                		    	    System.out.print("Enter Product Name: ");
                		    	    String pname = sc.nextLine();
                		    	    
                		    	    System.out.print("Enter Product Quantity: ");
                		    	    int quantity = sc.nextInt();
                		    	    
                		    	    System.out.print("Enter Product categories Id: ");
                		    	    int cid = sc.nextInt();

                		    	    productmodel newproduct = new productmodel(pname, price, quantity,cid);
                		    	    boolean isAdded1 = userService.isAddNewProduct(newproduct);

                		    	    if (isAdded1) {
                		    	        System.out.println("Product added successfully!");
                		    	    } else {
                		    	        System.out.println("Failed to add product. Please try again.");
                		    	    }
                		    	    break;

                		    	case 4:
                                    System.out.println("Exiting... Thank you!");
                                    sc.close();
                                    System.exit(0);

                                default:
                                    System.out.println("Invalid choice! Please try again.");
                		    }
                			
                		}while(true);
                		
                	}
                	else
                	{
                		System.out.println("Login Failed..........");
                	}
                	break;
                
                    
                case 4:
                	System.out.println("===============================Update Your Profile==============================================");
                	System.out.println("Enter the User ID");
                	int id=sc.nextInt();
                	sc.nextLine();
                	System.out.println("Enter the Name");
                	String name1=sc.nextLine();
                	System.out.print("Enter New Password: ");
                	String newPassword = sc.nextLine();
                	System.out.print("Enter New Role (CUSTOMER/ADMIN): ");
                	String newRole = sc.nextLine();
                	
                	boolean isupdate=userService.updateUserDetails(id, name1, newPassword, newRole);
                	if(isupdate)
                	{
                		System.out.println("Profile Updated Successfully");
                	}
                	else
                	{
                		System.out.println("Failed to Update the profile");
                	}
                	break;
             
                case 5:
                    System.out.println("Exiting... Thank you!");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (true);
    }

	
}
