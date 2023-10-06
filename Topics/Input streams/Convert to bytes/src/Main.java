import java.io.InputStream;

class Main {
    public static void main(String[] args) throws Exception {
        InputStream inputStream = System.in;
        byte[] arr = new byte[10000];
        int size = inputStream.read(arr);
        for(int i = 0; i < size; i++)
            System.out.print(arr[i]);
    }
}
