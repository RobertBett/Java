


public class Human{
    private int strength;
    private int intelligence;
    private int stealth;
    private int health;

    public Human(){
        this.strength     = 3;
        this.intelligence = 3;
        this.stealth      = 3;
        this.health       = 100;
    }

    public void setHealth(int health){this.health = health;}
    public int getHealth(){return health;}

    public void setStrength(int strength){this.strength = strength;}
    public int getStrength(){return strength;}

    public void setIntelligence(int intelligence){this.intelligence = intelligence;}
    public int getIntelligence(){return intelligence;}

    public void getInfo(){
        System.out.println("Health: "+health);
        System.out.println("Strength: "+strength);
        System.out.println("Intelligence: "+intelligence);
        System.out.println("Stealth: "+stealth+"\n");
    }

    public void setStealth(int stealth){this.stealth = stealth;}
    public int getStealth(){return stealth;}

    public void attack(Human human){
        human.setHealth(human.getHealth()-strength);
    }

    public static void main(String[] args) {
        Human human     = new Human();
        human.getInfo();

        Wizard wizard   = new Wizard();
        wizard.getInfo();
        human.attack(wizard);
        wizard.getInfo();

        Ninja ninja     = new Ninja();
        ninja.getInfo();
        wizard.heal(ninja);
        ninja.getInfo();

        Samurai samurai = new Samurai();
        samurai.deathBlow(human);
        samurai.getInfo();
        human.getInfo();

        Samurai samurai2 = new Samurai();
        Samurai samurai3 = new Samurai();
        Samurai samurai4 = new Samurai();
        Samurai samurai5 = new Samurai();

        System.out.println(Samurai.howMany());
    }
}