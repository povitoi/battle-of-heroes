public class Hero extends Creature {

    public static Hero hero;
    private int healCount = 4;


    Hero() {
        this.health = BattleHelper.round(70, 100);
        this.damage = BattleHelper.round(8, 10);

        this.hero = this;
        startHealth = this.health;
    }


    private void heal() {
        if (healCount > 0) {
            --healCount;
            health += (int) ((startHealth / 100) * 30);
            System.out.println("Ваше здоровье: " + this.health + ". Осталось " + healCount + " исцелений.");
        } else
            System.out.println("Исцеление больше невозможно!");
    }


    public static void heroAction(int command) {
        // Если получена команда "1" - герой атакует монстров,
        // если "2" - восстанавливает свое здоровье.
        // Можно выполнить только одно действие за ход.

        if (command == 1) {

            System.out.println("Вы нанесли " +
                    Monster.monsters.get(0).hit(hero.attack, hero.damage) + " единиц урона");

        } else if (command == 2) {

            hero.heal();
            System.out.println("Вы восстановили здоровье! Теперь оно равно: " + hero.health);

        }

    }

}
