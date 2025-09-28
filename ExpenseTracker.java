import java.io.*;
import java.util.ArrayList;

public class ExpenseTracker {
    private ArrayList<Expense> expenses;

    public ExpenseTracker() {
        this.expenses = new ArrayList<>();
    }

    // Simple Expense class to hold our data
    static class Expense {
        String date;
        String category;
        double amount;
        String description;

        Expense(String date, String category, double amount, String description) {
            this.date = date;
            this.category = category;
            this.amount = amount;
            this.description = description;
        }

        @Override
        public String toString() {
            return String.format("%s | %-12s | $%7.2f | %s",
                    date, category, amount, description);
        }

    }

    /**
     * Creates an Expense object from a string containing a
     * date, category, amount, and description separated by commas
     * @param parts the comma-separated string
     * @return an Expense containing the data from the string
     */
    private Expense expenseFromLine(String[] parts) {
        String date = parts[0].trim();
        String category = parts[1].trim();
        double amount = Double.parseDouble(parts[2].trim());
        String description = parts[3].trim();

        return new Expense(date, category, amount, description);
    }

    // STUDENTS WRITE THE FOLLOWING FUNCTION
    /**
     * Create an arraylist of Expense objects from a (csv) file of expense data
     * @param filename a CSV file with the expense data
     * @return an ArrayList of Expenses with the file data
     */
    public ArrayList<Expense> loadExpenses(String filename) {
        return void;
    }

    /**
     * Totals the expenses with a specific category name
     * @param categoryName name of category to total
     * @param expenses ArrayList of expenses
     * @return sum of amounts for expenses with given category name
     */
    public double getTotalForCategory(String categoryName, ArrayList<Expense> expenses) {
        double total = 0.0;
        for (Expense expense : expenses) {
            if (expense.category.equals(categoryName)) {
                total += expense.amount;
            }
        }
        return total;
    }

    /**
     * Loads expenses from a file and prints total amount for a category
     * @param filename the CSV file with the expense data
     * @param category which category to total
     */
    public void run(String filename, String category) {
        ArrayList<Expense> expenses = loadExpenses(filename);

        // Demonstrate the new methods
        if (!expenses.isEmpty()) {
            double total = getTotalForCategory(category, expenses);
            System.out.printf("%-15s: $%.2f%n", category, total);
        } else {
            System.out.println("No expenses found.");
        }
    }

    public static void main(String[] args) {
        // uncomment next line when ready to use via run configurations
        // new ExpenseTracker().run(args[0], args[1]);
        new ExpenseTracker().run("solution-code/src/data/expenses1.csv", "food");
        new ExpenseTracker().run("solution-code/src/data/expenses1.csv", "gas");
    }
}