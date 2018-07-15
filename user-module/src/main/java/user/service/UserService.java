package user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import user.beans.UserBean;
import user.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	/*List<UserBean> users = new ArrayList<>( Arrays.asList(
			new UserBean("1","A","B"),new UserBean("1","AB","B")));*/
	
	/**
	 * @return
	 */
	public Iterable<UserBean> fetchAllUsers(){
		return userRepository.findAll();
	}

	/**
	 * @param name
	 * @return
	 */
	public UserBean getUserOnName(String name){
		Iterable<UserBean> users = userRepository.findAll();
		for(UserBean user : users){
			if(user.getUserName().equals(name)){
				return user;
			}
		}
		//users.stream().filter(t -> t.getUserName().equals(name)).findFirst().get();
		return null;
				
		
	}

	/**
	 * @param userbean
	 */
	public void addUser(UserBean userbean) {
		userRepository.save(userbean);
	}

	public void deleteUserByName(String name) {
		Iterable<UserBean> users = userRepository.findAll();
		for(UserBean user : users){
			if(user.getUserName().equals(name)){
				userRepository.delete(user);
				break;
			}
		}
		
	}

	public void updateUser(UserBean userBean) {
		Iterable<UserBean> users = userRepository.findAll();
		for(UserBean user : users){
			if(user.getUserName().equals(userBean.getUserName())){
				user.setPassword(userBean.getPassword());
				userRepository.save(user);
			}
		}
		
	}
}
