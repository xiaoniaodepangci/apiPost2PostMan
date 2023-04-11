package postman.apipost.convert.postman2apipost.runner;


import org.springframework.core.io.ClassPathResource;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

//@Component
public class JavascriptBeautifierForJava {

    // my javascript beautifier of choice
    private static final String BEAUTIFY_JS_RESOURCE = "/static/beautify.js";

    // name of beautifier function
    private static final String BEAUTIFY_METHOD_NAME = "js_beautify";

    private final ScriptEngine engine;

    JavascriptBeautifierForJava() throws ScriptException, IOException {
        engine = new ScriptEngineManager().getEngineByName("nashorn");
        engine.eval("var global = this;");
        InputStream inputStream = new ClassPathResource(BEAUTIFY_JS_RESOURCE).getInputStream();
        engine.eval(new InputStreamReader(inputStream));
    }

    public String beautify(String javascriptCode) throws ScriptException, NoSuchMethodException {
        return (String) ((Invocable) engine).invokeFunction(BEAUTIFY_METHOD_NAME, javascriptCode);
    }


}