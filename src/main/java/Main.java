public class Main {

    public static void main(String[] args) {
        Matrix matrix = new Matrix(4, 6);

        matrix.write(0, 5);
        matrix.write(1, 5);
        matrix.write(2, 5);
        matrix.write(3, 5);
        matrix.write(4, 5);
        matrix.write(5, 5);
        matrix.write(6, 5);
        matrix.write(7, 5);
        matrix.write(8, 5);
        matrix.write(9, 5);
        matrix.write(10, 5);

        System.out.println("Read directly from disk: ");
        matrix.show();
        new FileDisk(10);
        new FileDisk(10);
        new FileDisk(10);
    }
}
