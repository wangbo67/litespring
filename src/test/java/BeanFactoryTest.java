import com.dcoder.beans.BeanDefinition;
import com.dcoder.beans.factory.BeanCreationException;
import com.dcoder.beans.factory.BeanDefinitionStoreException;
import com.dcoder.beans.factory.support.DefaultBeanFactory;
import com.dcoder.beans.factory.xml.XmlBeanDefinitionReader;
import com.dcoder.core.io.ClassPathResource;
import com.dcoder.service.v1.PetStoreService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BeanFactoryTest {
    DefaultBeanFactory factory = null;
    XmlBeanDefinitionReader reader = null;

    @Before
    public void setUp() {
        factory = new DefaultBeanFactory();
        reader = new XmlBeanDefinitionReader(factory);
    }

    @Test
    public void testGetBean() {
        reader.loadBeanDefinitions(new ClassPathResource("petstore-v1.xml"));
        BeanDefinition bd = factory.getBeanDefinition("petStore");

        assertTrue(bd.isSingleton());
        assertFalse(bd.isPrototype());
        assertEquals(BeanDefinition.SCOPE_DEFAULT,bd.getScope());

        assertEquals("com.dcoder.service.v1.PetStoreService", bd.getBeanCLassName());

        PetStoreService petStore = (PetStoreService) factory.getBean("petStore");
        assertNotNull(petStore);
    }

    @Test
    public void testInvalidBean() {
        reader.loadBeanDefinitions(new ClassPathResource("petstore-v1.xml"));
        try {
            factory.getBean("invalidBean");
        } catch (BeanCreationException e) {
            return;
        }

        Assert.fail("expect BeanCreationException");
    }

    @Test
    public void testInvalidXML() {
        try {
            reader.loadBeanDefinitions(new ClassPathResource("xxx.xml"));
        } catch (BeanDefinitionStoreException e) {
            return;
        }

        Assert.fail("expect BeanDefinitionStoreException");
    }
}
