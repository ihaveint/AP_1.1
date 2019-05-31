package resources;

import gameObjects.Rectangle;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class RectLoader {
    private static RectLoader ourInstance = new RectLoader();

    public static RectLoader getInstance() {
        return ourInstance;
    }

    private RectLoader() {

    }
    public static ArrayList<Rectangle> loadRectangles(String path) {
        ArrayList<Rectangle> result = new ArrayList<>();
        try {
            Scanner input = new Scanner(new File(path));

            while (input.hasNextLine()) {
                int xmin, ymin, xmax, ymax;
                String line = input.nextLine();
                String[] arr = line.split(" ");
                xmin = Integer.parseInt(arr[0]);
                ymin = Integer.parseInt(arr[1]);
                xmax = Integer.parseInt(arr[2]);
                ymax = Integer.parseInt(arr[3]);
                result.add(new Rectangle(xmin, ymin, xmax, ymax));

            }
            input.close();
            return result;
        }

        catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
