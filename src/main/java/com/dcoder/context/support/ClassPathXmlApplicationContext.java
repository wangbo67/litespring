package com.dcoder.context.support;

import com.dcoder.beans.factory.support.DefaultBeanFactory;
import com.dcoder.beans.factory.xml.XmlBeanDefinitionReader;
import com.dcoder.context.ApplicationContext;

public class ClassPathXmlApplicationContext implements ApplicationContext {
    private DefaultBeanFactory factory = null;

    public ClassPathXmlApplicationContext(String configFile) {
        factory = new DefaultBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
        reader.loadBeanDefinitions(configFile);
    }

    @Override
    public Object getBean(String beanId) {
        return factory.getBean(beanId);
    }
}
