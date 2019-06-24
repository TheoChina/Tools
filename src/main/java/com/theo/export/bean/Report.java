package com.theo.export.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Report implements Serializable {

    private static final long serialVersionUID = 1L;

    //车辆级别；1：标准型；2：舒适型；3：豪华型；4：商务型；5：尊贵型
    private Integer vehicle_type;

    //车辆所属部门ID
    private Integer struct_id;

    //查询开始日期；格式：yyyy-MM-dd
    private String report_sdate;

    //查询结束日期；格式：yyyy-MM-dd
    private String report_edate;

    //当前页码；不传为1
    private Integer page_no;

    //每页显示记录数；不传默认为10
    private Integer page_size;

    //排序字段编号；1：油费；2：有效油费；3：空驶油费；4：里程；5：有效里程；6：空驶里程；7：油耗；8：有效油耗；9：空驶油耗；
    private Integer sort_code;

    //排序类型；1：从低到高；4：从高到低
    private Integer asc_or_desc;

    //企业id
    private Integer company_id;


}
