package org.task.mint.dao;

import org.task.mint.entity.Admin;

import java.util.List;


public interface AdminDAO {
	
	List<Admin> getAdmins();

	void saveAdmin(Admin theAdmin);

	void updateAdmin(Admin theAdmin);
	
	Admin getAdmin(int theId);

	void deleteAdmin(int theId);

}
