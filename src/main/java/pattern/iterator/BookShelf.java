package pattern.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by adimn on 2018/8/8.
 */
public class BookShelf implements Aggregate {
    private List books;
    private Book last;

    public BookShelf(){
        books = new ArrayList();
    }

    @Override
    public Iterator iterator() {
        return new BookShelfIterator(this);
    }

    public Book getBookAt(Integer i) throws Exception {
        if( i < books.size() ){
            return (Book) books.get(i);
        }
        throw new Exception("index out of bound !");
    }

    public void addBook(Book book){
        books.add(book);
    }

    public Integer getLength() {
        return books.size();
    }
}
