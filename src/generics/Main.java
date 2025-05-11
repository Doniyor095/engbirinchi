package generics;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        // Dasturlashda generics ni ishlatish dan asosiy maqsad qaysidir class yoki metodni
        // turli xil ob'ektlar uchun ishlatish.  Ya'ni biz yozgan class yoki metod umumiy bo'lishligi.
        //genericni biz quyidagilarga qollashimiz mumkin

        //Class larga
        //Metod larga
        //Interface larga

        // generic metodni yozilishi
        // public <T> T show (T a){}
        // bu yerda <T> bu metod qabuk qiladigan tip T esa return qiladigan tip

        // genericni classda ishlatlishi
        // class Classname<T>{}
        // classda ishlatganimizda undan obyekt olganimizda
        // bu obyekni qaysi tip uchun ishlatishimizni aytishimiz kerak

        // objec bn genericni farqi
       Box box = new Box();
       box.setValue("salom");

    }
    
}
class MyClass {
    public <T,V> void show(T a, V b){
        if (a.toString().equals(b.toString())){
            System.out.println("Ikkalasi teng");
        } else {
            System.out.println("Teng emas!!");
        }
    }
}
class MyClass2<T,Y extends Number>{
    T name;
    Y age ;

}

class Box {
    private Object value;

    public void setValue(Object value) {
        this.value = value;
    }

    public Object getValue() {
        return value;
    }
}

class Box1<T, Y > {
    private T value;

    public void setValue(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }
}
