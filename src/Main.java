import java.util.Random;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Random rng = new Random(); // initialize random number generator
        Scanner in = new Scanner(System.in); // initialize scanner
        String donePlaying = ""; // initialize end game variable
        boolean done = false; //ends do while loop for whole app
        boolean done2 = false; // ends do while loop to check if the donePlaying variable is valid
        do
        {
            int die1 = rng.nextInt(6) + 1; //initial roles
            int die2 = rng.nextInt(6) + 1;
            int roll = die1 + die2; // roll sum
            int point = 0; // initialize point variable
            System.out.println("You rolled a " + die1 + " and a " + die2 + "\tThe sum of theses rolls is " + roll); // prints the initial roll
            if (roll == 2 || roll == 3 || roll == 12) // checks if you lost
            {
                System.out.println("You lost by crapping out.");
            }
            else if (roll == 7 || roll == 11) // checks if you won
            {
                System.out.println("You won with a natural!");
            }
            else
            {
                System.out.println("You are trying for point.");
                point = roll; // sets point to the value that is being rolled for
                int moreRolls =0; // initialize more rolls variable
                while (moreRolls != point) // the loop continues as long as the roll value is not equal to the point value.
                {
                    die1 = rng.nextInt(6) + 1;
                    die2 = rng.nextInt(6) + 1;
                    moreRolls = die1 + die2;
                    System.out.println("You rolled a " + die1 + " and a " + die2 + "\tThe sum of theses rolls is " + moreRolls);
                    if (moreRolls == 7) // checks if roll equals 7
                    {
                        moreRolls = point; // stops loop
                        System.out.println("You got a 7 so you lost.");
                    }
                    else if(moreRolls == point)
                    {
                        System.out.println("You made point so you won!");
                    }
                    else
                    {
                        System.out.println("You are trying for point.");
                    }

                }
            }
            System.out.println();

            System.out.print("Would you like to play again? Y/N: ");

            do
            {
                if (in.hasNextLine())
                {
                    donePlaying = in.nextLine();
                    if (donePlaying.equalsIgnoreCase("Y"))
                    {
                        System.out.println("Lets continue."); // continues game
                        done2 = true; // value is valid
                    }
                    else if (donePlaying.equalsIgnoreCase("N"))
                    {
                        done = true; //ends when the user is done
                        done2 = true;
                    }
                    else
                    {
                        System.out.println(donePlaying + " is not a valid choice.\nPlease enter a valid choice."); //if invalid response, it asks again
                    }
                }
                System.out.println();
            }while (!done2);
        }while(!done);
    }
}