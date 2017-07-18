/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package suapcron.suapdealer;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlForm;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlPasswordInput;
import com.gargoylesoftware.htmlunit.html.HtmlSubmitInput;
import com.gargoylesoftware.htmlunit.html.HtmlTextArea;
import com.gargoylesoftware.htmlunit.html.HtmlTextInput;
import java.io.IOException;

/**
 *
 * @author marcocspc
 */
public class SuapConnection {

    public static final String SUAP_URL = "https://suap.ifrn.edu.br";
    public static final String SUAP_LOGIN_URL = SUAP_URL + "/accounts/login/";
    public static final String SUAP_LOGIN_TEST_URL = SUAP_URL + "/accounts/login/";
    public static final String SUAP_LOGIN_PAGE_TITLE = "SUAP: Sistema Unificado de Administração Pública - Login";
    public static final String SUAP_OSERVATION_PAGE_BASE_URL = SUAP_URL + "/ponto/observacao_adicionar/";

    private WebClient conn;
    private String matricula;
    private String senha;

    public SuapConnection(String matricula, String senha) throws Exception {

        System.out.println("Iniciando navegador.");
        conn = new WebClient(BrowserVersion.BEST_SUPPORTED);
        System.out.println("Navegador inicializado.");

        this.matricula = matricula;
        this.senha = senha;

    }

    public String getSuapPage(String url) throws IOException {
        HtmlPage pagina = conn.getPage(url);

        if (pagina.getTitleText().equals(SuapConnection.SUAP_LOGIN_PAGE_TITLE)) {
            return login(url).asXml();
        } else {
            return pagina.asXml();
        }
    }

    public void putObservation(String observation, String observationURL) throws IOException {
        HtmlPage pagina = conn.getPage(observationURL);
        
        if (pagina.getTitleText().equals(SuapConnection.SUAP_LOGIN_PAGE_TITLE)) {
            pagina = login(observationURL);
        }
        
        HtmlForm formulario = pagina.getHtmlElementById("observacao_form");
        
        HtmlTextArea whereToInsertObs = formulario.getTextAreaByName("descricao");
        HtmlSubmitInput sendBtn = formulario.getInputByName("observacao_form");
        
        whereToInsertObs.setText(observation);
        
        sendBtn.click();
    }
    
    private HtmlPage login(String resultUrl) throws IOException {
        HtmlPage login = conn.getPage(resultUrl);
        HtmlForm formulario = login.getFirstByXPath("//form[@action='']");

        HtmlTextInput campoUsuario = formulario.getInputByName("username");
        HtmlPasswordInput campoSenha = formulario.getInputByName("password");
        HtmlSubmitInput botaoEnviar = formulario.getInputByValue("Acessar");
        
        campoUsuario.setValueAttribute(matricula);
        campoSenha.setValueAttribute(senha);

        HtmlPage result = botaoEnviar.click();

        return result;
    }
    
    public boolean validate(String user, String pass) throws IOException {
        this.matricula = user;
        this.senha = pass;
        
        HtmlPage pagina = this.login(SUAP_URL);
        
        System.out.println("Titulo esperado:" + "SUAP: Sistema Unificado de Administração Pública - Login");
        System.out.println("Titulo obtido: " + pagina.getTitleText());
        
        return !pagina.getTitleText().equals(SuapConnection.SUAP_LOGIN_PAGE_TITLE);
    }
    
    
    
}
