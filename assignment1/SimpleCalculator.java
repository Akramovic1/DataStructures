package com.company;

public class SimpleCalculator implements ISimpleCalc {
    public static void main(String[] args) {}

    @Override
    public int addition(int a, int b) {
        return a+b ;
    }
    @Override
        public float division ( int c, int d) throws RuntimeException {
            if (d == 0) {
                throw new RuntimeException("ERROR! Division by ZERO is impossible");

            } else {
                return (float) (c / d);
            }

        }
    }