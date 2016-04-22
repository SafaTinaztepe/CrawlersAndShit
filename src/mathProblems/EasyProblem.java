package mathProblems;

import java.util.Random;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.script.ScriptEngine;

public class EasyProblem extends MathProblem{
	String[] operators;
	int no1;
	int no2;
	String operator;
	ScriptEngineManager manager;
	ScriptEngine engine;
	
	public EasyProblem() throws ScriptException{
		
		this.difficulty = "Easy";
		random = new Random();
		//engine to mathematically evaluate strings
		manager = new ScriptEngineManager();
		engine = manager.getEngineByName("js");
		
		no1 = random.nextInt(100);
		//no1 = random.nextDouble() > .7 ? no1/=2 : no1;
		no1 = random.nextDouble() > .7 ? no1*-1 : no1;
		
		no2 = random.nextInt(100);
		//no2 = random.nextDouble() > .7 ? no2 /=2 : no2;
		no2 = random.nextDouble() > .7 ? no2*-1 : no2;
		
		operators = new String[]{"+","+","-"};
		operator = operators[random.nextInt(2)];
		
		this.setExpression((no1<0?"("+no1+")":no1) + " " + operator + " " + (no2<0?"("+no2+")":no2));
		this.solve();
		userAttempt = this.triggerQuestion();
		this.setUserEvaluation(this.evaluate());
		
	}

	public void solve() throws ScriptException{
		//replace all the spaces with ""
		//parse to mathematically evaluate string
		String expression = this.getExpression();
		expression = expression.replaceAll(" ", "").trim();
		String solution = engine.eval(expression).toString();
		this.setSolution(solution);
	}
	
	public String toString(){
		return "What is the value of " + this.getExpression() + "?";
	}

}
