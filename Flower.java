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
    public Flower(Garden garden, String species, int index){
        this.species = species;
        this.index = index;
        this.garden = garden;
    }

    /**
     * deletes this flower
     * <p>
     * removes this flower from the flowers ArrayList of the garden it belongs to and records this action in the outputs ArrayList of the garden,
     * to be written onto the output file later
     */
    void remove(){
        boolean removable = false;

        for (int i = 0; i < garden.flowers.size(); i++){
            if(garden.flowers.get(i) == this){
                garden.flowers.remove(i);
                removable = true;
                break;
            }
        }

        if(removable) {
            garden.outputs.add(species + " was removed " + LocalDate.now());
        }else{
            garden.outputs.add("Action failed: no " + species + " to remove.");
        }
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
