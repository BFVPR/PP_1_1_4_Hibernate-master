package jm.task.core.jdbc.service;
import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.util.List;

public class UserServiceImpl implements UserService {

    private final UserDao userDao = new UserDaoJDBCImpl();
//    private final UserDao userDao2 = new UserDaoHibernateImpl();

    public void createUsersTable() {
        userDao.createUsersTable();
//        userDao2.createUsersTable();
    }

    public void dropUsersTable() {
        userDao.dropUsersTable();
//        userDao2.dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) {
        userDao.saveUser(name, lastName, age);
//        userDao2.saveUser(name, lastName, age);
    }

    public void removeUserById(long id) {
        userDao.removeUserById(id);
//        userDao2.removeUserById(id);
    }

    public List<User> getAllUsers() {
        return userDao.getAllUsers();
//        return userDao2.getAllUsers();
    }

    public void cleanUsersTable() {
        userDao.cleanUsersTable();
//        userDao2.cleanUsersTable();
    }

}
