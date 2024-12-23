package org.shop.service;

import java.math.BigDecimal;
import java.util.List;

import org.shop.model.catmodel;
import org.shop.model.productmodel; // Corrected import
import org.shop.model.usermodel;

public interface userservice {
    public boolean isAddNewuser(usermodel model);
    public List<usermodel> viewAllusers();
    public boolean validateUser(String username, String password);
    public boolean updateUserDetails(int id, String name, String newPassword, String Role);
    boolean validateadmin(String username, String password, String role);
    public boolean isAddNewProduct(productmodel product);
    public boolean isshowcategory(catmodel cat);
}
