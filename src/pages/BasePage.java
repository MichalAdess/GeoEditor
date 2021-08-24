package pages;

import dtos.TestBeanBase;

public abstract class BasePage {


    public void fillPage(TestBeanBase testDTO){

        System.out.println("start to fill page: " + this.getClass().getSimpleName());
        this.assertTitle();
        this.fill(testDTO);
        this.pageAct();

    }

    protected void assertTitle(){
        System.out.println("Are you on the right page???");
    }

    protected void pageAct(){
    }

    protected void fill(TestBeanBase dto){
    }


}
