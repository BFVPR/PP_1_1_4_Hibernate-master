package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class UserDaoHibernateImpl implements UserDao {
    private static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS User (id BIGINT PRIMARY KEY AUTO_INCREMENT, name VARCHAR(30), last_name VARCHAR(30), age TINYINT)";
    private static final String DROP_TABLE = "DROP TABLE User";

    public UserDaoHibernateImpl() {

    }


    @Override
    public void createUsersTable() {
        try (SessionFactory factory = new Configuration().configure().addAnnotatedClass(User.class).buildSessionFactory();
             Session session = factory.getCurrentSession();) {
            session.beginTransaction();
            session.createSQLQuery(CREATE_TABLE).addEntity(User.class);
            session.getTransaction().commit();
        }
    }

    @Override
    public void dropUsersTable() {
        try (SessionFactory factory = new Configuration().configure().addAnnotatedClass(User.class).buildSessionFactory();
             Session session = factory.getCurrentSession();) {
            session.beginTransaction();
            session.createSQLQuery(DROP_TABLE).addEntity(User.class);
            session.getTransaction().commit();
        }
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        try (SessionFactory factory = new Configuration().configure().addAnnotatedClass(User.class).buildSessionFactory();
             Session session = factory.getCurrentSession();) {
            User user = new User(name, lastName, age);
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
        }
    }

    @Override
    public void removeUserById(long id) {
        try (SessionFactory factory = new Configuration().configure().addAnnotatedClass(User.class).buildSessionFactory();
             Session session = factory.getCurrentSession();) {
            session.beginTransaction();
            User user = session.get(User.class, id);
            session.delete(user);
            session.save(user);
            session.getTransaction().commit();
        }
    }

    @Override
    public List<User> getAllUsers() {
        try (SessionFactory factory = new Configuration().configure().addAnnotatedClass(User.class).buildSessionFactory();
             Session session = factory.getCurrentSession();) {
            session.beginTransaction();
            List<User> list = session.createQuery("from User").getResultList();
            for (User user : list) {
                list.add(user);
            }
            session.getTransaction().commit();
            return list;
        }

    }

    @Override
    public void cleanUsersTable() {
        try (SessionFactory factory = new Configuration().configure().addAnnotatedClass(User.class).buildSessionFactory();
             Session session = factory.getCurrentSession();) {
            session.beginTransaction();
            session.createQuery("delete User");
            session.getTransaction().commit();
        }
    }
}
