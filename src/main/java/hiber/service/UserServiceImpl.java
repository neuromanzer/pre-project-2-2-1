package hiber.service;

import hiber.dao.UserDao;
import hiber.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

   @Autowired
   private UserDao userDao;

   @Transactional
   @Override
   public void add(User user) {
      userDao.add(user);
   }


   @Override
   public List<User> listUsers() {
      return userDao.listUsers();
   }

   @Override
   public User getByCarNumberAndCarSeries(String name, int series) {
      return userDao.getByCarNumberAndCarSeries(name, series);
   }

}
