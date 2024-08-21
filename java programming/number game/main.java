import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class main {

    public static int checklimit(int limit){
        int guesslimit = 0;
        if(limit<=30){
            guesslimit = 3;
        }
        else if(limit<=100 && limit <30){
            guesslimit = 6;
        }
        else{
            guesslimit=10;
        }
        return guesslimit;
    }
    public static int checkguess(int limit, int guesses,boolean repeat){
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        System.out.println("limit is now : "+ limit);
        int comp = random.nextInt(limit);
        int count =0;
        while (true) { 
            count++;
            guesses ++;
            int user_guesses = 0;
            int value = checklimit(limit);
            if(repeat){    
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
            else{
                if(user_guesses < comp){
                    System.out.println("Your guess is smaller than the number!");
                }
                else if(user_guesses > comp){
                    System.out.println("Your guess is larger then the number");
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
        while(true){
            System.out.println("Welcome to number gussing game\n1) Play with infinite chances\n2) Play with limited chances\n3) EXIT \n(1 or 2 or exit)\nEnter : ");
            int ans1 = scanner.nextInt();
            boolean repeat= false;
            if(ans1 == 1){
                repeat = false;
            }
            else if(ans1 == 2){
                repeat = true;
            }
            if(ans1 == 1){    
                while(again){
                    System.out.println("Enter the limit (0-?): ");
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
            else if( ans1 == 2){
                while(again){
                    System.out.println("Enter the limit (0-?): ");
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
                System.exit(0);
            }
        }
    }
}
    