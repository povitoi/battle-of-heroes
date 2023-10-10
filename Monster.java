import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

public class Monster extends Creature {

    public static ArrayList<Monster> monsters = new ArrayList<>();
    public Monster monster;


    Monster(int health, int damage) {
        this.health = health;
        this.damage = damage;

        monster = this;
    }

    public static void monstersCreation(int count) {
        for (int i = 0; i < count; i++) {
            monsters.add(new Monster(BattleHelper.round(40, 70), BattleHelper.round(5, 7)));
        }
    }

    public static void monsterAction() {

        // Проверяем, нет ли в коллекции монстров с нулевым здоровьем.
        // Если есть, удаляем.
        Iterator<Monster> iterator = monsters.iterator();
        while (iterator.hasNext()) {
            Monster dubMonster = iterator.next();
            if (!dubMonster.isLive)
                iterator.remove();
        }

        // При каждом действии перемешиваем коллекцию,
        // чтобы взаимодействие происходило с разными монстрами.
        Collections.shuffle(monsters);

        // Наносим удар герою.
        System.out.println("Монстры нанесли вам " +
        Hero.hero.hit(monsters.get(0).attack, monsters.get(0).damage) + " единиц урона.");

    }

}