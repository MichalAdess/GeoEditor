package dtos;

import java.util.Arrays;
import java.util.List;

public class TestCreateDTO extends TestBeanBase{

    private String shape;
    private String xPx;
    private String yPx;
//    private String order;
    private String count;

    public String getCount() {
        return count;
    }

    public String getShape() {
        return shape;
    }

    public List<String> getXPx() {
        return Arrays.asList(xPx.split(";"));
    }

    public List<String> getYPx() {
        return Arrays.asList(yPx.split(";"));
    }

    public void setShape(String shape) {
        this.shape = shape;
    }

    public void setxPx(String xPx) {
        this.xPx = xPx;
    }

    public void setyPx(String yPx) {
        this.yPx = yPx;
    }

    public void setCount(String count) {
        this.count = count;
    }
}
