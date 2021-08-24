package infra.ui;

import infra.Browser;
import infra.exceptions.AutoRuntimeException;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseWE {

    private String description;
    private LocateBy selectBy;
    private String selector;
    private WebElement we;
    protected int action=0;

    public BaseWE(String description, LocateBy selectBy, String selector) {
        this.description = description;
        this.selectBy = selectBy;
        this.selector = selector;
    }

    protected void doIt(String whatToDo, Object value) {
        try {
            System.out.println("going to: " + whatToDo + " value is " + value);
            this.findElement();
            this.act(value);
        } catch (StaleElementReferenceException e) {
//            this.findElement();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    protected WebElement findElement() {

        try {
            we = Browser.driver().findElement(by());
        } catch (StaleElementReferenceException e) {
            this.findElement();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }

        return we;
    }

    private By by() {
        By by = null;
        switch (selectBy) {
            case ID:
                by = By.id(this.selector);
                break;
            case ClassName:
                by = By.className(this.selector);
                break;
            case IDX:
                by = By.cssSelector("[id*='" + this.selector + "']");
                break;
            case XPATH:
                by = By.xpath(this.selector);
                break;
            case CSS:
                by = By.cssSelector(this.selector);
                break;
        }

        return by;
    }

    protected int count() {
        return Browser.driver().findElements(this.by()).size();

    }

    public void validateText(String exp) {
        String text = this.findElement().getText();
        boolean equals = text.equals(exp);
        String msg = equals ? "text validation is like expected" : "text should be: " + exp + " but actual is: " + text;
        System.out.println(msg);
    }

    protected abstract void act(Object value);

    public String getDescription() {
        return description;
    }

    public WebElement getWe() {
        return we;
    }

    public enum LocateBy {

        XPATH,
        CSS,
        ClassName,
        IDX,
        ID;


    }


}
