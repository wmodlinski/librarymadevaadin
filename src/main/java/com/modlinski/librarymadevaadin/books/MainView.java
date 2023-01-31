package com.modlinski.librarymadevaadin.books;

import com.modlinski.librarymadevaadin.books.domain.Book;
import com.modlinski.librarymadevaadin.books.service.BookService;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route
public class MainView extends VerticalLayout {

    private BookService bookService = BookService.getInstance();
    private Grid<Book> grid = new Grid<>(Book.class);

    public MainView() {
        grid.setColumns("title", "author", "publicationYear", "type");
        add(grid);
        setSizeFull();
        refresh();
    }

    public void refresh() {
        grid.setItems(bookService.getBooks());
    }
}