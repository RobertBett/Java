


public class Wizard extends Human{
    public Wizard(){
        this.setHealth(50);
        this.setIntelligence(8);
    }

    public void heal(Human human){
        human.setHealth(human.getHealth()+this.getIntelligence());
    }

    public void fireball(Human human){
        human.setHealth(human.getHealth()-this.getIntelligence()*3);
    }
}