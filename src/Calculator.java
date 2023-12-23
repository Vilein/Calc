class Calculator {
    int x;

     int calculator (int a ,String operand, int b){

        if (operand.equals("+")){
            this.x = a + b;
        }
        else if (operand.equals("-")){
            this.x = a - b;
        }
        else if (operand.equals("*")) {
            this.x = a * b;
        }
        else if(operand.equals("/")){
            this.x = a / b;
        }
        return x;
    }
}
