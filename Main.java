/**
 * 
 */

/**
 * @author Administrator
 *
 */
import java.io.*;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Main {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws ScriptException 
	 */
	public static void main(String[] args) throws IOException, ScriptException {
		// TODO Auto-generated method stub
		
		try (BufferedReader br = new BufferedReader(new FileReader("input.txt"))) {
		    String line;
		    while ((line = br.readLine()) != null) {
		    	String[] operands = line.split("[-+*/]");
		    	for(int i=0;i<operands.length;i++){
		    		line = line.replace(operands[i], Integer.toString(RomanNumber.decode(operands[i])));
		    	}
		    	ScriptEngineManager manager = new ScriptEngineManager();
		    	ScriptEngine se = manager.getEngineByName("JavaScript");        
		    	Object result = se.eval(line);
		    	System.out.println(RomanNumber.toRoman((int)result));
		    }
		}
		
	}
}
