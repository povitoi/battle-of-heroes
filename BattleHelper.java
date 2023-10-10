import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class BattleHelper {
    // Класс, содержащий вспомогательные переменные и методы
    // для всех остальных сущностей.


    public static int attackModifier = 1;


    // "Обрезает" число до указанных границ.
    public static int rangeWatcher(int number, int min, int max) {
        int result;

        if (number > max)
            result = max;
        else if (number < min)
            result = min;
        else result = number;

        return result;
    }


    // Генерирует псевдослучайное число в указанном диапазоне.
    public static int round(int min, int max) {
        max -= min;
        return (int) ((Math.random() * ++max) + min);
    }

    public static void rules() {
        System.out.println("Добро пожаловать в игру Battle of Heroes!");
        System.out.println("Правила игры довольно просты.");
        System.out.println("Герой и монстры появляются на поле боя автоматически, после чего бой начинается.");
        System.out.println(" Суть заключается в том, что нужно либо бить монстров(команда - 1), ");
        System.out.println("либо восстанавливать свое здоровье, если оно слишком слабо.");
        System.out.println("Здоровье можно восстановить 4 раза за одну игру.");
    }

}
