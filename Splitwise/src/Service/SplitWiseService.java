package Service;

import enums.ExpenseType;
import model.expense.ExpenseData;
import model.split.Split;
import repository.ExpenseRepository;

import java.util.List;

public class SplitWiseService {
    ExpenseRepository expenseRepository;

    public SplitWiseService(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    public void addExpense(ExpenseType expenseType, String expensePaidBy, double amount,
                           List<Split> splits, ExpenseData expenseData) {
        expenseRepository.addExpense(expenseType, expensePaidBy, amount, splits, expenseData);
    }

    public void showBalance(String userName) {
        List<String> balances = expenseRepository.getBalance(userName);
        if (balances.isEmpty()) {
            System.out.println("No balances");
        } else {
            for (String balance : balances) {
                System.out.println(balance);
            }
        }
    }

    public void showBalances() {
        List<String> balances = expenseRepository.getBalances();
        if (balances.isEmpty()) {
            System.out.println("No balances");
        } else {
            for (String balance : balances) {
                System.out.println(balance);
            }
        }
    }
}
