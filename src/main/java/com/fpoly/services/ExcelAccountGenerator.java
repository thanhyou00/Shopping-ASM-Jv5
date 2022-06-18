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

import com.fpoly.entities.Account;

public class ExcelAccountGenerator {

	private List<Account> listAccounts;
	private XSSFWorkbook workbook;
	private XSSFSheet sheet;

	public ExcelAccountGenerator(List<Account> listAccounts) {
		this.listAccounts = listAccounts;
		workbook = new XSSFWorkbook();
	}

	private void writeHeader() {
		sheet = workbook.createSheet("Account");

		Row row = sheet.createRow(0);

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setBold(true);
		font.setFontHeight(16);
		style.setFont(font);

		createCell(row, 0, "ID", style);
		createCell(row, 1, "Fullname", style);
		createCell(row, 2, "Username", style);
		createCell(row, 3, "Email", style);
		createCell(row, 4, "Photo", style);
		createCell(row, 5, "Actived", style);
		createCell(row, 6, "Role", style);
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

		for (Account account : listAccounts) {
			Row row = sheet.createRow(rowCount++);
			int columnCount = 0;

			createCell(row, columnCount++, account.getId(), style);
			createCell(row, columnCount++, account.getFullname(), style);
			createCell(row, columnCount++, account.getUsername(), style);
			createCell(row, columnCount++, account.getEmail(), style);
			createCell(row, columnCount++, account.getAvatar(), style);
			createCell(row, columnCount++, account.getActived()==1?"Chưa kích hoạt":"Đã kích hoạt", style);
			createCell(row, columnCount++, account.getAdmin()==1?"Admin":"Member", style);
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
