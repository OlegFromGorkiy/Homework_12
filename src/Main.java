public class Main {
    public static void main(String[] args) {
        Library library = new Library(1);
        Book warAndPeace = new Book("Война и мир", new Author("Лев", "Толстой"), 1865);
        Book idiot = new Book("Идиот", new Author("Фёдор", "Достоевский"), 1869);
        Book theStand = new Book("The Stand", new Author("Stephen", "King"), 1978);
        Book newIdiot = new Book("Идиот", new Author("Фёдор", "Достоевский"), 1869);

        //Добавляем две книги, смотрим состав библиотеки
        library.addBook(warAndPeace);
        library.addBook(idiot);
        library.viewAll();
        System.out.println("***");
        //Запрашиваем информаци, не находим, добавляем и снова запрашиваем инфо
        library.bookInfo(theStand);
        library.addBook(theStand);
        library.bookInfo(theStand);
        System.out.println("***");
        //Добавляем имеющуюся книгу, меняем в имеющейся год, снова добавляем и
        //смотрим инфо.
        library.addBook(newIdiot);
        library.setYear(idiot, 1999);
        library.addBook(newIdiot);
        library.viewAll();
    }
}