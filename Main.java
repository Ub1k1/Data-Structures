/**
 * @author Angela Cao angelacao346@gmail.com
 * @version 1.0
 * @since 1.0
 */

public class Main {

    public static void main(String[] args) {
        Garden testGarden = new Garden("test", "circle", 8.6);
        testGarden.printAllFlowers();
        testGarden.printAllTrees();
        testGarden.runTasks();
    }
}
