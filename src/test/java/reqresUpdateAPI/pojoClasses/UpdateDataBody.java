package reqresUpdateAPI.pojoClasses;

public class UpdateDataBody {


    public static UpdateUser updateUserPayload(String name, String job) {

        UpdateUser user = new UpdateUser();
        user.setName(name);
        user.setJob(job);
        return user;
    }
}
