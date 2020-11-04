package com.tsystems.javaschool.tasks.calculator;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Calculator {

    /**
     * Evaluate statement represented as string.
     *
     * @param statement mathematical statement containing digits, '.' (dot) as decimal mark,
     *                  parentheses, operations signs '+', '-', '*', '/'<br>
     *                  Example: <code>(1 + 38) * 4.5 - 1 / 2.</code>
     * @return string value containing result of evaluation or null if statement is invalid
     */
    public String evaluate(String statement) {
        if (statement == null || statement.isEmpty() || statement.contains(",") || statement.contains("//")) return null;
        else {
            ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
            ScriptEngine scriptEngine = scriptEngineManager.getEngineByName("Nashorn");
            try {
                String result = scriptEngine.eval(statement)+"";
                return Double.isInfinite(Double.parseDouble(result)) ? null : result;
            } catch (ScriptException e) {
                System.out.println("Statement is not valid. Return null.");
            }
        }
        return null;
    }
}
