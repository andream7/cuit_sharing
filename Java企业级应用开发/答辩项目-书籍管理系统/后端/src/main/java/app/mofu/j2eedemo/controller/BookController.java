package app.mofu.j2eedemo.controller;

import app.mofu.j2eedemo.dto.ResponseDto;
import app.mofu.j2eedemo.model.Book;
import app.mofu.j2eedemo.repository.BookRepository;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

// 声明控制器，并设置路由前缀为 /book
@RestController
@RequestMapping(path = "/book")
public class BookController {

    // 自动注入BookRepository
    @Autowired
    private BookRepository bookRepository;

    // 定义了添加书籍的接口，使用POST方法，路由为 /add
    @PostMapping(path = "/add")
    public ResponseDto addBook(@RequestBody Book book) {
        bookRepository.save(book); // 保存书籍信息到数据库
        return new ResponseDto(true, null, "ok"); // 返回成功信息
    }

    // 定义了删除书籍的方法，路由为 /delete/{id}
    @GetMapping(path = "/delete/{id}")
    public ResponseDto deleteBook(@PathVariable Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id); // 查找书籍
        if (optionalBook.isPresent()) {
            bookRepository.deleteById(id); // 若找到则删除
            return new ResponseDto(true, null, "ok"); // 返回成功信息
        } else {
            return new ResponseDto(false, null, "book not found"); // 找不到则返回错误信息
        }
    }

    // 定义获取特定书籍的接口方法，路由为 /get/{id}
    @GetMapping("/get/{id}")
    public ResponseDto getBook(@PathVariable Long id) {
        Optional<Book> book = bookRepository.findById(id); // 查找书籍
        if (book.isPresent()) {
            return new ResponseDto(true, book.get(), "ok"); // 若找到则返回信息
        } else {
            return new ResponseDto(false, null, "book not found"); // 找不到则返回错误信息
        }
    }

    // 定义了获取所有书籍的接口方法，路由为 /list
    @GetMapping("/list")
    public ResponseDto listEmployees() {
        List<Book> books = bookRepository.findAll(); // 获取所有书籍信息
        return new ResponseDto(true, books, "ok"); // 返回所有书籍信息
    }

    // 定义了更改书籍信息的接口方法，路由为 /update/{id}，使用POST方法
    @PostMapping("/update/{id}")
    public ResponseDto updateBook(@PathVariable Long id, @RequestBody Book book) {

        Optional<Book> existingBook = bookRepository.findById(id); // 查找书籍
        if (existingBook.isPresent()) {

            book.setId(id); // 设定书籍ID
            bookRepository.save(book); // 保存书籍信息
            return new ResponseDto(true, null, "ok"); // 返回成功信息
        } else {
            return new ResponseDto(false, null, "book not found"); // 若找不到则返回错误信息
        }
    }

//    @GetMapping("/export")
//    public void export(HttpServletResponse response) throws IOException {
//        // 获取所有书籍信息
//        List<Book> books = bookRepository.findAll();
//
//        // 检查 books 列表是否为空
//        if (books.isEmpty()) {
//            System.out.println("No books found in the repository.");
//            return;
//        }
//
//        // 创新新的 ExportParams 对象
//        ExportParams exportParams = new ExportParams();
//        exportParams.setTitle("id");
//
//        // 创建 Workbook
//        Workbook workbook = ExcelExportUtil.exportExcel(exportParams, Book.class, books);
//
//        // 检查 workbook 是否成功创建
//        if (workbook == null) {
//            System.out.println("Workbook creation failed.");
//            return;
//        }
//
//        // 修改 response 的类型和头部信息以确保它会被识别为一个待下载的 Excel 文件
//        response.setContentType("application/vnd.ms-excel");
//        response.setHeader("Content-Disposition", "attachment;filename=books.xlsx");
//        response.setCharacterEncoding("UTF-8");
//
//        // 将 Workbook 写入到 response 的输出流中
//        workbook.write(response.getOutputStream());
//
//        // 最后，记得关闭 workbook 和 输出流
//        workbook.close();
//        response.getOutputStream().close();
//    }

    @GetMapping("/export")
    public void export(HttpServletResponse response) throws IOException {
        // 获取所有书籍信息
        List<Book> books = bookRepository.findAll();

        // 检查 books 列表是否为空
        if (books.isEmpty()) {
            System.out.println("No books found in the repository.");
            return;
        }

        // 创建Workbook
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Books");

        // 创建表头
        String[] header = {"Id", "Name", "Type", "Author", "Email", "Address", "Publishing", "Code", "Release-date", "Price"};
        Row headerRow = sheet.createRow(0);
        for (int i = 0; i < header.length; i++) {
            Cell headerCell = headerRow.createCell(i);
            headerCell.setCellValue(header[i]);
        }

        // 填充数据
        int rowNum = 1;
        for (Book book : books) {
            Row row = sheet.createRow(rowNum++);

            row.createCell(0).setCellValue(book.getId());
            row.createCell(1).setCellValue(book.getName());
            row.createCell(2).setCellValue(book.getType());
            row.createCell(3).setCellValue(book.getAuthor());
            row.createCell(4).setCellValue(book.getEmail());
            row.createCell(5).setCellValue(book.getAddress());
            row.createCell(6).setCellValue(book.getPublishing());
            row.createCell(7).setCellValue(book.getCode());
            row.createCell(8).setCellValue(book.getRelease_date().toString());
            row.createCell(9).setCellValue(book.getPrice());
        }

        // 修改 response 的类型和头部信息以确保它会被识别为一个待下载的 Excel 文件
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment;filename=books.xlsx");
        response.setCharacterEncoding("UTF-8");

        // 将 Workbook 写入到 response 的输出流中
        workbook.write(response.getOutputStream());

        // 最后，记得关闭 workbook 和 输出流
        workbook.close();
        response.getOutputStream().close();
    }
}