import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Student[] students = {
                new Student("Hedi", 123456, 50),
                new Student("Mahdi", 123457, 76),
                new Student("Ahmed", 123458, 80),
                new Student("Fares", 123459, 100)
        };
        Professor[] professors = {
                new Professor("Lamjed", 258369, "Calculus1"),
                new Professor("Mohamed", 258370, "ClassicalMechanics"),
                new Professor("Mounir", 258371, "IntroductionToProgramming"),
        };
        Book[] books = {
                new Book("Programming",123 , 3.5),
                new Book("Physics", 124, 4.0),
                new Book("Calculus", 125, 4.5)
        };
        int quit = 0;
        while(quit == 0){
            students = sortStudents(students);
            professors = sortProfessors(professors);
            books = sortBooks(books);
            System.out.println("""
                    Welcome to the University Database, please choose a number to continue:
                    1: Find student\s
                    2: Find professor
                    3: Find book
                    ----------------
                    4: Add student
                    5: Add professor
                    6: Add book
                    ----------------
                    7: Max grade
                    8: Min grade
                    9: Average grade
                    10: Threshold
                    11: Return Book for students
                    12: Reserve Book for students
                    13: Quit""");
            Scanner stdin=new Scanner(System.in);
            int menu = stdin.nextInt();
            switch (menu) {
                case 1 -> {
                    String studName;
                    System.out.println("Enter the name of the student: \t");
                    studName = stdin.next();
                    System.out.println(findStudent(students, studName));
                }
                case 2 -> {
                    String profName;
                    System.out.println("Enter the name of the professor: \t");
                    profName = stdin.next();
                    System.out.println(findProfessor(professors, profName));
                }
                case 3 -> {
                    String bookName;
                    System.out.println("Enter the name of the book: \t");
                    bookName = stdin.next();
                    System.out.println(findBook(books, bookName));
                }
                case 4 -> {
                    Student newStudent = new Student();
                    System.out.print("The name of the Student:\t");
                    newStudent.setName(stdin.next());
                    System.out.print("The id of the Student:\t");
                    newStudent.setId(stdin.nextInt());
                    System.out.print("The grade of the Student:\t");
                    newStudent.setGrade(stdin.nextInt());
                    students = addStudent(newStudent, students);
                    System.out.println("Student added successfully.");
                }
                case 5 -> {
                    Professor newProfessor = new Professor();
                    System.out.print("The name of the Professor:\t");
                    newProfessor.setName(stdin.next());
                    System.out.print("The id of the Professor:\t");
                    newProfessor.setId(stdin.nextInt());
                    System.out.print("The course of the Professor:\t");
                    newProfessor.setCourse(stdin.next());
                    professors = addProfessor(newProfessor, professors);
                    System.out.println("Professor added successfully.");
                }
                case 6 -> {
                    Book newBook = new Book();
                    System.out.print("The title of the Book:\t");
                    newBook.setTitle(stdin.next());
                    System.out.print("The id of the Book:\t");
                    newBook.setId(stdin.nextInt());
                    System.out.println("The rating of the Book:\t");
                    newBook.setRate(stdin.nextDouble());
                    books = addBook(newBook, books);
                    System.out.println("Book added successfully.");
                }
                case 7 -> System.out.println("The student with the maximum grade: " + maxGrade(students));
                case 8 -> System.out.println("The student with the minimum grade: " + minGrade(students));
                case 9 -> System.out.println("Average grade: " + averageGrade(students));
                case 10 -> {
                    int min;
                    System.out.println("The threshold:\t");
                    min = stdin.nextInt();
                    threshold(students, min);
                }
                case 11 ->{
                    System.out.print("The name of the person:\t");
                    String name = stdin.next();
                    System.out.print("The title of the book\t");
                    String title = stdin.next();

                    Student student = findStudent(students, name);
                    Book book = findBook(books, title);
                    if (student != null && book != null) {
                        if (book.getOwner() == student) {
                            book.setOwner(null);
                            for (int i = 0; i < books.length; i++) {
                                if (books[i] == book) {
                                    books[i] = book;
                                    break;
                                }
                            }
                            System.out.println(student.getName() + " returned the book.");
                        } else {
                            System.out.println("This book was not reserved by " + student.getName());
                        }
                    } else {
                        System.out.println("Student or book not found.");
                    }
                }
                case 12 -> {
                    System.out.print("Enter the name of the person: ");
                    String studentName = stdin.next();
                    System.out.print("Enter the title of the book to reserve: ");
                    String bookTitle = stdin.next();

                    Student student = findStudent(students, studentName);
                    Book book = findBook(books, bookTitle);

                    if (student != null && book != null) {
                        if (book.getAvailability()) {
                            book.setOwner(student);
                            for (int i = 0; i < books.length; i++) {
                                if (books[i] == book) {
                                    books[i] = book;
                                    break;
                                }
                            }
                            System.out.println("Book reserved successfully by " + student.getName());
                        } else {
                            System.out.println("Sorry, the book is already reserved.");
                        }
                    } else {
                        System.out.println("Student or book not found.");
                    }
                }
                case 13 -> quit = 1;
            }
        }
    }
    public static Student[] addStudent(Student newStudent, Student[] students){
        Student[] t = new Student[students.length + 1];
        for(int i = 0; i < students.length; i++){
            t[i] = students[i];
        }
        t[students.length] = newStudent;
        return t;
    }

    public static Professor[] addProfessor(Professor newProfessor, Professor[] professors){
        Professor[] t = new Professor[professors.length + 1];
        for(int i = 0; i < professors.length; i++){
            t[i] = professors[i];
        }
        t[professors.length] = newProfessor;
        return t;
    }

    public static Book[] addBook(Book newBook, Book[] books){
        Book[] t = new Book[books.length + 1];
        for(int i = 0; i < books.length; i++){
            t[i] = books[i];
        }
        t[books.length] = newBook;
        return t;
    }

    public static Student findStudent(Student[] students, String name){
        for(Student s : students){
            if(name.equals(s.getName())){
                return s;
            }
        }
        return null;
    }

    public static Professor findProfessor(Professor[] professors, String name){
        for(Professor p : professors){
            if(name.equals(p.getName())){
                return p;
            }
        }
        return null;
    }

    public static Book findBook(Book[] books, String title){
        for(Book b : books){
            if(title.equals(b.getTitle())){
                return b;
            }
        }
        return null;
    }

    public static Student minGrade(Student[] students){
        int minGrade = students[0].getGrade();
        Student min = students[0];
        for(int i = 1; i < students.length; i++){
            if(students[i].getGrade() < minGrade){
                min = students[i];
                minGrade = students[i].getGrade();
            }
        }
        return min;
    }

    public static Student maxGrade(Student[] students){
        int maxGrade = students[0].getGrade();
        Student max = students[0];
        for(int i = 1; i < students.length; i++){
            if(students[i].getGrade() > maxGrade){
                max = students[i];
                maxGrade = students[i].getGrade();
            }
        }
        return max;
    }

    public static double averageGrade(Student[] students){
        double average = 0;
        for(Student s : students){
            average += s.getGrade();
        }
        return average / students.length;
    }

    public static void threshold(Student[] students, int minGrade){
        for(Student s : students){
            if(s.getGrade() >= minGrade){
                System.out.println(s);
            }
        }
    }

    public static Student[] sortStudents(Student[] students) {
        int n = students.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (students[j].getId() == students[minIndex].getId()) {
                    minIndex = j;
                }
            }

            Student temp = students[i];
            students[i] = students[minIndex];
            students[minIndex] = temp;
        }
        return students;
    }

    public static Professor[] sortProfessors(Professor[] professors) {
        int n = professors.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (professors[j].getId() == professors[minIndex].getId()) {
                    minIndex = j;
                }
            }

            Professor temp = professors[i];
            professors[i] = professors[minIndex];
            professors[minIndex] = temp;
        }
        return professors;
    }

    public static Book[] sortBooks(Book[] books) {
        int n = books.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (books[j].getId() == books[minIndex].getId()) {
                    minIndex = j;
                }
            }

            Book temp = books[i];
            books[i] = books[minIndex];
            books[minIndex] = temp;
        }
        return books;
    }
}