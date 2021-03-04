package com.jdr.statedata;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.InputStream;
import java.util.*;

public class ReadExcel {

    List<District> districts = new ArrayList<>();

    public void setDistricts(List<District> districts) {
        this.districts = districts;
    }

   // public List<District> getDistrictData() {
    public District[] getDistrictData() {
        try {
            File newfile = new File("VotingData.xlsx");
            String absPath =  newfile.getAbsolutePath();


            InputStream file = getClass().getResourceAsStream("/VotingData.xlsx");
             // FileInputStream file =   new FileInputStream(new File("C:\\Users\\jim\\IdeaProjects\\statedata\\src\\main\\resources\\VotingData.xlsx"));



            // C:\Users\jim\IdeaProjects\statedata\target\classes


            //Create Workbook instance holding reference to .xlsx file
            XSSFWorkbook workbook = new XSSFWorkbook(file);

            //Get first/desired sheet from the workbook
            XSSFSheet sheet = workbook.getSheetAt(0);

            int rowCount = 0;


            // Set the columns needed for this statistic: Black voter percentage
            // This is columns 2,4,11, and 13
            Set<Integer> columnSet = new HashSet<>();
            columnSet.add(2);
            columnSet.add(4);
            columnSet.add(11);
            columnSet.add(13);

            //Iterate through each rows one by one
            Iterator<Row> rowIterator = sheet.iterator();
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();

                rowCount++;
                if (rowCount < 6 || rowCount > 441) continue;

                //For each row, iterate through all the columns
                Iterator<Cell> cellIterator = row.cellIterator();
                District district = new District();
                int columnCount = 0;
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    //Check the cell type and format accordingly

                    columnCount++;

                    // For this spreadsheet congressional district data starts on row 6
                    if (!columnSet.contains(columnCount)) continue;

                    switch (columnCount) {
                        //Column 2 is the two letter District code (capitalized)
                        case 2:
                            System.out.print("State:" + cell.getStringCellValue() + "  ");
                            district.setStateAbbrev(cell.getStringCellValue());
                            break;

                        case 4:
                            //System.out.println("Column 4 CellType: " + cell.getCellType());
                            // Some of the cells test as numeric type and some (At-large) test as String type
                            if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
                                // The value is 'At-large'. This is for states with only one district
                                // so we convert it to "00"
                                district.setDistrict(district.getStateAbbrev() + "00");
                            } else {
                                // The string is numeric. We convert it to an int to remove decimal portion
                                // and then to a String adding a leading "0" if it's only one digit
                                // Add the State Abbreviation so District is now in the correct format for simplemaps
                                String value = Integer.toString((int) (cell.getNumericCellValue()));
                                //System.out.println("Value:" + value);
                                if (value.length() == 1) {
                                    district.setDistrict(district.getStateAbbrev() + "0" + value);
                                } else {
                                    district.setDistrict(district.getStateAbbrev() + value);
                                }
                            }
                            //System.out.println("District:" + district.getDistrict());
                            break;

                        case 11:
                            if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
                                district.setTotalPossibleVoters(cell.getStringCellValue());
                            } else {
                                district.setTotalPossibleVoters(Double.toString(cell.getNumericCellValue()));
                            }
                            break;
                        case 13:
                            if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
                                if (cell.getStringCellValue().equals("N")) {
                                    district.setPercentVoted(0.0);
                                } else {
                                    district.setPercentVoted(new Double(cell.getStringCellValue()));
                                }
                            } else {
                                district.setPercentVoted(cell.getNumericCellValue());
                            }
                            break;
                    }
                }
                district.setColor();
                districts.add(district);
                System.out.println(district.toString());
            }
            file.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

//        String[] itemsArray = new String[itemList.size()];
//        itemsArray = itemList.toArray(itemsArray);

        District[] dists = new District[districts.size()];
        dists = districts.toArray(dists);
       // return districts;
        return dists;
    }
}

