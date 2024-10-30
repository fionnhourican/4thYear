import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import org.antlr.v4.runtime.CharStreams;

import java.io.FileInputStream;
import java.io.InputStream;

public class cal {
	public static void main(String[] args) throws Exception {
		try {
			String inputFile = null;
			if (args.length > 0)
				inputFile = args[0];
			InputStream is = System.in;
			if (inputFile != null)
				is = new FileInputStream(inputFile);

			calLexer lexer = new calLexer(CharStreams.fromStream(is));
			CommonTokenStream tokens = new CommonTokenStream(lexer);
			calParser parser = new calParser(tokens);

			// Create an instance of the custom error listener
			calSyntaxErrorListener errorListener = new calSyntaxErrorListener();

			// Remove default listeners and add the custom listener
			parser.removeErrorListeners();
			lexer.removeErrorListeners();
			parser.addErrorListener(errorListener);
			lexer.addErrorListener(errorListener);

			ParseTree tree = parser.prog();

			// Check if any errors occurred during parsing or lexical analysis
			if (errorListener.hasErrors()) {
				System.out.println(args[0] + " has not parsed");
			} else {
				System.out.println(args[0] + " parsed successfully");
			}
		} catch (Exception e) {
			System.out.println(args[0] + " has not parsed");
		}
	}
}
