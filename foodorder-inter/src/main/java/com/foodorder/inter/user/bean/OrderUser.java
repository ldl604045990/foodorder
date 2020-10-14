package com.foodorder.inter.user.bean;

import java.util.Date;

public class OrderUser {
    /**
     * 主键ID
     */
    private Integer id;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 用户密码
     */
    private String userPwd;

    /**
     * 用户号码
     */
    private String phone;

    /**
     * 用户类型(1:管理员 2:商户)
     */
    private Integer userType;

    /**
     * 创建时间
     */
    private Date createDate;

    /**
     * 商户ID
     */
    private Integer shopId;

    /**
     * 是否禁用  (0: 正常   1：禁用)
     */
    private Integer isDisable;

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
     * 用户名
     * @return user_name 用户名
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 用户名
     * @param userName 用户名
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * 用户密码
     * @return user_pwd 用户密码
     */
    public String getUserPwd() {
        return userPwd;
    }

    /**
     * 用户密码
     * @param userPwd 用户密码
     */
    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd == null ? null : userPwd.trim();
    }

    /**
     * 用户号码
     * @return phone 用户号码
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 用户号码
     * @param phone 用户号码
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * 用户类型(1:管理员 2:商户)
     * @return user_type 用户类型(1:管理员 2:商户)
     */
    public Integer getUserType() {
        return userType;
    }

    /**
     * 用户类型(1:管理员 2:商户)
     * @param userType 用户类型(1:管理员 2:商户)
     */
    public void setUserType(Integer userType) {
        this.userType = userType;
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
     * 商户ID
     * @return shop_id 商户ID
     */
    public Integer getShopId() {
        return shopId;
    }

    /**
     * 商户ID
     * @param shopId 商户ID
     */
    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    /**
     * 是否禁用  (0: 正常   1：禁用)
     * @return is_disable 是否禁用  (0: 正常   1：禁用)
     */
    public Integer getIsDisable() {
        return isDisable;
    }

    /**
     * 是否禁用  (0: 正常   1：禁用)
     * @param isDisable 是否禁用  (0: 正常   1：禁用)
     */
    public void setIsDisable(Integer isDisable) {
        this.isDisable = isDisable;
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