public class ArrayDisk extends Disk{

    private Integer[] array;

    public ArrayDisk(int size) {
        array = new Integer[size];
        for (int i = 0; i < size; i++) {
            array[i] = 0;
        }
    }

    @Override
    public int write(int input, int position) {
        if (position >= 0 && position < array.length) {
            array[position] = input;
            return 0;//OK
        } else throw new ArrayIndexOutOfBoundsException();
    }

    @Override
    public int read(int position) {
        if (position >= 0 && position < array.length)
            return array[position];
        else throw new ArrayIndexOutOfBoundsException();
    }
}
