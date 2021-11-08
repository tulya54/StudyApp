package com.lol.studyapp;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class DataActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);

        /*****  Целые числа - byte, short, int, long  *****/

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

        String text = "Hello";

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
