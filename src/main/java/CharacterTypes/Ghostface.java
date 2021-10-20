package CharacterTypes;

public class Ghostface extends Character {

    public Ghostface(){
        this.setName("Ghostface");
        this.setTotalHealth(30);
        this.currentHealth = getTotalHealth();
        this.setAttack(9);
        this.setDefense(9);
        this.setSpeed(5);

    }


}
