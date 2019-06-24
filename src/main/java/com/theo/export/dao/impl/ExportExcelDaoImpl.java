package com.theo.export.dao.impl;


import com.theo.export.dao.ExportExcelDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author Theo
 * @date 2019/6/24
 */
@Repository
public class ExportExcelDaoImpl implements ExportExcelDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Map<String,Object>> searchAll() {
        StringBuffer bf=new StringBuffer("select * from t_report_obd_daily_flow ");
        return jdbcTemplate.queryForList(bf.toString());
    }
}
