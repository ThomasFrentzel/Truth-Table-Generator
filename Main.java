package com.company;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String formula;
        boolean isTableValid = false;

        TruthTable truthTable = new TruthTable();

        System.out.print("Enter the formula: ");
        formula = input.nextLine();
        formula = formula.toLowerCase();

        switch(formula.length()) {
            case 1:
                isTableValid = truthTable.findFormulaWith1Variable(formula);
                break;
            case 2:
                isTableValid = truthTable.findFormulaWith1Variable(formula);
                break;
            case 3:
                isTableValid = truthTable.findFormulaWith2Variables(formula);
                break;
            case 4:
                isTableValid = truthTable.findFormulaWith2Variables(formula);
                break;
            case 5:
                if (formula.equals("~p^~q") || formula.equals("~pv~q")) {
                    isTableValid = truthTable.findFormulaWith2Variables(formula);
                    break;
                } else {
                    isTableValid = truthTable.findFormulaWith3Variables(formula);
                    break;
                }
            case 6:
                isTableValid = truthTable.findFormulaWith3Variables(formula);
                break;
            case 7:
                isTableValid = truthTable.findFormulaWith3Variables(formula);
                break;
            case 8:
                isTableValid = truthTable.findFormulaWith3Variables(formula);
            default:
                isTableValid = false;
        }
        
        if (!isTableValid)
            input.close();
    }
}
