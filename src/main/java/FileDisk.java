import java.io.*;

public class FileDisk extends Disk {

    private File file;

    public FileDisk(String path) {
        this.file = new File(path);
        createFileIfNotExist();
    }

    private void createFileIfNotExist() {
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Character write(Object input, int position) {
        String in = input.toString();
        try(RandomAccessFile raf =  new RandomAccessFile(file, "rw")){
            raf.seek(position);
            raf.write(in.getBytes());
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

}
