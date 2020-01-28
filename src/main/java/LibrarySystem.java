import  java.util.*; //importing package to use java utilities

public class LibrarySystem {   //declaring java class
    public static void main(String[] args) { //starting of main executable method

        Scanner scanner = new Scanner(System.in);                   // creating object of Scanner class to read input from keyboard
        int num;int lastChoice = 1; //int menuChoice;                                       // declaration of variables
        System.out.println("Enter number of books to record: ");
        num = scanner.nextInt();
        String bookTitles[] = new String[num];                         // declaration of arrays
        int copies[] = new int[num];
        for(int i=0; i<num; i++){                                       // loop to get data for required arrays
            System.out.println("Enter the title of the book: ");
            bookTitles[i] = scanner.next();
            System.out.println("Enter the number of book ' " + bookTitles[i] + " ' ");
            copies[i] = scanner.nextInt();
        }
        int menuChoice;
        do {
            menuChoice = showMenu();                              // calling method to show menu
            switch (menuChoice) {
                case 0:
                    System.out.println("End of Transactions");
                    break;
                case 1:                                                     // checking menu input and proceeding accordingly
                    // Borrow a book
                    borrowBook(bookTitles, copies, num);
                    break;
                case 2:
                    //Return a book
                    returnBook(bookTitles, copies, num);
                    break;
                case 3:
                    findUnavailableBooks(bookTitles, copies, num);
                    break;
                case 4:
                    findBookByTitle(bookTitles, copies, num);
                    break;
                case 5:
                    findBooksWithCopies(bookTitles, copies, num);
                default:
                    // /terminate the system
                    System.out.println("You Entered the wrong choice. Please Choose from available options: ");
                    break;
            }
        }while (menuChoice != 0);

//        if({
//            showMenu();
//        }


    }//end of main method
    //method for displaying Last menu
    public  static int showLastChoice()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter '0' to proceed more or press any key to Terminate");
        int lastChoice;
        lastChoice = scanner.nextInt();
        return lastChoice;
    }
    //method for displaying menu
    public static int showMenu(){
        Scanner scanner = new Scanner(System.in);
        int choice;
        System.out.println("\n-------***** Choose an option to proceed further ****----------\n");
        System.out.println(" 1. Borrow a Book \n 2. Return a Book \n 3. Find Unavialable Books"+
                "\n 4. Find book by Title \n 5. Find Books having Less than 5 Copies \n  0. Terminate");
        choice = scanner.nextInt();
        return choice;
    }
    //menu for executing borrowing book option
    public static void borrowBook(String bookTitles[], int copies[], int size){
        Scanner scanner = new Scanner(System.in);
        for(int i=0; i<size; i++){
            System.out.println(" *  "+bookTitles[i] );
        }
        System.out.println("Enter the title of the book to borrow: ");
        String bookRquested;
        bookRquested = scanner.next();
        for(int i=0; i<size; i++){
            if(bookTitles[i].equalsIgnoreCase(bookRquested)) {                      //finding requested book in array
                if (!(copies[i] <= 0)) {
                    System.out.println("Number of copies available was " + copies[i]);
                    //int n =  copies[i];
                    copies[i] = copies[i] - 1;                                      // decrementing number of available books
                    System.out.println("You are borrowing " + bookTitles[i]);
                    System.out.println("Number of copies available is " + copies[i]);
                } else {
                    System.out.println("Sorry!!! The requested book is not available");
                }
            }
        }
    }
    //method for executing returning book option
    public static void returnBook(String bookTitles[], int copies[], int size){
        Scanner scanner = new Scanner(System.in);
        for(int i=0; i<size; i++){
            System.out.println(" *  "+bookTitles[i] );
        }
        System.out.println("Enter the title of the book to return: ");
        String returnedBook;
        returnedBook = scanner.next();
        for(int i=0; i<size; i++){
            if(bookTitles[i].equalsIgnoreCase(returnedBook)){                       //finding requested book in array
                System.out.println("Number of copies available was " + copies[i]);
                //int n =  copies[i];
                copies[i]=copies[i]+1;                                               // Incrementing number of available books
                System.out.println( bookTitles[i]+ "book is returned");
                System.out.println("Number of copies available is " + copies[i]);
                //}
            }

        }
    }
   public static void findUnavailableBooks(String bookTitles[], int copies[], int size){
       for(int i=0; i<size; i++){
//           if(copies[i]==0){
//               System.out.println("All recorded books are available" );
////               break;
//           }
           System.out.println("Unavailable books are : \n" );
           if (copies[i]!=0){
               System.out.println(" *  "+bookTitles[i] );
           }


       }
   }
   //method to search book by title
   public static void findBookByTitle(String bookTitles[], int copies[], int size){
       Scanner scanner = new Scanner(System.in);
       System.out.println("Enter the title of the book to find: ");
       String book;
       book = scanner.next();
       for(int i=0; i<size; i++){
           if(bookTitles[i].equalsIgnoreCase(book)){                       //finding requested book in array
               System.out.println("You were searching for ' "+ bookTitles[i]+ " ' ");
               System.out.println("Number of copies available is " + copies[i]);
               //}
           }
       }
   }
   // method to find books having copies less than 5
    public static void findBooksWithCopies(String bookTitles[], int copies[], int size){
        int book =0;
        for(int i=0; i<size; i++){
            if(copies[i]<5){
                book++;
            }
        }
        System.out.println(book+ " have less than 5 copies");
    }

} //end of class
