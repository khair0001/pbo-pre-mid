public class Warrior extends Character {
    private int rage;
    private boolean berserkMode;

    public Warrior(String name, int hp, int maxHp, int mana, int maxMana, int attackPower, int defense) {
        super(name, hp, maxHp, mana, maxMana, attackPower, defense);
        this.rage = 0;
        this.berserkMode = false;
    }

    @Override
    public void attack() {
        int damage = attackPower;
        if (berserkMode) {
            damage = (int)(damage * 1.5);
        }
        
        rage += 10;
        System.out.println(name + " menyerang dengan pedang! Damage: " + damage);
        System.out.println("Rage meningkat menjadi: " + rage);
        System.out.println("===============================");
    }

    @Override
    public void useSpecialSkill() {
        if (rage >= 10) {
            berserkMode = true;
            rage -= 10;
            defense = (int)(defense * 0.7);
            attackPower = (int)(attackPower * 1.3);
            System.out.println(name + " mengaktifkan BERSERK MODE!");
            System.out.println("Attack meningkat! Defense menurun!");
        } else {
            System.out.println(name + " tidak memiliki cukup rage! (Butuh: 50, Tersedia: " + rage + ")");
        }
        System.out.println("===============================");
    }

    public int getRage() {
        return rage;
    }

    public void cleave() {
        System.out.println(name + " melakukan Cleave Attack (Area Damage)!");
    }
}
