/**
 * 
 */
package org.task.mint.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.task.mint.entity.Admin;
import org.task.mint.service.AdminService;

import java.util.List;

/**
 * @author Christian
 *
 */
@RestController
@RequestMapping("/admin")
public class AdminRestController {

	@Autowired
	private AdminService adminService;

	@GetMapping("/all")
	public List<Admin> getAdmins(){
		return adminService.getAdmins();
	}

	@GetMapping("/{id}")
	public Admin getAdmin(@PathVariable int id){
		return adminService.getAdmin(id);
	}

	@PostMapping("/add")
	public ResponseEntity<Object> addAdmin(@RequestBody Admin theAdmin) {
		adminService.saveAdmin(theAdmin);
		
		return ResponseEntity.ok().build();
	}
	
	@PutMapping("/update")
	public ResponseEntity<Object> updateAdmin(@RequestBody Admin theAdmin) {
		
		adminService.updateAdmin(theAdmin);
		
		return ResponseEntity.ok().build();
	}
}
