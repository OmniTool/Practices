package com.javarush.test.level05.lesson12.bonus02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.TreeSet;

/* Нужно добавить в программу новую функциональность
Задача: Программа вводит два числа с клавиатуры и выводит минимальное из них
на экран.
Новая задача: Программа вводит пять чисел с клавиатуры и выводит
минимальное из них на экран.
*/

public class Solution
{

    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        TreeSet<Integer> set = new TreeSet<Integer>();

        for (int i = 0; i < 5; i++)
        {
            set.add(Integer.parseInt(reader.readLine()));
        }






        System.out.println("Minimum = " + set.first());
    }


    public static int min(int a, int b)
    {
        return a < b ? a : b;
    }





}
