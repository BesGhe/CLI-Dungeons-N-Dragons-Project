package CharacterTypes;

public class BigBoi extends Character {

    public BigBoi(){
        this.setName("Big Boi");
        this.setTotalHealth(20);
        this.currentHealth = getTotalHealth();
        this.setAttack(7);
        this.setDefense(8);
        this.setSpeed(6);

    }

}
