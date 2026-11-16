package com.example.calculadra

class CalculadoraKT {

    var num1: String = ""
    var num2: String = ""
    var operacion: Char = 0.toChar()

    fun meterNumero(num: Int){
        num2 += num
    }

    fun operacion(op: Char){
        num1 = num2
        num2 = ""
        operacion = op
    }

    fun meterComa(){
        if (!num2.contains(".")){
            num2 += "."
        }
    }

    fun clear(){
        num1 = ""
        num2 = ""
        operacion = 0.toChar()
    }

    fun borrarUltimo(){
        if(num2.isNotEmpty()){
            num2 = num2.dropLast(1)
        }
    }


    fun igual(){
        val num1 = this.num1.toDouble()
        val num2 = this.num2.toDouble()

        when (operacion) {
            '+' -> this.num2 = (num1 + num2).toString()
            '-' -> this.num2 = (num1 - num2).toString()
            '*' -> this.num2 = (num1 * num2).toString()
            '/' -> this.num2 = (num1 / num2).toString()
        }

    }







}