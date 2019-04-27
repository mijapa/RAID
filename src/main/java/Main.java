public class Main {

    public static void main(String[] args) {
        Matrix matrix = new Matrix(4, 6);

        matrix.matrixWrite(0, 0);
        matrix.matrixWrite(1, 0);
        matrix.matrixWrite(2, 5);
        matrix.matrixWrite(3, 5);
        matrix.matrixWrite(4, 5);
        matrix.matrixWrite(5, 0);
        matrix.matrixWrite(6, 5);
        matrix.matrixWrite(7, 5);
        matrix.matrixWrite(8, 5);
        matrix.matrixWrite(9, 0);
        matrix.matrixWrite(10, 0);

        System.out.println("Read directly from disk: ");
        matrix.show();
        System.out.println("Read directly from matrix: ");
        matrix.show2();
    }
}
