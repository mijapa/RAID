public class Matrix {
    private Disk[] disks;
    private int numberOfDisks;
    private int numberOfDisksForData; // number of disk for real data eg. if you have 4 disks, 1 is always for checksum and 3 for real data
    private int sizeOfDisks;

    public Matrix(int numberOfDisks, int sizeOfDisks) {
        this.numberOfDisks = numberOfDisks;
        this.sizeOfDisks = sizeOfDisks;
        numberOfDisksForData = numberOfDisks - 1;
        initialize();
    }

    public void initialize(){
        disks = new Disk[numberOfDisks];
        for (int i = 0; i < numberOfDisks; i++) {
            disks[i] = new Disk(sizeOfDisks);
        }
    }

    public void matrixWrite(int position, int input) {
        int chosenDisk = position % numberOfDisksForData; //means column for table
        int placeOnDiskForData = position / numberOfDisksForData; //means row for table
        int placeParity = placeOnDiskForData % numberOfDisks;

        //write real data
        if (chosenDisk >= placeParity)
            disks[chosenDisk + 1].diskWrite(input, placeOnDiskForData);
        else
            disks[chosenDisk].diskWrite(input, placeOnDiskForData);
        //write parity
        disks[placeParity].diskWrite(parityValue(position), placeOnDiskForData);
    }

    private int parityValue(int position) {
        int placeOnDiskForData = position / numberOfDisksForData;
        int placeParity = placeOnDiskForData % numberOfDisks;
        int sum = 0;

        for (int i = 0; i < numberOfDisks; i++) {
            if (i == placeParity)
                continue;
            sum += disks[i].diskRead(placeOnDiskForData);
        }
        return sum % 2;
    }

//    IT'S BUG FOR ME, SHOW2() METHOD SHOWS WHAT IS INSIDE ALL MATRIX, SOLUTION BELOW  /Dominika
//    public int matrixRead(int position) {
//        return disks[position % (disks.length - 1)].diskRead(position / (disks.length - 1));
//    }

    //TODO check this (run Main.java)
    public int matrixRead(int position) {
        int placeOnDisk = position / numberOfDisks;
        return disks[position % numberOfDisks].diskRead(placeOnDisk);
    }

    public void show() {
        for (int j = 0; j < sizeOfDisks; j++) {
            for (int i = 0; i < numberOfDisks; i++) {
                System.out.print(disks[i].diskRead(j) + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void show2(){
        for(int i = 0; i < sizeOfDisks * numberOfDisks; i++){
            if(i % numberOfDisks == 0) System.out.println();
            System.out.print(matrixRead(i) + " ");
        }
    }

}
