import java.util.Random;

public class Creature {

    protected final int MAX_HEALTH = 100;
    protected final int MAX_DAMAGE = 10;


    protected boolean isLive = true;
    protected double startHealth;


    protected int attack = (int) (Math.random() * 30) + 1;
    protected int protection = (int) (Math.random() * 30) + 1;
    protected int health;
    protected int damage;


    private void isDead() {
        isLive = false;
    }


    // Метод, описывающий логику атаки.
    // Работает по такому принципу: атакующее существо вызывает
    // этот метод у объекта защищающегося существа,
    // передавая при этом в него значения атаки и урона. Защищающееся существо
    // рассчитывает наносимый себе урон исходя из принятых аргументов.
    protected int hit(int attack, int damage) {
        BattleHelper.attackModifier = (this.protection - attack) + 1;
        int cubeNumber = 0;
        for (int i = BattleHelper.attackModifier; i > 0; i--) {
            cubeNumber = BattleHelper.round(1, 6);

            if (cubeNumber == 5 || cubeNumber == 6) {
                int hitPoint = BattleHelper.round(1, damage);
                this.health -= hitPoint;

                // Если здоровье упало ниже нуля, установить его в 0
                if (this.health < 0) {
                    this.health = 0;
                    isDead();
                }

                return hitPoint;
            }

        }
        return 0;
    }

}