package object_oriented_approach.bmi_calculator;

import java.util.HashMap;
import java.util.Map;

public enum Category {
    Underweight(0,0),
    Healthy(60,18.5),
    Overweight(80,25d),
    Obesity(100,30d);


    private static final Map<Category,Integer> BY_MASS = new HashMap<>();
    private static final Map<Category, Double> BY_BMI = new HashMap<>();

    static {
        for (Category e : values()) {
            BY_MASS.put(e,e.mass);
            BY_BMI.put(e,e.bmi);
        }
    }

    public final int mass;
    public final double bmi;

    private Category(int mass, double bmi) {
        this.mass = mass;
        this.bmi = bmi;
    }


    public static int  massLimit(Category c) {
        return BY_MASS.get(c);
    }

    public static double bmiLimit(Category c) {
        return BY_BMI.get(c);
    }
}


