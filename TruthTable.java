package com.company;


public class TruthTable  {

    public char printBit(boolean p) {
        if (p)
            return 'T';
        else
            return 'F';
    }

    public void printFormula (String Correctformula) {
        System.out.print(" (" + Correctformula + ") ");
    }

    public void table1Literal(String Correctformula) {
        int i;

        boolean p, resp;

        System.out.println("+---+");
        System.out.print  ("| p |");
        printFormula (Correctformula);
        System.out.println();
        System.out.println("+---+");

        for (i = 1; i >= 0; i--) {

            switch (i) {
                case 1:
                    p = true;
                    break;
                default:
                    p = false;
            }


            resp = (Correctformula.charAt(0)=='~')? !p : p;
            System.out.print ("| " + printBit(p) + " |  ");
            System.out.println(printBit(resp) );

        }
        System.out.println("+----+");

    }

    public void table2Literal(String Correctformula) {
        int i;
        boolean p, q, resp = true;

        System.out.println("+---+---+");
        System.out.print  ("| p | q |");
        printFormula (Correctformula);
        System.out.println();
        System.out.println("+---+---+");
        for (i = 3; i >= 0; i--) {
            switch (i) {
                case 3:
                    p = true; q = true;
                    break;
                case 2:
                    p = true; q = false;
                    break;
                case 1:
                    p = false; q = true;
                    break;
                default:
                    p = false; q = false;
            }
            if (Correctformula.length() == 3)
                resp = Correctformula.charAt(1) == '^'? p && q: p || q;
            else if (Correctformula.length() == 4) {
                if (Correctformula.charAt(0)=='~')
                    resp = Correctformula.charAt(2) == '^'? (!p && q) : (!p || q);
                else if (Correctformula.charAt(2)=='˜')
                    resp = Correctformula.charAt(1) == 'ˆ'? (p && !q): (p || !q);
                else if (Correctformula.length() == 5) {
                }

            }

            System.out.print  ("| "    + printBit(p) + " | " + printBit(q) );
            System.out.println(" |  "  + printBit(resp) );
        }
        System.out.println("+----+---+");
    }


