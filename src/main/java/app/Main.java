package app;
import model.Book;
import model.Member;
import services.LibrarySystem;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LibrarySystem librarySystem = new LibrarySystem();
        librarySystem.addMember(new Member(1, "John", "john@mail.com"));
        librarySystem.addMember(new Member(2, "Emma", "emma@mail.com"));

        librarySystem.addBook(new Book(101, "Java Basics", "Alex", "Programming"));
        librarySystem.addBook(new Book(102, "OOP Mastery", "Bob", "Programming"));

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Library Menu ===");
            System.out.println("1. Display all books");
            System.out.println("2. Display all members");
            System.out.println("3. Borrow a book");
            System.out.println("4. Return a book");
            System.out.println("5. Add a new book");
            System.out.println("6. Add a new member");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");

            int choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (choice) {
                case 1: {
                    
                    librarySystem.displayAllBooks();
                    break;
                }

                case 2: {

                    librarySystem.displayAllMembers();
                    break;
                }
                case 3: {
                    System.out.print("Enter your Member ID: ");
                    int memberId = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Book ID to borrow: ");
                    int bookId = sc.nextInt();
                    sc.nextLine();
                    librarySystem.borrowABook(memberId,bookId);
                    break;
                }
                case 4: {
                    System.out.print("Enter your Member ID: ");
                    int memberId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Book ID to return: ");
                    int bookId = sc.nextInt();
                    sc.nextLine();

                    librarySystem.returnABook(memberId, bookId);
                    break;
                }
                case 5: {
                    System.out.print("Enter Book ID: ");
                    int newBookId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Book Title: ");
                    String title = sc.nextLine();

                    System.out.print("Enter Author: ");
                    String author = sc.nextLine();

                    System.out.print("Enter Category: ");
                    String category = sc.nextLine();

                    librarySystem.addBook(new Book(newBookId, title, author, category));
                    System.out.println("New book added successfully!");
                    break;
                }
                case 6: {
                    System.out.print("Enter Member ID: ");
                    int memberId = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Member Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Member Email: ");
                    String email = sc.nextLine();

                    librarySystem.addNewMember(memberId, name, email);
                    break;
                }
                case 7:
                    System.out.println("Goodbye!");
                    return;

                default:
                    System.out.println("Invalid choice, try again.");
            }
        }
    }
}

