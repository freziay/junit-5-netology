import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class UserService {
    private static final List<User> users = new ArrayList<>();

    public List<User> getAll() {
        return Collections.emptyList();
    }
    public static boolean add(User user){
        return users.add(user);
    }

    public Optional<User> login(String username, String password) {
        return Optional.empty();
    }
}
