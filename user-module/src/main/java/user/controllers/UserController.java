package user.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import user.beans.UserBean;
import user.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	/**
	 * This method is used to create the user
	 * 
	 * @param userbean
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/createUser")
	public String createUser(@RequestBody UserBean userbean) {
		userService.addUser(userbean);
		return "User Created";
	}

	/**
	 * This method is used to fetch all Users
	 * 
	 * @return
	 */
	@GetMapping("/allUsers")
	public @ResponseBody Iterable<UserBean> fetchAllUsers() {
		return userService.fetchAllUsers();
	}

	/**
	 * This method is responsible to fetch User on Param : name
	 * 
	 * @param name
	 * @return
	 */
	@RequestMapping("/findUser/{name}")
	public UserBean getUser(@PathVariable String name) {
		return userService.getUserOnName(name);
	}

	/**
	 * This method is reponsible to delete user on Param : Name
	 * 
	 * @param name
	 * @return
	 */
	@RequestMapping("/deleteUser/{name}")
	public String deleteUser(@PathVariable String name) {
		userService.deleteUserByName(name);
		return "User Deleted";
	}

	/**
	 * This method is responsible to update the user
	 * 
	 * @param userBean
	 * @return
	 */
	@PutMapping("updateUser")
	public String updateUser(@RequestBody UserBean userBean) {
		userService.updateUser(userBean);
		return "User Updated";
	}
}
