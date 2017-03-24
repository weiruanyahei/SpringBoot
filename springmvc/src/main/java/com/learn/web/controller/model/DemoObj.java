package com.learn.web.controller.model;

/**
 * Created by ldy on 2017/3/24.
 */
public class DemoObj {
    private Long id;
    private String name;
    public DemoObj(){//jackson对对象和json做转换时需要一个空构造器

    }

    public DemoObj(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
