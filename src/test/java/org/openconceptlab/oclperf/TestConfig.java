package org.openconceptlab.oclperf;

public class TestConfig {

    public static String getBaseUrl() {
        String baseUrl = System.getenv("BASE_TEST_URL");
        return (baseUrl == null) ? "https://app.qa.openconceptlab.org/" : baseUrl;
    }

    public static String getApiBaseUrl() {
        String baseUrl = System.getenv("BASE_API_TEST_URL");
        return (baseUrl == null) ? "https://api.qa.openconceptlab.org/" : baseUrl;
    }

    public static Integer getMaxUsers() {
        String maxUsers = System.getenv("MAX_USERS");
        return (maxUsers == null) ? 10 : Integer.parseInt(maxUsers);
    }
}
