package com.gaoshin.configuration;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public Configuration get(String key) {
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

}
