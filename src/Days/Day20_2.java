package Days;

import java.io.File;
import java.util.*;
import java.util.Scanner;
import java.util.regex.*;

class Tile{
    String[] image = new String[10];
    ArrayList<Tile> neighbors = new ArrayList<>();
    int tileNum = 0;
    ArrayList<String[]> orientations = new ArrayList<>();

    Tile(String[] rows, int tileNum){
        this.image = rows;
        this.tileNum = tileNum;
    }
    Tile(){
    }

    //Setters

    public void setOrientations(){
        String[] temp = this.image;
        orientations.add(temp);
        orientations.add(flip(temp));
        for(int i = 0; i < 3;i++){
            temp = rotate(temp);
            orientations.add(temp);
            orientations.add(flip(temp));
        }
    }

    public void setNeigbbors(ArrayList<Tile> tiles) {
        ArrayList<Tile> neighbors = new ArrayList<>();
        for(Tile tile:tiles) {
            if(this.tileNum != tile.getTileNum()){
               if(checkNeighbor(tile))
                   neighbors.add(tile);
            }
        }
        this.neighbors = neighbors;
    }

    public void setImage(String[] newImage) {
        this.image = newImage;
    }

    //Getters
    public int getTileNum(){
        return tileNum;
    }

    public ArrayList<Tile> getNeighbors(){
        return neighbors;
    }

    public String[] getSides(int leftBound, int rightBound){
        String left = "";
        String right = "";
        for(int i = 0; i < image.length;i++){
            left += image[i].charAt(leftBound);
            right += image[i].charAt(rightBound);
        }
        String[] sides = {image[0],image[image.length-1],left,right};
        return sides;
    }

    public ArrayList<String[]> getOrientations(){
        return orientations;
    }

    //Helpers functions

    public String[] cutSides(){
        String[] newImage = new String[8];
        for(int i = 0; i < 8;i++){
           newImage[i] = this.image[i+1].substring(1,9);
        }
        return newImage;
    }

    public void print(){
        String str = "";
        for(String row:this.image){
            str += row + "\n";
        }
        System.out.println(str);
    }
    public static String[] rotate(String[] image){
        String[] newImage = new String[image.length];
        Tile temp = new Tile(image,-1);
            //90 grados
            for(int i = image.length-1; i >=0 ; i--) {
               newImage[image.length-1-i] = temp.getSides(0,i)[3];
            }
            return newImage;
    }
    public static String[] flip(String[] image){
        String[] newImage = new String[image.length];
        Tile temp = new Tile(image, -1);
            for(int i = 0; i < image.length; i++){
                newImage[i] = temp.image[image.length-1-i];
            }
        return newImage;
    }
    public boolean checkNeighbor(Tile tile){
        String[] tile1 = this.getSides(0,9);
        String[] tile2 = tile.getSides(0,9);
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4;j++){
                if(tile1[i].equals(tile2[j]) || tile1[j].equals(reverse(tile2[j])) || reverse(tile1[i]).equals(tile2[j]) || reverse(tile1[i]).equals(reverse(tile2[j]))){
                    return true;
                }
            }
        }
        return false;

    }
    //Checks if the "this" shares the specified tiles with "tile"
    public boolean checkNeighbor(Tile tile, int[] sides){
        String[] tile1 = this.getSides(0,9);
        String[] tile2 = tile.getSides(0,9);
        for(int i :sides){
            for(int j = 0; j < 4;j++){
                if(tile1[i].equals(tile2[j]) || tile1[i].equals(reverse(tile2[j]))){
                    return true;
                }
            }
        }
        return false;
    }
    public static String reverse(String arr){
        String out = "";
        for(int i = 0; i < arr.length(); i++){
            out += arr.charAt(arr.length()-1-i);
        }
        return out;
    }
    //Returns the tile to the right of "this"
    public Tile getRight(){
        String right = this.getSides(0,9)[3];
        for(Tile neighbor: this.getNeighbors()){
            for(String[] orientation : neighbor.getOrientations()){
                Tile temp = new Tile(orientation,-1);
                if(temp.getSides(0,9)[2].equals(right)){
                    neighbor.setImage(orientation);
                    return neighbor;
                }
            }
        }

        return new Tile(new String[]{"No hay ningun tile a la derecha"},-213);
    }
    //Orients correctly the first piece of every row and return the first tile of the next row.
    public Tile orientCorner(){
        for(String[] orientation: this.getOrientations()){
            boolean failed = false;
            this.setImage(orientation);
            for(Tile neighbor : this.getNeighbors()){
                if(this.checkNeighbor(neighbor, new int[]{0,2}))  {
                    failed = true;
                    break;
                }
            }
            if(failed == false){
                break;
            }
        }
        for(Tile tile: this.getNeighbors()) {
            String bottom = this.getSides(0,9)[1];
            for(String[] orientation : tile.getOrientations()){
                Tile temp = new Tile(orientation,-1);
                String top = temp.getSides(0,9)[0];
                if(top.equals(bottom)) {
                    tile.setImage(orientation);
                    tile.neighbors.remove(this);
                    return tile;
                }
            }
        }
        return new Tile(new String[]{"failed"},777);
    }

    public Tile orientCorner(String botop){
        for(String[] orientation: this.getOrientations()){
            boolean failed = false;
            this.setImage(orientation);
            for(Tile neighbor : this.getNeighbors()){
                if(this.checkNeighbor(neighbor, new int[]{0,2}))  {
                    failed = true;
                    break;
                }
            }
            if(failed == false && botop.equals(this.getSides(0,9)[0])){
                break;
            }
        }
        for(Tile tile: this.getNeighbors()) {
            String bottom = this.getSides(0,9)[1];
            for(String[] orientation : tile.getOrientations()){
                Tile temp = new Tile(orientation,-1);
                String top = temp.getSides(0,9)[0];
                if(top.equals(bottom)) {
                    tile.setImage(orientation);
                    tile.neighbors.remove(this);
                    return tile;
                }
            }
        }
        return new Tile(new String[]{"failed"},777);
    }
}

 class Image extends Tile{
    String[] image;
    Image(int rowNum){
        image = new String[rowNum];
        Arrays.fill(image,"");
    }
    void addRight(int topBound, String[] tile){
        for(int i = 0; i < 8;i++){
            image[topBound + i] += tile[i];
        }
    }
    String getImage() {
        return String.join("\n", this.image);
    }
    public String toString(){
        return String.join("",this.image);
    }
    void rotate(){
       this.image = rotate(this.image);
    }
    void flip(){
        this.image = flip(this.image);
     }
}

