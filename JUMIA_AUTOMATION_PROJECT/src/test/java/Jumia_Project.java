import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class Jumia_Project {

    private WebDriver driver;

    @BeforeTest
    public void start() {
        //Locate the browser driver
        System.setProperty("webdriver.chrome.driver","Resources/chromedriver.exe");
        //Open the browser
        driver = new ChromeDriver();
    }

    @Test (priority = 0)
    public void openUrl() throws InterruptedException {
        //Fetch the url
        driver.get("https://www.jumia.com.ng/");
        //Test 1: Verify that user can launch URL
            if (driver.getCurrentUrl().contains("https://www.jumia.com.ng/"))
                //Pass
                System.out.println("Correct Webpage");
            else
                //Fail
                System.out.println("Incorrect Webpage");
        Thread.sleep(3000);
        //Maximise screen
        driver.manage().window().maximize();
        Thread.sleep(2000);
        }

    @Test (priority = 1)
    public void getTitle() throws InterruptedException {
        //Get title page
        //Test 2: Verify that title page contains Jumia Nigeria
        String expectedpageTitle = "Jumia Nigeria";
        String actualpageTitle = driver.getTitle();
            if (actualpageTitle.contains(expectedpageTitle))
        //Pass
        System.out.println("Correct Title Page");
            else
        //Fail
        System.out.println("Incorrect Title Page");
        Thread.sleep(3000);
    }

    @Test (priority = 2)
    public void signinClickable() throws InterruptedException {
        //Test 3: Verify that the signin button is clickable and redirects to the signin landing page
        //Navigate and click on Account header
        driver.findElement(By.xpath("//*[@id=\"jm\"]/header/section/div[2]/div[1]/label")).click();
        Thread.sleep(2000);
        //Click on sign in
        driver.findElement(By.xpath("//*[@id=\"dpdw-login-box\"]/div/div/a")).click();
        String expectedUrl = ("https://my.jumia.com.ng/interaction/KjhUZrdoIYk5MZ8jQVzia/en-ng/sign-in/email");
        String actualUrl = driver.getCurrentUrl();
            if(actualUrl.contains(expectedUrl))
                //Pass
                System.out.println("Sign in button works");
            else
                //Fail
                System.out.println("Sign in button fail");
        Thread.sleep(2000);
    }

    @Test (priority = 3)

    public void validSignin() throws InterruptedException {
        //Test 4:Verify that user can successfully signin with valid details
        //Input username in the username field
        driver.findElement(By.xpath("/html/body/div/div[4]/form/div[2]/div[2]/label/input")).sendKeys("dmojahmyyllah@rocketmail.com");
        //Click continue
        driver.findElement(By.xpath("/html/body/div/div[4]/form/div[2]/div[3]/div/button/span[3]")).click();
        Thread.sleep(1000);
        //Input password in the password field
        driver.findElement(By.xpath("//*[@id=\"passwordForm\"]/div[2]/div[3]/label/input")).sendKeys("admin2345");
        //Click Login
        driver.findElement(By.xpath("//*[@id=\"loginButton\"]/span[3]")).click();
            if (driver.getCurrentUrl().contains("https://www.jumia.com.ng/"))
                //Pass
                System.out.println("Successful Signin");
            else
                //Fail
                System.out.println("Unsuccessful Signin attempt");
        Thread.sleep(5000);
    }

    @Test (priority = 4)

    public void Logout() throws InterruptedException {
        //Test 5:Verify that when the user logs out, they are directed back to the home page
        //Navigate to your profile
        driver.findElement(By.xpath("//*[@id=\"jm\"]/header/section/div[2]/div[1]/label")).click();
        //Navigate to and click the Logout button
        driver.findElement(By.xpath("//*[@id=\"dpdw-login-box\"]/div/form/button")).click();
        //User should be able to log out successfully and return to the homepage
        String expectedUrl = "https://www.jumia.com.ng/";
        String actualUrl = driver.getCurrentUrl();
            if(actualUrl.contains(expectedUrl))
                //Pass
                System.out.println("Successfully Signed out");
            else
                //Fail
                System.out.println("Signout Unsuccessful");
        Thread.sleep(7000);
    }

    @Test (priority = 5)

    public void invalidPasswordLogin() throws InterruptedException {
        //Test 6:Verify that user cannot sign in with valid email and incorrect password
        //Fetch the url
        driver.get("https://www.jumia.com.ng/");
        Thread.sleep(1000);
        //Navigate to Account header
        driver.findElement(By.xpath("//*[@id=\"jm\"]/header/section/div[2]/div[1]/label")).click();
        //Click Sign in
        driver.findElement(By.xpath("//*[@id=\"dpdw-login-box\"]/div/div/a")).click();
        //Input valid username in the username field
        driver.findElement(By.xpath("/html/body/div/div[4]/form/div[2]/div[2]/label/input")).sendKeys("dmojahmyyllah@rocketmail.com");
        //Click continue
        driver.findElement(By.xpath("/html/body/div/div[4]/form/div[2]/div[3]/div/button/span[3]")).click();
        Thread.sleep(3000);
        //7.Input invalid password in the password field
        driver.findElement(By.xpath("//*[@id=\"passwordForm\"]/div[2]/div[3]/label/input")).sendKeys("12345678");
        //8.Click Login
        driver.findElement(By.xpath("//*[@id=\"loginButton\"]/span[3]")).click();
        //User should be unable to login with invalid password
            if (driver.getCurrentUrl().contains("https://my.jumia.com.ng/interaction/elBNZ4-lO9TQ__epu9-EZ/en-ng/sign-in"))
                //Pass
                System.out.println("Wrong Password");
            else
                //Fail
                System.out.println("Error");
        Thread.sleep(5000);
    }

    @Test (priority = 6)

    public void invalidEmailLogin() throws InterruptedException {
        //Test 7:Verify that user cannot sign in with invalid email and correct password
        //Fetch the url
        driver.get("https://www.jumia.com.ng/");
        Thread.sleep(1000);
        //Navigate to Account header
        driver.findElement(By.xpath("//*[@id=\"jm\"]/header/section/div[2]/div[1]/label")).click();
        //Click Sign in
        driver.findElement(By.xpath("//*[@id=\"dpdw-login-box\"]/div/div/a")).click();
        //Input invalid username in the field
        driver.findElement(By.xpath("/html/body/div/div[4]/form/div[2]/div[2]/label/input")).sendKeys("dmojah@rocketmail");
        //Click continue
        driver.findElement(By.xpath("/html/body/div/div[4]/form/div[2]/div[3]/div/button/span[3]")).click();
        //User should be unable to proceed to signin with invalid email
        Thread.sleep(2000);
            if (driver.getCurrentUrl().contains("https://my.jumia.com.ng/interaction/elBNZ4-lO9TQ__epu9-EZ/en-ng/sign-in/email"))
                //Pass
                System.out.println("Invalid Email");
            else
                //Fail
                System.out.println("Error");
        Thread.sleep(5000);
    }

    @Test (priority = 7)

    public void blankLogin() throws InterruptedException {
        //Test 8:Verify that user cannot sign in with blank email and password
        //Fetch the url
        driver.get("https://www.jumia.com.ng/");
        //Navigate to Account header
        driver.findElement(By.xpath("//*[@id=\"jm\"]/header/section/div[2]/div[1]/label")).click();
        //Click Sign in
        driver.findElement(By.xpath("//*[@id=\"dpdw-login-box\"]/div/div/a")).click();
        //Input blank username in the username field
        driver.findElement(By.xpath("/html/body/div/div[4]/form/div[2]/div[2]/label/input")).sendKeys(" ");
        //Click continue
        driver.findElement(By.xpath("/html/body/div/div[4]/form/div[2]/div[3]/div/button/span[3]")).click();
        //User should be unable to login with blank details
            if (driver.getCurrentUrl().contains("https://my.jumia.com.ng/interaction/00-RRt5Kx-lJ-OD5Iwjfy/en-ng/sign-in/email"))
                //Pass
                System.out.println("Input Valid Email");
            else
                //Fail
                System.out.println("Error");
        Thread.sleep(3000);
    }

    @Test (priority = 8)

    public void finalValidSignin() throws InterruptedException {
        //Test 9:Verify that user can successfully signin with valid details
        //Input username in the username field
        driver.findElement(By.xpath("/html/body/div/div[4]/form/div[2]/div[2]/label/input")).sendKeys("dmojahmyyllah@rocketmail.com");
        //Click continue
        driver.findElement(By.xpath("/html/body/div/div[4]/form/div[2]/div[3]/div/button/span[3]")).click();
        Thread.sleep(1000);
        //Input password in the password field
        driver.findElement(By.xpath("//*[@id=\"passwordForm\"]/div[2]/div[3]/label/input")).sendKeys("admin2345");
        //Click Login
        driver.findElement(By.xpath("//*[@id=\"loginButton\"]/span[3]")).click();
        if (driver.getCurrentUrl().contains("https://www.jumia.com.ng/"))
            //Pass
            System.out.println("Successful Signin");
        else
            //Fail
            System.out.println("Unsuccessful Signin attempt");
        Thread.sleep(5000);
    }

    @Test (priority = 9)

    public void finalLogout() throws InterruptedException {
        //Test 10:Verify that when the user logs out, they are directed back to the home page
        //Fetch the url
        driver.get("https://www.jumia.com.ng/");
        Thread.sleep(2000);
        //Navigate to your profile
        //Click Account header
        driver.findElement(By.xpath("//*[@id=\"jm\"]/header/section/div[2]/div[1]/label")).click();
        //Click the Logout button
        driver.findElement(By.xpath("//*[@id=\"dpdw-login-box\"]/div/form/button")).click();
        String expectedUrl = "https://www.jumia.com.ng/";
        String actualUrl = driver.getCurrentUrl();
        //User should be able to logout successfully, and return to the homepage
        if(actualUrl.contains(expectedUrl))
            //Pass
            System.out.println("Successfully Signed out");
        else
            //Fail
            System.out.println("Signout Unsuccessful");
        Thread.sleep(7000);
    }

        @AfterTest

        public void CloseBrowser () {
            driver.quit();

        }
    }
