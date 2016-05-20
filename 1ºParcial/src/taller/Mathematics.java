package taller;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

//TODO:TERMINAR
public class Mathematics {
	
	public void convertInftoPos(String s){
		
		List<Character> ans = new ArrayList();
		Deque<Operator> stack = new LinkedList<>();
		
		for(char c : s.toCharArray()){
			Operator op = getOperator(c);
			
			if (op == null) 	// es un numero
				ans.add(c);
			
			else {
				//switch()
			}
		}
	}
	
	
	public Operator getOperator( char c){
		switch(c) {
		case '+' :
			return new Sum();
		case '-' :
			return new Subs();
		case '*' :
			return new Mult();
		case '/' :
			return new Div();
		case '(' :
			return new OpenParenthesis();
		default : return null;

		}
	}
}
