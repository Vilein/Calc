import java.util.Arrays;
    class Interpretator {
    String [] romNum = {"I","II","III","IV","V","VI","VII","VIII","IX","X"};
    String [] arabNum = {"0","1","2","3","4","5","6","7","8","9","10"};
    String [] romNumAnswer = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X",
            "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
            "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX",
            "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
            "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L",
            "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
            "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
            "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
            "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
            "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};
    String res;
    String interpretator(String expr) throws Exception {

        //деление строки по знаку
        String[] a = expr.split("[+\\-*/]");

        // исключения по количеству операторов
        if (a.length < 2) {
            throw new Exception ("//т.к. строка не является математической операцией");
        } else if (a.length > 2) {
            throw new Exception ("//т.к. формат математической операции не удовлетворяет заданию" +
                    " - два операнда и один оператор (+, -, /, *)");
        }
        //присваеваем оператор
        String operand = String.valueOf(expr.charAt(a[0].length()));

        //обрезаем пробелы в числах
        for (int i =0; i < a.length; i++) {
            a[i] = a[i].trim();
        }

        //определяем вид чисел
        if ((Arrays.asList(romNum).indexOf(a[0]) != -1)
                && (Arrays.asList(romNum).indexOf(a[1]) != -1)) {

            //перевод операндов в римские цифры
            int x = Arrays.asList(romNum).indexOf(a[0]) + 1;
            int y = Arrays.asList(romNum).indexOf(a[1]) + 1;

            //вычисления
            Calculator calcRom = new Calculator();
            int z = calcRom.calculator(x, operand, y);

            //исключение римского ноля
            if (z == 0) {
                throw new Exception("//т.к. в римской системе отсутствует ноль");
            }

            // перевод вычислений в римские цифры и исключение римских отрицательных чисел
            try {
                this.res = romNumAnswer[z - 1];
            }catch (Exception e){
                throw new Exception("//т.к. в римской системе нет отрицательных чисел");
            }
            //пределяем вид чисел
        } else if (Arrays.asList(arabNum).indexOf(a[0]) != -1
                && Arrays.asList(arabNum).indexOf(a[1]) != -1) {
            int x = Arrays.asList(arabNum).indexOf(a[0]);
            int y = Arrays.asList(arabNum).indexOf(a[1]);

            //вычисления
            Calculator calcArab = new Calculator();
            int z = calcArab.calculator(x, operand, y);

            // перевод арабских вычислений в строку
                this.res = Integer.toString(z);

                //исключение разные системы счисления
        }else if (Arrays.asList(romNum).indexOf(a[0]) != -1
                && Arrays.asList(arabNum).indexOf(a[1]) != -1){
            throw new Exception("//т.к. используются одновременно разные системы счисления");

        }else if (Arrays.asList(arabNum).indexOf(a[0]) != -1
                && Arrays.asList(romNum).indexOf(a[1]) != -1){
            throw new Exception("//т.к. используются одновременно разные системы счисления");

        }else {
            throw new Exception("//т.к. по заданию в выражении допустимы только римские и арабские " +
                    "числа от одного до десяти");
        }
        return res;
    }
}

