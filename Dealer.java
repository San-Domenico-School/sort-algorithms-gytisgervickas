import greenfoot.*;
import java.util.ArrayList;

/**
 * This class declares, instantiates, and initializes a new deck.  Students 
 * should then implement the sort method at the botton of this class to see 
 * if they understanding basic ArrayList sort algorithms.
 * 
 * @author Gytis Gervickas
 * @version Feb 14, 2023
 */

public class Dealer extends Actor
{
    private Deck deck;
    private Card[] shuffledDeck;
    private Card[] selectionSort;
    private Card[] insertionSort;
    private Card[] mergeSort;
    
    // Instantiates a new deck
    public Dealer()
    {
        deck = new Deck();
        shuffledDeck = deck.getShuffledDeck();
        initializeSortArrays();
    }
    
    // Adds cards to board after Deck is initialized
    public void addedToWorld(World world)
    {
        showCards(world, shuffledDeck, 80);
        showCards(world, selectionSort(selectionSort, shuffledDeck.length), 220);
        showCards(world, insertionSort(insertionSort, shuffledDeck.length), 360);
        showCards(world, mergeSort(mergeSort, shuffledDeck.length), 500);
    }    
    // Shuffles the unshuffled deck
    
    
    // Sets all the sorted arrays equal to the shuffledCard array
    private void initializeSortArrays()
    {
        selectionSort = new Card[shuffledDeck.length];
        insertionSort = new Card[shuffledDeck.length];
        mergeSort = new Card[shuffledDeck.length];
        
        for(int i = 0; i < shuffledDeck.length; i++)
        { 
            Card card1 = new Card(shuffledDeck[i].getImageFile(),shuffledDeck[i].getValue());
            Card card2 = new Card(shuffledDeck[i].getImageFile(),shuffledDeck[i].getValue());
            Card card3 = new Card(shuffledDeck[i].getImageFile(),shuffledDeck[i].getValue());
            selectionSort[i] = card1;
            insertionSort[i] = card2;
            mergeSort[i] = card3;
        }
    }
    
    // Places card on board at y
    private void showCards(World world, Card[] cards, int y)
    {
        
       for(int i = 0; i < cards.length; i++)
       {
           world.addObject(cards[i],58 + 30 * i, y);
       } 
    }
    
    /* This is where the students attempt their sort algorithm by taking the
     * cards from the shuffled list and adding them to the sorted list.     
    **/
    
    /* Using the for each loops compare two cards and the one that has the smallest value
     * will be sorted to the sorted list. Usually it will be from smallest to the biggest 
     * cards since the lower number switches with a bigger one.
     * 
     */
    private Card[] selectionSort(Card[] arr, int n)
    {
        int min_index = 0;
        
        Card temp;
        
        for(int i = 0; i < arr.length - 1; i++)
        {
            int minElement = i;
            
            for(int k = i + 1; k < arr.length; k++)
            {
                if(arr[k].getValue() < arr[minElement].getValue())
                {
                    minElement = k;
                }
               
               
            }
            
            temp = arr[minElement];
            
            arr[minElement] = arr[i];
            
            arr[i] = temp;
        }            
          return selectionSort;    
    }
    
    
    /* Using the for each loops compare every new card to the beginning, pretty similar like we
     * did in a classroom asking "Am I bigger?". Until the lower number is found, the bigger 
     * cards go in front of it.
     * 
     */
    private Card[] insertionSort(Card[] arr, int n)
    {
        Card temp;
        
        for(int i = 0; i < arr.length; i++)
        {
            for(int k = 0; k < arr.length; k++)
            {
                if(arr[i].getValue() < arr[k].getValue())
                {
                    temp = arr[i];
                    arr[i] = arr[k];
                    arr[k] = temp;
                }

            }
           
        }
        
        return insertionSort;
    }
    
    /* Merge sort divides the array into two halves, and sort each half by recursively 
    * dividing it into halves and arrange them, then merge the sorted result in the end.
    */
    
    public Card[] mergeSort(Card[] a, int n)
    {
        /* What is the purpose of the following if statement?
        *“n” represents the length of the card deck, which states that if there is only
        *one card in the deck, then we do not have to sort it, just return it.
        */
        if (n < 2) 
        {
            return a;
        }
        
        // Explain the following 3 lines.
        int mid = n / 2;
        Card[] l = new Card[mid];
        Card[] r = new Card[n - mid];
    
        /* What does this for-loop do?
         * This is duplicating the value from the mother array to the left array.
        */
        for (int i = 0; i < mid; i++) 
            {
            l[i] = a[i];
            }
   
        /* What does this for-loop do?
         * Just as the for loop above, it is duplicating the values from the mother array 
         * to the right array.
         */
        for (int i = mid; i < n; i++) 
            {
            r[i - mid] = a[i];
            }
        
        /* What is the purpose of the next two lines?  
         * 
         * Why are they required?
         * 
        */
        mergeSort(l, mid);
        mergeSort(r, n - mid);
    
        // What is the goal of this return statement, when is it      
        // executed, and what exactly is getting returned?
        return merge(a, l, r, mid, n - mid);
    }
 
    // Write here what merge does.
    public Card[] merge(Card[] a, Card[] l, Card[] r, int left, int right) 
    { 
        // Why are these 3 ints declared and assigned zeros?
        int i = 0, j = 0, k = 0;
        
        // What is this while loop doing?
        while (i < left && j < right) 
        {
            // What is this if/else block doing?
            if (l[i].getValue() <= r[j].getValue()) 
            {
                a[k++] = l[i++];
            }
            else 
            {
                a[k++] = r[j++];
            }
        }
     
        // What are these two while loops doing and why are they needed.  
        // Doesn't the above while loop do the same thing?
        while (i < left)
        {
            a[k++] = l[i++];
        }
        
        while (j < right)
        {
            a[k++] = r[j++];
        }
        
        // What gets returned here?
        return a;
    }
}




