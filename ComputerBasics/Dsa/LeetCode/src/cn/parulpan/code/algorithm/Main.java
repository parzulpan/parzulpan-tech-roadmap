package cn.parulpan.code.algorithm;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author chengyan
 * @since 2022/10/14
 */
public class Main {
    public static void main(String[] args) {
        String href = "https://m.shopcider.com/product/list?collection_id=31&utm_source=SystemEmail-CrmNewUserWelcomeFlowNowJourney&utm_medium=email&utm_campaign=ima?ge3";
        System.out.println(href);
        href = removeUrlParam(href, "utm_source", "utm_medium", "utm_campaign");
        System.out.println(href);
    }

    public static String removeUrlParam(String url, String ...paramName) {
        for (String param : paramName) {
            url = url.replaceAll("&?"+param+"=[^&]*", "");
        }
        return url;
    }

}
