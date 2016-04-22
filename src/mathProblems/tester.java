package mathProblems;
import java.io.IOException;
import java.net.MalformedURLException;

import javax.script.ScriptException;
import mathProblems.EasyProblem;
public class tester {

	public static void main(String[] args) throws ScriptException, MalformedURLException, IOException{
		EasyProblem prob1 = new EasyProblem();
		System.out.println(prob1);
		System.out.println(prob1.getSolution());
		
		MediumProblem prob2 = new MediumProblem();
		System.out.println(prob2);
		System.out.println(prob2.getSolution());
		
		HardProblem prob3 = new HardProblem();
		System.out.println(prob3);
		System.out.println(prob3.getSolution());
	}

}
