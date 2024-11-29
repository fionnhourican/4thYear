import org.antlr.v4.runtime.*;

public class calSyntaxErrorListener extends BaseErrorListener {
    private boolean hasErrors = false;

    @Override
    public void syntaxError(Recognizer<?, ?> recognizer,
                            Object offendingSymbol,
                            int line, int charPositionInLine,
                            String msg, RecognitionException e) {
        hasErrors = true;
        System.err.println("line " + line + ":" + charPositionInLine + " " + msg);
    }

    public boolean hasErrors() {
        return hasErrors;
    }
}