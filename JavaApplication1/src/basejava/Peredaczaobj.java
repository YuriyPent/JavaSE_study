package basejava;

public class Peredaczaobj {

    int b;

    public void method(Peredaczaobj x) {
        x.b = 5;
    }

    public static void main(String[] args) {
        Peredaczaobj ob = new Peredaczaobj();
        ob.b = 1;
        System.out.println("Before method: " + ob.b);
        ob.method(ob);
        System.out.println("After method: " + ob.b);
    }

}
