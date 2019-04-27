public class ArrayDisk extends Disk{

    private Integer[] array;

    public ArrayDisk(int size) {
        array = new Integer[size];
        for (int i = 0; i < size; i++) {
            array[i] = 0;
        }
    }

    @Override
    public Integer write(Object input, int position) {
        if (position >= 0 && position < array.length) {
            array[position] = (Integer)input;
            return 0;//OK
        } else throw new ArrayIndexOutOfBoundsException();
    }

    @Override
    public Integer read(int position) {
        if (position >= 0 && position < array.length)
            return array[position];
        else throw new ArrayIndexOutOfBoundsException();
    }
}
