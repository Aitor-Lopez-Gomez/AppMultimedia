package com.example.calculadra;

public class Calculadora {

    private String num1;
    private String num2;
    private char operacion;

    public Calculadora() {
        num1 = "";
        num2 = "";
    }

    public String getNum1() {
        return num1;
    }

    public String getNum2() {
        return num2;
    }

    public void setNum2(String num2) {
        this.num2 = num2;
    }

    public void suma() {
        num1 = num2;
        operacion = '+';
        num2 = "";
    }

    public void operacion(char op) {
        operacion = op;
        num1 = num2;
        num2 = "";
    }

    public void meterNumero(int num) {
        this.num2 += num;
    }

    public String igual() {

        double num1 = Double.parseDouble(this.num1);
        double num2 = Double.parseDouble(this.num2);

        switch (operacion) {

            case '+':
                return String.valueOf(num1 + num2);

            case '-':
                return String.valueOf(num1 - num2);

            case '/':
                return String.valueOf(num1 / num2);

            case '*':
                return String.valueOf(num1 * num2);

            default:
                return "";
        }
    }
    public void meterComa(){
        if (!this.num2.contains(".")){
            this.num2 += ".";
        }
    }

    public void borrar(){
        this.num2 = "";
    }
}