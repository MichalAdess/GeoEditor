package infra.ui;

import infra.exceptions.AutoRuntimeException;

public class CheckBoxWE extends BaseWE {

    public CheckBoxWE(String description, LocateBy selectBy, String selector) {
        super(description, selectBy, selector);
    }

    private CheckBoxWE check(Boolean value) {
        this.doIt("check", value);
        return this;
    }

    private CheckBoxWE uncheck(Boolean value) {
        this.doIt("uncheck", value);
        return this;
    }

    public CheckBoxWE toggle(Boolean toCheck) {
        if (toCheck) {
            return check(toCheck);
        }
        return uncheck(toCheck);
    }

    public boolean isSelected() {
        try {
            return this.findElement().isSelected();
        } catch (Throwable t) {
            t.printStackTrace();
            throw t;
        }
    }

    @Override
    protected void act(Object value) {

        boolean val = Boolean.parseBoolean(String.valueOf(value));
        if (this.isSelected() != val) {
            this.getWe().click();
        }
    }
}
