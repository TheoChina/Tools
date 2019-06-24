package com.theo.export.service.impl;


import com.theo.export.bean.OBDExcelVO;
import com.theo.export.bean.Report;
import com.theo.export.dao.ExportExcelDao;
import com.theo.export.service.ExportExcelService;
import com.theo.export.utils.ExcelUtils;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Theo
 * @date 2019/6/24
 */
@Service
public class ExportExcelServiceImpl implements ExportExcelService {

    @Autowired
    ExportExcelDao exportExcelDao;

    @Override
    public List<Map<String,Object>> listOBDDailyFlow(Report report) {
        List<Map<String,Object>> list = exportExcelDao.searchAll();
        return list;
    }

    @Override
    public XSSFWorkbook exportOBDDailyList(List<Map<String, Object>> list, String sheetName) {
        List<OBDExcelVO> obdexcelVOList = new ArrayList<>(list.size());
        list.forEach(item ->{
            OBDExcelVO vo = new OBDExcelVO();
            try {
                BeanUtils.populate(vo,item);
                obdexcelVOList.add(vo);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        ExcelUtils<OBDExcelVO> util = new ExcelUtils<>(OBDExcelVO.class);
        XSSFWorkbook workbook = util.exportExcel(obdexcelVOList,sheetName);
        return workbook;
    }

}
