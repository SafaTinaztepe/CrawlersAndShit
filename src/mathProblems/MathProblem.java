/*
   _____       _               _ _   _           _   _                    
  / ____|     | |             (_) | | |         | | | |                   
 | (___  _   _| |__  _ __ ___  _| |_| |_ ___  __| | | |__  _   _          
  \___ \| | | | '_ \| '_ ` _ \| | __| __/ _ \/ _` | | '_ \| | | |         
  ____) | |_| | |_) | | | | | | | |_| ||  __/ (_| | | |_) | |_| |         
 |_____/ \__,_|_.__/|_| |_| |_|_|\__|\__\___|\__,_| |_.__/ \__, |         
  ______    _               _                   _    _____  __/ | __      
 |  ____|  | |             | |                 | |  / ____||___/ / _|     
 | |__ __ _| |__   __ _  __| |   __ _ _ __   __| | | (___   __ _| |_ __ _ 
 |  __/ _` | '_ \ / _` |/ _` |  / _` | '_ \ / _` |  \___ \ / _` |  _/ _` |
 | | | (_| | | | | (_| | (_| | | (_| | | | | (_| |  ____) | (_| | || (_| |
 |_|  \__,_|_| |_|\__,_|\__,_|  \__,_|_| |_|\__,_| |_____/ \__,_|_| \__,_|                                                                          
 */
package mathProblems;
import java.util.Random;
import javax.script.ScriptException;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public abstract class MathProblem {
	Random random;
	String difficulty;
	String solution;
	String expression;
	String userAttempt;
	boolean userEvaluation;
	
	public MathProblem(){
		Random random = new Random();
		userEvaluation = false;
		
	}
	public MathProblem(int difficulty){
		@SuppressWarnings("unused")
		Random random = new Random();
	}
	public boolean getUserEvaluation(){
		return this.userEvaluation;
	}
	
	public void setUserEvaluation(boolean userEvaluation){
		this.userEvaluation = userEvaluation;
	}
	
	public String getExpression(){
		return this.expression;
	}
	
	public String getSolution(){
		return this.solution;
	}
	
	public void setExpression(String expression){
		this.expression = expression;
	}
	
	public void setSolution(String solution){
		this.solution = solution;
	}
	
	public boolean checkSolution(String answer){
		answer.toLowerCase();
		return answer.equals(this.solution);

	}
	
	public abstract String toString();
	public abstract void solve() throws ScriptException;
	
	
	public String triggerQuestion(){
		String[] options = {"Bring it on!"};
		JPanel panel = new JPanel();
		JLabel label = new JLabel(this.getExpression());
		JTextField text = new JTextField(10);
		panel.add(label);
		panel.add(text);
		
		int inp = JOptionPane.showOptionDialog(
				null, panel, this.difficulty, JOptionPane.NO_OPTION, JOptionPane.QUESTION_MESSAGE,
				null, options, options[0]);
		if(inp == 0){userAttempt = text.getText();}
		return userAttempt;
	}
	
	public boolean evaluate(){
		return this.userAttempt.equals(this.solution);
	}	
}
