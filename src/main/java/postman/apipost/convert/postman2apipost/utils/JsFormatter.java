package postman.apipost.convert.postman2apipost.utils;


import org.springframework.core.io.ClassPathResource;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class JsFormatter {

    private static final String BEAUTIFY_JS_RESOURCE = "/static/beautify.js";

    // name of beautifier function
    private static final String BEAUTIFY_METHOD_NAME = "js_beautify";

    private ScriptEngine engine;

    private JsFormatter() throws ScriptException, IOException {
        engine = new ScriptEngineManager().getEngineByName("nashorn");
        engine.eval("\"use strict\";");
        engine.eval("var global = this;");
        InputStream inputStream = new ClassPathResource(BEAUTIFY_JS_RESOURCE).getInputStream();
        engine.eval(new InputStreamReader(inputStream));
    }


    /**
     * volatile 避免指令重排
     */
    private volatile static JsFormatter lazyMan;

    // 防止多线程出现问题，就使用了双重检测锁模式，懒汉式单列，     简称 DCL 懒汉式
    public static JsFormatter getInstance() throws ScriptException, IOException {
        if (null == lazyMan) {
            synchronized (JsFormatter.class) {
                if (null == lazyMan) {
                    lazyMan = new JsFormatter();  //在极端情况下不是一个原子性的操作
                }
            }
        }
        return lazyMan;  //当B线程进来的时候可以能 lazyMan 还没重拍好
    }


    public String formatter(String unformattedJs) throws ScriptException, NoSuchMethodException {

        return (String) ((Invocable) engine).invokeFunction(BEAUTIFY_METHOD_NAME, unformattedJs);
    }
}
