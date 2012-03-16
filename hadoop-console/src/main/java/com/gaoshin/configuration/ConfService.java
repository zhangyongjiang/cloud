package com.gaoshin.configuration;

import java.util.List;


public interface ConfService {
    Configuration set(String key, String value);
    Configuration getByKey(String key);
    List<Configuration> list();
    void remove(String confid);
    Configuration get(String confid);
    Configuration set(Configuration conf);
}
