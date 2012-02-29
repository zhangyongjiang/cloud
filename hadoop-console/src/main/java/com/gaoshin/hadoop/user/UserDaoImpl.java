package com.gaoshin.hadoop.user;

import org.springframework.stereotype.Repository;

import com.gaoshin.cloud.web.dao.HibernateBaseDao;

@Repository("userDao")
public class UserDaoImpl extends HibernateBaseDao implements UserDao {

}