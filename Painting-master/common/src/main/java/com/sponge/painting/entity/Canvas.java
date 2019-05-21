package com.sponge.painting.entity;

import java.util.Arrays;
import java.util.Date;

/**
 * 油画实体类
 */
public class Canvas {
    private Long id;
    private Long categoryId;
    private String name;
    private String creator;
    private byte[] smallImg;
    private Integer price;
    private String description;
    private String detail;
    private Date createTime;
    private Date updateTime;
    public Canvas()
    {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public byte[] getSmallImg() {
        return smallImg;
    }

    public void setSmallImg(byte[] smallImg) {
        this.smallImg = smallImg;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "Canvas{" +
                "id=" + id +
                ", categoryId=" + categoryId +
                ", name='" + name + '\'' +
                ", creator='" + creator + '\'' +
                ", smallImg=" + Arrays.toString(smallImg) +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", detail='" + detail + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
