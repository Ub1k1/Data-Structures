import java.time.LocalDate;

/**
 * @author Angela Cao angelacao346@gmail.com
 * @version 1.0
 * @since 1.0
 */

public class Tree extends Plant{
    /**
     * makes a new tree
     * <p>
     * makes a new tree and pairs it to the garden it belongs to
     * @param garden the garden that this tree belongs to
     * @param species the species of this tree
     * @param index the index of this tree in the trees ArrayList of the garden it belongs to
     */
    public Tree(Garden garden, String species){
        this.species = species;
        this.index = garden.trees.size();
        this.garden = garden;
    }
}
