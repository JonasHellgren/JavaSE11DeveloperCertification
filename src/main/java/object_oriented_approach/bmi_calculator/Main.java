package object_oriented_approach.bmi_calculator;

public class Main {

    public static void main(String[] args) {

        int mass = 95;
        MassCategoryEvaluator bmce = new MassCategoryBmiBased(mass);
        System.out.println("mass = " + mass + " is " + bmce.findCategory());

        mass = 65;
        bmce = new MassCategoryBmiBased(mass);   //polymorphism
        System.out.println("mass = " + mass + " is " + bmce.findCategory());

        double bmi = 22;
        bmce = new MassCategoryBmiBased(bmi);
        System.out.println("bmi = " + bmi + " is " + bmce.findCategory());

    }

}
