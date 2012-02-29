package com.gaoshin.configuration;

import org.springframework.stereotype.Repository;

import com.gaoshin.cloud.web.dao.HibernateBaseDao;

@Repository("confDao")
public class ConfDaoImpl extends HibernateBaseDao implements ConfDao {

}