package ru.mail.diepieonostosia;

import java.text.DecimalFormat;
import java.text.*;

public class comNum {
    private double Re;
    private double Im;

    public comNum(){
        Re = 0;
        Im = 0;
    }
    public comNum(double x, double y){
        Re = x;
        Im = y;
    }
    public double getRe(){
        return Re;
    }
    public double getIm(){
        return Im;
    }

    public double getModul(){
        return Math.sqrt((Re)*(Re) + (Im)*(Im));
    }
    public double getArc(){ return Math.atan(Im/Re); }


    public void setRe(double x){ this.Re = x; }
    public void setIm(double y){ this.Im = y; }

    public void printAlgebricForm(){

        double eps = 0.0000000001;

        NumberFormat nf = new DecimalFormat("#.####");
        String outRe = nf.format(Re);
        String outIm = nf.format(Im);

        //System.out.println(outRe+ outIm +"*i");

        if(Math.abs(Re)<eps && Math.abs(Im)>eps){
            System.out.println(outIm +"*i");

        }else if(Math.abs(Re)>eps && Math.abs(Im)<eps){
            System.out.println(outRe);

        }else if(Math.abs(Re)<eps && Math.abs(Im)<eps){
            System.out.println("0");

        }else{
            if(Im < 0){
                System.out.println(outRe + outIm +"*i");
                //System.out.format("#.##", Re, Im);
            }else{
                System.out.println(outRe +"+"+outIm +"*i");
            }
        }
    }

    public void printGeometryForm(){
        double r = Math.sqrt((Re)*(Re) + (Im)*(Im));
        double fi = Math.atan(Im/Re);

        NumberFormat nf = new DecimalFormat("#.####");
        String out_r = nf.format(r);
        String out_fi = nf.format(fi);
        System.out.println("z = "+out_r+"*(cos("+out_fi+")+ i*sin("+out_fi+")");
    }

    public void printExpForm(){
        double r = Math.sqrt((Re)*(Re) + (Im)*(Im));
        double fi = Math.atan(Im/Re);

        NumberFormat nf = new DecimalFormat("#.####");
        String out_r = nf.format(r);
        String out_fi = nf.format(fi);
        System.out.print("Показательная форма записи: ");
        System.out.println("z = "+out_r+"*e^("+out_fi+"*i)");
    }

    public void printExpForm(double r, double fi){
        NumberFormat nf = new DecimalFormat("#.####");
        String out_r = nf.format(r);
        String out_fi = nf.format(fi);
        System.out.println("z = "+out_r+"*e^("+out_fi+"*i)");
    }

    public comNum soprNum(){
        comNum sopr = new comNum(Re, -1 * Im);
        return sopr;
    }

    public static comNum addition(comNum a, comNum b){
        comNum cm = new comNum(a.getRe() + b.getRe(), a.getIm() + b.getIm());
        System.out.print("Cумма = ");
        cm.printAlgebricForm();
        return cm;
    }

    public static comNum subtraction(comNum a, comNum b){
        comNum cm = new comNum(a.getRe() - b.getRe(), a.getIm() - b.getIm());
        System.out.print("Разность = ");
        cm.printAlgebricForm();
        return cm;
    }

    public static comNum multiplication(comNum a, comNum b){
        System.out.print("Произведение = ");
        comNum cm = new comNum();
        //alg
        cm.setRe(a.getRe()*b.getRe() - b.getIm()*a.getIm());
        cm.setIm(a.getRe()*b.getIm() + a.getIm()*b.getRe());
        cm.printAlgebricForm();
        return cm;
    }

    public static comNum dev(comNum a, comNum b){
        System.out.println("Деление");
        comNum cm = new comNum();
        try{
            if(b.getModul() == 0) throw new Exception("Деление на 0!");
        } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println(e.getMessage());
                    System.exit(-1);
        } finally {
            comNum soprB = new comNum();
            soprB = b.soprNum();
            double re = a.getRe()*soprB.getRe() - a.getIm()*soprB.getIm();
            double im = a.getRe()*soprB.getIm() + a.getIm()*soprB.getRe();
            double z2 = Math.pow(b.getModul(), 2);

            re = re/z2;
            im = im/z2;
            cm.setRe(re);
            cm.setIm(im);
            System.out.print("Результат: ");
            cm.printAlgebricForm();
        }
        return  cm;
    }



    public void mulByLy(comNum a, double l){
        comNum cm = new comNum();
        cm.setRe(a.getRe()*l);
        cm.setIm(a.getIm()*l);
        cm.printAlgebricForm();
        //exp fprm
        cm.printExpForm(cm.getModul(), cm.getArc());
    }
}