public class Day20_2 extends Tile{
    public static void main(String[] args) throws Exception {
        File file = new File("//home//david//eclipse-workspace//AdventOfCode1//src//input");
        Scanner scan = new Scanner(file);
        ArrayList<Tile> tiles = new ArrayList<>();
        String[] image = new String[1000];
        boolean inTile = false;
        String tileImage = "";
        int tileNum = 0;
        while(scan.hasNextLine()){
            String line = scan.nextLine();
            if(line.startsWith("Days.Tile")){
                tileNum = Integer.parseInt(line.split(" ")[1].replace(":",""));
                inTile = true;
            }else if(inTile == true){
                tileImage += line + "\n";
            }
            if(line.equals("") && inTile == true){
                String[] arr = tileImage.split("\n");
                Tile tile = new Tile(arr,tileNum);
                tile.setOrientations();
                tiles.add(tile);
                inTile = false;
                tileImage = "";
            }
        }
        double size = Math.sqrt(tiles.size());
        Tile corner = new Tile(new String[10],-1);
        for(Tile tile : tiles) {
            tile.setNeigbbors(tiles);
            if (tile.getNeighbors().size() == 2) {
                corner = tile;
            }
        }
        //TODO: orient the top-left corner

        //Create a new image
        Image puzzle = new Image(8* (int)size);

        //Add the tiles from left to right and top to bottom
        int separator = 0;
        Tile current = corner;
        String botop = "";
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                //System.out.println(current.getTileNum());
                //Primero de la fila

                if(j == 0) {
                    if(i == 0) {
                        Tile tempCorner = corner.orientCorner();
                        botop = corner.getSides(0, 9)[1];
                        current = corner.getRight();
                        puzzle.addRight(separator, corner.cutSides());
                        corner = tempCorner;
                    }else{
                       Tile tempCorner = corner.orientCorner(botop);
                       botop = corner.getSides(0,9)[1];
                       current = corner.getRight();
                       puzzle.addRight(separator,corner.cutSides());
                       corner = tempCorner;
                    }

                //Ultimo de la fila
                }else if( j == size-1){
                    puzzle.addRight(separator, current.cutSides());
                    current = corner;
                }else {
                    puzzle.addRight(separator, current.cutSides());
                    current = current.getRight();
                }
            }
            separator += 8;
        }

        String monsterRegex = "..................#..{76}#....##....##....###.{76}.#..#..#..#..#..#...";
        int monsterCount = 0;
        for(int i = 0; i < 4; i++) {
            if(monsterCounter(puzzle.toString(),monsterRegex) != 0) {
                monsterCount = monsterCounter(puzzle.toString(),monsterRegex);
                break;
            }
            puzzle.flip();
            if(monsterCounter(puzzle.toString(),monsterRegex) != 0) {
                monsterCount = monsterCounter(puzzle.toString(),monsterRegex);
                break;
            }
            puzzle.flip();
            puzzle.rotate();
        }
        int hashesCount = 0;

        Pattern hashes = Pattern.compile("#");
        Matcher matcher1 = hashes.matcher(puzzle.getImage());

        while(matcher1.find())
            hashesCount++;

        int answer = hashesCount - (monsterCount*15);
        System.out.println(answer);
    }
    public static int monsterCounter(String puzzleImage,String regex){
        Pattern nessi = Pattern.compile(regex);
        Matcher matcher = nessi.matcher(puzzleImage);
        int monsterCount = 0;
        boolean statement = matcher.find();
        while (statement){
            monsterCount++;
            statement = matcher.find(matcher.start()+1);

        }
       return monsterCount;
    }
}
