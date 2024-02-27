public class Calculator
{
    // Calculator BMI value.
    public static String calculatorBMI(double wei, double hei)
    {
        double bmi = wei / (Math.pow((hei / 100), 2));
        return String.format("%.1f", bmi);
    }
/* 

    // Calculator BMR Male value.
    public static String calculatorBMR(double wei, double hei, int age, String gender)
    {
        if (gender.equals("male")) {
            double BMRmale = (665 + (9.6 * wei) + (1.8 * hei) - (4.7 * age)) /3;
            return String.format("%.1f", BMRmale);
        } else if (gender.equals("female")) {
            double BMRFemale = (665 + (9.6 * wei) + (1.8 * hei) - (4.7 * age)) /3;
            return String.format("%.1f", BMRFemale);
        }
    }*/
}