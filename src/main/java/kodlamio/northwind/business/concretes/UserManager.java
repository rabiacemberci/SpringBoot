package kodlamio.northwind.business.concretes;

import kodlamio.northwind.business.abstracts.UserService;
import kodlamio.northwind.core.dataAccess.UserDao;
import kodlamio.northwind.core.entities.User;
import kodlamio.northwind.core.utilities.results.DataResult;
import kodlamio.northwind.core.utilities.results.Result;
import kodlamio.northwind.core.utilities.results.SuccessDataResult;
import kodlamio.northwind.core.utilities.results.SuccessResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserManager implements UserService {

    private UserDao userDao;

    @Autowired
    public UserManager(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public Result add(User user) {
        this.userDao.save(user);
        return new SuccessResult("Kullanıcı Eklendi");
    }

    @Override
    public DataResult<User> findByEmail(String email) {
        return new SuccessDataResult<User>(this.userDao.findByEmail(email),"Kullanıcı bulundu");
    }
}
