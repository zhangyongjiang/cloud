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
    public JobConf set(String key, String value) {
        JobConfEntity entity = confDao.getUniqueResult(JobConfEntity.class, "name", key);
        if(entity == null) {
            entity = new JobConfEntity();
            entity.setName(key);
            entity.setValue(value);
            confDao.saveEntity(entity);
        }
        else {
            entity.setName(key);
            entity.setValue(value);
            confDao.merge(entity);
        }
        return ReflectionUtil.copy(JobConf.class, entity);
    }

    @Override
    public JobConf getByKey(String key) {
        JobConfEntity entity = confDao.getUniqueResult(JobConfEntity.class, "name", key);
        if(entity == null) {
            return null;
        }
        
        return ReflectionUtil.copy(JobConf.class, entity);
    }

    @Override
    public List<JobConf> list() {
        List<JobConfEntity> entities = confDao.find("from " + JobConfEntity.class.getSimpleName() + " conf where conf.ownerId is null");
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
        return set(conf.getName(), conf.getValue());
    }

}
