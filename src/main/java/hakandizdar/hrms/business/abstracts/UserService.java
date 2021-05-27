package hakandizdar.hrms.business.abstracts;

import java.util.List;

import hakandizdar.hrms.core.utilities.results.DataResult;
import hakandizdar.hrms.entities.concretes.User;

public interface UserService {
	DataResult<List<User>> getAll();
	DataResult<User> getUserByEmail(String email);

}
