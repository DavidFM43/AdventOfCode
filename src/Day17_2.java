import java.util.*;
import java.io.File;

public class Day17_2 {
    public static void main(String[] args) throws Exception {
        File file = new File("C:\\Users\\user\\Desktop\\Test\\AdventOfCode\\src\\input");
        Scanner scan = new Scanner(file);
        int rows = 8;
        int columns = 8;
        char[][] initialGrid = new char[rows][columns];
        int cont = 0;
        HashSet<ArrayList<Integer>> activeCubes = new HashSet<>();
        while (scan.hasNext()) {
            char[] line = scan.nextLine().toCharArray();
            initialGrid[cont] = line;
            cont++;
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                char cube = initialGrid[i][j];
                if (cube == '#') {
                    ArrayList<Integer> coor = new ArrayList<Integer>();
                    coor.add(j);
                    coor.add(i);
                    coor.add(0);
                    coor.add(0);
                    activeCubes.add(coor);
                }
            }
        }

        for (int i = 0; i < 6; i++) {
            activeCubes = newGen(activeCubes);
        }
        System.out.println(activeCubes.size());
    }

    public static HashSet<ArrayList<Integer>> newGen(HashSet<ArrayList<Integer>> activeCubes) {
        HashSet<ArrayList<Integer>> newGen = new HashSet<>();
        for (ArrayList<Integer> cube : activeCubes) {
            if (getActiveNeighbors(cube, activeCubes) == 2 || getActiveNeighbors(cube, activeCubes) == 3) {
                newGen.add(cube);
            }
            for (ArrayList<Integer> neighbor : getInactiveNeighbors(cube, activeCubes)) {
                if (getActiveNeighbors(neighbor, activeCubes) == 3)
                    newGen.add(neighbor);
            }
        }
        return newGen;
    }

    public static int getActiveNeighbors(ArrayList<Integer> coordinates, HashSet<ArrayList<Integer>> activeCubes) {
        int active = 0;
        int x = coordinates.get(0);
        int y = coordinates.get(1);
        int z = coordinates.get(2);
        int w = coordinates.get(3);
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                for (int k = -1; k < 2; k++) {
                    for (int n = -1; n < 2; n++) {
                        ArrayList<Integer> neighbor = new ArrayList<>();
                        neighbor.add(x + i);
                        neighbor.add(y + j);
                        neighbor.add(z + k);
                        neighbor.add(w + n);
                        if (!neighbor.equals(coordinates) && activeCubes.contains(neighbor)) {
                            active++;
                        }
                    }
                }
            }
        }
        return active;
    }

    public static HashSet<ArrayList<Integer>> getInactiveNeighbors(ArrayList<Integer> coor,
            HashSet<ArrayList<Integer>> activeCubes) {
        HashSet<ArrayList<Integer>> neighbors = new HashSet<>();
        int x = coor.get(0);
        int y = coor.get(1);
        int z = coor.get(2);
        int w = coor.get(3);
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                for (int k = -1; k < 2; k++) {
                    for (int n = -1; n < 2; n++) {
                        ArrayList<Integer> neighbor = new ArrayList<>();
                        neighbor.add(x + i);
                        neighbor.add(y + j);
                        neighbor.add(z + k);
                        neighbor.add(w + n);
                        if (!neighbor.equals(coor) && !activeCubes.contains(neighbor)) {
                            neighbors.add(neighbor);
                        }

                    }
                }
            }
        }
        return neighbors;
    }
}
