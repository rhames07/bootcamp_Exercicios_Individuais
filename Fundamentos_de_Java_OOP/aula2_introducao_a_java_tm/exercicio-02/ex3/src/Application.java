public class Application {
    public static void main(String[] args){
        Book b1 = new Book("Harry Potter", "9780545582889", "Rowling, J. K.");
        Book b2 = new Book(b1);

        System.out.println("------ Empréstimo --------");
        b2.emprestimo();
        System.out.println(b2.toString());

        System.out.println("------ Devolver --------");
        b2.devolver();
        System.out.println(b2.toString());

    }
}
