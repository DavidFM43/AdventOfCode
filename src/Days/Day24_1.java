package Days;

import java.io.File;
import java.util.*;


public class Day24_1 {

    public static void main(String[] args) throws Exception {

        File file = new File("//home//david//eclipse-workspace//AdventOfCode1//src//input");
        Scanner scan = new Scanner(file);
        HashSet<ArrayList<Integer>> blackTiles = new HashSet<>();


        while(scan.hasNextLine()){

           String tile = scan.nextLine();
           ArrayList<Integer> tileReference = getCoords(tile);

           if(!blackTiles.contains(tileReference)){

               blackTiles.add(tileReference);

           }else{

               blackTiles.remove(tileReference);

           }
        }

        for(int i = 0; i < 100;i++){
           blackTiles = newDay(blackTiles);
        }
        System.out.println(blackTiles.size());

    }

    public static HashSet<ArrayList<Integer>> newDay(HashSet<ArrayList<Integer>> currrentDay){

       HashSet<ArrayList<Integer>>  newDay = new HashSet<>();

       for(ArrayList<Integer> blackTile : currrentDay){

           int adjacetBlack = getAdjacentBlack(blackTile,currrentDay);

            if( adjacetBlack != 0 && adjacetBlack <= 2){
                newDay.add(blackTile);
            }
            for(ArrayList<Integer> whiteTile : getAdjacentWhite(blackTile, currrentDay)){
               if(getAdjacentBlack(whiteTile,currrentDay) == 2)
                   newDay.add(whiteTile);
            }
       }

       return newDay;
    }
    public static HashSet<ArrayList<Integer>> getAdjacentWhite(ArrayList<Integer> black, HashSet<ArrayList<Integer>> blacktiles){

        HashSet<ArrayList<Integer>> adjacentWhite = new HashSet<>();

        ArrayList<Integer> coords = new ArrayList<>();
        coords.addAll(black);

        for(int i = 0; i < 6; i++){
            switch (i){
                case 0:

                    coords.set(1,coords.get(1)-1);
                    coords.set(0,coords.get(0)+1);
                    if(!blacktiles.contains(coords))
                        adjacentWhite.add(coords);
                   coords = new ArrayList<>();
                    coords.addAll(black);

                case 1:

                    coords.set(2,coords.get(2)+1);
                    coords.set(1,coords.get(1)-1);
                    if(!blacktiles.contains(coords))
                        adjacentWhite.add(coords);
                    coords = new ArrayList<>();
                    coords.addAll(black);
                case 2:

                    coords.set(2,coords.get(2)+1);
                    coords.set(0,coords.get(0)-1);
                    if(!blacktiles.contains(coords))
                        adjacentWhite.add(coords);
                   coords = new ArrayList<>();
                    coords.addAll(black);

                case 3:

                    coords.set(1,coords.get(1)+1);
                    coords.set(0,coords.get(0)-1);

                    if(!blacktiles.contains(coords))
                        adjacentWhite.add(coords);
                   coords = new ArrayList<>();
                    coords.addAll(black);
                case 4:

                    coords.set(2,coords.get(2)-1);
                    coords.set(1,coords.get(1)+1);
                    if(!blacktiles.contains(coords))
                        adjacentWhite.add(coords);
                   coords = new ArrayList<>();
                    coords.addAll(black);
                case 5:
                    coords.set(2,coords.get(2)-1);
                    coords.set(0,coords.get(0)+1);
                    if(!blacktiles.contains(coords))
                        adjacentWhite.add(coords);
                   coords = new ArrayList<>();
                    coords.addAll(black);
            }
        }
        return adjacentWhite;
    }
    public static int getAdjacentBlack(ArrayList<Integer> black, HashSet<ArrayList<Integer>> blacktiles){

       int adjacentBlack = 0;
       ArrayList<Integer> coords;

       for(int i = 0; i < 6; i++){

           coords = new ArrayList<>();
           coords.addAll(black);

           switch (i){
               case 0:

                   coords.set(1,coords.get(1)-1);
                   coords.set(0,coords.get(0)+1);
                   if(blacktiles.contains(coords))
                       adjacentBlack++;
                   break;

               case 1:

                   coords.set(2,coords.get(2)+1);
                   coords.set(1,coords.get(1)-1);
                   if(blacktiles.contains(coords))
                       adjacentBlack++;
                   break;
               case 2:

                   coords.set(2,coords.get(2)+1);
                   coords.set(0,coords.get(0)-1);
                   if(blacktiles.contains(coords))
                       adjacentBlack++;
                   break;
               case 3:

                   coords.set(1,coords.get(1)+1);
                   coords.set(0,coords.get(0)-1);

                   if(blacktiles.contains(coords))
                       adjacentBlack++;
                   break;
               case 4:

                   coords.set(2,coords.get(2)-1);
                   coords.set(1,coords.get(1)+1);
                   if(blacktiles.contains(coords))
                       adjacentBlack++;
                   break;
               case 5:
                   coords.set(2,coords.get(2)-1);
                   coords.set(0,coords.get(0)+1);
                   if(blacktiles.contains(coords))
                       adjacentBlack++;
                   break;
           }
       }
       return adjacentBlack;

    }
    public static ArrayList<Integer> getCoords(String tiledir){

        // e = 0, se = 1, sw = 2, w = 3, nw = 4, ne = 5.

        int currentIndex = 0;
        ArrayList<Integer> coords = new ArrayList<>();
        coords.add(0);
        coords.add(0);
        coords.add(0);

        while(currentIndex < tiledir.length()){

            String str = tiledir.substring(currentIndex);

            if (str.startsWith("e")) {

                coords.set(1,coords.get(1)-1);
                coords.set(0,coords.get(0)+1);
                currentIndex++;

            } else if (str.startsWith("se")) {

                coords.set(2,coords.get(2)+1);
                coords.set(1,coords.get(1)-1);
                currentIndex += 2;

            } else if (str.startsWith("sw")) {

                coords.set(2,coords.get(2)+1);
                coords.set(0,coords.get(0)-1);
                currentIndex += 2;

            } else if (str.startsWith("w")) {

                coords.set(1,coords.get(1)+1);
                coords.set(0,coords.get(0)-1);
                currentIndex++;

            } else if (str.startsWith("nw")) {

                coords.set(2,coords.get(2)-1);
                coords.set(1,coords.get(1)+1);
                currentIndex += 2;

            } else if (str.startsWith("ne")) {

                coords.set(2,coords.get(2)-1);
                coords.set(0,coords.get(0)+1);
                currentIndex += 2;

            }

        }
        return coords;
    }
}