package com.dcoder.context.support;

import com.dcoder.beans.factory.support.DefaultBeanFactory;
import com.dcoder.beans.factory.xml.XmlBeanDefinitionReader;
import com.dcoder.context.ApplicationContext;
import com.dcoder.core.io.Resource;

public abstract class AbstractApplicationContext implements ApplicationContext {
    private DefaultBeanFactory factory = null;

    public AbstractApplicationContext(String path) {
        factory = new DefaultBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
        Resource resource = getResourceByPath(path);
        reader.loadBeanDefinitions(resource);
    }

    protected abstract Resource getResourceByPath(String path);

    @Override
    public Object getBean(String beanId) {
        return this.factory.getBean(beanId);
    }
}
