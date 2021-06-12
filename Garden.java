import java.util.*;
import java.io.*;
import java.time.*;

/**
 * @author Angela Cao angelacao346@gmail.com
 * @version 1.1
 * @since 1.0
 */

public class Garden {
    public String PARENTFOLDER = "C:\\Users\\caoan\\Documents\\DataStructures";
    public String name;
    String shape;
    double perimeter;
    double area;
    public int seeds = 0;
    public ArrayList<Flower> flowers = new ArrayList<>();
    public ArrayList<Tree> trees = new ArrayList<>();
    public ArrayList<String> outputs = new ArrayList<>();

    /**
     * Creates a square or circle garden
     * <p>
     * Creates a garden with shape based on the String parameter shape, and initializes the doubles perimeter and area based on the type of
     * shape and the dimension parameter, sideLengthOrRadius
     * <p>
     * @param name the name of the garden
     * @param shape the shape of the garden, either circle or square, must be all lowercase
     * @param sideLengthOrRadius the side length if garden is square, the radius if garden is circle
     */
    public Garden(String name, String shape, double sideLengthOrRadius){
        this.name = name;
        this.shape = shape;
        if(shape.equals("circle")){
            perimeter = 2 * Math.PI * sideLengthOrRadius;
            area = Math.PI * sideLengthOrRadius * sideLengthOrRadius;
        }else if(shape.equals("square")){
            perimeter = 4 * sideLengthOrRadius;
            area = sideLengthOrRadius * sideLengthOrRadius;
        }else{
            throw new IllegalArgumentException();
        }
    }

    /**
     * Creates a rectangle garden
     * <p>
     * Creates a rectangle-shaped garden, and initializes the doubles perimeter and area based on the length and width
     * @param name the name of the garden
     * @param shape the shape of the garden, must be rectangle, all lowercase
     * @param length the length of the rectangle garden
     * @param width the width of the rectangle garden
     */
    public Garden(String name, String shape, double length, double width){
        this.name = name;
        if (!shape.equals("rectangle")){
            throw new IllegalArgumentException();
        }
        this.shape = shape;
        perimeter = 2 * (length + width);
        area = length * width;
    }

    /**
     * records the mowing of grass
     * <p>
     * records the mowing of grass and the date when the grass was mowed into the outputs ArrayList, to be added to the output file later on
     */
    void mowGrass(){
        outputs.add("Grass was mowed on " + LocalDate.now());
    }

    /**
     * adds a new flower to the garden
     * <p>
     * adds a new flower with a species name to the ArrayList of flowers in this garden
     * @param species the species name of the flower
     */
    void addFlower(String species){
        flowers.add(new Flower(this, species, flowers.size()));
    }

    /**
     * adds a new tree to the garden
     * <p>
     * adds a new flower with a species name to the ArrayList of trees in this garden
     * @param species the species name of the tree
     */
    void addTree(String species){
        trees.add(new Tree(this, species, trees.size()));
    }

    /**
     * runs all tasks
     * <p>
     * runs all of the tasks on the input file and outputs the results on the output file
     */
    void runTasks(){
        try{
            File directions = new File(PARENTFOLDER, name + "directions.txt");
            Scanner inputReader = new Scanner(directions);
            while(true){
                String[] task = inputReader.nextLine().split(" ");
                String taskType = task[0];

                switch(taskType){
                    case "mow":
                        mowGrass();
                        break;
                    case "plantF":
                        addFlower(task[1]);
                        break;
                    case "plantT":
                        addTree(task[1]);
                        break;
                    case "water":
                        if(task[1] == "flower"){
                            flowers.get(Integer.parseInt(task[2])).water();
                        }else{
                            trees.get(Integer.parseInt(task[2])).water();
                        }
                        break;
                    case "fertilize":
                        if(task[1] == "flower"){
                            flowers.get(Integer.parseInt(task[2])).addFertilizer(task[3], Double.parseDouble(task[4]));
                        }else{
                            trees.get(Integer.parseInt(task[2])).addFertilizer(task[3], Double.parseDouble(task[4]));
                        }
                        break;
                    case "removeF":
                        removeFlower(task[1]);
                        break;
                    case "removeT":
                        removeTree(task[1]);
                        break;
                    case "collect":
                        for (int i = 0; i < flowers.size(); i++){
                            flowers.get(i).collectSeeds();
                        }
                        break;
                }

                if (!inputReader.hasNext()){
                    break;
                }
            }
            File maintenanceLog = new File(PARENTFOLDER, name + ".txt");
            FileWriter logWriter = new FileWriter(maintenanceLog);
            for (int i = 0; i < outputs.size(); i++) {
                logWriter.append(outputs.get(i) + "\n");
            }
            logWriter.close();
        }catch(IOException e){
            System.out.println("IOException detected!");
            e.printStackTrace();
        }
    }

    /**
     * Removes a flower
     * <p>
     * Removes the first flower in the arraylist that is of the species speciesName. If no such flower exists, it outputs an error message.
     * @param speciesName the species of flower to be removed
     */
    void removeFlower(String speciesName){
        boolean removable = false;

        for (int i = 0; i < flowers.size(); i++){
            if(flowers.get(i).species == speciesName){
                flowers.remove(i);
                removable = true;
                break;
            }
        }

        if(removable) {
            outputs.add(speciesName + " was removed " + LocalDate.now());
        }else{
            outputs.add("Action failed: no " + speciesName + " to remove.");
        }
    }

    /**
     * Removes a tree
     * <p>
     * Removes the first tree in the arraylist that is of the species speciesName. If no such tree exists, it outputs an error message.
     * @param speciesName the species of tree to be removed
     */
    void removeTree(String speciesName){
        boolean removable = false;

        for (int i = 0; i < trees.size(); i++){
            if(trees.get(i).species == speciesName){
                trees.remove(i);
                removable = true;
                break;
            }
        }

        if(removable) {
            outputs.add(speciesName + " was removed " + LocalDate.now());
        }else{
            outputs.add("Action failed: no " + speciesName + " to remove.");
        }
    }
}
