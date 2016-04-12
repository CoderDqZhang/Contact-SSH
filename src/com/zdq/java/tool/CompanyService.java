package com.zdq.java.tool;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.derby.impl.sql.compile.ConcatenationOperatorNode;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import sun.tools.tree.ThisExpression;

import com.zdq.dao.BaseDao;
import com.zdq.model.Company;
import com.zdq.model.CompanyId;
import com.zdq.model.User;

public class CompanyService extends BaseDao {
	
	/** 总行数 */  
	  
    private int totalRows = 0;  
  
    /** 总列数 */  
  
    private int totalCells = 0;  
  
    /** 错误信息 */  
  
    private String errorInfo;  
	
	/**
     * 查询stu表中所有的数据
     * @return 
     */
//    public static List<Company> getAllByDb() throws Exception{
//    	List<User> list = super.search("select * from Company");
//        return list;
//    }
    
    public int getTotalRows() {
		return totalRows;
	}

	public void setTotalRows(int totalRows) {
		this.totalRows = totalRows;
	}

	public int getTotalCells() {
		return totalCells;
	}

	public void setTotalCells(int totalCells) {
		this.totalCells = totalCells;
	}

	public String getErrorInfo() {
		return errorInfo;
	}

	public void setErrorInfo(String errorInfo) {
		this.errorInfo = errorInfo;
	}

	/**
     * 查询指定目录中电子表格中所有的数据
     * @param file 文件完整路径
     * @return
     */
    public static List<Company> getAllByExcel(String file) throws Exception{
        List<Company> list=new ArrayList<Company>();
        POIFSFileSystem fs=new POIFSFileSystem(new FileInputStream(file));   
        //得到Excel工作簿对象 
        /** 根据版本选择创建Workbook的方式 */  
        Workbook wb = null;
        try {
        	wb = new HSSFWorkbook(fs);
		} catch (Exception e) {
			// TODO: handle exception
			wb = new HSSFWorkbook(fs);
		} 
        CompanyService companyService = new CompanyService();
        //得到Excel工作表对象   
        list = companyService.read(wb);    
        return list;
        
    } 
  
    /** 
     *  
     * @描述：读取数据 
     *  
     * @参数：@param Workbook 
     *  
     * @参数：@return 
     *  
     * @返回值：List<List<String>> 
     */  
  
    public List<Company> read(Workbook wb)  
    {  
  
        List<Company> dataLst = new ArrayList<Company>();  
  
        /** 得到第一个shell */  
  
        Sheet sheet = wb.getSheetAt(0);  
        /** 得到Excel的行数 */  
  
        this.totalRows = sheet.getPhysicalNumberOfRows();  
  
        /** 得到Excel的列数 */  
  
        if (this.totalRows >= 1 && sheet.getRow(0) != null)  
        {  
  
            this.totalCells = sheet.getRow(0).getPhysicalNumberOfCells();  
  
        }  
  
        /** 循环Excel的行 */  
  
        for (int r = 1; r < this.totalRows; r++)  
        {  
  
            Row row = sheet.getRow(r);  
  
            if (row == null)  
            {  
  
                continue;  
  
            }  
  
            Company company= new Company();  
            CompanyId companyId = new CompanyId();
            /** 循环Excel的列 */  
  
            for (int c = 0; c < this.getTotalCells(); c++)  
            {  
  
                Cell cell = row.getCell(c);  
  
                String cellValue = "";  
  
                if (null != cell)  
                {  
                    // 以下是判断数据的类型  
                    switch (cell.getCellType())  
                    {  
                    
                    case HSSFCell.CELL_TYPE_NUMERIC: // 数字  
                        cellValue = cell.getNumericCellValue() + "";  
                        break;  
  
                    case HSSFCell.CELL_TYPE_STRING: // 字符串  
                        cellValue = cell.getStringCellValue();
                        try {
							String newStr = new String(cellValue.getBytes(), "UTF-8");
//							System.out.print(newStr);
						} catch (UnsupportedEncodingException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}  
                        break;
  
                    case HSSFCell.CELL_TYPE_BOOLEAN: // Boolean  
                        cellValue = cell.getBooleanCellValue() + "";  
                        break;  
  
                    case HSSFCell.CELL_TYPE_FORMULA: // 公式  
                        cellValue = cell.getCellFormula() + "";  
                        break;  
  
                    case HSSFCell.CELL_TYPE_BLANK: // 空值  
                        cellValue = "";  
                        break;  
  
                    case HSSFCell.CELL_TYPE_ERROR: // 故障  
                        cellValue = "非法字符";  
                        break;  
  
                    default:  
                        cellValue = "未知类型";  
                        break;  
                    }  
                }
                switch (c) {
				case 0:
					companyId.setUsername(cellValue.toString());
					break;
				case 1:
					companyId.setPhone(cellValue.toString());	
					break;
				case 2:
					companyId.setHome(cellValue.toString());	
					break;
				case 3:
					companyId.setDepartment(cellValue.toString());	
					break;
				case 4:
					companyId.setPosition(cellValue.toString());	
					break;
				case 5:
					companyId.setEmail(cellValue.toString());	
					break;
				case 6:
					companyId.setQq(cellValue.toString());	
					break;
				case 7:
					companyId.setAge(Integer.parseInt(cellValue.toString()));	
					break;
				case 8:
					companyId.setCompany(cellValue.toString());	
					break;
				default:
					break;
				} 
            }
            company.setId(companyId);
            /** 保存第r行的第c列 */  
            dataLst.add(company);
        }  
        return dataLst; 
    }  
}
