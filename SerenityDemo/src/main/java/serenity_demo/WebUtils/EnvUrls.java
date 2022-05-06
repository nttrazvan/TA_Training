package serenity_demo.WebUtils;

import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;

public class EnvUrls {

    private static EnvironmentVariables variables = SystemEnvironmentVariables.createEnvironmentVariables();

    private static String env = System.getProperty("testEnv").toLowerCase();

    private static String url;

    public static String ROOT_URL(){
        if(env.contains("prod")){
            url = variables.getProperty("default.url");
        }
        else if(env.contains("dev-test")){
            url = variables.getProperty("default.url");
        }
        else if(env.contains("uat")){
            url = variables.getProperty("default.url");
        }
        return url;
    }
    private Integer int2=2;
}
