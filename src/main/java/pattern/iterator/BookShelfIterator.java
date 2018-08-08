package pattern.iterator;

/**
 * Created by adimn on 2018/8/8.
 */
public class BookShelfIterator implements Iterator {
    private  BookShelf bookShelf;
    private Integer index;

    public BookShelfIterator(BookShelf bookShelf){
        this.bookShelf = bookShelf;
        index = 0;
    }

    @Override
    public Boolean hasNext() {
        Integer length = bookShelf.getLength();
        if(index<length){
            return true;
        }
        return false;
    }

    @Override
    public Object next() throws Exception{
        Book bookAt = bookShelf.getBookAt(index);
        index++;
        return bookAt;
    }


    public static void main(String[] args) {
        BookShelf bf = new BookShelf();
        Book haryOne = new Book("harry potter one");
        Book haryTwo = new Book("harry potter two");
        Book haryThree = new Book("harry potter three");
        bf.addBook(haryOne);
        bf.addBook(haryTwo);
        bf.addBook(haryThree);
        Iterator it = bf.iterator();
        while(it.hasNext()){
            try {
                Book next = (Book) it.next();
                System.out.println(next.getName());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
