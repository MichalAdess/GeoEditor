package infra.ui;

import dtos.TestCreateDTO;
import infra.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class DrawToolBarWE extends BaseWE {

    SimpleWE map = new SimpleWE("map", LocateBy.ID, "map");


    public DrawToolBarWE(String description, LocateBy selectBy, String selector) {
        super(description, selectBy, selector);
    }

    public void drawCircle(TestCreateDTO dto) {
        this.action = 1;
        this.doIt("draw circle", dto);
    }

    public void drawPolyline(TestCreateDTO dto) {
        this.action = 2;
        this.doIt("draw polyline", dto);
    }

    public void drawPolygons(TestCreateDTO dto) {
        this.action = 3;
        this.doIt("draw polygons", dto);
    }

    @Override
    protected void act(Object value) {
        TestCreateDTO dto = (TestCreateDTO) value;
        WebElement mapWe = map.findElement();
        Actions actions = new Actions(Browser.driver());
        switch (this.action) {
            case 1:
                this.getWe().findElement(By.className("leaflet-pm-icon-circle")).click();
                mapWe.click();
                actions.moveToElement(mapWe, Integer.parseInt(dto.getXPx().get(0)), 0).click().perform();
                System.out.println("radius is: " + dto.getXPx().get(0));
                break;
            case 2:
                this.getWe().findElement(By.className("leaflet-pm-icon-polyline")).click();
                mapWe.click();
                int moveToX = Integer.parseInt(dto.getXPx().get(0));
                int moveToY = Integer.parseInt(dto.getYPx().get(0));
                actions.moveToElement(mapWe, moveToX, moveToY).doubleClick().perform();
                System.out.println("move to: " + moveToX + "," + moveToY);
                break;
            case 3:
                this.getWe().findElement(By.className("leaflet-pm-icon-polygon")).click();
                mapWe.click();
                int fromX = 0;
                int fromY = 0;
                int count = Integer.parseInt(dto.getCount());
                for (int i = 0; i < count; i++) {
                    if (i == count - 1) {
                        fromX = 0;
                        fromY = 0;
                    }
                    System.out.println("fromX:=" + fromX + " fromY:=" + fromY);
                    actions.moveToElement(mapWe, fromX + Integer.parseInt(dto.getXPx().get(i)), fromY + Integer.parseInt(dto.getYPx().get(i))).click().build().perform();
                    fromX = fromX + Integer.parseInt(dto.getXPx().get(i));
                    fromY = fromY + Integer.parseInt(dto.getYPx().get(i));
                    System.out.println("moved to X:=" + fromX + " moved to Y:=" + fromY);
                }
                System.out.println("polygons was created");
                break;
        }

    }
}
