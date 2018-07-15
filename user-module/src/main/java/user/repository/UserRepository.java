package user.repository;
import org.springframework.data.repository.CrudRepository;

import user.beans.UserBean;

public interface UserRepository extends CrudRepository<UserBean, Long>{

}
