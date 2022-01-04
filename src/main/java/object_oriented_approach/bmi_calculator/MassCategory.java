package object_oriented_approach.bmi_calculator;

import java.util.HashMap;
import java.util.Map;

public enum MassCategory {
    Underweight(0,0),    //lower limits of mass in kg, bmi
    Healthy(60,18.5),
    Overweight(80,25d),
    Obesity(100,30d);

    private static final Map<MassCategory,Integer> BY_MASS = new HashMap<>();
    private static final Map<MassCategory, Double> BY_BMI = new HashMap<>();

    static {
        for (MassCategory e : values()) {
            BY_MASS.put(e,e.mass);
            BY_BMI.put(e,e.bmi);
        }
    }

    public final int mass;
    public final double bmi;

    MassCategory(int mass, double bmi) {
        this.mass = mass;
        this.bmi = bmi;
    }


    public static int  massLimit(MassCategory c) {
        return BY_MASS.get(c);
    }

    public static double bmiLimit(MassCategory c) {
        return BY_BMI.get(c);
    }
}


