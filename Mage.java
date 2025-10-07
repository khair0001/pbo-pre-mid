class Mage extends Character {
    private int intelligence;

    public Mage(String name, int hp, int maxHp, int mana, int maxMana, int attackPower, int defense, int intelligence) {
        super(name, hp, maxHp, mana, maxMana, attackPower, defense);
        this.intelligence = intelligence;
    }

    @Override
    public void attack() {
        if (mana >= 10) {
            int magicDamage = attackPower + (intelligence / 2);
            mana -= 10;
            System.out.println(name + " melempar Fireball! Magic Damage: " + magicDamage);
            System.out.println("Mana tersisa: " + mana);
        } else {
            System.out.println(name + " tidak memiliki cukup mana! Melakukan basic attack: " + (attackPower / 2));
        }
        System.out.println("===============================");
    }

    @Override
    public void useSpecialSkill() {
        if (mana >= 50) {
            int spellDamage = attackPower + intelligence;
            mana -= 50;
            System.out.println(name + " mengcast METEOR STORM!");
            System.out.println("Massive AoE Damage: " + spellDamage + " ke semua musuh!");
            System.out.println("Mana tersisa: " + mana);
        } else {
            System.out.println(name + " tidak memiliki cukup mana! (Butuh: 50, Tersedia: " + mana + ")");
        }
        System.out.println("===============================");
    }

    public int getIntelligence() {
        return intelligence;
    }
}
