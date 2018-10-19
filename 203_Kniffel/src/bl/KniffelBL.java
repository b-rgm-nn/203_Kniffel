package bl;

import java.util.Arrays;

/**
 *
 * @author Matthias
 */
public class KniffelBL {
    
    public int getPoints(KniffelValue value, int[] diceResult) {
        Arrays.sort(diceResult);
        switch(value) {
            case NurEinser: 
                return getNumResults(diceResult, 1); 
            case NurZweier: 
                return getNumResults(diceResult, 2); 
            case NurDreier: 
                return getNumResults(diceResult, 3);
            case NurVierer: 
                return getNumResults(diceResult, 4); 
            case NurFuenfer:
                return getNumResults(diceResult, 5); 
            case NurSechser:
                return getNumResults(diceResult, 6); 
            case Pasch3:
                return getPasch(diceResult, 3);
            case Pasch4:
                return getPasch(diceResult, 4);
            case FullHouse:
                return getFullHouse(diceResult);
            case StrasseKlein: 
                return getStreet(diceResult, 4) * 30;
            case StrasseGross: 
                return getStreet(diceResult, 5) * 40;
            case Kniffel: 
                return getKniffel(diceResult);
            case Chance:
                return getChance(diceResult);
            default:
                return -100;
        }
    }
    
    private int getChance(int[] diceResult) {
        int sum = 0;
        for (int i : diceResult) {
            sum += i;
        }
        return sum;
    }
    
    private int getNumResults(int[] diceResult, int number) {
        int count = 0;
        for (int res : diceResult) {
            if(res == number) count++;
        }
        return count * number;
    }
    
    private int getPasch(int[] diceResult, int numItems) {
        for (int i = 1; i <= 6; i++) {
            int res = getPasch(diceResult, numItems, i);
            if(res > 0) {
                return res;
            }
        }
        return 0;
    }
    
    private int getPasch(int[] diceResult, int numItems, int number) {
        int itemsLeft = numItems;
        for (int result : diceResult) {
            if(result == number){
                itemsLeft--;
            }
        }
        if(itemsLeft <= 0) {
            return numItems * number;
        }
        return 0;
    }
    
    private int getFullHouse(int[] diceResult) {
        return (diceResult[0] == diceResult[1]
                && diceResult[3] == diceResult[4]
                && ( (diceResult[2] == diceResult[0]) || (diceResult[2] == diceResult[4]) )) ? 25 : 0;
    }

    private int getStreet(int[] diceResult, int length) {
        int street = 1;
        for (int i = 1; i < diceResult.length; i++) {
            if(diceResult[i] == diceResult[i-1] + 1)
                street++;
            else
                street = 0;
            if(street == length) {
                return 1;
            }
        }
        return 0;
    }

    private int getKniffel(int[] diceResult) {
        if(getPasch(diceResult, 5) > 0) {
            return 50;
        }
        return 0;
    }
}
