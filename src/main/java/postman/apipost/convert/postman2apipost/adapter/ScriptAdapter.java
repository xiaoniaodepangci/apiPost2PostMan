package postman.apipost.convert.postman2apipost.adapter;


import org.springframework.stereotype.Component;
import postman.apipost.convert.postman2apipost.apipost.ApiPostRequestEvent;
import postman.apipost.convert.postman2apipost.postman.PostManEvent;
import postman.apipost.convert.postman2apipost.postman.PostManScript;
import postman.apipost.convert.postman2apipost.utils.JsFormatter;

import javax.script.ScriptException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static postman.apipost.convert.postman2apipost.global.Constant.POSTMAN_PRE_SCRIPT;
import static postman.apipost.convert.postman2apipost.global.Constant.POSTMAN_TEST;

/**
 * 预执行脚本转换
 */
@Component
public class ScriptAdapter extends AbstractBaseAdapter<List<PostManEvent>, ApiPostRequestEvent> {

    @Override
    public ApiPostRequestEvent sourceToTarget(List<PostManEvent> source) {
        ApiPostRequestEvent apiPostRequestEvent = new ApiPostRequestEvent();

        JsFormatter instance;
        try {
            instance = JsFormatter.getInstance();
            for (PostManEvent postManEvent : source) {
                if (POSTMAN_PRE_SCRIPT.equals(postManEvent.getListen())) {
                    List<String> exec = postManEvent.getPostManScript().getExec();
                    String join = String.join("", exec);
                    apiPostRequestEvent.setPreScript(instance.formatter(join.trim()));
                } else if (POSTMAN_TEST.equals(postManEvent.getListen())) {
                    List<String> exec = postManEvent.getPostManScript().getExec();
                    String join = String.join("", exec);
                    apiPostRequestEvent.setTest(instance.formatter(join.trim()));
                }
            }

        } catch (ScriptException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return apiPostRequestEvent;
    }

    private String stringConnection(List<String> exec) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String s : exec) {

        }
        return stringBuilder.toString();
    }


    @Override
    public List<PostManEvent> targetToSource(ApiPostRequestEvent source) {
        List<PostManEvent> list = new ArrayList<>();

        PostManEvent preEvent = new PostManEvent();
        PostManEvent testEvent = new PostManEvent();

        preEvent.setListen("prerequest");
        PostManScript preScript = new PostManScript();
        preScript.setType("text/javascript");
        if (source.getPreScript() != null) {
            preScript.setExec(Arrays.asList(source.getPreScript().split("\\r?\\n")));
        } else {
            preScript.setExec(Collections.singletonList(""));
        }
        preEvent.setPostManScript(preScript);

        testEvent.setListen("test");
        PostManScript testScript = new PostManScript();
        testScript.setType("text/javascript");
        if (source.getTest() != null) {
            testScript.setExec(Arrays.asList(source.getTest().split("\\r?\\n")));
        } else {
            testScript.setExec(Collections.singletonList(""));
        }
        testEvent.setPostManScript(testScript);

        list.add(preEvent);
        list.add(testEvent);
        return list;
    }
}
