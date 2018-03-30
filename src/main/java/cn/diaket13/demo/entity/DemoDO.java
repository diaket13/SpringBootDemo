package cn.diaket13.demo.entity;

import cn.diaket13.demo.enums.DemoTypeEnum;

public class DemoDO {
    private Integer id;
    private String name;
    private Integer attack;
    private DemoTypeEnum type;
    private String description;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAttack() {
        return attack;
    }

    public void setAttack(Integer attack) {
        this.attack = attack;
    }

    public DemoTypeEnum getType() {
        return type;
    }

    public void setType(DemoTypeEnum type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
