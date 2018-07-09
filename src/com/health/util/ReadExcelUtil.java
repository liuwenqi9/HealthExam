package com.health.util;


import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.health.entity.Personinfo;


/**
 * 
 * @author JSY
 * @date:6月22日
 */


public class ReadExcelUtil {

	private static final String EXCEL_XLS = "xls";
	private static final String EXCEL_XLSX = "xlsx";

	/**
	 * 判断Excel的版本,获取Workbook
	 * @param in
	 * @param filename
	 * @return
	 * @throws IOException
	 */
	public static Workbook getWorkbok(InputStream in,File file) throws IOException{
		Workbook wb = null;
		if(file.getName().endsWith(EXCEL_XLS)){	 //Excel 2003
			wb = new HSSFWorkbook(in);
		}else if(file.getName().endsWith(EXCEL_XLSX)){	// Excel 2007/2010
			wb = new XSSFWorkbook(in);
		}
		return wb;
	}

	/**
	 * 判断文件是否是excel
	 * @throws Exception 
	 */
	public static void checkExcelVaild(File file) throws Exception{
		if(!file.exists()){
			throw new Exception("文件不存在");
		}
		if(!(file.isFile() && (file.getName().endsWith(EXCEL_XLS) || file.getName().endsWith(EXCEL_XLSX)))){
			throw new Exception("文件不是Excel");
		}
	}


		/**
		 * 读取Excel测试，兼容 Excel 2003/2007/2010
		 * @param path
		 * @return
		 */
	public static List<List<String>> readExcel(String path) {
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
		/*BufferedWriter bw = new BufferedWriter(new FileWriter(new File("F:InsertSql.txt")));*/
		FileInputStream is =null;//文件输入流
		List<List<String>> tableList = new ArrayList<List<String>>();
		try {
			// 同时支持Excel 2003、2007
			File excelFile = new File(path); // 创建文件对象
			 is = new FileInputStream(excelFile); // 文件流
			checkExcelVaild(excelFile);
			Workbook workbook = getWorkbok(is,excelFile);
			//Workbook workbook = WorkbookFactory.create(is); // 这种方式 Excel2003/2007/2010都是可以处理的

			int sheetCount = workbook.getNumberOfSheets(); // Sheet的数量
			/**
			 * 设置当前excel中sheet的下标：0开始
			 */
			Sheet sheet = workbook.getSheetAt(0);	// 遍历第一个Sheet

			// 为跳过第一行目录设置count
			int count = 0;

		    for (Row row : sheet) {
		    	
		    	// 跳过第一行的目录
		    	if(count == 0){
		    		count++;
		    		continue;
		    	}
		    	if(count == 1){
		    		count++;
		    		continue;
		    	}
		    	// 如果当前行没有数据，跳出循环
		    	if(row.getCell(0) == null){
	        		return  tableList;
	        	}
		    	  List<String> rowList = new ArrayList<String>();
		    	String rowValue = "";
		        for (Cell cell : row) {
		        	if(cell.toString() == null){
		        		continue;
		        	}
		        	
		        	int cellType = cell.getCellType();
		        	String cellValue = "";
		            switch (cellType) {
		                case Cell.CELL_TYPE_STRING:		// 文本
		                    cellValue = cell.getRichStringCellValue().getString() ;
		                    break;
		                case Cell.CELL_TYPE_NUMERIC:	// 数字、日期
		                    if (DateUtil.isCellDateFormatted(cell)) {
		                        cellValue = fmt.format(cell.getDateCellValue()) ;
		                    } else {
		                    	 /* DecimalFormat df = new DecimalFormat("0");    
		                    	  cellValue = df.format(cell.getNumericCellValue()) + "#";  */  
		                    	 cell.setCellType(Cell.CELL_TYPE_STRING);
		                    	  cellValue = String.valueOf(cell.getRichStringCellValue().getString()) ;
		                    	 /* Double value = cell.getNumericCellValue();  
		                          BigDecimal bd1 = new BigDecimal(Double.toString(value));  
		                          cellValue = bd1.toPlainString()+ "#";  */
		                    }
		                    break;
		              
		                case Cell.CELL_TYPE_BOOLEAN:	// 布尔型
		                    cellValue = String.valueOf(cell.getBooleanCellValue()) ;
		                    break;
		                case Cell.CELL_TYPE_BLANK: // 空白
		                    cellValue = cell.getStringCellValue() ;
		                    break;
		                case Cell.CELL_TYPE_ERROR: // 错误
		                    cellValue = "错误#";
		                    break;
		                case Cell.CELL_TYPE_FORMULA:	// 公式
		                    // 得到对应单元格的公式
		                    //cellValue = cell.getCellFormula() + "#";
		                    // 得到对应单元格的字符串
		                    cell.setCellType(Cell.CELL_TYPE_STRING);
		                    cellValue = String.valueOf(cell.getRichStringCellValue().getString()) ;
		                    break;
		                default:
		                    cellValue = "";
		            }
		            //System.out.print(cellValue);
		            rowValue += cellValue;
		            rowList.add(cellValue);
		        }
		        tableList.add(rowList);
		        System.out.println(rowValue);
		        System.out.println();
		        
		    }
		    
		    
		  
		    
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
		    	if (is != null)
		    		is.close();
		    } catch (IOException e) {
		    	e.printStackTrace();
		    }
		}
		return tableList;
		
		
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
			case 0:
				System.out.println("第一列"+list.get(i));
				break;
			case 1://公司账号
				personinfo.setAccount(list.get(i));
						
			break;
			case 2: //人员名字
				
				personinfo.setName(list.get(i));
			break;
			case 3: //人员身份证
				
				personinfo.setIdentity(list.get(i));
			break;
			case 4: //人员性别
				
				personinfo.setSex(list.get(i));
			break;
			case 5: //人员年龄
				/*Integer age = Integer.parseInt(list.get(i));//字符串转整型
*/				

				int age =0;
				System.out.println("age = " + age);
				
				try {
					age = Integer.parseInt(list.get(i));
				} catch (NumberFormatException e) {
				    e.printStackTrace();
				}
//				if(s.equals("25")) {
//					System.out.println("值为25");
//				}
				
				personinfo.setAge(age);
			break;
			case 6: //人员电话
				
				personinfo.setTelephone(list.get(i));
			break;
			default:
				break;
			}
				
		}
		
		return personinfo;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	/*public static void main(String[] args) {
		
		String t=Thread.currentThread().getContextClassLoader().getResource("").getPath(); 
		System.out.println(t);
		List<List<String>> tableList=ReadExcelUtil.readExcel();
		for (int i = 0; i < tableList.size(); i++) {
			System.out.println("获得的数据："+tableList.get(i));
			for (int j = 0; j < tableList.get(i).size(); j++) {
				
			}
		}
	}*/
	
	
	

	
	
 }


	
	
	

