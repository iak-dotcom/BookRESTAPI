package com.api.book.bootrestbook.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.book.bootrestbook.dao.BookRepository;
import com.api.book.bootrestbook.entitiies.Book;
@Service
public class BookService {
   @Autowired
   private BookRepository bookRepository;


    //We will create a fake service instead of database
   //   private static List<Book> list = new ArrayList<>();
   //   static{
   //      list.add(new Book(12,"The Book of Science","Imran Khan"));
   //      list.add(new Book(11,"Java","James"));
   //      list.add(new Book(16,"Python","John"));
   //   }
     //Get all books
     public List<Book> getAllBooks() {
      List<Book> list = (List<Book>)this.bookRepository.findAll();
        return list;
}
     //Get single book by id
     public Book getBookByid(int id) {
     Book book = null;
//     book = list.stream().filter(e -> e.getId() ==  id).findFirst().get();
     book= this.bookRepository.findById(id);

return book;
    }
    //adding the book
    public Book addBook(Book b) {
   Book result = bookRepository.save(b);
      // list.add(b);
      return result;
}
//delete the book
public void deleteBook(int bid) {
// list = list.stream().filter(book ->{
  //    if(book.getId()!= bid){
//       return true;
//    }else{
//       return false;
//    }
// }).collect(Collectors.toList());
bookRepository.deleteById(bid);
}
public void updateBook(Book book, int bookId) {
//   list=  list.stream().map(b->{
//       if(b.getId()==bookId){
//       b.setTitle(book.getTitle());
//       b.setAuthor(book.getAuthor());
//       }
//       return b;
//    }).collect(Collectors.toList());
book.setId(bookId);
bookRepository.save(book);
}
}