// nome do pacoe
package apiTest;

// Bibliotecas


import io.restassured.response.Response;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.*;

// Classe

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TesteUser { // inicio da classe
    // Atributos
    static String ct = "application/json"; // content type
    static String uriUser = "https://petstore.swagger.io/v2/user/";

    // Funções e Métodos
    // Funções de apoio
    public static String lerArquivoJson(String arquivoJson) throws IOException {
            return new String(Files.readAllBytes(Paths.get(arquivoJson)));
    }


    // Funções de Testes
    @Test
    @DisplayName("Testar inclusão de usuário via api")
    @Order(1)
    public void testarIncluirUser() throws IOException {
        // carregar os dados do json
        String jsonBody = lerArquivoJson("src/test/resources/json/user1.json");

        String userID = "1373929587";
        // realizar o teste

        given()
                .contentType(ct)
                .log().all()
                .body(jsonBody)
        .when()
                .post(uriUser)
        .then()
                .log().all()
                .statusCode(200)
                .body("code", is(200))
                .body("type", is("unknown"))
                .body("message", is(userID))
        ;
    } // fim do post

    @Test
    @DisplayName("Testar consulta de usuário criado via api")
    @Order(2)
    public void testarConsultarUser(){
        String username = "djmac";

        // resultado esperados

        int userID = 1373929587;
        String email = "mac@iphone.com";
        String password = "123mac";
        String telefone = "11922223333";

        given()
                .contentType(ct)
                .log().all()
        .when()
                .get(uriUser + username)
        .then()
                .log().all()
                .statusCode(200)
                .body("id", is(userID))
                .body("email", is(email))
                .body("password", is(password))
                .body("phone", is(telefone))
        ;


    }

    @Test
    @DisplayName("Teste para atualizar dados do usuário criado anteriormente")
    @Order(3)
    public void testarAlterarUser() throws IOException { // início put user
        String jsonBody = lerArquivoJson("src/test/resources/json/user2.json");

        String userID = "1373929587";
        String username = "djmac";

        given()
                .contentType(ct)
                .log().all()
                .body(jsonBody)
        .when()
                .put(uriUser + username)
        .then()
                .log().all()
                .statusCode(200)
                .body("code", is(200))
                .body("type", is("unknown"))
                .body("message", is(userID))
        ;
    } // fim do put user

    @Test
    @DisplayName("Teste para realizar exclusão do usuário criado")
    @Order(4)
    public void testarExcluirUser(){
        String username = "djmac";

        given()
                .contentType(ct)
                .log().all()
        .when()
                .delete(uriUser + username)
        .then()
                .statusCode(200)
                .body("code", is(200))
                .body("type", is("unknown"))
                .body("message", is(username))
        ;

    } // fim do delete user

    @Test
    @DisplayName("Testar consulta de usuário com retorno de token e armazenamento")
    public void testarLogin() {
        String username = "djmac";
        String password = "123456mac";

        Response response = (Response) given()
                .contentType(ct)
                .log().all()
        .when()
                .get(uriUser + "login?username=" + username + "&password=" + password)
        .then()
                .log().all()
                .statusCode(200)
                .body("code", is(200))
                .body("type", is("unknown"))
                .body("message", containsString("logged in user session:"))
                .body("message", hasLength(36))
        .extract()
        ;

        String token = response.jsonPath().getString("message").substring(23);
        System.out.println("Conteudo do Token: " + token);
    } // fim do login

    @ParameterizedTest
    @DisplayName("Testar inclusão de usuários via arquivo CSV to Json")
    @CsvFileSource(resources = "csv/massaUser.csv", numLinesToSkip = 1, delimiter = ',')

    public void testarIncluirUserSCV(
            String id,
            String username,
            String firstName,
            String lastName,
            String email,
            String password,
            String phone,
            String userStatus) {
        // carregar os dados do json
        StringBuilder jsonBody = new StringBuilder("{");
        jsonBody.append("'id' : " + id + "," );
        jsonBody.append("'username' : " + username + ",");
        jsonBody.append("'firstName' : " + firstName + ",");
        jsonBody.append("'lastName' : " + lastName + ",");
        jsonBody.append("'email' : " + email + ",");
        jsonBody.append("'password' : " + password + ",");
        jsonBody.append("'phone' : " + phone + ",");
        jsonBody.append("'userStatus' : " + userStatus + ",");
        jsonBody.append("}");
        // realizar o teste

        given()
                .contentType(ct)
                .log().all()
                .body(jsonBody)
        .when()
                .post(uriUser)
        .then()
                .log().all()
                .statusCode(200)
                .body("code", is(200))
                .body("type", is("unknown"))
                .body("message", is(id))
        ;

    } //  fim incluir CSV


} // fim da classe