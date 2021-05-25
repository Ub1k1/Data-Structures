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
    public Tree(Garden garden, String species, int index){
        this.species = species;
        this.index = index;
        this.garden = garden;
    }

    /**
     * deletes this tree
     * <p>
     * removes this tree from the trees ArrayList of the garden this tree belongs to, and records this action into the outputs ArrayList of the
     * garden, to be written to the output file of the garden later
     */
    void remove(){
        boolean removable = false;

        for (int i = 0; i < garden.trees.size(); i++){
            if(garden.trees.get(i) == this){
                garden.flowers.remove(i);
                removable = true;
                break;
            }
        }

        if(removable) {
            garden.outputs.add(species + " was removed on " + LocalDate.now());
        }else{
            garden.outputs.add("Action failed: no " + species + " to remove.");
        }
    }
}
