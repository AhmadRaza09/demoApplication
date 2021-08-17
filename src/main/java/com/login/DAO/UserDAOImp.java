package com.login.DAO;

import com.login.model.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;


import javax.transaction.Transactional;
import java.util.Iterator;
import java.util.List;


@Repository("userDao")

public class UserDAOImp implements com.login.DAO.UserDAO {
    @Autowired
    HibernateTemplate hibernateTemplate;
    @Autowired
    SessionFactory factory;



    @Override
    @Transactional
    public int add(User user) {
        Integer i = (Integer) this.hibernateTemplate.save(user);
        return  i;
    }

    @Override
    @Transactional
    public User getUserById(int id)
    {
        return this.hibernateTemplate.get(User.class, id);
    }

    @Override
    @Transactional
    public User getUserByEmail(String email) {

//        get the id of the user
        Session s = factory.openSession();
        String query = "SELECT u.id from User as u INNER JOIN u.account e WHERE e.email=:mail";

        Query q = s.createQuery(query);
        q.setParameter("mail", email);
        List<Object []> list = q.getResultList();
        int id = (Integer)((Object) list.get(0));
        s.close();



//        get the user
        User user = getUserById(id);



        return user;

    }

    @Override
    @Transactional
    public Long getCount(int status) {

//        get the id of the user
        Session s = factory.openSession();
        Query q;
        if(status != 0)
        {
            String query = "select count(status) from User where status=:status";

            q = s.createQuery(query);
            q.setParameter("status", status);
        }
        else
        {
            String query = "select count(status) from User";

            q = s.createQuery(query);

        }
        Iterator i = q.iterate();
        Long count = (Long) i.next();
        s.close();

        return count;

    }




    @Override
    @Transactional
    public List<User> getAllUser()
    {
       return this.hibernateTemplate.loadAll(User.class);

    }

    @Override
    @Transactional
    public void updateUser(User user)
    {
        this.hibernateTemplate.update(user);
    }



}
