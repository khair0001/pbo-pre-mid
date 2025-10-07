## Fantasy RPG

### Kelompok : 
	1. Ahmad Muslihul Khair (F1D02310001)
	2. Baiq Alfia Zahira (F1D02310042)

### Penjelasan Kode
1. Interface
``` java
public interface IFightable {
    void attack();
    void defend();
    void takeDamage(int damage);
}
```
Kode di atas merupakan penerapan **interface** pada program yang dibuat. Interface `IFightable` digunakan untuk menggambarkan **karakter yang dapat bertarung** dalam permainan.
-  **attack()** → melakukan serangan kepada musuh,
- **defend()** → bertahan dari serangan,
- **takeDamage(int damage)** → menerima serangan dan mengurangi HP.

2. Abstrak
``` java
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
```
Kelas `Character` merupakan **kelas abstrak** yang mengimplementasikan interface `IFightable`, berfungsi sebagai **kerangka dasar** bagi semua karakter dalam permainan. 
Metode `attack()` dan `useSpecialSkill()` dibuat abstrak agar **setiap subclass** dapat menggunakannya. 
**`protected`** digunakan agar atribut dapat diakses langsung oleh sublass warrior mage dan archer, tetapi tetap tidak bisa diakses dari luar class `Character`.
3. Subclass
``` java
public class Archer extends Character {
    private int critChance; // dalam persen

    public Archer(String name, int hp, int maxHp, int mana, int maxMana, int attackPower, int defense, int critChance) {
        super(name, hp, maxHp, mana, maxMana, attackPower, defense);
        this.critChance = critChance;
    }
```

``` java
class Mage extends Character {
    private int intelligence;

    public Mage(String name, int hp, int maxHp, int mana, int maxMana, int attackPower, int defense, int intelligence) {
        super(name, hp, maxHp, mana, maxMana, attackPower, defense);
        this.intelligence = intelligence;
    }
```

``` java
public class Warrior extends Character {
    private int rage;
    private boolean berserkMode;

    public Warrior(String name, int hp, int maxHp, int mana, int maxMana, int attackPower, int defense) {
        super(name, hp, maxHp, mana, maxMana, attackPower, defense);
        this.rage = 0;
        this.berserkMode = false;
    }
```

``` java
@override
    public void attack()
@Override
	public void useSpecialSkill()
```
Kode **`@Override`** digunakan untuk menandai bahwa method yang sudah didefinisikan sebelumnya di class `Character` atau `IFightable`, sehingga subclass archer, mage dan warrior dapat memiliki versi yang berbeda tergantung berdasarkan apa yang dinginkan.

4. Polimorfisme
``` java
        System.out.println("=== FANTASY RPG GAME ===\n");
        Character warrior = new Warrior("Conan", 150, 150, 30, 30, 35, 20);
        Character mage = new Mage("Gandalf", 80, 80, 150, 150, 25, 10, 50);
        Character archer = new Archer("Legolas", 100, 100, 50, 50, 30, 15, 30);
        Character[] party = { warrior, mage, archer };
```
Kode ini merupakan potongan dari kode main, yang termasuk ke dalam penggunaan polymorfisme yang berguna agar sublass tidak ditulis satu-persatu, tetapi diperlakukan sebagai satu tipe, yaitu **`Character`**.

misalkan jika tidak menggunakan Polymorfisme akan seperti 
``` java
        Warrior warrior = new Warrior("Conan", 150, 150, 30, 30, 35, 20);
        Mage mage = new Mage("Gandalf", 80, 80, 150, 150, 25, 10, 50);
        Archer archer = new Archer("Legolas", 100, 100, 50, 50, 30, 15, 30);
```
sehingga kode tetap jalan tapi jadi lebih panjang. jika menggunakan polymorfisme cukup gunakan `Character[]` dan bisa memanggil semua karakter sekaligus.