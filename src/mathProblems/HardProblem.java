package mathProblems;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Scanner;

import javax.script.ScriptException;

public class HardProblem extends MathProblem {
	private final static String URL = "http://jservice.io/api/random";
	private String answer;
	
	public HardProblem() throws MalformedURLException, IOException, ScriptException {
		// TODO Auto-generated method stub
		URLConnection connection = new URL(URL).openConnection();
		connection.setRequestProperty("Accept-Charset", "UTF-8");
		InputStream response = connection.getInputStream();
		Scanner scanner = new Scanner(response);
		String responseBody = scanner.useDelimiter("\\A").next();
		int beginAnswer = responseBody.indexOf("answer") + 9;//distance from "answer" to the answer
		int endAnswer = responseBody.indexOf("question") - 3;
		answer = responseBody.substring(beginAnswer, endAnswer);
		int beginQuestion = endAnswer+14;
		int endQuestion = responseBody.indexOf("value") - 3;
		String question = responseBody.substring(beginQuestion, endQuestion);
		int beginDifficulty = responseBody.indexOf("title") + 8;
		int endDifficulty = responseBody.indexOf("created_at", responseBody.indexOf("created_at") + 1) - 3;
		this.difficulty = responseBody.substring(beginDifficulty,endDifficulty);
		this.setExpression(question);
		this.solve();
		userAttempt = this.triggerQuestion();
		this.setUserEvaluation(this.evaluate());
		scanner.close();
		System.out.println(this.getSolution());
	}

	public String toString() {
		return this.getExpression();
	}
	
	public void solve() throws ScriptException {
		answer = answer.toLowerCase();
		this.setSolution(answer);
	}

}
