package kodlamio.northwind.business.abstracts;

import kodlamio.northwind.core.entities.User;
import kodlamio.northwind.core.utilities.results.DataResult;
import kodlamio.northwind.core.utilities.results.Result;


public interface UserService {
    Result add(User user);
    DataResult<User> findByEmail(String email);

}
