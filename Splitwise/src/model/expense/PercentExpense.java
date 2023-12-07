package model.expense;

import model.User;
import model.split.PercentSplit;
import model.split.Split;

import java.util.List;
import java.util.Objects;

public class PercentExpense extends Expense {
    public PercentExpense(Double amount, User expensePaidBy, List<Split> splits, ExpenseData expenseData) {
        super(amount, expensePaidBy, splits, expenseData);
    }

    @Override
    public boolean validate() {
        double totalPercent = 0D;
        for (Split split : getSplits()) {
            if (!(split instanceof PercentSplit percentSplit)) return false;
            totalPercent += percentSplit.getPercent();
        }
        return Objects.equals(totalPercent, 100D);
    }
}
