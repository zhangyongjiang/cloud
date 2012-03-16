package com.gaoshin.configuration;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gaoshin.cloud.web.bean.BusinessException;
import com.gaoshin.cloud.web.bean.ServiceError;
import common.util.reflection.ReflectionUtil;

@Service("confService")
@Transactional
public class ConfServiceImpl implements ConfService {
    @Autowired
    private ConfDao confDao;

    @Override
    public Configuration set(String key, String value) {
        ConfigurationEntity entity = confDao.getUniqueResult(ConfigurationEntity.class, "name", key);
        if(entity == null) {
            entity = new ConfigurationEntity();
            entity.setName(key);
            entity.setValue(value);
            confDao.saveEntity(entity);
        }
        else {
            entity.setName(key);
            entity.setValue(value);
            confDao.merge(entity);
        }
        return ReflectionUtil.copy(Configuration.class, entity);
    }

    @Override
    public Configuration getByKey(String key) {
        ConfigurationEntity entity = confDao.getUniqueResult(ConfigurationEntity.class, "name", key);
        if(entity == null) {
            return null;
        }
        
        return ReflectionUtil.copy(Configuration.class, entity);
    }

    @Override
    public List<Configuration> list() {
        List<ConfigurationEntity> entities = confDao.find("from ConfigurationEntity");
        List<Configuration> beans = new ArrayList<Configuration>();
        for(ConfigurationEntity entity : entities) {
            beans.add(ReflectionUtil.copy(Configuration.class, entity));
        }
        return beans;
    }

    @Override
    public void remove(String confid) {
        ConfigurationEntity entity = confDao.getEntity(ConfigurationEntity.class, confid);
        if(entity == null) 
            throw new BusinessException(ServiceError.NotFound);
        confDao.deleteEntity(entity);
    }

    @Override
    public Configuration get(String confid) {
        ConfigurationEntity entity = confDao.getEntity(ConfigurationEntity.class, confid);
        if(entity == null) 
            throw new BusinessException(ServiceError.NotFound);
        return ReflectionUtil.copy(Configuration.class, entity);
    }

    @Override
    public Configuration set(Configuration conf) {
        return set(conf.getName(), conf.getValue());
    }

}
