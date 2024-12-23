package org.shop.service;



import java.math.BigDecimal;
import java.util.List;

import org.shop.model.catmodel;
import org.shop.model.productmodel;
import org.shop.model.usermodel;
import org.shop.repository.userrepo;
import org.shop.repository.userrepoimpl;

public class userserviceImpl implements userservice {
    userrepo repo = new userrepoimpl();

    @Override
    public boolean isAddNewuser(usermodel model) {
        return repo.isAddNewuser(model);
    }

	@Override
	public List<usermodel> viewAllusers() {
		
		return repo.viewAllusers();
	}
	public boolean validateUser(String username,String password) {
        return repo.validateUser(username,password);
    }

	@Override
	public boolean updateUserDetails(int id, String name, String newPassword, String Role) {
		// TODO Auto-generated method 
		return repo.updateUserDetails(id, name, newPassword, Role);
		
	}

	@Override
	public boolean validateadmin(String username, String password,String role) {
		return repo.validateadmin(username, password,role);
		
	}

	

	@Override
	public boolean isAddNewProduct(productmodel product) {
		return repo.isAddNewProduct(product);
	}

	@Override
	public boolean isshowcategory(catmodel cat) {
		return repo.isshowcategory(cat);
		
	}





	
    
}
