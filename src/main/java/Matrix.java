public class Matrix {
    private Disk[] disks;
    private int sizeOfDisks;

    public Matrix(int numberOfDisks, int sizeOfDisks) {
        this.sizeOfDisks = sizeOfDisks;
        disks = new Disk[numberOfDisks];
        for (int i = 0; i < numberOfDisks; i++) {
            disks[i] = new Disk(sizeOfDisks);
        }
    }

    public void matrixWrite(int position, int input) {

        int parityColumn = position % (disks.length - 1);

        if (parityColumn >= ((position / (disks.length - 1)) % disks.length))
            disks[parityColumn + 1].diskWrite(input, position / (disks.length - 1));
        else
            disks[parityColumn].diskWrite(input, position / (disks.length - 1));

        disks[(position / (disks.length - 1)) % disks.length].diskWrite(parity(position), position / (disks.length - 1));
    }

    private int parity(int position) {
        int sum = 0;
        for (int i = 0; i < disks.length; i++) {
            if (i == (position / (disks.length - 1)) % disks.length) continue;
            sum += disks[i].diskRead(position / (disks.length - 1));
        }
        return sum % 2;
    }

    public int matrixRead(int position) {
        return disks[position % (disks.length - 1)].diskRead(position / (disks.length - 1));
    }

    public void show() {
        for (int j = 0; j < sizeOfDisks; j++) {
            for (int i = 0; i < disks.length; i++) {
                System.out.print(disks[i].diskRead(j) + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public int checkParityPosition(int row) {

        return 0;
    }
}
