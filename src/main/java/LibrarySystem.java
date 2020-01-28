import  java.util.*;

public class LibrarySystem {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int num; int menuChoice;
        System.out.println("Enter number of books to record: ");
        num = scanner.nextInt();
        String bookTitles[] = new String[num];
        int copies[] = new int[num];
        for(int i=0; i<num; i++){
            System.out.println("Enter the title of the book: ");
            bookTitles[i] = scanner.next();
            System.out.println("Enter the number of book " + bookTitles[i]);
            copies[i] = scanner.nextInt();
        }
        menuChoice = showMenu();
        switch (menuChoice){
            case 1:
                // Borrow a book
                borrowBook(bookTitles, copies, num);
            case 2:
                //Return a book
                returnBook(bookTitles, copies, num);
            default:
                // /terminate the system

    }
    }
    public static int showMenu(){
        Scanner scanner = new Scanner(System.in);
        int choice;
        System.out.println("-------***** Choose an option to proceed further ****----------\n");
        System.out.println("1. Borrow a Book \n 2. Return a Book ");
        choice = scanner.nextInt();
        return choice;
    }
    public static void borrowBook(String bookTitles[], int copies[], int size){
        Scanner scanner = new Scanner(System.in);
        for(int i=0; i<size; i++){
            System.out.println((i+1)+". "+bookTitles[i] );
        }
        System.out.println("Enter the title of the book to borrow: ");
        String bookRquested;
        bookRquested = scanner.next();
        for(int i=0; i<size; i++){
            if(bookTitles[i].equalsIgnoreCase(bookRquested)){
                System.out.println("Number of copies available is " + copies[i]);
                int n =  copies[i];
                copies[i]=copies[i]-1;
                System.out.println("You are borrowing " + bookTitles[i]);
                System.out.println("Number of copies available is " + copies[i]);
            }
//            else{
//                System.out.println("The requested book is not available");
//            }
        }
    }
    public static void returnBook(String bookTitles[], int copies[], int size){
        Scanner scanner = new Scanner(System.in);
        for(int i=0; i<size; i++){
            System.out.println((i+1)+". "+bookTitles[i] );
        }
        System.out.println("Enter the title of the book to return: ");
        String returnedBook;
        returnedBook = scanner.next();
        for(int i=0; i<size; i++){
            if(bookTitles[i].equalsIgnoreCase(returnedBook)){
                System.out.println("Number of copies available was " + copies[i]);
                //int n =  copies[i];
                copies[i]=copies[i]+1;
                System.out.println("You are returning " + bookTitles[i]);
                System.out.println("Number of copies available is " + copies[i]);
            }
//            else{
//                System.out.println("The requested book is not found");
//            }
        }
    }

}
