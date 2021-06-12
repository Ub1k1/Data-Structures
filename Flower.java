import java.time.LocalDate;
import java.util.Random;

/**
 * @author Angela Cao angelacao346@gmail.com
 * @version 1.0
 * @since 1.0
 */

public class Flower extends Plant{

    /**
     * makes a new flower
     * <p>
     * makes a new flower and pairs it to the garden it belongs to
     * @param garden the garden that the flower belongs to
     * @param species the species name of the flower
     * @param index the index of the flower in the flowers ArrayList of the garden it belongs to
     */
    public Flower(Garden garden, String species){
        this.species = species;
        this.index = garden.flowers.size();
        this.garden = garden;
    }

    /**
     * collect the seeds of this flower
     * <p>
     * collects the seeds of this flower, which is an random amt from 0 to 10, and adds this number to the total inventory of seeds, then records
     * this task onto the outputs ArrayList, to be written onto the output file later
     */
    void collectSeeds(){
        Random rand = new Random();
        int seedsToAdd = rand.nextInt(10);
        garden.seeds += seedsToAdd;

        garden.outputs.add(seedsToAdd + " were collected " + LocalDate.now());
    }
}
