public class Archer extends Character {
    private int critChance; // dalam persen

    public Archer(String name, int hp, int maxHp, int mana, int maxMana, int attackPower, int defense, int critChance) {
        super(name, hp, maxHp, mana, maxMana, attackPower, defense);
        this.critChance = critChance;
    }

    @Override
    public void attack() {
        int damage = attackPower;
        boolean isCritical = Math.random() * 100 < critChance;
        
        if (isCritical) {
            damage *= 2;
            System.out.println(name + " melepaskan panah CRITICAL HIT! Damage: " + damage);
        } else {
            System.out.println(name + " melepaskan panah! Damage: " + damage);
        }
        System.out.println("===============================");
    }

    @Override
    public void useSpecialSkill() {
        if (mana >= 20) {
            int preciseDamage = attackPower * 3;
            mana -= 20;
            System.out.println(name + " menggunakan PRECISE SHOT!");
            System.out.println("Guaranteed Critical Damage: " + preciseDamage);
            System.out.println("Mana tersisa: " + mana);
        } else {
            System.out.println(name + " tidak memiliki cukup mana! (Butuh: 20, Tersedia: " + mana + ")");
        }
        System.out.println("===============================");
    }

    public int getCritChance() {
        return critChance;
    }

    public void multiShot() {
        System.out.println(name + " melepaskan Multiple Arrows ke 3 target berbeda!");
    }
}
