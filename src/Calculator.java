public class Calculator
{
    public static String calculatorBMI(double wei, double hei)
    {
        //Calculator BMI value.
        double bmi = wei / (Math.pow((hei / 100), 2));
        return String.format("%.1f", bmi);
    }
}
