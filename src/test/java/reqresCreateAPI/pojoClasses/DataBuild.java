package reqresCreateAPI.pojoClasses;

public class DataBuild {

    private String name;
    private String job;

    static DataBuild dataBuild;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getJob() {
        return job;
    }

    public DataBuild createUser(String userName, String userJob) {
        setName(userName);
        setJob(userJob);
        return this;
    }
}
