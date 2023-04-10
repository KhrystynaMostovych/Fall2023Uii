package utilities;

public class EnvironmentManager {
     // here we will set up all inv variable

    public static String baseUrl;
    public static String userName;
    public static String password;

    public static void setUpEnvironment () throws Exception {
        switch (ConfigReader.getProperty("environment").toLowerCase()){
            case "dev":
                DEV();
                break;
            case "qa":
                QA() ;
                break;
            case "prod":
                PROD();
                break;
            default: throw new Exception ("Invalid inv in conf.properties");



    }

    }
    private static void PROD(){
      baseUrl = "https://www.meetup.com/";
      userName = "ProdUser";
      password ="test123";

    }


    private static void QA() {
        baseUrl = "https://www.qa-meetup.com/";
        userName = "QaUser";
        password ="test123";
    }

    private static void DEV() {
        baseUrl = "https://www.dev-meetup.com/";
        userName = "DefUser";
        password = "test123";

    }}



