package com.dcoder.beans.factory.xml;

import com.dcoder.beans.BeanDefinition;
import com.dcoder.beans.factory.BeanDefinitionStoreException;
import com.dcoder.beans.factory.support.BeanDefinitionRegistry;
import com.dcoder.beans.factory.support.GenericBeanDefinition;
import com.dcoder.core.io.Resource;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

public class XmlBeanDefinitionReader {
    private BeanDefinitionRegistry registry;

    public static final String ID_ATTRIBUTE = "id";

    public static final String CLASS_ATTRIBUTE = "class";

    public static final String SCOPE_ATTRIBUTE = "scope";

    public XmlBeanDefinitionReader(BeanDefinitionRegistry registry) {
        this.registry = registry;
    }

    public void loadBeanDefinitions(Resource resource) {
        InputStream is = null;
        try {
            is = resource.getInputStream();
            SAXReader reader = new SAXReader();
            Document doc = reader.read(is);

            Element root = doc.getRootElement(); //<beans>
            Iterator<Element> iter = root.elementIterator();
            while (iter.hasNext()) {
                Element ele = (Element) iter.next();
                String id = ele.attributeValue(ID_ATTRIBUTE);
                String beanClassName = ele.attributeValue(CLASS_ATTRIBUTE);
                BeanDefinition bd = new GenericBeanDefinition(id, beanClassName);
                //获取xml文件中设置的scope值
                if(ele.attributeValue(SCOPE_ATTRIBUTE) != null) {
                    bd.setScope(ele.attributeValue(SCOPE_ATTRIBUTE));
                }
                this.registry.registerBeanDefinition(id, bd);
            }
        } catch (Exception e) {
            throw new BeanDefinitionStoreException("IOException parsing XML document from " + resource.getDescription(), e);
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
