package mathProblems;
import java.util.Random;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class MediumProblem extends MathProblem {

	String[] operators;
	int no1;
	int no2;
	String operator;
	ScriptEngineManager manager;
	ScriptEngine engine;

	public MediumProblem() throws ScriptException{
		this.difficulty = "Medium";
		random = new Random();
		manager = new ScriptEngineManager();
		engine = manager.getEngineByName("js");
		
		no1 = random.nextInt(21);
		no1 = random.nextDouble() > .7 ? no1*-1 : no1;
		
		no2 = random.nextInt(21);
		no2 = random.nextDouble() > .7 ? no2*-1 : no2;
		
		operators = new String[]{"*","*","/"};
		operator = operators[random.nextInt(2)];
		
		this.setExpression((no1<0?"("+no1+")":no1) + " " + operator + " " + (no2<0?"("+no2+")":no2));
		this.solve();
		userAttempt = this.triggerQuestion();
		this.setUserEvaluation(this.evaluate());
	}

	public String toString(){
		return "What is the value of " + this.getExpression() + "?";
	}

	public void solve() throws ScriptException {
		// TODO Auto-generated method stub
		String expression = this.getExpression();
		expression = expression.replaceAll(" ", "").trim();
		String solution = engine.eval(expression).toString();
		this.setSolution(solution);
	}
	
	
}
