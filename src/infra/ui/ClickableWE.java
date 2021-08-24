package infra.ui;

public class ClickableWE extends BaseWE{

    public ClickableWE(String description, LocateBy selectBy, String selector) {
        super(description, selectBy, selector);
    }

    public void click(){
        this.doIt("click",null);
    }

    @Override
    protected void act(Object value) {
        this.findElement().click();
    }
}
