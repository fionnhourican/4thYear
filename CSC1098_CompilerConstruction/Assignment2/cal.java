import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import org.antlr.v4.runtime.CharStreams;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

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

			// First pass: build the symbol table
			//SymbolTableVisitor symbolTableVisitor = new SymbolTableVisitor();
			//symbolTableVisitor.visit(tree);
			//SymbolTable symbolTable = symbolTableVisitor.getSymbolTable();
			SymbolTable symbolTable = new SymbolTable();
	
			// Second pass: evaluate the program with semantic checks
			EvalVisitor evalVisitor = new EvalVisitor(symbolTable);
			evalVisitor.visit(tree);

			//evalVisitor.printTree(tree, parser, 0);

			//evalVisitor.printSymbolTable();

			// Check if every variable is both written to and read from
			Set<String> writtenVariables = symbolTable.getWrittenVariables();
			Set<String> readVariables = symbolTable.getReadVariables();

			for (String variable : writtenVariables) {
				if (!readVariables.contains(variable)) {
					System.err.println("Warning: " + variable + " is written to but not read from.");
				} else{
				}
			}

			for (String variable : readVariables) {
				if (!writtenVariables.contains(variable)) {
					System.err.println("Warning: " + variable + " is read from but not written to.");
				}
			}

			// Print the written variables
			/*
			System.out.println("Written Variables:");
			for (String variable : writtenVariables) {
				System.out.println(variable);
			}
		
	
			// Print the read variables
			System.out.println("Read Variables:");
			for (String variable : readVariables) {
				System.out.println(variable);
			}
			
			System.out.println("Memory values: " + evalVisitor.getMemory().values());
			System.out.println("Memory keyset: " + evalVisitor.getMemory().keySet());

			for (String variable : evalVisitor.getMemory().keySet()) {
				System.out.println("Variable: " + variable + " Value: " + evalVisitor.getMemory().get(variable));
			}
			*/

			// Generate TAC code
			List<String> tacInstructions = evalVisitor.getTacInstructions();

			// Print TAC instructions
			/*
			System.out.println("TAC Instructions:");
			for (String instruction : tacInstructions) {
				System.out.println(instruction);
			}*/

			// Generate the output file name by replacing .cal with .ir
            String tacFileName = inputFile.replace(".cal", ".ir");

            // Write TAC instructions to a file
            try (PrintWriter writer = new PrintWriter(new FileWriter(tacFileName))) {
                //writer.println("main:");
                for (String instruction : tacInstructions) {
                    writer.println(instruction);
                }
				writer.println("call _exit, 0");
            }

			//evalVisitor.printSymbolTable();
			//symbolTable.printAllScopes();
			//evalVisitor.printSymbolTable();

			//SemanticCheckVisitor semanticCheckVisitor = new SemanticCheckVisitor(symbolTableVisitor.getSymbolTable());
        	//semanticCheckVisitor.visit(tree);
			/*
			// Evaluate the parse tree
            EvalVisitor eval = new EvalVisitor();
            eval.visit(tree);

			// Output the parse tree nicely
			eval.printParseTree(tree, parser);

			SymbolTableVisitor symbolTableVisitor = new SymbolTableVisitor();
            symbolTableVisitor.visit(tree);
			*/
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
