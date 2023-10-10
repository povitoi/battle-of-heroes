import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Game {
    public static void main(String[] args) {
        // Класс для создания и запуска существ в бой.

        BattleHelper.rules();

        Monster.monstersCreation(BattleHelper.round(2, 5));
        new Hero();


        try (BufferedReader commandReader = new BufferedReader(new InputStreamReader(System.in))) {
            while (Hero.hero.isLive && !Monster.monsters.isEmpty()) {
                System.out.print("Введите одну из команд - 1(атака) или 2(восстановление здоровья): ");
                Hero.heroAction(Integer.valueOf(commandReader.readLine()));
                Monster.monsterAction();
            }
        } catch (IOException e) {
        }

        if (!Hero.hero.isLive)
            System.out.println("Герой был повержен. Вы проиграли...");
        else
            System.out.println("Все монстры уничтожены. Вы победили!");

    }
}
