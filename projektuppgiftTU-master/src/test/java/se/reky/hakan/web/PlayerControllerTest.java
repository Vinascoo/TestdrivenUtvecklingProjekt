package se.reky.hakan.web;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Disabled
public class PlayerControllerTest {

    ChromeDriver driver;

    @BeforeAll
    public static void init(){
        WebDriverManager.chromedriver().setup();
    }
    @BeforeEach
    public void setUp(){
        driver = new ChromeDriver();
    }
    @AfterEach
    public void tearDown(){
        if(driver != null){
            driver.quit();
        }
    }

    @DisplayName("Selenium test 1")
    @Test
    public void amountOfPlayers (){
        driver.get("http://localhost:8080/players");

        WebElement playerList = driver.findElement(By.tagName("ul"));
        int playerAmount = playerList.findElements(By.tagName("li")).size();

        assertEquals(2, playerAmount);
    }

    @DisplayName("Selenium test 2")
    @Test
    public void nameOfPlayer (){

        driver.get("http://localhost:8080/players");

        List<WebElement> players = driver.findElements(By.tagName("ul"));

        WebElement firstPlayer = players.get(0);
        assertTrue(firstPlayer.getText().contains("Kalle"), "First player is kalle");
    }

    @DisplayName("Selenium test 3")
    @Test
    public void titleOfPage (){

        driver.get("http://localhost:8080/players");

        assertEquals("Players List", driver.getTitle(), "Title correct");
    }

    @DisplayName("Selenium test 4")
    @Test
    public void buttonText (){
        driver.get("http://localhost:8080/players");
        WebElement button = driver.findElement(By.tagName("button"));
        String buttonText = button.getText();
        assertEquals("Logga in", buttonText);
    }

    @DisplayName("Player link test")
    @Test

    public void playerLink (){

        driver.get("http://localhost:8080/players");
        WebElement nameLink = driver.findElement(By.cssSelector("ul li a"));
        nameLink.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement playerName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("player-name")));

        // Check if the player's name is displayed
        boolean playerNameIsDisplayed = playerName.isDisplayed();
        assertTrue(playerNameIsDisplayed);


    }

}
