package dtos;

import infra.DataManager;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TestBeanBase {

    private final List<Map<String, String>> dto = new ArrayList<>();

    public List<TestBeanBase> setDTO() {

        List<Map<String, String>> testData = DataManager.getTestData();
        Class<?> clazz = null;
        List<TestBeanBase> lstDTO = new ArrayList<>();
        try {
            clazz = Class.forName(this.getClass().getName());
            for (int i = 0; i < testData.size(); i++) {
                TestBeanBase instance = (TestBeanBase) clazz.newInstance();
                Field[] declaredFields = this.getClass().getDeclaredFields();
                for (Field f : declaredFields) {
                    f.setAccessible(true);
                    try {
                        f.set(instance, testData.get(i).get(f.getName()));
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
                lstDTO.add(instance);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lstDTO;
    }


}