    public void table3Literal (String Correctformula) {
        int i;
        boolean p, q, r, resp = true;

        System.out.println("+-----+-----+-----+");
        System.out.println("|  p  |  q  |  r  |  "+ Correctformula );
        System.out.println("+-----+-----+-----+");

        for (i = 7; i >= 0; i--) {
            switch (i) {
                case 7:
                    p = true; q = true; r = true;
                    break;
                case 6:
                    p = true; q = true; r = false;
                    break;
                case 5:
                    p = true; q = false; r = true;
                    break;
                case 4:
                    p = true; q = false; r = false;
                    break;
                case 3:
                    p = false; q = true; r = true;
                    break;
                case 2:
                    p = false; q = true; r = false;
                    break;
                case 1:
                    p = false; q = false; r = true;
                    break;
                default:
                    p = false; q = false; r = false;
            }

            if (Correctformula.length() == 5) {
                //******************
                //Without denial
                //******************
                if ((Correctformula.charAt(1)) == '^' && (Correctformula.charAt(3) == '^'))
                    resp = p && q && r;
                else if ((Correctformula.charAt(1)) == '^' && (Correctformula.charAt(3) == 'v'))
                    resp = p && q || r;
                else if ((Correctformula.charAt(1)) == 'v' && (Correctformula.charAt(3) == 'v'))
                    resp = p || q || r;
                else if ((Correctformula.charAt(1)) == 'v' && (Correctformula.charAt(3) == '^'))
                    resp = p || q && r;
            } else if (Correctformula.length() == 6) {
                //******************
                //Only one denial
                //******************

                //EX: ~p^q^r
                if ((Correctformula.charAt(0)) == '~') {
                    if ((Correctformula.charAt(2)) == '^' && (Correctformula.charAt(4) == '^'))
                        resp = !p && q && r;
                    else if ((Correctformula.charAt(2)) == '^' && (Correctformula.charAt(4) == 'v'))
                        resp = !p && q || r;
                    else if ((Correctformula.charAt(2)) == 'v' && (Correctformula.charAt(4) == 'v'))
                        resp = !p || q || r;
                    else if ((Correctformula.charAt(2)) == 'v' && (Correctformula.charAt(4) == '^'))
                        resp = !p || q && r;
                }
                //EX: p^~q^r
                if ((Correctformula.charAt(2)) == '~') {
                    if ((Correctformula.charAt(1)) == '^' && (Correctformula.charAt(4) == '^'))
                        resp = p && !q && r;
                    else if ((Correctformula.charAt(1)) == '^' && (Correctformula.charAt(4) == 'v'))
                        resp = p && !q || r;
                    else if ((Correctformula.charAt(1)) == 'v' && (Correctformula.charAt(4) == 'v'))
                        resp = p || !q || r;
                    else if ((Correctformula.charAt(1)) == 'v' && (Correctformula.charAt(4) == '^'))
                        resp = p || !q && r;
                }

                //EX: p^q^~r
                if ((Correctformula.charAt(4)) == '~') {
                    if ((Correctformula.charAt(1)) == '^' && (Correctformula.charAt(3) == '^'))
                        resp = p && q && !r;
                    else if ((Correctformula.charAt(1)) == '^' && (Correctformula.charAt(3) == 'v'))
                        resp = p && q || !r;
                    else if ((Correctformula.charAt(1)) == 'v' && (Correctformula.charAt(3) == 'v'))
                        resp = p || q || !r;
                    else if ((Correctformula.charAt(1)) == 'v' && (Correctformula.charAt(3) == '^'))
                        resp = p || q && !r;
                }
                //******************
                //End - Only one denial
                //******************
            } else if (Correctformula.length() == 7) {
                //********************
                // 2 Denials
                //********************
                //EX: ~p^~q^r
                if ( ((Correctformula.charAt(0)) == '~') && ((Correctformula.charAt(3)) == '~') )  {
                    if ((Correctformula.charAt(2)) == '^' && (Correctformula.charAt(5) == '^'))
                        resp = !p && !q && r;
                    else if ((Correctformula.charAt(2)) == '^' && (Correctformula.charAt(5) == 'v'))
                        resp = !p && !q || r;
                    else if ((Correctformula.charAt(2)) == 'v' && (Correctformula.charAt(5) == 'v'))
                        resp = !p || !q || r;
                    else if ((Correctformula.charAt(2)) == 'v' && (Correctformula.charAt(5) == '^'))
                        resp = !p || !q && r;
                }

                //EX: ~p^q^~r
                if ( ((Correctformula.charAt(0)) == '~') && ((Correctformula.charAt(5)) == '~') )  {
                    if ((Correctformula.charAt(2)) == '^' && (Correctformula.charAt(4) == '^'))
                        resp = !p && q && !r;
                    else if ((Correctformula.charAt(2)) == '^' && (Correctformula.charAt(4) == 'v'))
                        resp = !p && q || !r;
                    else if ((Correctformula.charAt(2)) == 'v' && (Correctformula.charAt(4) == 'v'))
                        resp = !p || q || !r;
                    else if ((Correctformula.charAt(2)) == 'v' && (Correctformula.charAt(4) == '^'))
                        resp = !p || q && !r;
                }

                //EX: p^~q^~r
                if ( ((Correctformula.charAt(2)) == '~') && ((Correctformula.charAt(5)) == '~') )  {
                    if ((Correctformula.charAt(1)) == '^' && (Correctformula.charAt(4) == '^'))
                        resp = p && !q && !r;
                    else if ((Correctformula.charAt(1)) == '^' && (Correctformula.charAt(4) == 'v'))
                        resp = p && !q || !r;
                    else if ((Correctformula.charAt(1)) == 'v' && (Correctformula.charAt(4) == 'v'))
                        resp = p || !q || !r;
                    else if ((Correctformula.charAt(1)) == 'v' && (Correctformula.charAt(4) == '^'))
                        resp = p || !q && !r;
                }
                //********************
                // End - 2 Negations
                //********************                

            } else if (Correctformula.length() == 8) {
                //********************
                // 3 Denials
                //********************                

                //EX: ~p^~q^~r
                if ((Correctformula.charAt(0)) == '~' && (Correctformula.charAt(3) == '~')  && (Correctformula.charAt(6) == '~')) {
                    if ((Correctformula.charAt(2)) == '^' && (Correctformula.charAt(5) == '^'))
                        resp = !p && !q && !r;
                }
                //********************
                // End - 3 Negations
                //********************                
            }


            //resp = true;
            System.out.print  ("|  " + printBit(p) + "  |  " + printBit(q) + "  |  " + printBit(r) );
            System.out.println("  |  " + printBit(resp)  );
        }
        System.out.println("+-----+-----+-----+");
    }

        // check formula with 1 variable
    public boolean findFormulaWith1Variable(String formula) {
        if ((formula.charAt(0) == '~' && formula.charAt(1) == 'p')||
                (formula.charAt(0) == 'p' && formula.length()   == 1)) {
            table1Literal (formula);
            return true;
        }else
            System.out.print("Incorrect formula!");
            return false;
    }

        // check formula with 2 variables
    public boolean findFormulaWith2Variables(String formula) {
        boolean formOk;
        if ((formula.length() == 3) &&
                (formula.charAt(0) == 'p') &&
                (formula.charAt(2) == 'q')) {
            if ((formula.charAt(1) == 'ˆ') ||
                    (formula.charAt(1) == 'v'))
                formOk = true;
            else
                formOk = false;
        }else if ((formula.length() == 4) &&
                (formula.charAt(0) == '~') &&
                (formula.charAt(1) == 'p') &&
                (formula.charAt(3) == 'q')) {
            if ((formula.charAt(2) == '^') ||
                    (formula.charAt(2) == 'v'))
                formOk = true;
            else
                formOk = false;
        }else if ((formula.length()  == 4) &&
                (formula.charAt(0) == 'p') &&
                (formula.charAt(2) == '~') &&
                (formula.charAt(3) == 'q')) {
            if ((formula.charAt(1) == '^')  ||
                    (formula.charAt(1) == 'v'))
                formOk = true;
            else
                formOk = false;
        }else if ((formula.length()  == 5) &&
                (formula.charAt(0) == '~') &&
                (formula.charAt(1) == 'p') &&
                (formula.charAt(3) == '~') &&
                (formula.charAt(4) == 'q')) {
            if ((formula.charAt(2) == '^')  ||
                    (formula.charAt(2) == 'v'))
                formOk = true;
            else
                formOk = false;
        }else
            formOk = false;
            System.out.print("Incorrect formula!");
    if (formOk)
        tableTwoLiteral(formula);
        return formOk;
    }

