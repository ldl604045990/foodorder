package com.foodorder.inter.user.bean;

import java.io.Serializable;
import java.util.Date;

public class OrderShop implements Serializable {

    private static final long serialVersionUID = 4911174143538223952L;
    /**
     *
     */
    private Integer id;

    /**
     * 用户ID
     */
    private Integer userId;

    /**
     * 联系电话
     */
    private String phone;

    /**
     * 店铺名称
     */
    private String shopName;

    /**
     * 店铺LOG
     */
    private String shopLog;

    /**
     * 创建日期
     */
    private Date createDate;

    /**
     * 是否删除（0：正常 1：删除）
     */
    private Integer deleteFlag;

    /**
     * 更新日期
     */
    private Date updateDate;

    /**
     * 更新人员ID
     */
    private Integer updateBy;

    /**
     * 创建人员ID
     */
    private Integer createBy;

    /**
     * 店铺地址
     */
    private String address;

    /**
     * 使用截止日期
     */
    private Date deadline;

    /**
     *
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
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
     * 联系电话
     * @return phone 联系电话
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 联系电话
     * @param phone 联系电话
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * 店铺名称
     * @return shop_name 店铺名称
     */
    public String getShopName() {
        return shopName;
    }

    /**
     * 店铺名称
     * @param shopName 店铺名称
     */
    public void setShopName(String shopName) {
        this.shopName = shopName == null ? null : shopName.trim();
    }

    /**
     * 店铺LOG
     * @return shop_log 店铺LOG
     */
    public String getShopLog() {
        return shopLog;
    }

    /**
     * 店铺LOG
     * @param shopLog 店铺LOG
     */
    public void setShopLog(String shopLog) {
        this.shopLog = shopLog == null ? null : shopLog.trim();
    }

    /**
     * 创建日期
     * @return create_date 创建日期
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * 创建日期
     * @param createDate 创建日期
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 是否删除（0：正常 1：删除）
     * @return delete_flag 是否删除（0：正常 1：删除）
     */
    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    /**
     * 是否删除（0：正常 1：删除）
     * @param deleteFlag 是否删除（0：正常 1：删除）
     */
    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    /**
     * 更新日期
     * @return update_date 更新日期
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * 更新日期
     * @param updateDate 更新日期
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * 更新人员ID
     * @return update_by 更新人员ID
     */
    public Integer getUpdateBy() {
        return updateBy;
    }

    /**
     * 更新人员ID
     * @param updateBy 更新人员ID
     */
    public void setUpdateBy(Integer updateBy) {
        this.updateBy = updateBy;
    }

    /**
     * 创建人员ID
     * @return create_by 创建人员ID
     */
    public Integer getCreateBy() {
        return createBy;
    }

    /**
     * 创建人员ID
     * @param createBy 创建人员ID
     */
    public void setCreateBy(Integer createBy) {
        this.createBy = createBy;
    }

    /**
     * 店铺地址
     * @return address 店铺地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 店铺地址
     * @param address 店铺地址
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * 使用截止日期
     * @return deadline 使用截止日期
     */
    public Date getDeadline() {
        return deadline;
    }

    /**
     * 使用截止日期
     * @param deadline 使用截止日期
     */
    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }
}