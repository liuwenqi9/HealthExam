package com.health.entity;

public class Menu {
    private Integer menuid;

    private Integer parentid;

    private Object menuname;

    private Object url;

    public Integer getMenuid() {
        return menuid;
    }

    public void setMenuid(Integer menuid) {
        this.menuid = menuid;
    }

    public Integer getParentid() {
        return parentid;
    }

    public void setParentid(Integer parentid) {
        this.parentid = parentid;
    }

    public Object getMenuname() {
        return menuname;
    }

    public void setMenuname(Object menuname) {
        this.menuname = menuname;
    }

    public Object getUrl() {
        return url;
    }

    public void setUrl(Object url) {
        this.url = url;
    }
}