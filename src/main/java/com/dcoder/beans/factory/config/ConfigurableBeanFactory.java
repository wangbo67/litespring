package com.dcoder.beans.factory.config;

import com.dcoder.beans.factory.BeanFactory;

public interface ConfigurableBeanFactory extends BeanFactory {
    void setBeanClassLoader(ClassLoader beanClassLoader);
    ClassLoader getBeanClassLoader();
}
