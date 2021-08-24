package tests;

import dtos.TestBeanBase;
import dtos.TestCreateDTO;
import dtos.TestEditDTO;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.GeoEditorPage;

import java.util.Iterator;

public class TestCut extends BaseTest {


    @Override
    @Test(dataProvider = "testCut")
    protected void test(TestBeanBase dto) {
        TestEditDTO teDto = (TestEditDTO) dto;
        TestCreateDTO polygon = new TestCreateDTO();
        polygon.setShape("POLYGONS");
        polygon.setxPx("300;100;-50;-100;-300;0");
        polygon.setyPx("0;-100;-100;-100;100;0");
        polygon.setCount("6");
        GeoEditorPage geoEditorPage = new GeoEditorPage();
        geoEditorPage.draw(polygon);
        geoEditorPage.cut(teDto);
    }

    @DataProvider(name = "testCut")
    public Iterator<Object[]> dataProvider() {
        return super.getDataProvider();
    }


    @Override
    protected TestBeanBase getTestBeanBase() {
        return new TestEditDTO();
    }
}
