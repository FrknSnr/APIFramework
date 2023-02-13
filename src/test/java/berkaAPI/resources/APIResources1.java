package berkaAPI.resources;

public enum APIResources1 {

    AddClientAPI("/api-clients");
    private String resource;

    APIResources1(String resource) {
        this.resource = resource ;
    }

    public String getResource() {
        return resource;
    }
}
