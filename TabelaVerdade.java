package com.company;


public class TabelaVerdade {

    public char printBit(boolean p) {
        if (p)
            return 'V';
        else
            return 'F';
    }

    public void printFormula (String formulaCorreta) {
        System.out.print(" (" + formulaCorreta + ") ");
    }

    //tabela com uma variavel
    public void tabelaUmLiteral(String formulaCorreta) {
        int i;

        boolean p, resp;

        System.out.println("+---+");
        System.out.print  ("| p |");
        printFormula (formulaCorreta);
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


            resp = (formulaCorreta.charAt(0)=='~')? !p : p;
            System.out.print ("| " + printBit(p) + " |  ");
            System.out.println(printBit(resp) );

        }
        System.out.println("+----+");

    }

    //tabela com duas variaveis
    public void tabelaDoisLiterais(String formulaCorreta) {
        int i;
        boolean p, q, resp = true;

        System.out.println("+---+---+");
        System.out.print  ("| p | q |");
        printFormula (formulaCorreta);
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
            if (formulaCorreta.length() == 3)
                resp = formulaCorreta.charAt(1) == '^'? p && q: p || q;
            else if (formulaCorreta.length() == 4) {
                if (formulaCorreta.charAt(0)=='~')
                    resp = formulaCorreta.charAt(2) == '^'? (!p && q) : (!p || q);
                else if (formulaCorreta.charAt(2)=='˜')
                    resp = formulaCorreta.charAt(1) == 'ˆ'? (p && !q): (p || !q);
                else if (formulaCorreta.length() == 5) {
                }

            }

            System.out.print  ("| "    + printBit(p) + " | " + printBit(q) );
            System.out.println(" |  "  + printBit(resp) );
        }
        System.out.println("+----+---+");
    }


    //tabela com tres variaveis
    public void tabelaTresLiterais (String formulaCorreta) {
        int i;
        boolean p, q, r, resp = true;

        System.out.println("+-----+-----+-----+");
        System.out.println("|  p  |  q  |  r  |  "+ formulaCorreta );
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

            if (formulaCorreta.length() == 5) {
                //******************
                //Sem negação
                //******************
                if ((formulaCorreta.charAt(1)) == '^' && (formulaCorreta.charAt(3) == '^'))
                    resp = p && q && r;
                else if ((formulaCorreta.charAt(1)) == '^' && (formulaCorreta.charAt(3) == 'v'))
                    resp = p && q || r;
                else if ((formulaCorreta.charAt(1)) == 'v' && (formulaCorreta.charAt(3) == 'v'))
                    resp = p || q || r;
                else if ((formulaCorreta.charAt(1)) == 'v' && (formulaCorreta.charAt(3) == '^'))
                    resp = p || q && r;
            } else if (formulaCorreta.length() == 6) {
                //******************
                //Somente uma negação
                //******************

                //EX: ~p^q^r
                if ((formulaCorreta.charAt(0)) == '~') {
                    if ((formulaCorreta.charAt(2)) == '^' && (formulaCorreta.charAt(4) == '^'))
                        resp = !p && q && r;
                    else if ((formulaCorreta.charAt(2)) == '^' && (formulaCorreta.charAt(4) == 'v'))
                        resp = !p && q || r;
                    else if ((formulaCorreta.charAt(2)) == 'v' && (formulaCorreta.charAt(4) == 'v'))
                        resp = !p || q || r;
                    else if ((formulaCorreta.charAt(2)) == 'v' && (formulaCorreta.charAt(4) == '^'))
                        resp = !p || q && r;
                }
                //EX: p^~q^r
                if ((formulaCorreta.charAt(2)) == '~') {
                    if ((formulaCorreta.charAt(1)) == '^' && (formulaCorreta.charAt(4) == '^'))
                        resp = p && !q && r;
                    else if ((formulaCorreta.charAt(1)) == '^' && (formulaCorreta.charAt(4) == 'v'))
                        resp = p && !q || r;
                    else if ((formulaCorreta.charAt(1)) == 'v' && (formulaCorreta.charAt(4) == 'v'))
                        resp = p || !q || r;
                    else if ((formulaCorreta.charAt(1)) == 'v' && (formulaCorreta.charAt(4) == '^'))
                        resp = p || !q && r;
                }

                //EX: p^q^~r
                if ((formulaCorreta.charAt(4)) == '~') {
                    if ((formulaCorreta.charAt(1)) == '^' && (formulaCorreta.charAt(3) == '^'))
                        resp = p && q && !r;
                    else if ((formulaCorreta.charAt(1)) == '^' && (formulaCorreta.charAt(3) == 'v'))
                        resp = p && q || !r;
                    else if ((formulaCorreta.charAt(1)) == 'v' && (formulaCorreta.charAt(3) == 'v'))
                        resp = p || q || !r;
                    else if ((formulaCorreta.charAt(1)) == 'v' && (formulaCorreta.charAt(3) == '^'))
                        resp = p || q && !r;
                }
                //******************
                //Fim - Somente uma negação
                //******************
            } else if (formulaCorreta.length() == 7) {
                //********************
                // 2 Negações
                //********************
                //EX: ~p^~q^r
                if ( ((formulaCorreta.charAt(0)) == '~') && ((formulaCorreta.charAt(3)) == '~') )  {
                    if ((formulaCorreta.charAt(2)) == '^' && (formulaCorreta.charAt(5) == '^'))
                        resp = !p && !q && r;
                    else if ((formulaCorreta.charAt(2)) == '^' && (formulaCorreta.charAt(5) == 'v'))
                        resp = !p && !q || r;
                    else if ((formulaCorreta.charAt(2)) == 'v' && (formulaCorreta.charAt(5) == 'v'))
                        resp = !p || !q || r;
                    else if ((formulaCorreta.charAt(2)) == 'v' && (formulaCorreta.charAt(5) == '^'))
                        resp = !p || !q && r;
                }

                //EX: ~p^q^~r
                if ( ((formulaCorreta.charAt(0)) == '~') && ((formulaCorreta.charAt(5)) == '~') )  {
                    if ((formulaCorreta.charAt(2)) == '^' && (formulaCorreta.charAt(4) == '^'))
                        resp = !p && q && !r;
                    else if ((formulaCorreta.charAt(2)) == '^' && (formulaCorreta.charAt(4) == 'v'))
                        resp = !p && q || !r;
                    else if ((formulaCorreta.charAt(2)) == 'v' && (formulaCorreta.charAt(4) == 'v'))
                        resp = !p || q || !r;
                    else if ((formulaCorreta.charAt(2)) == 'v' && (formulaCorreta.charAt(4) == '^'))
                        resp = !p || q && !r;
                }

                //EX: p^~q^~r
                if ( ((formulaCorreta.charAt(2)) == '~') && ((formulaCorreta.charAt(5)) == '~') )  {
                    if ((formulaCorreta.charAt(1)) == '^' && (formulaCorreta.charAt(4) == '^'))
                        resp = p && !q && !r;
                    else if ((formulaCorreta.charAt(1)) == '^' && (formulaCorreta.charAt(4) == 'v'))
                        resp = p && !q || !r;
                    else if ((formulaCorreta.charAt(1)) == 'v' && (formulaCorreta.charAt(4) == 'v'))
                        resp = p || !q || !r;
                    else if ((formulaCorreta.charAt(1)) == 'v' && (formulaCorreta.charAt(4) == '^'))
                        resp = p || !q && !r;
                }
                //********************
                // Fim - 2 Negações
                //********************                

            } else if (formulaCorreta.length() == 8) {
                //********************
                // 3 Negações
                //********************                

                //EX: ~p^~q^~r
                if ((formulaCorreta.charAt(0)) == '~' && (formulaCorreta.charAt(3) == '~')  && (formulaCorreta.charAt(6) == '~')) {
                    if ((formulaCorreta.charAt(2)) == '^' && (formulaCorreta.charAt(5) == '^'))
                        resp = !p && !q && !r;
                }
                //********************
                // Fim - 3 Negações
                //********************                
            }




            //resp = true;
            System.out.print  ("|  " + printBit(p) + "  |  " + printBit(q) + "  |  " + printBit(r) );
            System.out.println("  |  " + printBit(resp)  );
        }
        System.out.println("+-----+-----+-----+");
    }

    //verifica formula com 1 variavel
    public boolean achaFormulaCom1Variavel(String formula) {
        if ((formula.charAt(0) == '~' && formula.charAt(1) == 'p')||
                (formula.charAt(0) == 'p' && formula.length()   == 1)) {
            tabelaUmLiteral (formula);
            return true;
        }else
            System.out.print("Fórmula incorreta!");
            return false;
    }

    //verifica formula com 2 variaveis
    public boolean achaFormulaCom2Variaveis(String formula) {
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
            System.out.print("Fórmula incorreta!");
    if (formOk)
        tabelaDoisLiterais(formula);
        return formOk;
    }

    //verifica formula com 3 variaveis
    public boolean achaFormulaCom3Variaveis(String formula) {
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
            System.out.print("Fórmula incorreta!");}
    if (formOk)
        tabelaTresLiterais(formula);
        return formOk;
    }
}