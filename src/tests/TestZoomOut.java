package tests;

import org.testng.annotations.Test;
import pages.GeoEditorPage;

public class TestZoomOut extends BaseTest {

    @Test
    public void testZoomOut() {
        GeoEditorPage geoEditorPage = new GeoEditorPage();
        geoEditorPage.zoomOut();
    }



}
