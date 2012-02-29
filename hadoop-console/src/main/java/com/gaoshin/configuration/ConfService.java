package com.gaoshin.configuration;

import java.util.List;


public interface ConfService {
    Configuration set(String key, String value);
    Configuration get(String key);
    List<Configuration> list();
}
