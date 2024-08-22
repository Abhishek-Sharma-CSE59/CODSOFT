
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class main {

    public static int checklimit(int limit){
        int guesslimit = 0;
        if(limit<=30){
            guesslimit = 3;
            System.out.println("You have 3 guesses only");
        }
        else if(limit<=100 && limit >30){
            guesslimit = 6;
            System.out.println("You have 6 guesses only");
        }
        else{
            System.out.println("You have 10 guesses only");
            guesslimit=10;
        }
        return guesslimit;
    }
    public static int checkguess(int limit, int guesses,boolean repeat){
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        System.out.println("Range is now : "+ limit);
        int comp = random.nextInt(limit);
        int count =0;
        int value;
        while (true) { 
            count++;
            guesses ++;
            int user_guesses = 0;
            if(repeat){    
                value = checklimit(limit);
                if (value != 0){
                    while(count > value){
                        System.out.println("You have reached your limit!");
                        return 0;
                    }
                }
            }           
            try {
                System.out.print("Enter your Guess :");
                user_guesses = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Try Entering integar next time");
                System.exit(0);
            }
            if (user_guesses == comp){
                System.out.println("You got Right!");
                break;
            }
            else if(user_guesses == -1){
                break;
            }
            else{
                if(user_guesses < comp){
                    System.out.println("Hint- Computer Guess is Larger then your Guess!");
                }   
                else if(user_guesses > comp){
                    System.out.println("Hint- Computer Guess is Smaller then your Guess!");
                }
                continue;
                
            }
            
            
        }System.out.println("You got this in " + guesses + " attempts");
        return 0;
    }


    public static int checkint(int limit2){
        Scanner scanner = new Scanner(System.in);
        try {
            limit2 = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Try Entering integar next time");
            return -1;
        }
        if(limit2 <= 0){
            System.out.println("please Enter number greater than 0");
            return -1;
        }
        return limit2;
    }
    public static boolean askagain(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Do you want to play again (yes or no ) : ");
        String ans = scanner.nextLine();
        if(!ans.equalsIgnoreCase("yes")){
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int guesses = 0;
        int limit = 1;
        boolean again = true;
        int ans1;
        while(true){
            again = true;
            System.out.print("-------------------------------\nWelcome to number gussing game\n-------------------------------\n1) Play with infinite chances\n2) Play with limited chances\n3) EXIT \nPress (1/2/3)\nPress : ");
            ans1 = scanner.nextInt();

            // System.out.println("you entered " + ans1);
            boolean repeat= false;
            if(ans1 == 1){
                repeat = false;
            }
            else if(ans1 == 2){
                repeat = true;
            }
            // System.out.println("you entered " + ans1);
            if(ans1 == 1){    
                System.out.println("---------------------------------------------------\nIn this game you have infinite chances,\nto guess the number choosen by the computer\nRules-\n-You have to enter the range in which,\n the computer will choose the number \n-if you want to exit or give up ,\n while guessing the number just enter '-1'\n---------------------------------------------------\n");
                while(again){
                    System.out.print("Starting...\nEnter the range (0-?): ");
                    limit = checkint(limit);
                    if(limit == -1){
                        System.exit(0);
                    }
                    checkguess(limit, guesses,repeat);
                    while(true){
                        if(askagain()){
                            
                            again = false;
                            break;
                        }break;
                    }
                }
            }
            else if(ans1 == 2){
                // System.out.println("Entered the second if");
                while(again){
                    System.out.print("Starting...\nEnter the range (0-?): ");                    
                    limit = checkint(limit);
                    if(limit == -1){
                        System.exit(0);
                    }
                    int count = 0;
                    checkguess(limit, guesses,repeat);
                    while(true){
                        if (askagain()){
                            again = false;
                            break;
                        }break;
                    }
                }
            }
            else if(ans1 == 3){
                System.out.println("exiting...");
                System.exit(0);
            }
            else{
                System.out.println("there is some issue please check it");
            }
        }
    }
}
    