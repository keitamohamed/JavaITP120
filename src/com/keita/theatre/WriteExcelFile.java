package com.keita.theatre;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class WriteExcelFile {

    private Workbook workbook;
    private Sheet sheet;

    public WriteExcelFile(){
        workbook = new XSSFWorkbook();
        sheet = workbook.createSheet("Ticket Sale Record");
    }

    public void createFile(List<Customer> customers) {
        createExcel(customers, headerStyle(), row());
    }

    private void createExcel(List<Customer> customers, CellStyle cellStyle, Row row){
        String[] header = {"Name", "Number Of Adult", "Number Of Kid", "Total Price"};

        for (int i = 0; i < header.length; i++){
            Cell cell = row.createCell(i);
            cell.setCellValue(header[i]);
            cell.setCellStyle(cellStyle);
        }

        int numRow = 1;
        for (Customer customer : customers) {
            Row r = sheet.createRow(numRow++);
            r.createCell(0).setCellValue(customer.getName());
            r.createCell(1).setCellValue(customer.getNumAdult());
            r.createCell(2).setCellValue(customer.getNumKid());
            r.createCell(3).setCellValue(customer.getPrice());

            r.getCell(0).setCellStyle(rowStyle());
            r.getCell(1).setCellStyle(rowStyle());
            r.getCell(2).setCellStyle(rowStyle());
            r.getCell(3).setCellStyle(rowStyle());
        }

        for (int i = 0; i < header.length; i++){
            sheet.autoSizeColumn(i);
        }

        Frame f = new Frame();

        FileDialog foBox = new FileDialog(f, "Save Excel File", FileDialog.SAVE);
        foBox.setVisible(true);

        String foName = foBox.getFile();
        String dirPath = foBox.getDirectory();

        File outFile = new File(dirPath + foName + ".xlsx");
        try {
            FileOutputStream out = new FileOutputStream(outFile);
            workbook.write(out);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private CellStyle headerStyle() {
        Font header = workbook.createFont();
        header.setBold(true);
        header.setFontHeightInPoints((short) 16);
        header.setFontName("Times New Roman");


        CellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setAlignment(HorizontalAlignment.CENTER);
        cellStyle.setFont(header);

        return cellStyle;
    }

    private CellStyle rowStyle() {
        Font rowStyle = workbook.createFont();
        rowStyle.setFontHeightInPoints((short) 13);
        rowStyle.setColor(IndexedColors.RED.getIndex());
        rowStyle.setFontName("Times New Roman");


        CellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setAlignment(HorizontalAlignment.CENTER);
        cellStyle.setFont(rowStyle);

        return cellStyle;
    }

    private Row row(){
        return sheet.createRow(0);
    }
}
