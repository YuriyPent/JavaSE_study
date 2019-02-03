package basejava;

public class Mass1 {

    static int count(int[] xar)//метод возвращает размер массива
    {
        return xar.length;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6};

        System.out.println("The array size is: " + count(array));
//        try {
//            System.in.read();
//        } catch (Exception e) {
//        }
    }
}
