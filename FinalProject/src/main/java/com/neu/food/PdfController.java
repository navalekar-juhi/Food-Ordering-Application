package com.neu.food;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import com.neu.pdfview.OrderPdfView;

@Controller
public class PdfController {
	@RequestMapping(value = "/report", method = RequestMethod.GET)
    public ModelAndView createReport()
    {
        View view = new OrderPdfView();
        return new ModelAndView(view);
        
    }
}
