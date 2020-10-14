package com.foodorder.inter.user.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
public class OrderShopDto implements Serializable {


    private static final long serialVersionUID = 291731125546086978L;

    /**
     *
     */
    private Integer id;

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
     * 创建人
     */
    private Integer createBy;

    /**
     * 截止日期
     */
    private Date deadline;

    /**
     * 店铺地址
     */
    private String address;


}
