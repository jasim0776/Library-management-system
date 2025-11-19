package model;
import java.util.ArrayList;
import java.util.List;
public class Member {
    private int id;
    private String name;
    private String email;
    private List<Book> borrowedBooks;

    public  Member(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.borrowedBooks = new ArrayList<>();
    }
    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public String getEmail(){
        return email;
    }
    public List<Book> getBorrowedBooks(){
        return borrowedBooks;
    }

    public boolean borrowBook(Book book){
        if (!book.isAvailable()){
            System.out.println("Book is not available");
            return false;
        }else{
            boolean success = book.borrowBook(this);
            if (success){
                borrowedBooks.add(book);
                return true;
            }else{
                return false;
            }
        }

    }

    public boolean returnBook(Book book){
        boolean hasBorrowedBook = borrowedBooks.contains(book);
        if (!hasBorrowedBook){
            System.out.println("The book was never borrowed");
            return false;
        }else {
            boolean success = book.returnBook();
            if (success){
                borrowedBooks.remove(book);
                return true;
            }else{
                return false;
            }

        }

    }
    public String printBorrowedBooks(){
        if (borrowedBooks.isEmpty()){
            return "No book was borrowed." ;
        }
            StringBuilder sb = new StringBuilder();
            sb.append("Borrowed Books:\n");
            for (Book book : borrowedBooks){
                sb.append("- ").append(book.getTitle()).append("\n");
            }
        return sb.toString();
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Member { ");
        sb.append("id: ").append(id).append(", ");
        sb.append("name: ").append(name).append(", ");
        sb.append("email: ").append(email).append(", ");
        sb.append("borrowedBooks = ").append(borrowedBooks.size());
        sb.append(" }");
        return sb.toString();
    }


}
