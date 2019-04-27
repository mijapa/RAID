import java.io.*;

public class FileDisk extends Disk {

    private File file;

    public FileDisk() {
        this.file = new File("file.txt");
        //file.createNewFile(); // if file already exists will do nothing
    }

    //TODO fix this method
    @Override
    public Character write(Object input, int position) {
        byte buffer[];
        try(RandomAccessFile raf =  new RandomAccessFile(file, "rw")){
            raf.seek(position);
            buffer = convertToBytes(input);
            raf.write(buffer);
            return 0;

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Character read(int position) {
        byte buffer[] = new byte[1];
        try(RandomAccessFile raf =  new RandomAccessFile(file, "r")){
            raf.seek(position);
            raf.read(buffer);
            return (char)buffer[0];
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public byte[] convertToBytes(Object object) throws IOException {
        try (ByteArrayOutputStream bos = new ByteArrayOutputStream();
             ObjectOutput out = new ObjectOutputStream(bos)) {
            out.writeObject(object);
            return bos.toByteArray();
        }
    }
}
