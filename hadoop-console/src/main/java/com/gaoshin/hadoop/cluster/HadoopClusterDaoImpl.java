package com.gaoshin.hadoop.cluster;

import org.springframework.stereotype.Repository;

import com.gaoshin.cloud.web.dao.HibernateBaseDao;

@Repository("hadoopClusterDao")
public class HadoopClusterDaoImpl extends HibernateBaseDao implements HadoopClusterDao {

}