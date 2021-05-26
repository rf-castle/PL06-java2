public class LambdaExpressionExercise {
    public static void main(String[] args) {
        LambdaExpressionExercise tester = new
                LambdaExpressionExercise();
        MathOperation thirdPower = (double x, double y) -> (x * x * x);
        MathOperation squareRoot = (double x, double y) -> Math.sqrt(x);
        MathOperation power = Math::pow;
        PassFailService passFailService1 = score -> {
            if(score >= 70){
                System.out.println("Pass");
            }
            else {
                System.out.println("Fail");
            }
        };

        passFailService1.showMessage(70);
        passFailService1.showMessage(50);
    }

    interface MathOperation {
        double operation(double  x, double y);
    }

    interface PassFailService{
        void showMessage(int score);
    }

    private double operate(
            double x, double y,
            MathOperation mathOperation)
    {
        return mathOperation.operation(x, y);
    }
}