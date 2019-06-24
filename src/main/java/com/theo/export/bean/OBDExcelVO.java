package com.theo.export.bean;

import com.theo.export.utils.ExcelVOAttribute;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OBDExcelVO {

    @ExcelVOAttribute(name = "车牌号")
    private String vehicle_license;
    @ExcelVOAttribute(name = "当日油费")
    private String day_oil_fee;
    @ExcelVOAttribute(name = "当日有效油费")
    private String day_valid_oil_fee;
    @ExcelVOAttribute(name = "当日空驶油费")
    private String day_empty_oil_fee;
    @ExcelVOAttribute(name = "当日行驶总里程")
    private String day_mileage;

    @ExcelVOAttribute(name = "当日有效里程")
    private String day_valid_mileage;
    @ExcelVOAttribute(name = "当日空驶里程 ")
    private String day_empty_mileage;
    @ExcelVOAttribute(name = "当日油耗")
    private String day_oil_consumption;
    @ExcelVOAttribute(name = "当日有效油耗")
    private String day_valid_oil_consumption;
    @ExcelVOAttribute(name = "当日空驶油耗")

    private String day_empty_oil_consumption;
    @ExcelVOAttribute(name = "创建时间")
    private String create_time;
    @ExcelVOAttribute(name = "部门名称")
    private String struct_name;

}
