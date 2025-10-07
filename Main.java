public class Main {
    public static void main(String[] args) {
        System.out.println("=== FANTASY RPG GAME ===\n");
        Character warrior = new Warrior("Conan", 150, 150, 30, 30, 35, 20);
        Character mage = new Mage("Gandalf", 80, 80, 150, 150, 25, 10, 50);
        Character archer = new Archer("Legolas", 100, 100, 50, 50, 30, 15, 30);

        Character[] party = { warrior, mage, archer };

        System.out.println("========= PARTY STATUS =========");
        warrior.showStatus();
        System.out.println("Rage        : " + ((Warrior) party[0]).getRage());
        mage.showStatus();
        System.out.println("Intelligence    : " + ((Mage) party[1]).getIntelligence()   );
        archer.showStatus();
        System.out.println("Critical Chance: " + ((Archer) party[2]).getCritChance() + "%");
        System.out.println();

        System.out.println("========= ATTACK ==========");
        party[0].attack();
        party[1].attack();
        party[2].attack();
        System.out.println();

        System.out.println("=========== TAKING DAMAGE ===========");
        warrior.takeDamage(30);
        mage.takeDamage(40);
        archer.takeDamage(25);
        System.out.println();

        System.out.println("========== SPECIAL SKILLS ==========");
        warrior.useSpecialSkill();
        mage.useSpecialSkill();
        archer.useSpecialSkill();
        System.out.println();

        System.out.println("========== FINAL STATUS ==========");
        party[0].showStatus();
        party[1].showStatus();
        party[2].showStatus();
    }
}