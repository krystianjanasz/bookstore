package org.example.controller;

import org.example.component.Cart;
import org.example.entity.Book;
import org.example.entity.Category;
import org.example.services.AuthorService;
import org.example.services.BookService;

import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import org.example.services.CategoryService;
import org.example.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/books")
public class BookController {
    private BookService bookService;
    private CategoryService categoryService;
    private AuthorService authorService;
    private UserService userService;
    private Cart cart;

    @Autowired
    public void setBookService(BookService bookService){
        this.bookService = bookService;
    }

    @Autowired
    public void setCategoryService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Autowired
    public void setAuthorService(AuthorService authorService) {
        this.authorService = authorService;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setCart(Cart cart) {
        this.cart = cart;
    }

    @GetMapping("/list")
    public String list(Model model) {
        List<Book> books = bookService.getBooks();
        model.addAttribute("books", books);
        model.addAttribute("cart", cart);
        model.addAttribute("book", new Book());
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(userService.isAdmin(auth.getName()));
        if(userService.isAdmin(auth.getName())){
            return "books/admin-list";
        }
        return "books/list";
    }

    @PostMapping("/list")
    public String list_add(@ModelAttribute("book")Book book, Model model) {
        List<Book> books = bookService.getBooks();
        cart.addBookId(bookService.getBook(book.getId()));
        model.addAttribute("books", books);
        model.addAttribute("cart", cart);
        model.addAttribute("book", new Book());
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(userService.isAdmin(auth.getName()));
        return "redirect:/books/list";
    }

    @GetMapping("/add")
    public String add(Model model){
        model.addAttribute("book",new Book());
        model.addAttribute("categories", categoryService.getCategories());
        model.addAttribute("authors", authorService.getAuthors());
        return "books/form";
    }

    @PostMapping("/add")
    public String save(@ModelAttribute("book")Book book){
        bookService.saveBook(book);
        return "redirect:/books/list";
    }

    @GetMapping("/edit")
    public String edit(@RequestParam("bookId") int bookId, Model model) {
        Book book = bookService.getBook(bookId);
        List<Category> categories = categoryService.getCategories();
        model.addAttribute("book", book);
        model.addAttribute("categories", categories);
        model.addAttribute("authors", authorService.getAuthors());
        return "books/form";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("bookId") int bookId) {
        bookService.deleteBook(bookId);
        return "redirect:/books/list";
    }

    @GetMapping("/shopping-cart")
    public String cart(Model model){
        model.addAttribute("cart", cart);
        double price = 0;
        for(Book b: cart.getBooks()){
            price+=b.getPrice();
        }
        model.addAttribute("sumPrice", price);
        return "cart";
    }

    @GetMapping("/shopping-cart/delete")
    public String cart_delete(@RequestParam("bookId") int bookId){
        cart.deleteBookId(bookService.getBook(bookId));
        return "redirect:/books/shopping-cart";
    }
}
