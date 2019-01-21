package com.qianfengsix.hotel.hotel.pojo;

import javax.validation.constraints.NotNull;

/**
 * Create by lcr on 2018/11/10 0010.
 */
public class Group {
    @NotNull(message = "团建id不能为空")
    private int group_id;
    @NotNull(message = "团建名称不能为空")
    private String group_name;
    @NotNull(message = "团建价格不能为空")
    private double group_price;
    @NotNull(message = "团建人数不能为空")
    private int group_personnum;
    @NotNull(message = "团建标签不能为空")
    private String group_type;
    private String group_image;

    public String getGroup_image() {
        return group_image;
    }

    public void setGroup_image(String group_image) {
        this.group_image = group_image;
    }

    public int getGroup_id() {
        return group_id;
    }

    public void setGroup_id(int group_id) {
        this.group_id = group_id;
    }

    public String getGroup_name() {
        return group_name;
    }

    public void setGroup_name(String group_name) {
        this.group_name = group_name;
    }

    public double getGroup_price() {
        return group_price;
    }

    public void setGroup_price(double group_price) {
        this.group_price = group_price;
    }

    public int getGroup_personnum() {
        return group_personnum;
    }

    public void setGroup_personnum(int group_personnum) {
        this.group_personnum = group_personnum;
    }

    public String getGroup_type() {
        return group_type;
    }

    public void setGroup_type(String group_type) {
        this.group_type = group_type;
    }

    @Override
    public String toString() {
        return "Group{" +
                "group_id=" + group_id +
                ", group_name='" + group_name + '\'' +
                ", group_price=" + group_price +
                ", group_personnum=" + group_personnum +
                ", group_type='" + group_type + '\'' +
                '}';
    }
}
