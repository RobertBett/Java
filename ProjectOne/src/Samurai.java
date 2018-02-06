

public class Samurai extends Human{
    private static int count = 0;

    public Samurai(){
        this.setHealth(200);
        count++;
    }

    public void deathBlow(Human human){
        human.setHealth(0);
        this.setHealth(this.getHealth()/2);
    }

    public void meditate(){
        this.setHealth(this.getHealth()+this.getHealth()/2);
    }

    public static int howMany(){
        return count;
    }
}