package in.parthi.common;

import java.util.Scanner;
import in.parthi.core.model.transaction.Transaction;

public enum TransactionCategory {
    TRAVEL, FOOD, SALARY, OPERATION_COST, SALES, INSTALLMENT, PRODUCT__COST, ACCESORIES, ADVERTISEMENT, CAMPAIGN_COST;

    public static void choose(Transaction transaction) {
        Scanner sc = Properties.getSacnnerInstance();
        int option;
        int i;
        do {
            i = 1;
            for (TransactionCategory tmp : TransactionCategory.values()) {
                System.out.println((i++) + "]\t" + tmp);

            }
            System.out.print("Choose your Option: ");
            option = sc.nextInt();

            if (option >= 1 && option <= TransactionCategory.values().length) {
                transaction.setTxnCategory(TransactionCategory.values()[option - 1]);
            } else {
                System.out.println("Please enter a valis option between 1-" + TransactionCategory.values().length);

            }

        } while (option < 1 || option > TransactionCategory.values().length);
    }
}
