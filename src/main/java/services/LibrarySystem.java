package services;
import java.util.ArrayList;
import java.util.List;
import model.Book;
import model.Member;

public class LibrarySystem {
    private List<Book> books;
    private List<Member> members;
    public LibrarySystem() {
        books = new ArrayList<>();
        members = new ArrayList<>();
    }
    public void addBook(Book book){
        books.add(book);
    }
    public void addMember(Member member){
        members.add(member);
    }
    public Book findBookById(int Id){
        for (Book book : books) {
            if (book.getId()==Id){
                return book;
            }
        }
        return null;
    }
    public Member findMemberById(int Id){
        for (Member member : members) {
            if (member.getId()==Id){
                return member;
            }
        }
        return null;
    }
    public boolean borrowBook(int bookId, Member member){
        Book book = findBookById(bookId);
        if (book == null){
            System.out.println("Book not found");
            return false;
        }
        else if (!book.isAvailable()){
            System.out.println("Book is already borrowed by " + book.getBorrowedBy().getName());
            return false;
        }
        else{
            book.borrowBook(member);
            return true;
        }
    }
    public boolean returnBook(int bookId, Member member){
        Book book = findBookById(bookId);
        if (book == null){
            System.out.println("Book not found");
            return false;
        }
        else if (book.isAvailable()){
            System.out.println("Book was never borrowed");
            return false;
        } else if (member==book.getBorrowedBy()) {
            book.returnBook();
            return true;

        }
        else {
            System.out.println("You did not borrow this book");
            return false;
        }

    }
    public void displayAllBooks(){
        if(books.isEmpty()){
            System.out.println("There is no book available :( ");
            return;
        }else {
            for (Book book : books) {
                System.out.println("-------------------------------");
                System.out.println("Title    : " + book.getTitle());
                System.out.println("Author   : " +book.getAuthor());
                System.out.println("Category : " +book.getCategory());
                if (book.isAvailable()){
                    System.out.println("Status : Available");
                }else {
                    System.out.println("Status : Book is borrowed by " + book.getBorrowedBy().getName());
                }
                System.out.println();

            }

        }
    }
    public void displayAllMembers(){
        if (members.isEmpty()){
            System.out.println("There are no members registered");
            return;
        }
        for (Member member : members) {
            System.out.println(member);
        }
    }
    public void borrowABook(int memberId, int bookId){
        Member member = findMemberById(memberId);
        if (member == null) {
            System.out.println("Invalid Member ID.");
            return;
        }
        boolean success = borrowBook(bookId, member);

        if (success) {
            System.out.println("Book borrowed successfully.");
        } else {
            Book book = findBookById(bookId);

            if (book == null) {
                System.out.println("Book not found.");
            } else if (!book.isAvailable()) {
                System.out.println("Book is already borrowed by " + book.getBorrowedBy().getName());
            } else {
                System.out.println("Borrowing failed.");
            }
        }
    }
    public void returnABook(int memberId, int bookId) {
        Member member = findMemberById(memberId);

        if (member == null) {
            System.out.println("Invalid Member ID.");
            return;
        }

        boolean success = returnBook(bookId, member);

        if (success) {
            System.out.println("Book returned successfully.");
        } else {
            Book book = findBookById(bookId);

            if (book == null) {
                System.out.println("Book not found.");
            }
            else if (book.isAvailable()) {
                System.out.println("This book was never borrowed.");
            }
            else if (book.getBorrowedBy() != member) {
                System.out.println("You cannot return a book you did not borrow.");
            }
            else {
                System.out.println("Returning failed.");
            }
        }
    }
    public void addNewMember(int id, String name, String email) {
        if (findMemberById(id) != null) {
            System.out.println("A member with this ID already exists.");
            return;
        }

        Member newMember = new Member(id, name, email);
        addMember(newMember);
        System.out.println("Member added successfully!");
    }



}
