public abstract class Character implements IFightable {
    protected String name;
    protected int hp;
    protected int maxHp;
    protected int mana;
    protected int maxMana;
    protected int attackPower;
    protected int defense;

    public Character(String name, int hp, int maxHp, int mana, int maxMana, int attackPower, int defense) {
        this.name = name;
        this.maxHp = maxHp;
        this.hp = hp;
        this.maxMana = maxMana;
        this.mana = mana;
        this.attackPower = attackPower;
        this.defense = defense;
    }

    public abstract void attack();
    public abstract void useSpecialSkill();

    @Override
    public void takeDamage(int damage) {
        int actualDamage = damage - defense;
        actualDamage = Math.max(actualDamage, 0);

        hp -= actualDamage;
        if (hp < 0)
            hp = 0;

        System.out.println(name + " menerima " + actualDamage + " damage! HP tersisa: " + hp);
    }

    @Override
    public void defend() {
        System.out.println(name + " dalam posisi bertahan!");
    }

    public boolean isAlive() {
        return hp > 0;
    }

    public void showStatus() {
        System.out.println("=================================");
        System.out.println("        STATUS KARAKTER");
        System.out.println("=================================");
        System.out.println("Nama Karakter : " + name);
        System.out.println("HP             : " + hp + "/" + maxHp);
        System.out.println("Mana           : " + mana + "/" + maxMana);
        System.out.println("Attack Power   : " + attackPower);
        System.out.println("Defense        : " + defense);
        
    }

    public String getName() {
        return name;
    }

}
