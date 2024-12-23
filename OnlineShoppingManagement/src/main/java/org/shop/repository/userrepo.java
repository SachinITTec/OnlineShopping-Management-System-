package org.shop.repository;

import java.math.BigDecimal;
import java.util.List;

import org.shop.model.catmodel;
import org.shop.model.productmodel;
import org.shop.model.usermodel;

public interface userrepo {
	public boolean isAddNewuser(usermodel model);
	public List<usermodel> viewAllusers();
	boolean validateUser(String username,String password);
    boolean updateUserDetails(int id,String name,String newPassword,String Role);
    boolean validateadmin(String username,String password,String role);
    public boolean isAddNewProduct(productmodel product);
    public boolean isshowcategory(catmodel cat);
}
