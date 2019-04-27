public interface InputOutput<T> {

    T write(T input, int position);

    T read(int position);

}
