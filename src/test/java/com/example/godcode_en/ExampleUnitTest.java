package com.example.godcode_en;

import org.json.JSONObject;
import org.junit.Test;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {

     String a="{\"result\":null,\"targetUrl\":null,\"success\":false,\"error\":{\"code\":3002,\"message\":\"产品不存在！\",\"details\":null,\"validationErrors\":null},\"unAuthorizedRequest\":false,\"__abp\":true}\n";
     JSONObject jb = new JSONObject(a);
        boolean success = jb.getBoolean("success");
        // String message = error.getString("message");
        System.out.println(success);
    }





}
