package infra.ui;

import infra.Browser;

public class InputWE extends BaseWE {

    public InputWE(String description, BaseWE.LocateBy selectBy, String selector) {
        super(description, selectBy, selector);
    }

    public void sendKeys(String value) {
        this.doIt("type", value);
    }

    @Override
    protected void act(Object value) {
        String val = (String) value;
        this.findElement().sendKeys(val);
    }
}
