package com.gaoshin.configuration;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gaoshin.cloud.web.bean.BusinessException;
import com.gaoshin.cloud.web.bean.ServiceError;
import com.gaoshin.cloud.web.job.entity.JobConfEntity;
import com.gaoshin.job.bean.JobConf;
import common.util.reflection.ReflectionUtil;

@Service("confService")
@Transactional
public class ConfServiceImpl implements ConfService {
    @Autowired
    private ConfDao confDao;

    @Override
    public JobConf getByKey(String key) {
        JobConfEntity entity = confDao.getUniqueResult(JobConfEntity.class, "name", key);
        if(entity == null) {
            return null;
        }
        
        return ReflectionUtil.copy(JobConf.class, entity);
    }

    @Override
    public List<JobConf> list(String ownerId) {
        List<JobConfEntity> entities = null;
        if(ownerId == null)
            entities = confDao.find("from " + JobConfEntity.class.getSimpleName() + " conf");
        else
            entities = confDao.find("from " + JobConfEntity.class.getSimpleName() + " conf where conf.ownerId = ?", ownerId);
        List<JobConf> beans = new ArrayList<JobConf>();
        for(JobConfEntity entity : entities) {
            beans.add(ReflectionUtil.copy(JobConf.class, entity));
        }
        return beans;
    }

    @Override
    public void remove(String confid) {
        JobConfEntity entity = confDao.getEntity(JobConfEntity.class, confid);
        if(entity == null) 
            throw new BusinessException(ServiceError.NotFound);
        confDao.deleteEntity(entity);
    }

    @Override
    public JobConf get(String confid) {
        JobConfEntity entity = confDao.getEntity(JobConfEntity.class, confid);
        if(entity == null) 
            throw new BusinessException(ServiceError.NotFound);
        return ReflectionUtil.copy(JobConf.class, entity);
    }

    @Override
    public JobConf set(JobConf conf) {
        JobConfEntity entity = confDao.getUniqueResult(JobConfEntity.class, "name", conf.getName());
        if(entity == null) {
            entity = ReflectionUtil.copy(JobConfEntity.class, conf);
            confDao.saveEntity(entity);
            conf.setId(entity.getId());
        }
        else {
            entity = ReflectionUtil.copy(JobConfEntity.class, conf);
            confDao.merge(entity);
        }
        return conf;
    }

}
