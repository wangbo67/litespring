import com.dcoder.context.ApplicationContext;
import com.dcoder.context.support.ClassPathXmlApplicationContext;
import com.dcoder.context.support.FileSystemXmlApplicationContext;
import com.dcoder.service.v1.PetStoreService;
import org.junit.Assert;
import org.junit.Test;

public class ApplicationContextTest {
    @Test
    public void testGetBeanFromClassPathContext() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("petstore-v1.xml");
        PetStoreService petStore = (PetStoreService)ctx.getBean("petStore");
        Assert.assertNotNull(petStore);
    }

    @Test
    public void testGetBeanFromFileSystemContext(){
        //注意啊，这里仍然是hardcode了一个本地路径，这是不好的实践!! 如何处理，留作作业
		ApplicationContext ctx = new FileSystemXmlApplicationContext("/Users/wangbo/petstore-v1.xml");
		PetStoreService petStore = (PetStoreService)ctx.getBean("petStore");
		Assert.assertNotNull(petStore);

    }
}
