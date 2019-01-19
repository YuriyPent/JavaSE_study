package basejava;

public class peredaczaobj {

    int b;

    public void method(peredaczaobj x) {
        x.b = 5;
    }

    public static void main(String[] args) {
        peredaczaobj ob = new peredaczaobj();
        ob.b = 1;
        System.out.println("Before method: " + ob.b);
        ob.method(ob);
        System.out.println("After method: " + ob.b);
    }

}
