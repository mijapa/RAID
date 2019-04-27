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

    public void initializeDisk(){
        disks = new ArrayDisk[numberOfDisks];
        for (int i = 0; i < numberOfDisks; i++) {
            disks[i] = new ArrayDisk(sizeOfDisks);
        }
    }

    @Override
    public Integer write(Object position, int input) {
        int chosenDisk = (Integer) position % numberOfDisksForData; //means column for table
        int placeOnDiskForData = (Integer) position / numberOfDisksForData; //means row for table
        int placeParity = placeOnDiskForData % numberOfDisks;

        //write real data
        if (chosenDisk >= placeParity)
            disks[chosenDisk + 1].write(input, placeOnDiskForData);
        else
            disks[chosenDisk].write(input, placeOnDiskForData);
        //write parity
        disks[placeParity].write(parityValue((Integer)position), placeOnDiskForData);
        return 0;
    }

    private int parityValue(int position) {
        int placeOnDiskForData = position / numberOfDisksForData;
        int placeParity = placeOnDiskForData % numberOfDisks;
        int sum = 0;

        for (int i = 0; i < numberOfDisks; i++) {
            if (i == placeParity)
                continue;
            sum += (Integer)disks[i].read(placeOnDiskForData);
        }
        return sum % 2;
    }

//    IT'S BUG FOR ME, SHOW2() METHOD SHOWS WHAT IS INSIDE ALL MATRIX, SOLUTION BELOW  /Dominika
//    public int read(int position) {
//        return disks[position % (disks.length - 1)].read(position / (disks.length - 1));
//    }

    //TODO check this (run Main.java)
    @Override
    public Integer read(int position) {
        int placeOnDisk = position / numberOfDisks;
        return (Integer)disks[position % numberOfDisks].read(placeOnDisk);
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

    public void show2(){
        for(int i = 0; i < sizeOfDisks * numberOfDisks; i++){
            if(i % numberOfDisks == 0) System.out.println();
            System.out.print(read(i) + " ");
        }
    }

}
