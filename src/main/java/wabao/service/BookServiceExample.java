package wabao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wabao.dao.BooksDao;
import wabao.pojo.books;

import java.util.List;

@Service
public class BookServiceExample implements BookService {

    @Autowired
    private BooksDao booksDao;
    @Override
    public List<books> searchBook() {
        return booksDao.SearchBooksAll();
    }

}
