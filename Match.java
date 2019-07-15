import java.util.Scanner;

public class Match {

	public static void main(String[] args) {
		Scanner user = new Scanner(System.in);
		System.out.println("Enter a parentheses string:");
		String paren = user.nextLine();
		user.close();
		System.out.println(isBalanced(paren));
	}
	
	public static boolean isBalanced(String paren) {

		  int numberOfParen = 0;

		  for(int i=0; i < paren.length(); i++) {      
			    if(paren.charAt(i) == '('){
			    	numberOfParen += 1;
			    } else if(paren.charAt(i) == ')'){
			    	numberOfParen -= 1;    
			    }
		  }
		  if (numberOfParen == 0)
				  return true;
		  else
			  return false;
		}
}

