package tests;

import dtos.TestBeanBase;
import dtos.TestCreateDTO;
import dtos.TestEditDTO;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.GeoEditorPage;

import java.util.Iterator;

public class TestEdit extends BaseTest {


    @Override
    @Test(dataProvider = "testEdit")
    protected void test(TestBeanBase dto) {
        TestEditDTO teDto = (TestEditDTO) dto;
        TestCreateDTO polyline = new TestCreateDTO();
        polyline.setShape("POLYLINE");
        polyline.setxPx("100");
        polyline.setyPx("0");
        GeoEditorPage geoEditorPage = new GeoEditorPage();
        geoEditorPage.draw(polyline);
        geoEditorPage.edit(teDto);

    }

    @DataProvider(name = "testEdit")
    public Iterator<Object[]> dataProvider() {
        return super.getDataProvider();
    }


    @Override
    protected TestBeanBase getTestBeanBase() {
        return new TestEditDTO();
    }
}
