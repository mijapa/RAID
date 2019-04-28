public class Main {

    public static void main(String[] args) {
        Matrix matrix = new Matrix(4, 6);

        matrix.write(0, 0);
        matrix.write(1, 0);
        matrix.write(2, 5);
        matrix.write(3, 5);
        matrix.write(4, 5);
        matrix.write(5, 0);
        matrix.write(6, 5);
        matrix.write(7, 5);
        matrix.write(8, 5);
        matrix.write(9, 0);
        matrix.write(10, 0);

        System.out.println("Read directly from disk: ");
        matrix.show();
        System.out.println("Read directly from matrix: ");
        matrix.show2();

        System.out.println();
        Disk disk = new FileDisk("file.txt");
        disk.write("z",3);
        System.out.println(disk.read(3));
    }
}
