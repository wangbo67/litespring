package com.dcoder.context.support;

import com.dcoder.beans.factory.support.DefaultBeanFactory;
import com.dcoder.beans.factory.xml.XmlBeanDefinitionReader;
import com.dcoder.context.ApplicationContext;
import com.dcoder.core.io.ClassPathResource;
import com.dcoder.core.io.Resource;

public class ClassPathXmlApplicationContext implements ApplicationContext {
    private DefaultBeanFactory factory = null;

    public ClassPathXmlApplicationContext(String configFile) {
        factory = new DefaultBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
        Resource resource = new ClassPathResource(configFile);
        reader.loadBeanDefinitions(resource);
    }

    @Override
    public Object getBean(String beanId) {
        return factory.getBean(beanId);
    }
}
