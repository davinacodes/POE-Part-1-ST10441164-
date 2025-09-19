import org.example.Login;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LoginTest {

    @Test
    public void testValidPhoneNumber() {
        Login login = new Login("Kyle", "Marowa", "ch&&sec@ke99!", "+27838968976", "kyl_1");
        assertTrue(login.checkPhonenumber("+27838968976"));
    }

    @Test
    public void testInvalidPhoneNumber() {
        Login login = new Login("Kyle", "Marowa", "ch&&sec@ke99!", "+27838968976", "kyl_1");
        assertFalse(login.checkPhonenumber("08966553"));
    }

    @Test
    public void testValidUsername() {
        Login login = new Login("Kyle", "Marowa", "ch&&sec@ke99!", "+27838968976", "kyl_1");
        assertTrue(login.checkUsername("kyl_1"));
    }

    @Test
    public void testInvalidUsername() {
        Login login = new Login("Kyle", "Marowa", "ch&&sec@ke99!", "+27838968976", "kyl_1");
        assertFalse(login.checkUsername("kyle!!!!!!"));
    }

    @Test
    public void testValidPassword() {
        String validPassword = "Ch&&sec@ke99!";
        Login login = new Login("Kyle", "Marowa", validPassword, "+27838968976", "kyl_1");
        assertTrue("Password should be accepted", login.checkPassword(validPassword));
    }


    @Test
    public void testInvalidPassword() {
        Login login = new Login("Kyle", "Marowa", "ch&&sec@ke99!", "+27838968976", "kyl_1");
        assertFalse(login.checkPassword("password"));
    }

    @Test
    public  void testLoginSuccess() {
        Login login = new Login("Kyle", "Marowa", "ch&&sec@ke99!", "+27838968976", "kyl_1");
       Assert.assertTrue(login.loginUser("kyl_1","ch&&sec@ke99!"));
    }

    @Test
    public void testLoginUnsuccessful() {
        Login login = new Login("Kyle", "Marowa", "ch&&sec@ke99!", "+27838968976", "kyl_1");
        Assert.assertTrue(login.loginUser("kyl_1", "WrongPass"));
    }




}
