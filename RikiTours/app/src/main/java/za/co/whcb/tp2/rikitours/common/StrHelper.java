package za.co.whcb.tp2.rikitours.common;

/**
 * Created by Shaun Mesias on 2016/12/03.
 */
public class StrHelper {

    public static String FirstLetterCapitalise(String word)
    {
        String firstLetter = null;

        firstLetter = word.substring(0,1);
        word = word.substring(1);
        word = firstLetter.toUpperCase() + word;
        return word;
    }
}
