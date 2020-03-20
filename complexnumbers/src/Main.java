import ru.mail.diepieonostosia.*;


public class Main {
    public static void main(String [] args){
        comNum cn1 = new comNum(3,1);
        System.out.print("а  = ");
        cn1.printAlgebricForm();
        comNum cn2 = new comNum(2,-1);
        System.out.print("b = ");
        cn2.printAlgebricForm();
        comNum cn3 = new comNum();
        cn3 = comNum.dev(cn1, cn2);
        cn3.printExpForm();

        cn3 = comNum.addition(cn1, cn2);
        cn3 = comNum.subtraction(cn1, cn2);
        cn3 = comNum.multiplication(cn1, cn2);

    }
}
