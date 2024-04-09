package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import org.hibernate.Transaction;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class UserDaoHibernateImpl implements UserDao {
    private final SessionFactory sessionFactory = Util.getSessionFactory();
    Transaction trans = null;

    public UserDaoHibernateImpl() {

    }

    @Override
    public void createUsersTable() {

        try (Session session = Util.getSessionFactory().openSession()) {
            trans = session.beginTransaction();
            session.createSQLQuery("CREATE TABLE IF EXISTS users (id BIGINT PRIMARY KEY " +
                            "AUTO_INCREMENT" +
                            ", name VARCHAR(45)" +
                            ", lastName VARCHAR(45)" +
                            ", age INT)")
                    .executeUpdate();
            trans.commit();
            trans.rollback();
        }
    }

    @Override
    public void dropUsersTable() {

        try (Session session = Util.getSessionFactory().openSession()) {
            trans = session.beginTransaction();
            session.createSQLQuery("DROP TABLE IF EXISTS users").executeUpdate();
            trans.commit();
            trans.rollback();
        }
    }

    @Override


    @Override
    public void removeUserById(long id) {

        try (Session session = Util.getSessionFactory().openSession()) {
            trans = session.beginTransaction();
            User user = session.get(User.class, id);
            if (user != null) {
                session.delete(user);
            }
            trans.commit();
            trans.rollback();
        }
    }

    @Override
    public List<User> getAllUsers() {
        return null;
        try (Session session = Util.getSessionFactory().openSession()) {
            return session.createQuery("from users").list();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    @Override
    public void cleanUsersTable() {

    }
}
