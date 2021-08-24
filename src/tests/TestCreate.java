package tests;

import dtos.TestBeanBase;
import dtos.TestCreateDTO;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import pages.GeoEditorPage;

import java.util.Iterator;

public class TestCreate extends BaseTest {

    @Override
    @Test(dataProvider = "testCreate")
    protected void test(TestBeanBase dto) {
        TestCreateDTO tcDto = (TestCreateDTO) dto;
        new GeoEditorPage().draw(tcDto);
    }

    @DataProvider(name = "testCreate")
    public Iterator<Object[]> dataProvider() {
        return super.getDataProvider();
    }


    @Override
    protected TestBeanBase getTestBeanBase() {
        return new TestCreateDTO();
    }
}
