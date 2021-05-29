package hakandizdar.hrms.business.concretes;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import hakandizdar.hrms.business.abstracts.UserService;
import hakandizdar.hrms.core.utilities.results.DataResult;
import hakandizdar.hrms.core.utilities.results.SuccessDataResult;
import hakandizdar.hrms.dataAccess.abstracts.UserDao;
import hakandizdar.hrms.entities.concretes.User;

@Service
public class UserManager implements UserService {

	private UserDao userDao;
	
	@Autowired
	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	@Override
	public DataResult<List<User>> getAll() {
		return new SuccessDataResult<List<User>>(this.userDao.findAll());
	}

	@Override
	public DataResult<User> getUserByEmail(String email) {
		return new SuccessDataResult<User>(this.userDao.getByEmail(email));
	}

	

}
