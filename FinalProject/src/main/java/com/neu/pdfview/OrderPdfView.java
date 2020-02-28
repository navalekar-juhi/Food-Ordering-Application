package com.neu.pdfview;

import java.util.Map;

import org.springframework.web.servlet.view.document.AbstractPdfView;
import java.awt.Color;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.neu.dao.OrdersDAO;
import com.neu.pojo.Customer;
import com.neu.pojo.OrderDetails;
import com.neu.pojo.User;

public class OrderPdfView extends AbstractPdfView {

    @Override
    protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
            HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        Font font_helvetica_14_bold_blue = new Font(Font.TIMES_ROMAN, 14, Font.BOLD, Color.BLUE);
        Font font_courier_16_italic_red = new Font(Font.TIMES_ROMAN, 16, Font.ITALIC, Color.RED);
        Font font_courier_16_bold_black = new Font(Font.TIMES_ROMAN, 16, Font.BOLD, Color.BLACK);

        HttpSession session = request.getSession();
        User u =(User) session.getAttribute("user");
        Customer customer = (Customer) session.getAttribute("customerdetails");
        OrdersDAO orDet = new OrdersDAO();
        List odList = orDet.viewList(u.getUserId());

        Paragraph p1 = new Paragraph("Fooze - Your Order History", font_courier_16_bold_black);
        document.add(p1);

        Paragraph p2 = new Paragraph("Customer Id: " + String.valueOf(u.getUserId()), font_courier_16_italic_red);
        document.add(p2);

        Paragraph p3 = new Paragraph("Customer Name: " + customer.getfName() + " " + customer.getlName(), font_courier_16_italic_red);
        document.add(p3);

        Iterator orderIterator = odList.iterator();
        while (orderIterator.hasNext()) {
            OrderDetails orders = (OrderDetails) orderIterator.next();

            PdfPTable tablehead = new PdfPTable(3); 
            PdfPCell cell1 = new PdfPCell(new Paragraph("Item Id"));
            PdfPCell cell3 = new PdfPCell(new Paragraph("Item Name"));
            PdfPCell cell4 = new PdfPCell(new Paragraph("Price"));

            tablehead.addCell(cell1);
            tablehead.addCell(cell3);
            tablehead.addCell(cell4);

            PdfPTable tablebody = new PdfPTable(3);
         
            PdfPCell cell6 = new PdfPCell(new Paragraph(String.valueOf(orders.getItemId())));
            PdfPCell cell8 = new PdfPCell(new Paragraph(orders.getItemName()));
            PdfPCell cell10 = new PdfPCell(new Paragraph(String.valueOf("$"+orders.getPrice())));

            tablebody.addCell(cell6);
            tablebody.addCell(cell8);
            tablebody.addCell(cell10);

            tablehead.setSpacingBefore(10f);
            tablebody.setSpacingAfter(20f);

            document.add(tablehead);
            document.add(tablebody);

        }

    }

}
