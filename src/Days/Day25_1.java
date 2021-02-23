package Days;

import java.io.File;
import java.util.*;


public class Day25_1 {

    public static void main(String[] args) throws Exception {
        //5764801
        //17807724
        //6930903
        //19716708
        int cardPublic = 6930903;
        int doorPublic = 19716708;

        //int cardPublic = 5764801;
        //int doorPublic = 17807724;

        int value = 1;
        int subjectNumber = 7;

        int cardLoop = findLoopSize(cardPublic);
        int doorLoop = findLoopSize(doorPublic);

            System.out.println(findKey(cardLoop,doorPublic));


    }
    public static long findKey(int loopSize, int oppositeKey){
       long value = 1;
       int subjectNumber = oppositeKey;

        for(int i = 0; i < loopSize; i++){
            value = (value*subjectNumber) % 20201227;
        }
        return value;
    }
    public static int findLoopSize(int publicKey){

        int value = 1;
        int subjectNumber = 7;
        int loopSize = 0;

        while(value != publicKey){

            value = (value*subjectNumber) % 20201227;
            loopSize++;


        }

        return loopSize;
    }
}