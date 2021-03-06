package com.javarush.test.level09.lesson11.home04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* Конвертер дат
Ввести с клавиатуры дату в формате «08/18/2013»
Вывести на экран эту дату в виде «AUG 18, 2013».
Воспользоваться объектом Date и SimpleDateFormat.
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        Date d = new Date();
        SimpleDateFormat sd = new SimpleDateFormat("MMM dd, yyyy");
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String s = r.readLine();
        String[] sArr = s.split("/");
        d.setMonth(Integer.parseInt(sArr[0]) - 1);
        d.setDate(Integer.parseInt(sArr[1]));
        d.setYear(Integer.parseInt(sArr[2]));
        System.out.println(sd.format(d) + " " + d.getYear());
    }
}
