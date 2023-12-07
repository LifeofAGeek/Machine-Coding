package model.expense;

import model.User;
import model.expense.ExpenseData;
import model.split.ExactSplit;
import model.split.Split;

import java.util.List;
import java.util.Objects;

public class ExactExpense extends Expense {
    public ExactExpense(Double amount, User expensePaidBy, List<Split> splits, ExpenseData expenseData) {
        super(amount, expensePaidBy, splits, expenseData);
    }

    @Override
    public boolean validate() {
        double totalAmount = 0D;
        for (Split split : getSplits()) {
            if (!(split instanceof ExactSplit exactSplit)) return false;
            totalAmount += exactSplit.getAmount();
        }
        return Objects.equals(totalAmount, getAmount());
    }
}