    // check formula with 3 variables
    public boolean findFormulaWith3Variables(String formula) {
        boolean formOk;
        if ((formula.length() == 5) &&
                (formula.charAt(0) == 'p') &&
                (formula.charAt(2) == 'q') &&
                (formula.charAt(4) == 'r') ) {
            if ( ((formula.charAt(1) == '^') || (formula.charAt(1) == 'v')) && ((formula.charAt(3) == '^') || (formula.charAt(3) == 'v')) )
                formOk = true;
            else
                formOk = false;

        }else if ((formula.length() == 6) &&
                (formula.charAt(0) == '~') &&
                (formula.charAt(1) == 'p') &&
                (formula.charAt(3) == 'q') &&
                (formula.charAt(5) == 'r')){
            if ((formula.charAt(2) == '^') ||
                    (formula.charAt(2) == 'v') &&
                    (formula.charAt(4) == '^') ||
                    (formula.charAt(4) == 'v'))
                formOk = true;
            else
                formOk = false;

        }else if ((formula.length() == 6) &&
                (formula.charAt(0) == 'p') &&
                (formula.charAt(2) == '~') &&
                (formula.charAt(3) == 'q') &&
                (formula.charAt(5) == 'r')){
            if ((formula.charAt(1) == '^') ||
                    (formula.charAt(1) == 'v') &&
                    (formula.charAt(4) == '^') ||
                    (formula.charAt(4) == 'v'))
                formOk = true;
            else
                formOk = false;

        }else if ((formula.length() == 6) &&
                (formula.charAt(0) == 'p') &&
                (formula.charAt(2) == 'q') &&
                (formula.charAt(4) == '~') &&
                (formula.charAt(5) == 'r')){
            if ((formula.charAt(1) == '^') ||
                    (formula.charAt(1) == 'v') &&
                    (formula.charAt(3) == '^') ||
                    (formula.charAt(3) == 'v'))
                formOk = true;
            else
                formOk = false;

        }else if ((formula.length() == 7) &&
                (formula.charAt(0) == '~') &&
                (formula.charAt(1) == 'p') &&
                (formula.charAt(3) == '~') &&
                (formula.charAt(4) == 'q') &&
                (formula.charAt(6) == 'r')) {
            if ((formula.charAt(2) == '^') ||
                    (formula.charAt(2) == 'v') &&
                    (formula.charAt(5) == '^') ||
                    (formula.charAt(5) == 'v'))
                formOk = true;
            else
                formOk = false;

        }else if ((formula.length() == 7) &&
                (formula.charAt(0) == '~') &&
                (formula.charAt(1) == 'p') &&
                (formula.charAt(3) == 'q') &&
                (formula.charAt(5) == '~') &&
                (formula.charAt(6) == 'r')) {
            if ((formula.charAt(2) == '^') ||
                    (formula.charAt(2) == 'v') &&
                    (formula.charAt(4) == '^') ||
                    (formula.charAt(4) == 'v'))
                formOk = true;
            else
                formOk = false;

        }else if ((formula.length() == 7) &&
                (formula.charAt(0) == 'p') &&
                (formula.charAt(2) == '~') &&
                (formula.charAt(3) == 'q') &&
                (formula.charAt(5) == '~') &&
                (formula.charAt(6) == 'r')) {
            if ((formula.charAt(1) == '^') ||
                    (formula.charAt(1) == 'v') &&
                    (formula.charAt(4) == '^') ||
                    (formula.charAt(4) == 'v'))
                formOk = true;
            else
                formOk = false;

        }else if ((formula.length()  == 8) &&
                (formula.charAt(1) == 'p') &&
                (formula.charAt(4) == 'q') &&
                (formula.charAt(7) == 'r')) {
            if ( ((formula.charAt(2) == '^') || (formula.charAt(2) == 'v')) && ((formula.charAt(5) == '^') || (formula.charAt(5) == 'v')) 
                && ((formula.charAt(0) == '~') || (formula.charAt(3) == '~') || (formula.charAt(6) == '~')) )
                formOk = true;
            else
                formOk = false;
        }

        else {
            formOk = false;
            System.out.print("Incorrect formula!");}
    if (formOk)
        tableTresLiterais(formula);
        return formOk;
    }
}
