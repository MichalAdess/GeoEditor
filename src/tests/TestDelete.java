package tests;

import dtos.TestBeanBase;
import dtos.TestCreateDTO;
import dtos.TestEditDTO;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.GeoEditorPage;

import java.util.Iterator;

public class TestDelete extends BaseTest {

    @Test
    protected void testDelete() {
        TestCreateDTO circle = new TestCreateDTO();
        circle.setShape("CIRCLE");
        circle.setxPx("150");
        GeoEditorPage geoEditorPage = new GeoEditorPage();
        geoEditorPage.draw(circle);
        geoEditorPage.delete();
    }


}
