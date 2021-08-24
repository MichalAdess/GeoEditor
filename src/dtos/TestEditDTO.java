package dtos;

import java.util.Arrays;
import java.util.List;

public class TestEditDTO extends TestBeanBase {

    private String xPx;
    private String yPx;

    public List<String> getXPx() {
        return Arrays.asList(xPx.split(";"));
    }

    public List<String> getYPx() {
        return Arrays.asList(yPx.split(";"));
    }
}
