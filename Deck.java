/**
 * Write a description of class Deck here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Deck  
{
    private Card[] initialDeck;
    
    public Deck()
    {
        initialDeck = new Card[]
        {
            new Card("ace_of_hearts.GIF", 1),
            new Card("two_of_hearts.GIF", 2),
            new Card("three_of_hearts.GIF", 3),
            new Card("four_of_hearts.GIF", 4),
            new Card("five_of_hearts.GIF", 5),
            new Card("six_of_hearts.GIF", 6),
            new Card("seven_of_hearts.GIF", 7),
            new Card("eight_of_hearts.GIF", 8),
            new Card("nine_of_hearts.GIF", 9),
            new Card("ten_of_hearts.GIF", 10),
            new Card("jack_of_hearts.GIF", 11),
            new Card("queen_of_hearts.GIF", 12),
            new Card("king_of_hearts.GIF", 13),
        };
    }
    
    public Card[] getShuffledDeck()
    {
        Card[] shuffledDeck = new Card[initialDeck.length];
        Card[] tempDeck = new Card[initialDeck.length];
        shuffledDeck = initialDeck;
        tempDeck = initialDeck;
        
        // Makes sure that shuffledCards has no null elements
        for(int i = 0; i < initialDeck.length; i++)
        {
            shuffledDeck[i] = initialDeck[i];
        }
        
        // This algorithm will swap the cards 300 times
        for(int i = 0; i < 300; i++)
        {
            int shuffledIndex = (int)(Math.random() * initialDeck.length);
            int tempIndex = (int)(Math.random() * initialDeck.length);
            Card shuffled = shuffledDeck[shuffledIndex];
            shuffledDeck[shuffledIndex] = tempDeck[tempIndex];
            tempDeck[tempIndex] = shuffled;
        }
        return shuffledDeck;
    }
}
