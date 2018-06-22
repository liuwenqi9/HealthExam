package com.health.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.health.entity.Personinfo;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;





/**
 * 
 * @author JSY
 * @date 6月21日
 *	读取excel工具类
 */
public class ReadExcelFileUtil {
	
	
	
	
	
	/**
	 * 按行读取Excel表
	 * 
	 * @param path
	 * @throws IOException
	 */
	
	public static List<List<String>> readExcel(String path) {
		String fileType = path.substring(path.lastIndexOf(".") + 1);
		List<List<String>> tableList = new ArrayList<List<String>>();
		// 读取excel文件
		InputStream isputStream = null;
		try {
			isputStream= new FileInputStream(path);
			// 获取工作薄
			Workbook wb = null;
			if (fileType.equals("xls")) {
				wb = WorkbookFactory.create(isputStream);
				System.out.println("--读取的文件格式为xls");
			} else if (fileType.equals("xlsx")) {
				// wb = new XSSFWorkbook(is);
				wb = WorkbookFactory.create(isputStream);
				System.out.println("--读取的文件格式为xlsx");

			} else {
				return null;
			}
			// Workbook wbs = WorkbookFactory.create(f.getInputStream());
			// Sheet childSheet = wbs.getSheetAt(0);
			// 读取第一个工作页sheet
		
			Sheet sheet =  (Sheet) wb.getSheetAt(0);
            //总行数
            int rowLength = ((org.apache.poi.ss.usermodel.Sheet) sheet).getLastRowNum()+1;
            //工作表的列
            Row row = ((org.apache.poi.ss.usermodel.Sheet) sheet).getRow(1);
            //总列数
            int colLength = row.getLastCellNum();
            //得到指定的单元格
            Cell cell = row.getCell(0);
            //得到单元格样式
            CellStyle cellStyle = cell.getCellStyle();
            System.out.println("读取的文件行数：" + rowLength + ",列数：" + colLength);  
            for (int i = 0; i < rowLength; i++) {  
                row = ((org.apache.poi.ss.usermodel.Sheet) sheet).getRow(i); 
                ArrayList<String> rowList = new ArrayList<String>();
                for (int j = 0; j < colLength; j++) {  
                    cell = row.getCell(j);  
                    //Excel数据Cell有不同的类型，当我们试图从一个数字类型的Cell读取出一个字符串时就有可能报异常：  
                    //Cannot get a STRING value from a NUMERIC cell  
                    //将所有的需要读的Cell表格设置为String格式  
                    if (cell != null) {
                        cell.setCellType(CellType.STRING);  
                    }
                  /*  //对Excel进行修改  
                    if (i > 0 && j == 1)  
                        cell.setCellValue("1000");  
                    System.out.print(cell.getStringCellValue() + "\t");  */
                    rowList.add(cell.getStringCellValue());
                    
                }
                tableList.add(rowList);
                System.out.println("每行的数据:"+rowList); 
                System.out.println(" ");
                System.out.println("总行数行的数据:"+tableList);  
            }  
            
		} catch (Exception e) {
			e.printStackTrace();
		} finally {//关闭流
			try {
				if (isputStream != null)
					isputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		//放回集合
		return tableList;
	}
	
	/**
	 * 
	 * @param list
	 * @return
	 */
	public static  Personinfo getPersoninfo(List<String> list) {
		Personinfo personinfo=new Personinfo();
		//字符串转整型
		for (int i = 0; i < list.size(); i++) {
			switch(i) {
			case 0://公司账号
				personinfo.setAccount(list.get(i));
			break;
			case 1: //人员名字
				
				personinfo.setName(list.get(i));
			break;
			case 2: //人员身份证
				
				personinfo.setIdentity(list.get(i));
			break;
			case 3: //人员性别
				
				personinfo.setSex(list.get(i));
			break;
			case 4: //人员年龄
				int age = Integer.parseInt(list.get(i));//字符串转整型
				personinfo.setAge(age);
			break;
			case 5: //人员电话
				
				personinfo.setTelephone(list.get(i));
			break;
			default:
				break;
			}
				
		}
		
		return personinfo;
	}
	/**
	 * 
	 * @param path
	 * @return
	 */
	public static List<Personinfo> getPersoninfoList(String path){
		
		List<Personinfo> personinfoList = new ArrayList<Personinfo>();
		List<List<String>> tableList = readExcel(path);
		for(List<String> list: tableList) {
			Personinfo personinfo=new Personinfo();
			personinfo=getPersoninfo(list);
			if(personinfo!=null) {//不为空则添加进链表
				personinfoList.add(personinfo);
			}
		}

		return personinfoList;
		
	}
	
	

	public static void main(String[] args) {
		String path="‪F:\\complete\\传一人民医院-企业注册人员模板.xlsx";
		System.out.println("路径："+path);
		 ReadExcelFileUtil.readExcel(path);
		
		
	}
	
}
