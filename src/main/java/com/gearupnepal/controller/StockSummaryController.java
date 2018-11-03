/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gearupnepal.controller;

import com.gearupnepal.web.entity.Category;
import com.gearupnepal.web.entity.Login;
import com.gearupnepal.web.entity.TempChild;
import com.gearupnepal.web.entity.repository.LoginRepository;
import com.gearupnepal.web.service.CategoryService;
import com.gearupnepal.web.service.ChildSubcategoryService;
import com.gearupnepal.web.service.SubCategoryService;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Section;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.annotation.MultipartConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Dell
 */
@Controller
@RequestMapping(value = "/admin/stock")
@MultipartConfig(maxFileSize = 16177215)    // upload file's size up to 16MB
public class StockSummaryController {

    @Autowired
    CategoryService categoryService;

    @Autowired
    LoginRepository loginRepository;

    @Autowired
    SubCategoryService subCategoryService;

    @Autowired
    ChildSubcategoryService childSubcategoryService;

    List<TempChild> tempChilds = new ArrayList<>();

    private static String FILE = "C:\\Users\\admin\\Pictures\\FirstPdf.pdf";
    private static Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 18,
            Font.BOLD);
    private static Font redFont = new Font(Font.FontFamily.TIMES_ROMAN, 12,
            Font.NORMAL, BaseColor.RED);
    private static Font subFont = new Font(Font.FontFamily.TIMES_ROMAN, 16,
            Font.BOLD);
    private static Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 12,
            Font.BOLD);

    @GetMapping
    public String index(Model model) {
        long id = 1;
        model.addAttribute("categories", categoryService.getAll());
        model.addAttribute("subCategories", subCategoryService.getAll());
        model.addAttribute("childSubCategories", childSubcategoryService.getAll());
        List<Category> categories = categoryService.getAll();
        System.out.println(categories.get(0).getName());

        return "stockreport";
    }

    @GetMapping(value = "/add")
    public String add() {
        return "admin/categorys/add";
    }

    @PostMapping
    public String index(@ModelAttribute("Category") Category category) {
        List<Login> logins = loginRepository.findAll();
        category.setCreatedBy(logins.get(logins.size() - 1).getUserName());
        System.out.println("saving");
        categoryService.save(category);
        return "redirect:/category";
    }

    @GetMapping(value = "/delete/{id}")
    public String delete(@PathVariable("id") long id) {
        System.out.println("deleted");

        categoryService.delete(id);
        System.out.println("deleted");
        return "redirect:/category";
    }

    @GetMapping(value = "/edit/{id}")
    public String edit(@PathVariable("id") long id, Model model) {
        System.out.println("editingedasdsssssssssa");
        model.addAttribute("category", categoryService.findById(id));
        return "editcategory";
    }

    private static void createTable(Section subCatPart)
            throws BadElementException, IOException {
        PdfPTable table = new PdfPTable(3);

        PdfPCell c1 = new PdfPCell(new Phrase("Table Header 1"));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);

        c1 = new PdfPCell(new Phrase("Table Header 2"));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);

        c1 = new PdfPCell(new Phrase("Table Header 3"));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);
        table.setHeaderRows(1);
        Image img = Image.getInstance("C:\\Users\\admin\\Pictures\\rajesh.jpg");

        table.addCell(img);
        table.addCell("1.1");
        table.addCell("1.2");
        table.addCell("2.1");
        table.addCell("2.2");
        table.addCell("2.3");

        subCatPart.add(table);

    }

}
