import java.time.*;

/**
 * @author Angela Cao angelacao346@gmail.com
 * @version 1.0
 * @since 1.0
 */

public abstract class Plant {
    String species;
    Garden garden;
    int index;

    /**
     * waters the plant
     * <p>
     * waters the plant, and adds the task and date to the outputs ArrayList, to be written onto the output file later
     */
    void water(){
        garden.outputs.add(species + " was watered on " + LocalDate.now());
    }

    /**
     * adds fertilizer to the plant
     * <p>
     * adds a certain amount of fertilizer of a certain type to the plant, and records this info onto the outputs ArrayList, to be written onto
     * the output file later
     * @param type the type of fertilizer
     * @param amtInGrams the amount of fertilizer added, in grams
     */
    void addFertilizer(String type, double amtInGrams){
        garden.outputs.add(amtInGrams + " grams of " + type + " added to " + species + " on " + LocalDate.now());
    }

    /**
     * remove the plant
     * <p>
     * removes the plant from the respective ArrayList, flowers, or trees
     */
    abstract void remove();
}
