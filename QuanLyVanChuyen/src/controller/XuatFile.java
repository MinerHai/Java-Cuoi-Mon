/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.io.FileOutputStream;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.io.FileOutputStream;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;

/**
 *
 * @author Dell
 */
public class XuatFile {

    public XuatFile() {
    }

    public void exportTableToExcel(JTable table, String filePath) {
        try {
            Workbook workbook = new XSSFWorkbook();
            Sheet sheet = workbook.createSheet("Doanh Thu");

            TableModel model = table.getModel();

            // Tạo tiêu đề cột
            Row headerRow = sheet.createRow(0);
            for (int col = 0; col < model.getColumnCount(); col++) {
                Cell cell = headerRow.createCell(col);
                cell.setCellValue(model.getColumnName(col));
                CellStyle style = workbook.createCellStyle();
                Font font = workbook.createFont();
                font.setBold(true);
                style.setFont(font);
                cell.setCellStyle(style);
            }

            // Thêm dữ liệu từ JTable vào file Excel
            for (int row = 0; row < model.getRowCount(); row++) {
                Row excelRow = sheet.createRow(row + 1);
                for (int col = 0; col < model.getColumnCount(); col++) {
                    Cell cell = excelRow.createCell(col);
                    Object value = model.getValueAt(row, col);

                    if (value instanceof Integer) {
                        cell.setCellValue((Integer) value);
                    } else if (value instanceof Float || value instanceof Double) {
                        cell.setCellValue(Double.parseDouble(value.toString()));
                    } else if (value instanceof java.util.Date) {
                        CellStyle dateStyle = workbook.createCellStyle();
                        CreationHelper creationHelper = workbook.getCreationHelper();
                        dateStyle.setDataFormat(creationHelper.createDataFormat().getFormat("dd-MM-yyyy"));
                        cell.setCellStyle(dateStyle);
                        cell.setCellValue((java.util.Date) value);
                    } else {
                        cell.setCellValue(value != null ? value.toString() : "");
                    }
                }
            }

            // Ghi dữ liệu ra file
            try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
                workbook.write(fileOut);
            }

            workbook.close();
            JOptionPane.showMessageDialog(null, "Xuất file Excel thành công!");

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Đã xảy ra lỗi khi xuất file Excel.");
        }
    }

    public static void exportToPDF(String data) {
        try {
            // Đường dẫn và tên file
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Chọn vị trí lưu file PDF");
            fileChooser.setSelectedFile(new java.io.File("Invoice.pdf"));

            int userSelection = fileChooser.showSaveDialog(null);
            if (userSelection == JFileChooser.APPROVE_OPTION) {
                java.io.File fileToSave = fileChooser.getSelectedFile();
                String filePath = fileToSave.getAbsolutePath();

                // Thêm đuôi .pdf nếu không có
                if (!filePath.toLowerCase().endsWith(".pdf")) {
                    filePath += ".pdf";
                }

                // Khởi tạo Document và PdfWriter
                Document document = new Document();
                PdfWriter.getInstance(document, new FileOutputStream(filePath));

                // Mở Document
                document.open();
                // Thêm nội dung vào PDF
                for (String line : data.split("\n")) {
                    document.add(new Paragraph(line));
                }

                // Đóng Document
                document.close();

                // Hiển thị thông báo thành công
                JOptionPane.showMessageDialog(null, "File đã được lưu tại: " + filePath);
            }

        } catch (DocumentException | FileNotFoundException ex) {
            // Xử lý lỗi nếu có
            JOptionPane.showMessageDialog(null, "Lỗi khi tạo file PDF: " + ex.getMessage());
        }
    }
}
