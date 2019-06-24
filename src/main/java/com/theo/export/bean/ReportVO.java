package com.theo.export.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @date 2019/6/20
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReportVO {

    //设备的SIM号
    private String sim_no;
    //当日油费
    private Integer day_oil_fee;
    //当日有效油费
    private Integer day_valid_oil_fee;
    //当日空驶油费
    private Integer day_empty_oil_fee;

    //当日行驶总里程
    private Integer day_mileage;
    //当日有效里程
    private Integer day_valid_mileage;
    //当日空驶里程
    private Integer day_empty_mileage;

    //当日油耗
    private Integer day_oil_consumption;
    //当日有效油耗
    private Integer day_valid_oil_consumption;
    //当日空驶油耗
    private Integer day_empty_oil_consumption;

    //设备号
    private String device_no;
    //车牌号
    private String vehicle_license;
    //车辆级别；1：标准型；2：舒适型；3：豪华型；4：商务型；5：尊贵型
    private Integer vehicle_type;
    //所属部门ID
    private String struct_id;
    //所属部门名称
    private String struct_name;




}
