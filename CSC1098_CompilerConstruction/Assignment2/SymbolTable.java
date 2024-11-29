import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import org.antlr.v4.runtime.tree.ParseTree;

public class SymbolTable {
    private Stack<Map<String, String>> scopes;
    private List<Scope> allScopes;
    private Map<String, Integer> functionParameterCounts = new HashMap<>();
    private Map<String, String> functionReturnTypes = new HashMap<>();
    private Set<String> writtenVariables = new HashSet<>();
    private Set<String> readVariables = new HashSet<>();

    public SymbolTable() {
        scopes = new Stack<>();
        allScopes = new ArrayList<>();
        enterScope("global"); // Initialize with a global scope
    }

    public void enterScope(String name) {
        Map<String, String> newScope = new LinkedHashMap<>();
        scopes.push(newScope);
        allScopes.add(new Scope(name, newScope));
        //System.out.println("Entered new scope: " + name);
    }

    public void exitScope() {
        if (!scopes.isEmpty()) {
            //System.out.println("Exiting scope: " + allScopes.get(allScopes.size() - 1).name);
            scopes.pop();
        }
    }

    public void insert(String name, String type) {
        if (!scopes.isEmpty()) {
            scopes.peek().put(name, type);
            //System.out.println("Inserted " + name + " : " + type + " into scope: " + allScopes.get(allScopes.size() - 1).name);
        }
    }

    public void insertFunctionParameterCount(String functionName, int paramCount) {
        functionParameterCounts.put(functionName, paramCount);
    }

    public void insertFunctionReturnType(String functionName, String returnType) {
        functionReturnTypes.put(functionName, returnType);
    }

    public void insertVariable(String name, String type) {
        if (!allScopes.isEmpty()) {
            scopes.peek().put(name, "var:" + type);
        }
    }

    public void insertConstant(String name, String type) {
        if (!allScopes.isEmpty()) {
            scopes.peek().put(name, "const:" + type);
        }
    }

    public void insertParameter(String name, String type) {
        if (!allScopes.isEmpty()) {
            scopes.peek().put(name, "param:" + type);
        }
    }

    public Map<String, String> getFunctionReturnTypes() {
        return functionReturnTypes;
    }

    public int getFunctionParameterCount(String functionName) {
        if (functionParameterCounts.containsKey(functionName)) {
            return functionParameterCounts.get(functionName);
        } else {
            return -1; // Return -1 to indicate that the function is not found
        }
    }

    public void markVariableWritten(String name) {
        writtenVariables.add(name);
    }

    public void markVariableRead(String name) {
        readVariables.add(name);
    }

    public Set<String> getWrittenVariables() {
        return writtenVariables;
    }

    public Set<String> getReadVariables() {
        return readVariables;
    }

    public String lookup(String name) {
        for (int i = scopes.size() - 1; i >= 0; i--) {
            if (scopes.get(i).containsKey(name)) {
                String value = scopes.get(i).get(name);
                if (value.startsWith("var:") || value.startsWith("const:") || value.startsWith("param:")) {
                    return value.split(":")[1];
                }
                return value;
            }
        }
        return null; // Not found
    }

    public String getType(String name) {
        for (int i = scopes.size() - 1; i >= 0; i--) {
            if (scopes.get(i).containsKey(name)) {
                String value = scopes.get(i).get(name);
                if (value.startsWith("var:") || value.startsWith("const:") || value.startsWith("param:")) {
                    return value.split(":")[0];
                }
                return value;
            }
        }
        return null; // Not found
    
    }

    public Boolean IsFunctionParent(ParseTree ctx) {
        while (ctx.getParent() != null) {
            if (ctx.getParent() == null) {
                return false;
            }
            if (ctx.getParent().getClass().getSimpleName().equals("FunctionContext")) {
                return true;
            }
            ctx = ctx.getParent();
            if (ctx.getParent().getClass().getSimpleName().equals("ProgContext")) {
                return false;
            }
        }
        return false;
    }

    public boolean isDeclaredInCurrentScope(String name) {
        if (!scopes.isEmpty()) {
            return scopes.peek().containsKey(name);
        }
        return false;
    }

    public void printCurrentScope() {
        System.out.println("Current Symbol Table:");
        for (int i = 0; i < scopes.size(); i++) {
            System.out.println("Scope: " + allScopes.get(i).name);
            for (Map.Entry<String, String> entry : scopes.get(i).entrySet()) {
                System.out.println("  " + entry.getKey() + " : " + entry.getValue());
            }
        }
    }

    public void printAllScopes(Map<String, Object> memory) {
        System.out.println("-----------------------------------------------------------------------------------");
        System.out.println("|                                  Symbol Table                                   |");
        System.out.println("-----------------------------------------------------------------------------------");
        for (Scope scope : allScopes) {
            System.out.println("-----------------------------------------------------------------------------------");
            System.out.println("Scope: " + scope.name);
            System.out.println("-----------------------------------------------------------------------------------");
            System.out.printf("%-20s %-20s %-20s %-20s\n", "ID", "Type", "Memory Location", "Return Type");
            System.out.println("-------------------- -------------------- -------------------- --------------------");
            for (Map.Entry<String, String> entry : scope.symbols.entrySet()) {
                String symbolName = entry.getKey();
                String memoryLocation = memory.containsKey(symbolName) ? memory.get(symbolName).toString() : "N/A";
                if (functionReturnTypes.containsKey(symbolName)) {
                    String symbolType = entry.getValue();
                    String returnType = functionReturnTypes.get(symbolName);
                    System.out.printf("%-20s %-20s %-20s %-20s\n", symbolName, symbolType, memoryLocation, returnType);
                } else {
                    String symbolType = entry.getValue().split(":")[0];
                    String type = entry.getValue().split(":")[1];
                    System.out.printf("%-20s %-20s %-20s %-20s\n", symbolName, symbolType, memoryLocation, type);
                }
            }
            System.out.println();
        }
    }

    private static class Scope {
        String name;
        Map<String, String> symbols;

        Scope(String name, Map<String, String> symbols) {
            this.name = name;
            this.symbols = symbols;
        }
    }
}