package com.lol.studyapp;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class DataActivity extends AppCompatActivity {

    byte b3; //если он находится внутри класса: он уже иницциализирован. Т.е если мы ему не
    //присвоили значение, ему джава автоматом присваивает значение по умолчению(0 или фолс, зависит
    //от типа данных
    // Глобальные данные-это данные которые находятся внутрий класса.Мы их можем использывать внутри любого метода
    //Локальные даннее-это данные которые находятся внутри метода. Мы их можем использывать только внутри этого метода
    //т.к, их не объявили глобально


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);
        new CycleTest();//создали в памяти



        Integer integer = null;

        if (integer == null) {

        }

        List<Integer> list;
        int value;

        integer = new Integer(1);//Классу Integer присвоили значение(иниицализировали)
        //Integer, String - это ссылычные данные,это классы которые горят черным цветом. Их можно проверять на null,
        //потомц что это объект (класс)
        int f = integer.intValue(); //все что горит синим цветом-это приметивные данные. Их нельзя проверять на null
        byte b7;
        if (integer != null) {

        }

        /*****  Целые числа - byte, short, int, long  *****/

        byte b2; //не инициализирован (пустой), потому что находится внутри метода, а не класса.
        //Ему сами должны присвоить значение (инициализировать)
        b2 = 0;//инициализация - передала/присвоила ему значение(литерал)

        byte nn = b3;
        byte b = 126; // Диапазон от -128 до 127!
        short s = 1123;
        int i = 64536;
        long l = 2147483648L; // Постфикс l или L обозначает литералы типа long

        //  byte	8 бит	от -128 до 127
        //  short	16 бит	от -32768 до 32767
        //  int	32 бит	от -2147483648 до 2147483647
        //  long	64 бит	от -9223372036854775808L до 9223372036854775807L


        /*****  Числа с плавающей точкой (иначе вещественные) - float, double  *****/

        double a = 4.12;
        //  хранит число с плавающей точкой от ±4.9*10-324 до ±1.8*10308 и занимает 8 байт

        float pi = 3.14f; // При использовании типа float требуется указывать суффикс f или F
        //  хранит число с плавающей точкой от -3.4*1038 до 3.4*1038 и занимает 4 байта

        /*****  Логический - boolean  *****/

        boolean bool = true;
        //  boolean	8 (в массивах), 32 (не в массивах используется int)	true (истина) или false (ложь)

        /*****  Символьный - char  *****/

        char w = 'a';
        //  char	16 бит	беззнаковое целое число, представляющее собой символ UTF-16 (буквы и цифры)

        //Символы тоже относят к целочисленным типам из-за особенностей представления в памяти и традиций.

        String text = "Hello";// это массив char-ов
        String text2 = new String("Hello");// это массив char-ов
        String text3 = new String(new char[]{'H', 'e', 'l', 'l', 'o'});


        Integer cat;

        String guest = "dog";

        if (guest == "cat") {
            //  true
        } else if (guest == "dog") {
            //  true
        } else if (guest == "bird") {
            //  true
        } else {
            //  false
        }



        switch (guest) {
            case "cat":
                //  true
                break;
            case "dog":
                //  true
                break;
            case "bird":
                //  true
                break;
            default:
                //  false
                break;
        }

        boolean isWorkGood = false;

        int ZP = 100000;

        if (isWorkGood) {
            ZP += 5000;
        }

    }

    private void test1 () {
        int a = 5;
        int b = 10;
        boolean c = a == b;
    }

    private void test (){
        int a = 10;
        int b = 20;
        int c = 30;
        int d = a + b * c;
        int e = ((d - a) + b) + c;
    }

    private void convertDataToData() {
        int numb = 45;
        String text = "Bitch" + String.valueOf(numb);
        long sum = (int) numb;
    }

    private void concatString() {
        String a = "Hello", b = "World";// Здесь + означает объединение (конкатенацию) строк
        String text = a + " " + b;// Пробел не вставляется автоматически
        // Строки конкатенируются слева направо, надо помнить это когда соединяешь строку и примитив
    }

    private void nextLineString() {
        String text = "blyat" +"suka suka tvoyu mat" + "\n"
                + "blya" + "suka tvoyu mat";
    }
}
