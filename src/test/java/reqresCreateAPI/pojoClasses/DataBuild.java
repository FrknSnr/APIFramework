package reqresCreateAPI.pojoClasses;

public class DataBuild {

    private static String name;
    private static String job;

    static DataBuild dataBuild = new DataBuild();

    public String getName() {
        return name;
    }

    public String getJob() {
        return job;
    }

    // DENEME. OLMAZSA DİĞER YOLDAN DEVAM.
    public static DataBuild createUser(String userName, String userJob) {

        job = userJob;
        name = userName;
        return dataBuild;
    }
}
