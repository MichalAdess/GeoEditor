package infra.ui;

import dtos.TestCreateDTO;
import dtos.TestEditDTO;
import infra.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.util.List;
import java.util.function.Function;

public class EditToolBarWE extends BaseWE {

    SimpleWE map = new SimpleWE("map", LocateBy.ID, "map");
    SimpleWE path = new SimpleWE("path", LocateBy.ClassName, "leaflet-interactive");

    public EditToolBarWE(String description, LocateBy selectBy, String selector) {
        super(description, selectBy, selector);
    }


    public void drag(TestEditDTO dto) {
        this.action = 1;
        this.doIt("drag", dto);
    }

    public void edit(TestEditDTO dto) {
        this.action = 2;
        this.doIt("edit", dto);
    }

    public void cut(TestEditDTO dto) {
        this.action = 3;
        this.doIt("cut", dto);
    }

    public void delete(TestEditDTO dto) {
        this.action = 4;
        this.doIt("delete", dto);
    }

    @Override
    protected void act(Object value) {
        TestEditDTO dto;
        WebElement mapWe = map.findElement();
        Actions actions = new Actions(Browser.driver());
        WebElement pathWe;
        int xOffset;
        int yOffset;
        switch (this.action) {
            case 1:
                dto = (TestEditDTO) value;
                this.getWe().findElement(By.className("leaflet-pm-icon-drag")).click();
                xOffset = Integer.parseInt(dto.getXPx().get(0));
                yOffset = Integer.parseInt(dto.getYPx().get(0));
                pathWe = path.findElement();
                actions.moveToElement(pathWe).clickAndHold().moveToElement(pathWe, xOffset, yOffset).release().perform();
                System.out.println("drag to:= " + xOffset + "," + yOffset);
                break;
            case 2:
                dto = (TestEditDTO) value;
                pathWe = path.findElement();
                String style = "translate3d(" + pathWe.getRect().getX() + "px";
                this.getWe().findElement(By.className("leaflet-pm-icon-edit")).click();
                WebElement leftIcon = mapWe.findElement(By.cssSelector("[style*='" + style + "']"));
                try {
                    WebElement cb = Browser.driver().findElement(By.className("cookie-banner"));
                    Robot robot = new Robot();
                    robot.mouseMove(mapWe.getSize().getWidth() / 2, mapWe.getSize().getHeight() / 2 + cb.getSize().getHeight() + mapWe.getLocation().getY());
                    xOffset = Integer.parseInt(dto.getXPx().get(0));
                    yOffset = Integer.parseInt(dto.getYPx().get(0));
                    actions.clickAndHold(leftIcon).moveToElement(mapWe, xOffset, yOffset).release().build().perform();
                    System.out.println("edit to:= " + xOffset + "," + yOffset);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case 3:
                dto = (TestEditDTO) value;
                this.getWe().findElement(By.className("leaflet-pm-icon-cut")).click();
                actions.moveToElement(mapWe).click().perform();
                int previousX = 0, previousY = 0;
                for (int i = 0; i < dto.getXPx().size(); i++) {
                    previousX = previousX + Integer.parseInt(dto.getXPx().get(i));
                    previousY = previousY + Integer.parseInt(dto.getYPx().get(i));
                    if (i % 2 > 0) {
                        if (i == dto.getXPx().size() - 1) {
                            previousX = 0;
                            previousY = 0;
                        }
                        actions.moveToElement(mapWe, previousX, previousY).click().perform();
                        System.out.println("cut to:= " + previousX + "," + previousY);
                    }
                }
                break;
            case 4:
                pathWe = path.findElement();
                this.getWe().findElement(By.className("leaflet-pm-icon-delete")).click();
                actions.moveToElement(pathWe).click().perform();
                System.out.println("circle was deleted");
                break;
        }

    }

}
