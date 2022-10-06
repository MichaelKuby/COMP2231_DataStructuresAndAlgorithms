import java.io.FileNotFoundException;

/**
 * FilmCameraAnalyzer demonstrates the use of a binary decision tree to
 * help you buy a film camera.
 */
public class FilmCameraAnalyzer
{
	/**
	 *  Asks questions of the user to diagnose a medical problem.
	 */
	public static void main(String[] args) throws FileNotFoundException
	{
		System.out.println("So, you wanna buy a film camera.");

		DecisionTree expert = new DecisionTree("input2.txt");
		expert.evaluate();
	}
}
