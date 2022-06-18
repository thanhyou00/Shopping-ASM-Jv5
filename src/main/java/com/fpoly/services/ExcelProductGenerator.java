package com.fpoly.services;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.fpoly.entities.Product;

public class ExcelProductGenerator {

	private List<Product> listProducts;
	private XSSFWorkbook workbook;
	private XSSFSheet sheet;

	public ExcelProductGenerator(List<Product> listProducts) {
		this.listProducts = listProducts;
		workbook = new XSSFWorkbook();
	}

	private void writeHeader() {
		sheet = workbook.createSheet("Product");

		Row row = sheet.createRow(0);

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setBold(true);
		font.setFontHeight(16);
		style.setFont(font);

		createCell(row, 0, "ID", style);
		createCell(row, 1, "Name", style);
		createCell(row, 2, "Price", style);
		createCell(row, 3, "Image", style);
		createCell(row, 4, "Brand", style);
		createCell(row, 5, "Size", style);
		createCell(row, 6, "Available", style);
		createCell(row, 7, "Descriptions", style);
		createCell(row, 8, "Category ID", style);
	}

	private void createCell(Row row, int columnCount, Object value, CellStyle style) {
		sheet.autoSizeColumn(columnCount);
		Cell cell = row.createCell(columnCount);
		if (value instanceof Integer) {
			cell.setCellValue((Integer) value);
		} else if (value instanceof Double) {
			cell.setCellValue((Double) value);
		} else if (value instanceof Long) {
			cell.setCellValue((Long) value);
		} else if (value instanceof Boolean) {
			cell.setCellValue((Boolean) value);
		} else {
			cell.setCellValue((String) value);
		}
		cell.setCellStyle(style);
	}

	private void write() {
		int rowCount = 1;

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setFontHeight(14);
		style.setFont(font);

		for (Product product : listProducts) {
			Row row = sheet.createRow(rowCount++);
			int columnCount = 0;

			createCell(row, columnCount++, product.getId(), style);
			createCell(row, columnCount++, product.getName(), style);
			createCell(row, columnCount++, product.getPrice(), style);
			createCell(row, columnCount++, product.getImage(), style);
			createCell(row, columnCount++, product.getBrand(), style);
			createCell(row, columnCount++, product.getSize(), style);
			createCell(row, columnCount++, product.getAvailable()==1?"Còn hàng":"Hết hàng", style);
			createCell(row, columnCount++, product.getDescriptions(), style);
			createCell(row, columnCount++, product.getCategories().getId(), style);
		}
	}

	public void generate(HttpServletResponse response) throws IOException {
		writeHeader();
		write();
		ServletOutputStream outputStream = response.getOutputStream();
		workbook.write(outputStream);
		workbook.close();

		outputStream.close();

	}
}
