package infra.ui;

import dtos.TestCreateDTO;
import dtos.TestEditDTO;
import infra.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ZoomToolBarWE extends BaseWE {

    public ZoomToolBarWE(String description, LocateBy selectBy, String selector) {
        super(description, selectBy, selector);
    }

    public void zoomIn() {
        this.action = 1;
        this.doIt("zoom in", null);
    }

    public void zoomOut() {
        this.action = 2;
        this.doIt("zoom out", null);
    }


    @Override
    protected void act(Object value) {
        switch (this.action) {
            case 1:
                WebElement zoomIn = this.getWe().findElement(By.className("leaflet-control-zoom-in"));
                zoomIn.click();
                clickTillDisabled(zoomIn);
                break;
            case 2:
                WebElement zoomOut = this.getWe().findElement(By.className("leaflet-control-zoom-out"));
                zoomOut.click();
                clickTillDisabled(zoomOut);
                break;
        }

    }

    private void clickTillDisabled(WebElement we) {
        int count = 40;
        while (!we.getAttribute("class").contains("disabled") && count > 0) {
            we.click();
            count--;
        }
        if(count==0){
            System.err.println("the button does not changed to disabled");
        }
        System.out.println("zoom in/out done");
    }
}
