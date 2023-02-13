package berkaAPI.bodyClasses;

public class DataBuild {

    private String clientName;
    private String clientEmail;

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientEmail() {
        return clientEmail;
    }

    public void setClientEmail(String clientEmail) {
        this.clientEmail = clientEmail;
    }

    public DataBuild addClientPayload(String name, String email) {
        setClientEmail(email);
        setClientName(name);
        return this ;
    }
}
