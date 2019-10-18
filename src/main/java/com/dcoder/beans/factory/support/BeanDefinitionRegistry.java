package com.dcoder.beans.factory.support;

import com.dcoder.beans.BeanDefinition;

public interface BeanDefinitionRegistry {
    BeanDefinition getBeanDefinition(String beanID);
    void registerBeanDefinition(String beanID, BeanDefinition bd);
}