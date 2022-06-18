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

import com.fpoly.entities.Order;

public class ExcelOrderGenerator {

	private List<Order> listOrders;
	private XSSFWorkbook workbook;
	private XSSFSheet sheet;

	public ExcelOrderGenerator(List<Order> listOrders) {
		this.listOrders = listOrders;
		workbook = new XSSFWorkbook();
	}

	private void writeHeader() {
		sheet = workbook.createSheet("Order");

		Row row = sheet.createRow(0);

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setBold(true);
		font.setFontHeight(16);
		style.setFont(font);

		createCell(row, 0, "ID", style);
		createCell(row, 1, "Account ID", style);
		createCell(row, 2, "Shipping address", style);
		createCell(row, 3, "Order date", style);
		createCell(row, 4, "Order status", style);
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

		for (Order order : listOrders) {
			Row row = sheet.createRow(rowCount++);
			int columnCount = 0;
			String odStt = "";
			if(order.getOrderStatus()==1) {
				odStt = "Đã thanh toán";
			} else if(order.getOrderStatus()==0) {
				odStt = "Chưa thanh toán";
			} else if(order.getOrderStatus()==2) {
				odStt = "Đã hủy";
			}
			createCell(row, columnCount++, order.getId(), style);
			createCell(row, columnCount++, order.getAccount().getId(), style);
			createCell(row, columnCount++, order.getShippingAddress(), style);
			createCell(row, columnCount++, order.getOrderDate(), style);
			createCell(row, columnCount++, odStt, style);
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
