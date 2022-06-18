package com.fpoly.services;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.fpoly.beans.HistoryModel;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.CMYKColor;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import lombok.Data;

@Data
public class PDFGenerator {
	// List to hold all Students
		private List<HistoryModel> bill;

		public void generate(HttpServletResponse response) throws DocumentException, IOException {

			// Creating the Object of Document
			Document document = new Document(PageSize.A4);

			// Getting instance of PdfWriter
			PdfWriter.getInstance(document, response.getOutputStream());

			// Opening the created document to modify it
			document.open();

			// Creating font
			// Setting font style and size
			Font fontTiltle = FontFactory.getFont(FontFactory.TIMES_ROMAN);
			fontTiltle.setSize(20);

			// Creating paragraph
			Paragraph paragraph = new Paragraph("Bill of product detail", fontTiltle);

			// Aligning the paragraph in document
			paragraph.setAlignment(Paragraph.ALIGN_CENTER);

			// Adding the created paragraph in document
			document.add(paragraph);

			// Creating a table of 7 columns
			PdfPTable table = new PdfPTable(7);

			// Setting width of table, its columns and spacing
			table.setWidthPercentage(100f);
			table.setWidths(new int[] { 3, 3, 3, 3, 3, 3, 3 });
			table.setSpacingBefore(5);

			// Create Table Cells for table header
			PdfPCell cell = new PdfPCell();

			// Setting the background color and padding
			cell.setBackgroundColor(CMYKColor.BLUE);
			cell.setPadding(5);

			// Creating font
			// Setting font style and size
			Font font = FontFactory.getFont(FontFactory.TIMES_ROMAN);
			font.setColor(CMYKColor.WHITE);

			// Adding headings in the created table cell/ header
			// Adding Cell to table
			cell.setPhrase(new Phrase("Name customer", font));
			table.addCell(cell);
			cell.setPhrase(new Phrase("Name product", font));
			table.addCell(cell);
			cell.setPhrase(new Phrase("Price", font));
			table.addCell(cell);
			cell.setPhrase(new Phrase("Quantity", font));
			table.addCell(cell);
			cell.setPhrase(new Phrase("Total price", font));
			table.addCell(cell);
			cell.setPhrase(new Phrase("Shipping address", font));
			table.addCell(cell);
			cell.setPhrase(new Phrase("Status", font));
			table.addCell(cell);

			// Iterating over the list of students
			for (HistoryModel od : bill) {
				// Adding account name 
				table.addCell(od.getOrder().getAccount().getFullname());
				// Adding product name
				table.addCell(od.getProduct().getName());
				// Adding price
				table.addCell(String.valueOf(od.getOrderDetail().getPrice()));
				// Adding quantity
				table.addCell(String.valueOf(od.getOrderDetail().getQuantity()));
				// Adding total price
				table.addCell(String.valueOf(od.getOrderDetail().getPrice()*od.getOrderDetail().getQuantity()));
				// Adding address
				table.addCell(od.getOrder().getShippingAddress());
				// Adding status
				table.addCell("Đã thanh toán");
			}
			// Adding the created table to document
			document.add(table);

			// Closing the document
			document.close();

		}
}
