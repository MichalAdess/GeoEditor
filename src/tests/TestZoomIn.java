package tests;

import dtos.TestBeanBase;
import dtos.TestCreateDTO;
import dtos.TestEditDTO;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.GeoEditorPage;

import java.util.Iterator;

public class TestZoomIn extends BaseTest {

    @Test
    public void testZoomIn() {
        GeoEditorPage geoEditorPage = new GeoEditorPage();
        geoEditorPage.zoomIn();
    }

}
