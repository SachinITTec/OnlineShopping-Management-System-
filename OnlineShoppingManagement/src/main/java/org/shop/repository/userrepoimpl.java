package org.shop.repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.shop.model.catmodel;
import org.shop.model.productmodel;
import org.shop.model.usermodel;

public class userrepoimpl extends DBState implements userrepo {
    @Override
    public boolean isAddNewuser(usermodel model) {
        try {
            stmt = conn.prepareStatement("INSERT INTO user (name, password, role) VALUES (?, ?, ?)");
            stmt.setString(1, model.getName());
            stmt.setString(2, model.getPassword());
            stmt.setString(3, model.getRole());

            int value = stmt.executeUpdate();
            return value > 0;
        } catch (Exception ex) {
            System.out.println("Error is " + ex);
        }
        return false;
    }

	@Override
	public List<usermodel> viewAllusers() {
		// TODO Auto-generated method stub
		List<usermodel> viewuser=new ArrayList();
		try
		{
			stmt=conn.prepareStatement("select * from user");
			rs=stmt.executeQuery();
			while(rs.next())
			{
				usermodel model=new usermodel(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4));
				viewuser.add(model);
			}
			return viewuser;
		}catch(Exception e)
		{
           System.out.println("Error is"+e);
           return null;
		}
	}
	
	public boolean validateUser(String username,String password)
	{
		try
		{
			stmt=conn.prepareStatement("select * from user where name=? and password=?");
			stmt.setString(1, username);
			stmt.setString(2, password);
			rs=stmt.executeQuery();
			
			return rs.next();
			
		}
		catch(Exception e)
		{
			System.out.println("Error is "+e);
		}
		return false;
	}
	
	public boolean updateUserDetails(int id,String newName,String newPassword,String newRole)
	{
		
		try {
	        stmt = conn.prepareStatement("UPDATE user SET name = ?, password = ?, role = ? WHERE id = ?");
	        stmt.setString(1, newName);
	        stmt.setString(2, newPassword);
	        stmt.setString(3, newRole);
	        stmt.setInt(4, id);

	        int rowsUpdated = stmt.executeUpdate();
	        return rowsUpdated > 0;
	    } catch (Exception e) {
	        System.out.println("Error updating user details: " + e);
	    }
	    return false;
		
	}

	@Override
	public boolean validateadmin(String username, String password,String role) {
		// TODO Auto-generated method stub
		try
		{
			stmt=conn.prepareStatement("select * from user where name=? and password=? and role=?");
			stmt.setString(1, username);
			stmt.setString(2, password);
			stmt.setString(3, role);
			rs=stmt.executeQuery();
			
			return rs.next();
			
			
			
		}catch(Exception e)
		{
			System.out.println("Error is "+e);
		}
		return false;
	}


	public boolean isAddNewProduct(productmodel product) {
	    try {
	        // Use only the columns that need manual input
	        stmt = conn.prepareStatement("INSERT INTO products(name, price, quantity,cid) VALUES (?, ?, ?,?)");
	        stmt.setString(1, product.getName());      // Set name
	        stmt.setBigDecimal(2, product.getPrice()); // Set price
	        stmt.setInt(3, product.getQuantity());     // Set quantity
	        stmt.setInt(4,product.getCid());

	        int value = stmt.executeUpdate(); // Execute the query
	        return value > 0; // Check if the product was successfully added
	    } catch (Exception ex) {
	        System.out.println("Error is " + ex); // Print the error for debugging
	    }
	    return false; // Return false in case of failure
	}

	@Override
	public boolean isshowcategory(catmodel cat) {
		 try {
		        stmt = conn.prepareStatement("SELECT cid, category_name FROM categories");
		        rs = stmt.executeQuery();
		        System.out.println("Available Categories:");
		        while (rs.next()) {
		            System.out.println("ID: " + rs.getInt("cid")+ ", category Name: " + rs.getString("category_name"));
		        }
		    } catch (Exception e) {
		        System.out.println("Error: " + e);
		    }
		return false;
	}



	
	
	
	
}
