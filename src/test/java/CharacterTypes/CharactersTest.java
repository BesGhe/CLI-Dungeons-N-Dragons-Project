package CharacterTypes;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CharactersTest {

    //initialize variables first
Characters testCharacter;
Characters [] testArray;
Characters tester1;
Characters tester2;
Characters tester3;


    @Before
    //can be created with test class or Generate
    public void setUp() throws Exception {
        testCharacter = new Characters();

    }

    @Test
    //broken!!
    public void getNameTest() {
        //Given
     //testCharacter type Characters

        //Expected
       String expected ="testC";

        //Actual
        String actual = this.testCharacter.getName();
    }


    @Test
    public void checkPlayerVitalsTest() {
      //Given
       Characters[] testArray2 = {tester1, tester2, tester3};
       tester1.setTotalHealth(10);
       tester2.setTotalHealth(20);
       tester3.setTotalHealth(20);

       //Expected
        tester1.getTotalHealth();
        tester2.getCurrentHealth();

        //Actual
        tester1.getTotalHealth(); // ??



    }

    @Test
    public void checkDealerVitalsTest() {
    }
}