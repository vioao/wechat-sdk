package com.github.vioao.wechat.bean.entity.component.wxa;

/**
 * 可填选的类目.
 *
 * @author vioao
 */
public class Category {
    private String firstClass;
    private String secondClass;
    private String thirdClass;
    private Integer firstId;
    private Integer secondId;
    private Integer thirdId;

    public String getFirstClass() {
        return firstClass;
    }

    public void setFirstClass(String firstClass) {
        this.firstClass = firstClass;
    }

    public String getSecondClass() {
        return secondClass;
    }

    public void setSecondClass(String secondClass) {
        this.secondClass = secondClass;
    }

    public String getThirdClass() {
        return thirdClass;
    }

    public void setThirdClass(String thirdClass) {
        this.thirdClass = thirdClass;
    }

    public Integer getFirstId() {
        return firstId;
    }

    public void setFirstId(Integer firstId) {
        this.firstId = firstId;
    }

    public Integer getSecondId() {
        return secondId;
    }

    public void setSecondId(Integer secondId) {
        this.secondId = secondId;
    }

    public Integer getThirdId() {
        return thirdId;
    }

    public void setThirdId(Integer thirdId) {
        this.thirdId = thirdId;
    }

    @Override
    public String toString() {
        return "Category{" +
                "firstClass='" + firstClass + '\'' +
                ", firstId=" + firstId +
                ", secondClass='" + secondClass + '\'' +
                ", secondId=" + secondId +
                ", thirdClass='" + thirdClass + '\'' +
                ", thirdId=" + thirdId +
                '}';
    }
}
