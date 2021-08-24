package tests;

import dtos.TestBeanBase;
import infra.Browser;
import infra.ConfigManager;
import infra.DataManager;
import org.testng.annotations.*;

import java.util.*;

public abstract class BaseTest {

    private static ConfigManager configs = ConfigManager.configs();

    @BeforeClass
    public void beforeClass() {
        Browser.driver().get(configs.getProperty(ConfigManager.Props.APP_URL));
    }


    @Test
    protected void test(TestBeanBase dto) {

    }

    public Iterator<Object[]> getDataProvider() {
        DataManager.readCSV("resources\\tests\\" + this.getClass().getSimpleName() + ".csv");
        List<TestBeanBase> testBeans = this.getTestBeanBase().setDTO();
        List<Object[]> retVal = new ArrayList<>();
        for (TestBeanBase tb : testBeans) {
            retVal.add(new Object[]{tb});
        }
        return retVal.iterator();
    }


    protected  TestBeanBase getTestBeanBase(){
        return null;
    };

    @AfterMethod
    public void afterMethod() {
//        Browser.driver().close();
    }

    @AfterClass
    public void afterClass() {
        Browser.driver().close();
    }


}
