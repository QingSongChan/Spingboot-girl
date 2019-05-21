package com.poni.domain;
/*
 *@author:PONI_CHAN
 *@date:2018/9/2022:36
 */

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity   //表示对应数据库的一个表
public class Girl {

    @Id
    @GeneratedValue    //id自增
    private Integer id;

    private String cupSize;

    @Min(value=18,message = "未成年少女不得添加！")
    private Integer age;

    @NotNull(message = "身高必须传入！")
    private  Integer height;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCupSize() {
        return cupSize;
    }

    public void setCupSize(String cupSize) {
        this.cupSize = cupSize;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Girl() {
    }

    @Override
    public String toString() {
        return "Girl{" +
                "id=" + id +
                ", cupSize='" + cupSize + '\'' +
                ", age=" + age +
                ", height=" + height +
                '}';
    }
}
