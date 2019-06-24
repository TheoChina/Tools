package com.theo.export.service;


import com.theo.export.bean.Report;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.util.List;
import java.util.Map;

public interface ExportExcelService {

    List listOBDDailyFlow(Report report);

    XSSFWorkbook exportOBDDailyList(List<Map<String, Object>> list, String 列表);
}
