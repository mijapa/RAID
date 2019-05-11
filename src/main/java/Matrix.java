public class Matrix implements InputOutput {

    private Disk[] disks;
    private int numberOfDisks;
    private int numberOfDisksForData; // number of disk for real data eg. if you have 4 disks, 1 is always for checksum and 3 for real data
    private int sizeOfDisks;

    public Matrix(int numberOfDisks, int sizeOfDisks) {
        this.numberOfDisks = numberOfDisks;
        this.sizeOfDisks = sizeOfDisks;
        numberOfDisksForData = numberOfDisks - 1;
        initializeDisk();
    }

    public void initializeDisk() {
        disks = new FileDisk[numberOfDisks];
        for (int i = 0; i < numberOfDisks; i++) {
            disks[i] = new FileDisk(sizeOfDisks);
        }
    }

    @Override
    public int write(int position, int input) {
        int chosenDisk = position % numberOfDisksForData; //means column for table
        int placeOnDiskForData = position / numberOfDisksForData; //means row for table
        int placeParity = placeOnDiskForData % numberOfDisks;

        //write real data
        if (chosenDisk >= placeParity)
            disks[chosenDisk + 1].write(input, placeOnDiskForData);
        else
            disks[chosenDisk].write(input, placeOnDiskForData);
        //write parity
        disks[placeParity].write(parityValue(position), placeOnDiskForData);
        return 0;
    }

    private int parityValue(int position) {
        int placeOnDiskForData = position / numberOfDisksForData;
        int placeParity = placeOnDiskForData % numberOfDisks;
        int sum = 0;

        for (int i = 0; i < numberOfDisks; i++) {
            if (i == placeParity)
                continue;
            sum += disks[i].read(placeOnDiskForData);
        }
        return sum % 2;
    }

    //TODO check this (run Main.java)
    @Override
    public int read(int position) {
        int chosenDisk = position % numberOfDisksForData; //means column for table
        int placeOnDiskForData = position / numberOfDisksForData; //means row for table
        int placeParity = placeOnDiskForData % numberOfDisks;

        //write real data
        if (chosenDisk >= placeParity)
            return disks[chosenDisk + 1].read(placeOnDiskForData);
        else
            return disks[chosenDisk].read(placeOnDiskForData);
    }

    public void show() {
        for (int j = 0; j < sizeOfDisks; j++) {
            for (int i = 0; i < numberOfDisks; i++) {
                System.out.print(disks[i].read(j) + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public int[][] toArray() {
        int[][] tab = new int[sizeOfDisks][numberOfDisks];
        for (int j = 0; j < sizeOfDisks; j++) {
            for (int i = 0; i < numberOfDisks; i++) {
                tab[j][i] = disks[i].read(j);
            }
        }
        return tab;
    }
}
