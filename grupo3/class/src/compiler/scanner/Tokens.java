/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package compiler.scanner;

/**
 *
 * @author p1jav
 */
public enum Tokens {
    Reservadas,
    id,
    operador_arith,
    alpha,
    digit,
    hex_digit,
    decimal_literal,
    hex_literal,
    rel_op,
    assign_op,
    LESS_EQUAL,
    GREATER_EQUAL,
    EQUAL,
    NOT_EQUAL,
    AND,
    OR,
    LEFT_PAR,
    RIGHT_PAR,
    ERROR
}
