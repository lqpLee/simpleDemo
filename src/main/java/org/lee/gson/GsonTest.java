package org.lee.gson;

import com.google.gson.*;

/**
 * <p>
 *
 * </p>
 *
 * @author liqp
 * @since 2020-06-01
 */
public class GsonTest {


    public static void main(String[] args) {
        String json = "{\"code\":0,\"description\":\"success\",\"data\":{\"verifyId\":\"95d6a71971da462bb684cfee5b530df1\",\"certStatus\":\"null\",\"customerId\":\"null\",\"orderNum\":\"null\"},\"logId\":\"20200601133727010011069076563F308\"}";


        JsonObject asJsonObject = new JsonParser().parse(json).getAsJsonObject();
        JsonObject data = asJsonObject.getAsJsonObject("data");

        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson("{\"key\":\"value\"}", JsonObject.class);


        ResultObject resultObject = new Gson().fromJson(json, ResultObject.class);
        String s = resultObject.getData().toString();
        System.out.println(s);

    }
}
