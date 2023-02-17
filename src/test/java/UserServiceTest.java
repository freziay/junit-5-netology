import org.hamcrest.MatcherAssert;
import org.hamcrest.collection.IsEmptyCollection;
import org.hamcrest.core.IsEqual;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.text.html.Option;
import java.awt.*;
import java.util.Optional;
//import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserServiceTest {
    private static final User IVAN = new User(1,"Ivan","123");
    private static final User PETY = new User(1,"Pety","321");
    private UserService userService;

    @BeforeEach
     void prepere(){
        System.out.println("Before each: "+this);
        userService = new UserService();
    }
    @Test
    void usersEptyIfNoUserAdded(){
        System.out.println("Test 1: "+this);
        var users= userService.getAll();
        MatcherAssert.assertThat(users, IsEmptyCollection.empty());
        assertTrue(users.isEmpty());

    }
    @Test
    void userSizeIfUserAdded(){
        System.out.println("Test 2: "+this);
        userService.add(IVAN);
        userService.add(PETY);
        var users= userService.getAll();
        MatcherAssert.assertThat(users, IsEqual.equalTo(users));

    }
    @Test
    void loginFailIfPassvordIsNotCorrect(){
        System.out.println("Test 3: "+this);
        userService.add(IVAN);
        var maybeuser=userService.login(IVAN.getUsername(),"1111");
        assertTrue(maybeuser.isEmpty());
    }

    @Test
     void loginSuccessIfUserExists(){
        System.out.println("Test 4: "+this);
        UserService.add(IVAN);
        Optional<User> maybeUser = userService.login(IVAN.getUsername(),IVAN.getPassword());
        Assertions.assertFalse(maybeUser.isPresent());
        maybeUser.ifPresent(user -> assertEquals(IVAN, user));
    }



    @AfterEach
    void deliteDatafromDatabase(){
        System.out.println("After each: "+this);

    }
}
