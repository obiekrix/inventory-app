package org.task.mint.service;

import org.task.mint.entity.Admin;

import java.util.List;

/**
 * @author Christian
 *
 */
public interface AdminService {
	
	public List<Admin> getAdmins();

	public void saveAdmin(Admin theAdmin);

	public void updateAdmin(Admin theAdmin);

	public Admin getAdmin(int theId);

	public void deleteAdmin(int theId);
}
