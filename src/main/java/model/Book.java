package model;
import model.Member;

public class Book {
    private int id;
    private String title;
    private String author;
    private String category;

    private boolean isAvailable;
    private Member borrowedBy;

    public Book(int id, String title, String author, String category) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.category = category;

        this.isAvailable = true;
        this.borrowedBy = null;
        }
    public int getId(){
        return id;
    }
    public String getTitle(){
        return title;
    }
    public String getAuthor(){
        return author;
    }
    public String getCategory(){
        return category;
    }
    public boolean isAvailable(){
        return isAvailable;
    }
    public Member getBorrowedBy(){
        return borrowedBy;
    }

    public boolean borrowBook(Member member){
        if (!isAvailable){
            System.out.println("Book is already borrowed");
            return false;
        }
            this.isAvailable = false;
            this.borrowedBy = member;
            return true;
    }
    public boolean returnBook(){
        if (isAvailable){
            System.out.println("Book is not borrowed");
            return false;
        }

        this.isAvailable = true;
        this.borrowedBy = null;
        return true;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Book { ");
        sb.append("Title: ").append(title).append(", ");
        sb.append("Author: ").append(author).append(", ");
        sb.append("Category: ").append(category).append(", ");

        if (isAvailable) {
            sb.append("Status: Available");
        } else {
            sb.append("Status: Borrowed by ").append(borrowedBy.getName());
        }

        sb.append(" }");
        return sb.toString();
    }


}
