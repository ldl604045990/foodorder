package com.foodorder.inter.user.bean;

import java.io.Serializable;
import java.util.Date;

public class OrderMenu implements Serializable {

    private static final long serialVersionUID = -1334878271697444665L;
    /**
     * 主键ID
     */
    private Integer id;

    /**
     * 菜单级别(1,2级菜单)
     */
    private Integer menuLevel;

    /**
     * 菜单父类ID
     */
    private Integer menuPid;

    /**
     * 菜单名称
     */
    private String menu;

    /**
     * 用户ID
     */
    private Integer userId;

    /**
     * 店铺ID
     */
    private Integer shopId;

    /**
     * 创建时间
     */
    private Date createDate;

    /**
     * 是否删除 （0：正常 1：删除）
     */
    private Integer deleteFlag;

    /**
     * 创建者
     */
    private Integer createBy;

    /**
     * 更新时间
     */
    private Date updateDate;

    /**
     * 更新者
     */
    private Integer updateBy;

    /**
     * 主键ID
     * @return id 主键ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * 主键ID
     * @param id 主键ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 菜单级别(1,2级菜单)
     * @return menu_level 菜单级别(1,2级菜单)
     */
    public Integer getMenuLevel() {
        return menuLevel;
    }

    /**
     * 菜单级别(1,2级菜单)
     * @param menuLevel 菜单级别(1,2级菜单)
     */
    public void setMenuLevel(Integer menuLevel) {
        this.menuLevel = menuLevel;
    }

    /**
     * 菜单父类ID
     * @return menu_pid 菜单父类ID
     */
    public Integer getMenuPid() {
        return menuPid;
    }

    /**
     * 菜单父类ID
     * @param menuPid 菜单父类ID
     */
    public void setMenuPid(Integer menuPid) {
        this.menuPid = menuPid;
    }

    /**
     * 菜单名称
     * @return menu 菜单名称
     */
    public String getMenu() {
        return menu;
    }

    /**
     * 菜单名称
     * @param menu 菜单名称
     */
    public void setMenu(String menu) {
        this.menu = menu == null ? null : menu.trim();
    }

    /**
     * 用户ID
     * @return user_id 用户ID
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 用户ID
     * @param userId 用户ID
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 店铺ID
     * @return shop_id 店铺ID
     */
    public Integer getShopId() {
        return shopId;
    }

    /**
     * 店铺ID
     * @param shopId 店铺ID
     */
    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    /**
     * 创建时间
     * @return create_date 创建时间
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * 创建时间
     * @param createDate 创建时间
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 是否删除 （0：正常 1：删除）
     * @return delete_flag 是否删除 （0：正常 1：删除）
     */
    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    /**
     * 是否删除 （0：正常 1：删除）
     * @param deleteFlag 是否删除 （0：正常 1：删除）
     */
    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    /**
     * 创建者
     * @return create_by 创建者
     */
    public Integer getCreateBy() {
        return createBy;
    }

    /**
     * 创建者
     * @param createBy 创建者
     */
    public void setCreateBy(Integer createBy) {
        this.createBy = createBy;
    }

    /**
     * 更新时间
     * @return update_date 更新时间
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * 更新时间
     * @param updateDate 更新时间
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * 更新者
     * @return update_by 更新者
     */
    public Integer getUpdateBy() {
        return updateBy;
    }

    /**
     * 更新者
     * @param updateBy 更新者
     */
    public void setUpdateBy(Integer updateBy) {
        this.updateBy = updateBy;
    }
}