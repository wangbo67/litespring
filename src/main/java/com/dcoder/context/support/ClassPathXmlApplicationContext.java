package com.dcoder.context.support;

import com.dcoder.core.io.ClassPathResource;
import com.dcoder.core.io.Resource;

public class ClassPathXmlApplicationContext extends AbstractApplicationContext {

    public ClassPathXmlApplicationContext(String path) {
        super(path);
    }

    @Override
    protected Resource getResourceByPath(String path) {
        return new ClassPathResource(path);
    }
}
