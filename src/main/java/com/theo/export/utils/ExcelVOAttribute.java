package com.theo.export.utils;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface ExcelVOAttribute {

    /**
     * 导出到excel中的名称
     *
     */
    String name();


    /**
     * 对应的列名
     *
     */
    String column() default "";




}
