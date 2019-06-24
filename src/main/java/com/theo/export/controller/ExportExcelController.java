package com.theo.export.controller;

import com.theo.export.bean.Report;
import com.theo.export.service.ExportExcelService;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

/**
 * @author Theo
 * @date 2019/6/24
 */
@RestController
@RequestMapping("theo")
public class ExportExcelController {

    @Autowired
    ExportExcelService exportExcelService;

    /**
     * 导出excel
     * @param
     * @param
     * @return
     * @throws Exception
     * @author
     * 2019年6月24日
     */
    @PostMapping("/export")
    public void exportOBDDailyFlow(Report report, HttpServletResponse response) throws Exception{
        List<Map<String,Object>> list=exportExcelService.listOBDDailyFlow(report);
        XSSFWorkbook workbook =exportExcelService.exportOBDDailyList((List<Map<String, Object>>) list,"列表");
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode("列表.xlsx", "utf-8"));
        try(OutputStream outputStream = response.getOutputStream()){
            workbook.write(outputStream);
            outputStream.flush();
        }
    }
}
