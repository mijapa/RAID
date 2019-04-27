public class Disk {
    private Integer[] tab;

    public Disk(int size) {
        tab = new Integer[size];
        for (int i = 0; i < size; i++) {
            tab[i] = 0;
        }
    }

    public int diskWrite(int input, int position) {
        if (position >= 0 && position < tab.length) {
            tab[position] = input;
            return 0;//OK
        } else throw new ArrayIndexOutOfBoundsException();
    }

    public int diskRead(int position) {
        if (position >= 0 && position < tab.length)
            return tab[position];
        else throw new ArrayIndexOutOfBoundsException();
    }
}
