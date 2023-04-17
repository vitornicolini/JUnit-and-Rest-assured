// Pacote

package webTest;
// Bibliotecas


import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

// Classe
public class ComprarPassagemWD {
    // Atributos
    private WebDriver driver; // declaramos o objeto do Selenium WebDriver

    // Funções e Métricas

    // Antes do Teste
    @BeforeEach
    public void setUp(){ // inicio do Before
        // declarar o gerenciador para baixar o chrome web driver
        WebDriverManager.chromedriver().setup();
        // configuração especifica a partir do Selenium WebDriver 4.8.1
        ChromeOptions options = new ChromeOptions(); // instanciar o objeto ChromeOptions
        // Adicionou ao ChromeOptions a opção de permitir qualquer origem de acesso remoto
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options); // instanciar o Selenium
        driver.manage().window().maximize(); // maximiza a janela do navegador

    } // fim do Before

    // Depois do Teste
    @AfterEach
    public void tearDown(){ // inicio do After
        driver.quit(); // destroi a instancia do Selenium WebDriver

    }


    // O Teste
    @Test
    public void comprarPassagemWD(){ // inicio do comprarPassagem
        driver.get("https://www.blazedemo.com"); // abre o navegador com endereço alvo
        // selecionar a lista/combo de cidade de origem
        driver.findElement(By.name("fromPort")).click();
        // selecionar a cidade na lista
        {// inicio da seleção dentro da lista
            WebElement lista = driver.findElement(By.name("fromPort"));
            //WebElement dropdown = driver.findElement(By.name("fromPort"));
            lista.findElement(By.xpath("//option[. ='São Paolo']")).click();
            //dropdown.findElement(By.xpath("//option[. = 'São Paolo']")).click();
        }// fim da seleção dentro da lista

        driver.findElement(By.name("toPort")).click();
        // selecionar a cidade na lista
        {// inicio da seleção dentro da lista
            WebElement lista = driver.findElement(By.name("toPort"));
            //WebElement dropdown = driver.findElement(By.name("fromPort"));
            lista.findElement(By.xpath("//option[. ='Berlin']")).click();
            //dropdown.findElement(By.xpath("//option[. = 'São Paolo']")).click();
        }// fim da seleção dentro da lista

        // apertar o botão Find Flights
        driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
        // validar a frase que indica que o vôo é de São Paolo para Berlin
        //assertThat(driver.findElement(By.cssSelector("h3")).getText(), is("Flights from São Paolo to Berlin:"));
        assertEquals("Flights from São Paolo to Berlin:", driver.findElement(By.cssSelector("h3")).getText());

    } // fim do comprarPassagem

    @Test
    public void comprarPassagemWDa(){ // inicio do comprarPassagem
        driver.get("https://the-internet.herokuapp.com/"); // abre o navegador com endereço alvo
        // selecionar a lista/combo de cidade de origem
        //driver.findElement(By.name("fromPort")).click();
        driver.findElement(By.xpath("//a[@href ='/checkboxes']")).click();
        // selecionar a cidade na lista
        assertThat(driver.findElement(By.cssSelector("h3")).getText(), is("Checkboxes"));
        // selecionar checkbox


        {// inicio da seleção dentro da lista
            //WebElement lista = driver.findElement(By.name("fromPort"));
            WebElement lista = driver.findElement(By.name("fromPort"));
            //WebElement dropdown = driver.findElement(By.name("fromPort"));
            lista.findElement(By.xpath("//option[. ='São Paolo']")).click();
            //dropdown.findElement(By.xpath("//option[. = 'São Paolo']")).click();
        }// fim da seleção dentro da lista

        driver.findElement(By.name("toPort")).click();
        // selecionar a cidade na lista
        {// inicio da seleção dentro da lista
            WebElement lista = driver.findElement(By.name("toPort"));
            //WebElement dropdown = driver.findElement(By.name("fromPort"));
            lista.findElement(By.xpath("//option[. ='Berlin']")).click();
            //dropdown.findElement(By.xpath("//option[. = 'São Paolo']")).click();
        }// fim da seleção dentro da lista

        // apertar o botão Find Flights
        driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
        // validar a frase que indica que o vôo é de São Paolo para Berlin
        //assertThat(driver.findElement(By.cssSelector("h3")).getText(), is("Flights from São Paolo to Berlin:"));
        assertEquals("Flights from São Paolo to Berlin:", driver.findElement(By.cssSelector("h3")).getText());

    } // fim do comprarPassagem

    @Test
    public void comprarPassagemWDb(){ // inicio do comprarPassagem
        driver.get("https://www.blazedemo.com"); // abre o navegador com endereço alvo
        // selecionar a lista/combo de cidade de origem
        driver.findElement(By.name("fromPort")).click();
        // selecionar a cidade na lista
        {// inicio da seleção dentro da lista
            WebElement lista = driver.findElement(By.name("fromPort"));
            //WebElement dropdown = driver.findElement(By.name("fromPort"));
            lista.findElement(By.xpath("//option[. ='São Paolo']")).click();
            //dropdown.findElement(By.xpath("//option[. = 'São Paolo']")).click();
        }// fim da seleção dentro da lista

        driver.findElement(By.name("toPort")).click();
        // selecionar a cidade na lista
        {// inicio da seleção dentro da lista
            WebElement lista = driver.findElement(By.name("toPort"));
            //WebElement dropdown = driver.findElement(By.name("fromPort"));
            lista.findElement(By.xpath("//option[. ='Berlin']")).click();
            //dropdown.findElement(By.xpath("//option[. = 'São Paolo']")).click();
        }// fim da seleção dentro da lista

        // apertar o botão Find Flights
        driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
        // validar a frase que indica que o vôo é de São Paolo para Berlin
        //assertThat(driver.findElement(By.cssSelector("h3")).getText(), is("Flights from São Paolo to Berlin:"));
        assertEquals("Flights from São Paolo to Berlin:", driver.findElement(By.cssSelector("h3")).getText());

    } // fim do comprarPassagem

    @Test
    public void comprarPassagemWDc(){ // inicio do comprarPassagem
        driver.get("https://www.blazedemo.com"); // abre o navegador com endereço alvo
        // selecionar a lista/combo de cidade de origem
        driver.findElement(By.name("fromPort")).click();
        // selecionar a cidade na lista
        {// inicio da seleção dentro da lista
            WebElement lista = driver.findElement(By.name("fromPort"));
            //WebElement dropdown = driver.findElement(By.name("fromPort"));
            lista.findElement(By.xpath("//option[. ='São Paolo']")).click();
            //dropdown.findElement(By.xpath("//option[. = 'São Paolo']")).click();
        }// fim da seleção dentro da lista

        driver.findElement(By.name("toPort")).click();
        // selecionar a cidade na lista
        {// inicio da seleção dentro da lista
            WebElement lista = driver.findElement(By.name("toPort"));
            //WebElement dropdown = driver.findElement(By.name("fromPort"));
            lista.findElement(By.xpath("//option[. ='Berlin']")).click();
            //dropdown.findElement(By.xpath("//option[. = 'São Paolo']")).click();
        }// fim da seleção dentro da lista

        // apertar o botão Find Flights
        driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
        // validar a frase que indica que o vôo é de São Paolo para Berlin
        //assertThat(driver.findElement(By.cssSelector("h3")).getText(), is("Flights from São Paolo to Berlin:"));
        assertEquals("Flights from São Paolo to Berlin:", driver.findElement(By.cssSelector("h3")).getText());

    } // fim do comprarPassagem




} // fim da classe
