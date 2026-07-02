import java.util.HashMap;
import java.util.Map;

public class FinancialForecasting {

    // Map to store computed results for memoization
    private static Map<Integer, Double> memo = new HashMap<>();

    // Recursive method with memoization to predict future value
    public static double predictFutureValue(double initialValue, double growthRate, int years) {
        // Base case: If no more years to predict, return the initial value
        if (years == 0) {
            return initialValue;
        }
        // Check if the result for this number of years is already memoized
        if (memo.containsKey(years)) {
            return memo.get(years);
        }

        // Recursive step: Calculate the value for the previous year and then apply growth
        double previousYearValue = predictFutureValue(initialValue, growthRate, years - 1);
        double currentValue = previousYearValue * (1 + growthRate);
        
        // Store the result in the memoization map
        memo.put(years, currentValue);
        
        return currentValue;
    }

    public static void main(String[] args) {
        double initialValue = 1000.0; // Initial investment
        double annualGrowthRate = 0.05; // 5% growth rate
        int numberOfYears = 10; // Predict for 10 years

        // We need to adjust the call to pass the initial value through the recursion
        // A better approach for this problem structure is often iterative, but to show memoization:
        // We can calculate the final value based on the initial value and years directly.
        
        // Let's define the function based on years from the start
        // f(n) = f(n-1) * (1 + growthRate)
        
        // To make the memoization more illustrative, let's start with a clear cache
        memo.clear();
        // Let's calculate the value at year 10 based on year 0 (initialValue)
        double futureValue = predictFutureValue(initialValue, annualGrowthRate, numberOfYears);

        System.out.printf("The predicted future value after %d years is: %.2f%n", numberOfYears, futureValue);

        // Demonstrate that memoization works by calling again (would be faster)
        // and for an intermediate value that is now cached
        memo.clear(); // clearing for clean demonstration
        predictFutureValue(initialValue, annualGrowthRate, 5);
        System.out.println("Value for 5 years (calculated and memoized): " + memo.get(5));
        predictFutureValue(initialValue, annualGrowthRate, 10); // this call will reuse the result for year 5
        System.out.println("Value for 10 years (reusing previous calculations): " + memo.get(10));

    }
}
