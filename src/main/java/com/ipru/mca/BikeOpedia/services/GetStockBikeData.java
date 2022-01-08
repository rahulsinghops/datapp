package com.ipru.mca.BikeOpedia.services;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.ipru.mca.BikeOpedia.dao.BikeDetailRepo;
import com.ipru.mca.BikeOpedia.entity.BikeDetails;

@Service
public class GetStockBikeData {
	
	@Autowired
	BikeDetailRepo bikerepo;
	
	@Value("${filepath}")
	String filepath;

	public void getBikeDetails() {
		try {
			int modelindex = 0;
			int versionindex = 0;
			int exshowroomindex = 0;
			int detailsindex = 0;
			int p_bangaloreindex = 0;
			int p_mumbaiindex = 0;
			int p_puneindex = 0;
			int p_new_Delhiindex = 0;
			int p_chennaiindex = 0;
			int p_kolkataindex = 0;
			int p_hyderabadindex = 0;
			int p_chandigarhindex = 0;
			int p_ahmedabadindex = 0;
			//File file = new File("C:\\Users\\rahul.singh7\\Desktop\\bike.xlsx");
			File file = new File(System.getProperty("user.dir")+filepath);
			Workbook workbook = WorkbookFactory.create(file);
			// Workbook workbook = WorkbookFactory.create();
			Sheet sheet = workbook.getSheet("bikedetails");

			Iterator<Row> rows = sheet.iterator();
			while (rows.hasNext()) {

				BikeDetails bike = new BikeDetails();
				Row row = (Row) rows.next();

				Iterator<Cell> cells = row.cellIterator();
				while (cells.hasNext()) {
					Cell cell = (Cell) cells.next();

					 //System.out.println(cell.getColumnIndex());

					if (cell.getRowIndex() == 0) {
						
						//System.out.println("row number" + cell.getRowIndex() + "--column number" + cell.getColumnIndex());
						String columnname = cell.getStringCellValue();
						//System.out.println("columnname:" + columnname + ":" + cell.getColumnIndex());
						if (columnname.indexOf("Model") != -1) {
							modelindex = cell.getColumnIndex();
							//System.out.println("modelindex:" + modelindex);
							continue;
						}
						if (columnname.indexOf("Version") != -1) {
							versionindex = cell.getColumnIndex();
							//System.out.println("versionindex:" + versionindex);
							continue;
						}
						if (columnname.indexOf("Ex-showroom") != -1) {
							exshowroomindex = cell.getColumnIndex();
							//System.out.println("exshowroomindex:" + exshowroomindex);
							continue;
						}
						if (columnname.indexOf("About model") != -1) {
							detailsindex = cell.getColumnIndex();
							//System.out.println("detailsindex:" + detailsindex);
							continue;
						}
						if (columnname.indexOf("Bangalore") != -1) {
							p_bangaloreindex = cell.getColumnIndex();
							//System.out.println("p_bangaloreindex:" + p_bangaloreindex);
							continue;
						}
						if (columnname.indexOf("Mumbai") != -1) {
							p_mumbaiindex = cell.getColumnIndex();
							//System.out.println("p_mumbaiindex:" + p_mumbaiindex);
							continue;
						}
						if (columnname.indexOf("Pune") != -1) {
							p_puneindex = cell.getColumnIndex();
							//System.out.println("p_puneindex:" + p_puneindex);
							continue;
						}
						if (columnname.indexOf("Delhi") != -1) {
							p_new_Delhiindex = cell.getColumnIndex();
							//System.out.println("p_new_Delhiindex:" + p_new_Delhiindex);
							continue;
						}
						if (columnname.indexOf("Chennai") != -1) {
							p_chennaiindex = cell.getColumnIndex();
							//System.out.println("p_chennaiindex:" + p_chennaiindex);
							continue;
						}
						if (columnname.indexOf("Kolkata") != -1) {
							p_kolkataindex = cell.getColumnIndex();
							//System.out.println("p_kolkataindex:" + p_kolkataindex);
							continue;
						}
						if (columnname.indexOf("Hyderabad") != -1) {
							p_hyderabadindex = cell.getColumnIndex();
							//System.out.println("p_hyderabadindex:" + p_hyderabadindex);
							continue;
						}
						if (columnname.indexOf("Chandigarh") != -1) {
							p_chandigarhindex = cell.getColumnIndex();
							//System.out.println("p_chandigarhindex:" + p_chandigarhindex);
							continue;
						}
						if (columnname.indexOf("Ahmedabad") != -1) {
							p_ahmedabadindex = cell.getColumnIndex();
							//System.out.println("p_ahmedabadindex:" + p_ahmedabadindex);
							continue;
						}
					} else {
						
						//System.out.println("row number --" + cell.getRowIndex() + "--column number" + cell.getColumnIndex());
						// to eliminate numeric type errors
						CellType type = cell.getCellType();
						//System.out.println("type of cel:" + type.toString());
						if (cell.getColumnIndex() == modelindex) {
							if (type.toString().equalsIgnoreCase(CellType.NUMERIC.toString()))
								bike.setModel(cell.getNumericCellValue() +"");
							else
								bike.setModel(cell.getStringCellValue());

							continue;
						}
						if (cell.getColumnIndex() == versionindex) {
							if (type.toString().equalsIgnoreCase(CellType.NUMERIC.toString()))
								bike.setVersion(cell.getNumericCellValue() +"" );
							else
								bike.setVersion(cell.getStringCellValue());
							continue;
						}
						if (cell.getColumnIndex() == detailsindex) {
							if (type.toString().equalsIgnoreCase(CellType.NUMERIC.toString()))
								bike.setDetails(cell.getNumericCellValue() +"");
							else
								bike.setDetails(cell.getStringCellValue());
							continue;
						}				
                        //double type fields	
						if (cell.getColumnIndex() == exshowroomindex) {
							if (type.toString().equalsIgnoreCase(CellType.NUMERIC.toString()))
								bike.setExshowroom(cell.getNumericCellValue() );
							else
								bike.setExshowroom(Double.parseDouble( cell.getStringCellValue() !="" ? cell.getStringCellValue().replace(",", ""):"0.0" ));
							continue;
						}

						if (cell.getColumnIndex() == p_bangaloreindex) {
							if (type.toString().equalsIgnoreCase(CellType.NUMERIC.toString()))
								bike.setP_bangalore(cell.getNumericCellValue() );
							else
								bike.setP_bangalore(Double.parseDouble( cell.getStringCellValue() !="" ? cell.getStringCellValue().replace(",", ""):"0.0" ));
							continue;
						}
						if (cell.getColumnIndex() == p_mumbaiindex) {
							if (type.toString().equalsIgnoreCase(CellType.NUMERIC.toString()))
								bike.setP_mumbai(cell.getNumericCellValue() );
							else
								bike.setP_mumbai(Double.parseDouble( cell.getStringCellValue() !="" ? cell.getStringCellValue().replace(",", ""):"0.0" ));
							continue;
						}
						if (cell.getColumnIndex() == p_puneindex) {
							if (type.toString().equalsIgnoreCase(CellType.NUMERIC.toString()))
								bike.setP_pune(cell.getNumericCellValue() );
							else
								bike.setP_pune(Double.parseDouble( cell.getStringCellValue() !="" ? cell.getStringCellValue().replace(",", ""):"0.0" ));
							continue;
						}
						if (cell.getColumnIndex() == p_new_Delhiindex) {
							if (type.toString().equalsIgnoreCase(CellType.NUMERIC.toString()))
								bike.setP_new_Delhi(cell.getNumericCellValue() );
							else
								bike.setP_new_Delhi(Double.parseDouble( cell.getStringCellValue() !="" ? cell.getStringCellValue().replace(",", ""):"0.0" ));
							continue;
						}
						if (cell.getColumnIndex() == p_chennaiindex) {
							if (type.toString().equalsIgnoreCase(CellType.NUMERIC.toString()))
								bike.setP_chennai(cell.getNumericCellValue() );
							else
								bike.setP_chennai(Double.parseDouble( cell.getStringCellValue() !="" ? cell.getStringCellValue().replace(",", ""):"0.0" ));
							continue;
						}
						if (cell.getColumnIndex() == p_kolkataindex) {
							if (type.toString().equalsIgnoreCase(CellType.NUMERIC.toString()))
								bike.setP_kolkata(cell.getNumericCellValue() );
							else
								bike.setP_kolkata(Double.parseDouble( cell.getStringCellValue() !="" ? cell.getStringCellValue().replace(",", ""):"0.0" ));
							continue;
						}
						if (cell.getColumnIndex() == p_hyderabadindex) {
							if (type.toString().equalsIgnoreCase(CellType.NUMERIC.toString()))
								bike.setP_hyderabad(cell.getNumericCellValue() );
							else
								bike.setP_hyderabad(Double.parseDouble( cell.getStringCellValue() !="" ? cell.getStringCellValue().replace(",", ""):"0.0" ));
							continue;
						}
						if (cell.getColumnIndex() == p_chandigarhindex) {
							if (type.toString().equalsIgnoreCase(CellType.NUMERIC.toString()))
								bike.setP_chandigarh(cell.getNumericCellValue() );
							else
								bike.setP_chandigarh(Double.parseDouble( cell.getStringCellValue() !="" ? cell.getStringCellValue().replace(",", ""):"0.0" ));
							continue;
						}
						if (cell.getColumnIndex() == p_ahmedabadindex) {
							if (type.toString().equalsIgnoreCase(CellType.NUMERIC.toString()))
								bike.setP_ahmedabad(cell.getNumericCellValue() );
							else
								bike.setP_ahmedabad(Double.parseDouble( cell.getStringCellValue() !="" ? cell.getStringCellValue().replace(",", ""):"0.0" ));
							continue;
						}

					}
					 

				}
				//adding in bike data 
				bikerepo.save(bike);
				//System.out.println(bike);

			}
			System.out.println("before closing ");
			
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			System.out.println("finally executed");
		}
		//return new BikeDetails();
	}

}
