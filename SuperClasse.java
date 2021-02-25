package br.gov.siaoimobile.commons;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.codehaus.plexus.util.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.server.handler.FindElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Strings;
import com.google.common.collect.ImmutableMap;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfReaderContentParser;
import com.itextpdf.text.pdf.parser.SimpleTextExtractionStrategy;
import com.itextpdf.text.pdf.parser.TextExtractionStrategy;

import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;




/**
 * 
 * NA SUPERCLASSE FORAM CRIADOS VÁRIOS MÉTODOS PARA FACILITAR A IMPLEMENTAÇÃO
 * ÁGIL DOS SCRIPTS ORIENTAMOS QUE, CASO SEJAM ADICIONADOS MAIS MÉTODOS, TODOS
 * TENHA NOTA EXPLICATIVA PARA O ENTENDIMENTO DO FUNCIONAMENTO DOS MESMOS
 * 
 * 
 */

public class SuperClasse {

	protected static final int SEG = 1;
	protected static final int MIN = 1000;
	protected static final int HOR = 1000 * 60;
	protected static final String VIRGULA = ";";
	protected static ATUTestRecorder recorder;
	protected static AndroidDriver<MobileElement> driver;
	protected WebDriverWait wait;
	
	

	static List<Evidencia> evidencias = new ArrayList<>();

	/*******************************************************************************************
	 * AQUI ESTÃO SENDO INFORMADOS OS CAMINHOS ONDE OS ARQUIVOS ESTARÃO PARA ACESSO
	 */
	static LeitoresTxt leitortxtConcessao;
	static String caminhoconcessao = "Utils\\dataPools\\concessao.txt";
	static LeitoresTxt leitortxtMensagem;
	static String caminhomensagem = "Utils\\dataPools\\mensagem.txt";
	static LeitoresTxt leitortxtLiberacoes;
	static String caminhoLiberacoes = "Utils\\dataPools\\liberacoes.txt";
	static LeitoresTxt leitortxtContratos;
	static String caminhoContratos = "Utils\\dataPools\\contratos.txt";
	static LeitoresTxt leitortxtAcesso;
	static String caminhoAcesso = "Utils\\dataPools\\acesso.txt";
	static LeitoresTxt leitortxtAmortizacao;
	static String caminhoAmortizacao = "Utils\\dataPools\\amortizacao.txt";
	static LeitoresTxt leitortxtDB2;
	static String caminhoDB2 = "Utils\\dataPools\\db2.txt";
	static LeitoresTxt leitortxtRemuneracao;
	static String caminhoRemuneracao = "Utils\\dataPools\\remuneracao.txt";
	static LeitoresTxt leitortxtPagaVendedor;
	static String caminhoPagaVendedor = "Utils\\dataPools\\pagamentoVendedor.txt";
	
	/*************************************************************************************************************************************************************************************
	 * OS ARQUIVOS DEVEM SER INICIALIZADOS INFORMANDO O CAMINHO E O SEPARADOR
	 * 
	 */
	public static void inicializar() {

		
		try {
			if (leitortxtConcessao == null)
				leitortxtConcessao = new LeitoresTxt(caminhoconcessao, VIRGULA);
			if (leitortxtMensagem == null)
				leitortxtMensagem = new LeitoresTxt(caminhomensagem, VIRGULA);
			if (leitortxtLiberacoes == null)
				leitortxtLiberacoes = new LeitoresTxt(caminhoLiberacoes, VIRGULA);
			if (leitortxtContratos == null)
				leitortxtContratos = new LeitoresTxt(caminhoContratos, VIRGULA);
			if (leitortxtAcesso == null)
				leitortxtAcesso = new LeitoresTxt(caminhoAcesso, VIRGULA);
			if (leitortxtAmortizacao == null)
				leitortxtAmortizacao = new LeitoresTxt(caminhoAmortizacao, VIRGULA);
			if (leitortxtDB2 == null)
				leitortxtDB2 = new LeitoresTxt(caminhoDB2, VIRGULA);
			if (leitortxtRemuneracao == null)
				leitortxtRemuneracao = new LeitoresTxt(caminhoRemuneracao, VIRGULA);
			if (leitortxtPagaVendedor == null)
				leitortxtPagaVendedor = new LeitoresTxt(caminhoPagaVendedor, VIRGULA);

			
		} catch (Exception e) {
			System.out.println("Arquivo não encontrado!");
		}
	}
	/***********************************************************************************************************************************************************************************
	 * ITERAÇÃO COM VALOR DO ARQUIVO REMUNERACAO
	 */
	public static String getValor_6(int nuLinha) {
		return leitortxtRemuneracao.getValor(nuLinha).trim();
	}

	/***********************************************************************************************************************************************************************************
	 * ITERAÇÃO COM XPATH DO ARQUIVO REMUNERACAO
	 */
	public static String getXpath_6(int nuLinha) {
		return leitortxtRemuneracao.getXpath(nuLinha).trim();
	}
	/***********************************************************************************************************************************************************************************
	 * ITERAÇÃO COM VALOR DO ARQUIVO PAGAMENTO VENDEDOR
	 */
	public static String getValor_7(int nuLinha) {
		return leitortxtPagaVendedor.getValor(nuLinha).trim();
	}

	/***********************************************************************************************************************************************************************************
	 * ITERAÇÃO COM XPATH DO ARQUIVO PAGAMENTO VENDEDOR
	 */
	public static String getXpath_7(int nuLinha) {
		return leitortxtPagaVendedor.getXpath(nuLinha).trim();
	}

	/***********************************************************************************************************************************************************************************
	 * LOGO ABAIXO TODOS OS ARQUIVOS DEVEM SER INSTACIADOS PARA O DEVIDO RETORNO
	 */
	public static String getValor_4(int nuLinha) {
		return leitortxtAmortizacao.getValor(nuLinha).trim();
	}

	/***********************************************************************************************************************************************************************************
	 * ITERAÇÃO COM XPATH DO ARQUIVO AMORTIZAÇÃO
	 */
	public static String getXpathValor_4(int nuLinha) {
		return leitortxtAmortizacao.getXpath(nuLinha).trim();
	}
	/***********************************************************************************************************************************************************************************
	/***********************************************************************************************************************************************************************************
	 * ITERAÇÃO COM VALOR DO ARQUIVO LIBERAÇOES
	 */
	public static String getValor(int nuLinha) {
		return leitortxtLiberacoes.getValor(nuLinha).trim();
	}

	/***********************************************************************************************************************************************************************************
	 * ITERAÇÃO COM XPATH DO ARQUIVO LIBERACOES
	 */
	public static String getXpathValor(int nuLinha) {
		return leitortxtLiberacoes.getXpath(nuLinha).trim();
	}
	/***********************************************************************************************************************************************************************************
	 * ITERAÇÃO COM VALOR DO ARQUIVO ACESSO
	 */
	public static String getValor_1(int nuLinha) {
		return leitortxtAcesso.getValor(nuLinha).trim();
	}

	/***********************************************************************************************************************************************************************************
	 * ITERAÇÃO COM XPATH DO ARQUIVO ACESSO
	 */
	public static String getValor_2(int nuLinha) {
		return leitortxtAcesso.getXpath(nuLinha).trim();
	}
	/***********************************************************************************************************************************************************************************
	 * ITERAÇÃO COM XPATH DO ARQUIVO ACESSO
	 */
	public static String getValor_3(int nuLinha) {
		return leitortxtAcesso.getXpath_1(nuLinha).trim();
	}

	/***********************************************************************************************************************************************************************************
	 * ITERAÇÃO COM O ARQUIVO MENSAGEM
	 */
	public static String getMensagem(int nuLinha) {
		return leitortxtMensagem.getMensagem(nuLinha).trim();
	}
	/***********************************************************************************************************************************************************************************
	 * ITERAÇÃO COM XPATH DO ARQUIVO CONCESSAO
	 */
	public static String getXpathMens(int nuLinha) {
		return leitortxtMensagem.getXpath_1(nuLinha).trim();
	}

	/***********************************************************************************************************************************************************************************
	 * ITERAÇÃO COM O ARQUIVO MENSAGEM
	 */
	public static String getMensagemC(int nuLinha) {
		return leitortxtMensagem.getValor(nuLinha);
	}
	/***********************************************************************************************************************************************************************************
	 * ITERAÇÃO COM XPATH DO ARQUIVO CONCESSAO
	 */
	public static String getXpathMensC(int nuLinha) {
		return leitortxtMensagem.getXpath(nuLinha);
	}

	/***********************************************************************************************************************************************************************************
	 * ITERAÇÃO COM A COLUNA DE VALORES DO ARQUIVO CONCESSAO
	 */
	public static String getTipoFato(int nuLinha) {
		return leitortxtConcessao.getValor(nuLinha);
	}

	/***********************************************************************************************************************************************************************************
	 * ITERAÇÃO COM XPATH DO ARQUIVO CONCESSAO
	 */
	public static String getXpath(int nuLinha) {
		return leitortxtConcessao.getXpath(nuLinha);
	}

	/***********************************************************************************************************************************************************************************
	 * ITERAÇÃO COM A COLUNA DE CONTRATOS
	 */
	public static String getContrato(int nuLinha) {
		return leitortxtContratos.getValor(nuLinha);
	}

	public static List<String> getListaContratos(int nuLinhaInicio) {
		List<String> contratos = new ArrayList<String>();
		for (int i = nuLinhaInicio; i <= leitortxtContratos.getQuantidadeLinhas(); i++) {
			contratos.add(leitortxtContratos.getValor(i));
		}
		return contratos;
	}
	
	public static List<String> getListaContratos(int nuLinhaInicio, String caminho) throws IOException {
		leitortxtContratos = new LeitoresTxt(caminho, VIRGULA);
		List<String> contratos = new ArrayList<String>(); 
		System.out.println(caminhoContratos);
		System.out.println(caminho);
		for (int i = nuLinhaInicio; i <= leitortxtContratos.getQuantidadeLinhas(); i++) {
			String valor = leitortxtContratos.getValor(i);
			if(valor.isEmpty()) {
				break;
			}
			contratos.add(valor);
		}
		return contratos;
	}
	
	public static String getContrato(int nuLinha, String caminho) {
		caminhoContratos = caminho;
		return leitortxtContratos.getValor(nuLinha);
	}

	/***********************************************************************************************************************************************************************************
	 * ITERAÇÃO COM PATH DE CONTRATOS
	 */
	public static String getData(int nuLinha) {
		return leitortxtContratos.getXpath(nuLinha);
	}
	
	/***********************************************************************************************************************************************************************************
	 * ITERAÇÃO COM VALOR DE DB2
	 */
	public static String getValorDB2_1(int nuLinha) {
		return leitortxtDB2.getValor(nuLinha).trim();
	}

	/***********************************************************************************************************************************************************************************
	 * ITERAÇÃO COM O ARQUIVO MENSAGEM
	 */
	public static String getValorDB2_2(int nuLinha) {
		return leitortxtDB2.getXpath(nuLinha);
	}

	/*******************************************************************************************
	 * SERVE PARA INFORMAR O TEMPO, PASSANDO COMO PARAMETRO A QUANTIDADE DE TEMPO E
	 * O TIPO EXEMPLO: sleep(1, MIN)
	 * 
	 * @param tempo
	 * @param timeUnit
	 * @throws InterruptedException
	 */
	protected static final void tempo(long tempo, int timeUnit) throws InterruptedException {
		Thread.sleep(tempo * timeUnit);
	}

//		public static void logPrint(String strlog) {
//			ExtentTest extentTest = TestRule.getExtentTest();
//		}
	/*******************************************************************************************
	 * SERVE PARA ROLAR A PÁGINA PARA BAIXO, OU PARA CIMA, OU FINAL BASTA PASSAR
	 * COMO PARÂMETRO O KEYEVENT ESTE EXEMPLO FICARÁ DEFAULT, BASTA TROCAR O EVENTO:
	 * acionarTeclado(KeyEvent.VK_PAGE_DOWN);
	 * 
	 * @param hora
	 * @return
	 */
	public static void acionarTeclado(int evento) throws AWTException {

		Robot robot = new Robot();
		robot.keyPress(evento);foto();
		robot.keyRelease(evento);foto();
		
	}
	/*******************************************************************************************
	 * SERVE PARA ROLAR A PÁGINA PARA BAIXO, OU PARA CIMA, OU FINAL BASTA PASSAR
	 * COMO PARÂMETRO O XPATH DO LOCAL QUE QUER ROLAR E O KEYEVENT ESTE EXEMPLO FICARÁ DEFAULT, BASTA TROCAR O EVENTO:
	 * acionarTecladoAngular("xPath", Keys.PAGE_DOWN);
	 * 
	 * @param hora
	 * @return
	 */
	public static void acionarTecladoAngular(String xPath, Keys teclado) throws AWTException {

		MobileElement scroll = driver.findElement(By.xpath(xPath));
		scroll.sendKeys(teclado);
		
	}

	/*******************************************************************************************
	 * SERVE PARA LER OS VALORES DE UM PDF 
	 * BASTA PASSAR COMO PARÂMETRO O ENDEREÇO E NOME DO DOCUMENTO PDF
	 * @throws IOException 
	 * 
	 */
	public static void leitorDeValoresPDF(String caminho) throws AWTException, IOException {

		List<String> linhas = new ArrayList<String>();
		 PdfReader reader = new PdfReader(caminho);
	     PdfReaderContentParser parser = new PdfReaderContentParser(reader);
	     PrintWriter out = new PrintWriter(System.out);
	     TextExtractionStrategy strategy;
	     for (int i = 1; i <= reader.getNumberOfPages(); i++) {
	         strategy = parser.processContent(i, new SimpleTextExtractionStrategy());
	         linhas.add(strategy.getResultantText());
	         out.println(strategy.getResultantText());
	     }
	     reader.close();
//	     out.flush();
//	     out.close();
	     ;
	
	}
	/*******************************************************************************************
	 * SERVE PARA CLICAR NO ALERT DA PAGINA
	 * @throws IOException 
	 * 
	 */

	public static void clicarAlert(AndroidDriver<?> driver) {

		Alert clicAlert = driver.switchTo().alert();
		clicAlert.accept();

	}

	/*******************************************************************************************
	 * APRESENTA AS HORAS, MINUTOS E SEGUNDOS ATUAIS, DE ACORDO COM OS MESMOS
	 * PAR�METROS DO SISTEMA
	 * 
	 * @param hora
	 * @return
	 */
	public static String hojemaishoras(int hora) {
		SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
		Calendar c = Calendar.getInstance();
		c.add(Calendar.HOUR, hora);
		return sdf.format(c.getTime());
		
		

	}
	/*******************************************************************************************
	 * SERVE PARA INSERIR TEXTO AO CAMPO PASSANDO COMO PARÂMETRO o BY E O TEXTO
	 * EXEMPLO: inserirTextoCampo(By.xpath(""), "texto");
	 * 
	 * @param link
	 */
	
	public static void inserirTextoCampo(By by, String texto) {
		
		MobileElement element = driver.findElement(by);
		if(element.isDisplayed()) {
			element.clear();
			element.sendKeys(texto);foto();
		}
	}
	/*******************************************************************************************
	 * SERVE PARA INSERIR TEXTO AO CAMPO PASSANDO COMO PARÂMETRO A ID E O TEXTO
	 * EXEMPLO: inserirTextoCampoId("id", "texto");
	 * 
	 * @param link
	 */

	public static void inserirTextoCampoId(String id, String texto) {
		MobileElement element = driver.findElement(By.id(id));
		element.clear();
		element.sendKeys(texto);

	}

	/*******************************************************************************************
	 * SERVE PARA INSERIR TEXTO AO CAMPO PASSANDO COMO PARÂMETRO A XPATH E O TEXTO
	 * EXEMPLO: inserirTextoCampoPath("xpath", "texto");
	 * 
	 * @param link
	 */

	public static void inserirTextoCampoPath(String xpath, String texto) {
		MobileElement element = driver.findElement(By.xpath(xpath));
		element.clear();
		element.sendKeys(texto);

	}
	/*******************************************************************************************
	 * SERVE PARA INSERIR TEXTO AO CAMPO PASSANDO COMO PARÂMETRO A XPATH E O TEXTO
	 * EXEMPLO: inserirTextoCampoPath("xpath", "texto");
	 * 
	 * @param link
	 */

	public static void inserirTextoCampoCssSele(String cssSelector, String texto) {
		MobileElement element = driver.findElement(By.cssSelector(cssSelector));
		element.clear();
		element.sendKeys(texto);

	}

	/*******************************************************************************************
	 * SERVE PARA COMPARAR SE O VALOR APRESENTADO É VERDADEIRO PASSANDO COMO
	 * PARÂMETRO TEXTO E O XPATH EXEMPLO: comparaValorXpath("valor", "xpath");
	 * 
	 * @param link
	 */

	public static void comparaValorXpath(String valor, String xpath) {
		MobileElement element = driver.findElement(By.xpath(xpath.trim()));
		String text = element.getText();//VERIFICA SE O OBJETO TEM TEXTO
		if(Strings.isNullOrEmpty(text)) {//SE RETORNAR NULO
			text = element.getText();//BUSCA POR ATRIBUTO
		}
		assertEquals(valor, text);//E FAZ A COMPARAÇÃO
		
	}
	/*******************************************************************************************
	 * SERVE PARA COMPARAR SE O VALOR APRESENTADO É VERDADEIRO PASSANDO COMO
	 * PARÂMETRO TEXTO E O XPATH EXEMPLO: comparaValorXpath("valor", "xpath");
	 * 
	 * @param link
	 */

	public static void comparaValorPath(String valor, String xpath) {
		String text = driver.findElement(By.xpath(xpath.trim())).getText();//VERIFICA SE O OBJETO TEM TEXTO
		assertEquals(valor, text);//E FAZ A COMPARAÇÃO

	}

	/*******************************************************************************************
	 * SERVE PARA GRAVAR AS AÇÕES DO SISTEMA PASSANDO COMO PARÂMETRO A PASTA ONDE SERÁ COLOCADO O VIDEO
	 * E O NOME DO VIDEO EXEMPLO: comparaValorcssSele("pastaVideo", "nomeVideo");
	 * 
	 * @param link
	 */
	public static void gravarAcao(String pastaVideo, String nomeVideo) throws ATUTestRecorderException {
		
		 DateFormat dateFormat = new SimpleDateFormat("yy-MM-dd HH-mm-ss");
		 Date date = new Date();
		 recorder = new ATUTestRecorder(pastaVideo,nomeVideo+dateFormat.format(date),false);
		  //To start video recording.
		 recorder.start();  

	}
	/*******************************************************************************************
	 * SERVE PARA COMPARAR SE O VALOR APRESENTADO É VERDADEIRO PASSANDO COMO
	 * PARÂMETRO TEXTO E O CSSSELECTOR EXEMPLO: comparaValorcssSele("valor", "cssSelector");
	 * 
	 * @param link
	 */

	public static void comparaValorcssSele(String valor, String cssSel) {
		MobileElement element = driver.findElement(By.cssSelector(cssSel.trim()));
		String text = element.getText();
		if(Strings.isNullOrEmpty(text)) {
			text = element.getAttribute("value");
		}
		assertEquals(valor, text);
		
	}

	/*******************************************************************************************
	 * SERVE PARA CLICAR NO OBJETO PASSANDO COMO PAR�METRO O BY 
	 *  EXEMPLO: clicarObjeto(By.xpath("propriedade do objeto"));
	 * 
	 * @param link
	 */
	public static void clicarObjeto(By by) {
		MobileElement element = driver.findElement(by);
		if(element != null && element.isDisplayed()) {
			element.click();
		
			
		}
		
	}
	public static void clicarlinkId(String link) {
		MobileElement linkMenu1 = driver.findElement(By.id(link));
		assertTrue(linkMenu1.isDisplayed());
		linkMenu1.click();
	}

	/*******************************************************************************************
	 * SERVE PARA CLICAR NO LINK DE PROPRIEDADE NAME PASSANDO COMO PAR�METRO O NAME
	 * DO LINK EXEMPLO: linkName("testename");
	 * 
	 * @param link
	 */
	public static void clicarlinkName(String link) {
		MobileElement linkMenu1 = driver.findElement(By.name(link));
		assertTrue(linkMenu1.isDisplayed());
		linkMenu1.click();
	}
	/*******************************************************************************************
	 * SERVE PARA CLICAR NO LINK DE PROPRIEDADE NAME PASSANDO COMO PAR�METRO O TEXT
	 * DO LINK EXEMPLO: clicarlinkText("testename");
	 * 
	 * @param link
	 */
	public static void clicarlinkText(String link) {
		MobileElement linkMenu1 = driver.findElement(By.linkText(link));
		assertTrue(linkMenu1.isDisplayed());
		linkMenu1.click();
	}

	/*******************************************************************************************
	 * SERVE PARA CLICAR NO LINK DE PROPRIEDADE XPATH PASSANDO COMO PAR�METRO O
	 * XPATH DO LINK EXEMPLO: linkPath("testexpath");
	 * 
	 * @param link
	 */
	public static void clicarlinkPath(String link) {
		MobileElement linkMenu1 = driver.findElement(By.xpath(link));
		assertTrue(linkMenu1.isDisplayed());
		linkMenu1.click();
	}
	/*******************************************************************************************
	 * SERVE PARA CLICAR NO LINK DE PROPRIEDADE cssSelector PASSANDO COMO PAR�METRO O
	 * XPATH DO LINK EXEMPLO: clicarlinkSelector("testexpath");
	 * 
	 * @param link
	 */
	public static void clicarlinkSelector(String link) {
		MobileElement linkMenu1 = driver.findElement(By.cssSelector(link));
		assertTrue(linkMenu1.isDisplayed());
		linkMenu1.click();
	}

	/*********************************************************************************************
	 * RENOVA O FRAME DA PAGINA
	 * Ex.: renewFrame("frame");
	 */
	protected static void renewFrame(String frame) {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(frame);
	}

	/*******************************************************************************************
	 * SERVE PARA CLICAR NO OBJETO DE PROPRIEDADE ID PASSANDO COMO PAR�METRO A ID DO
	 * OBJETO EXEMPLO: clicarId("botaoid");
	 * 
	 * @param idObjeto
	 */
	public static void clicarId(String idObjeto) {

//		while (driver.findElement(By.id(idObjeto)).isDisplayed() == false
//				&& driver.findElement(By.id(idObjeto)).isEnabled() == false) {
//
//		}

		MobileElement clicaObjeto = driver.findElement(By.id(idObjeto));
		assertTrue(clicaObjeto.isDisplayed());
		clicaObjeto.click();
	}

	/*******************************************************************************************
	 * SERVE PARA CLICAR NO OBJETO DE PROPRIEDADE CSSSELECTOR PASSANDO COMO
	 * PAR�METRO O CSSSELECTOR DO OBJETO EXEMPLO:
	 * clicarSelector("botaocssSelector");
	 * 
	 * @param idObjeto
	 */
	public static void clicarSelector(String selObjeto) {

		// ACESSO AO CLIQUE DO BOTÃO FECHAR
		MobileElement element = driver.findElement(By.cssSelector(selObjeto));
		while (element.isDisplayed() == false
				&& element.isEnabled() == false) {

		}

		MobileElement clicaObjeto = element;
		assertTrue(clicaObjeto.isDisplayed());
		clicaObjeto.click();
	}

	/*******************************************************************************************
	 * SERVE PARA CLICAR NO OBJETO DE PROPRIEDADE NAME PASSANDO COMO PAR�METRO A
	 * NAME DO OBJETO EXEMPLO: clicarName("botaoname");
	 * 
	 * @param idObjeto
	 */
	public static void clicarName(String nameObjeto) {
		MobileElement clicaObjeto = driver.findElement(By.id(nameObjeto));
		assertTrue(clicaObjeto.isDisplayed());
		clicaObjeto.click();
	}

	/*******************************************************************************************
	 * SERVE PARA CLICAR NO OBJETO DE PROPRIEDADE XPATH PASSANDO COMO PAR�METRO A
	 * XPATH DO OBJETO EXEMPLO: clicarPath("botaoxpath");
	 * 
	 * @param idObjeto
	 */
	public static void clicarPath(String xpathObjeto) {
		MobileElement clicaObjeto = driver.findElement(By.xpath(xpathObjeto));
		assertTrue(clicaObjeto.isDisplayed());
		clicaObjeto.click();
	}

	/*******************************************************************************************
	 * SERVE PARA SELECIONAR O OBJETO COM PROPRIEDADE ID, PASSANDO COMO PAR�METRO A
	 * XPATH E O VALOR A SER SELECIONADO EXEMPLO: selecionaComboId("comboid",
	 * "teste");
	 * 
	 * @param id
	 * @param valor
	 * @throws InterruptedException
	 */
	public static void selecionaComboId(String id, String valor) throws InterruptedException {
		tempo(1, MIN);
		MobileElement element = driver.findElement(By.id(id));
		element.click();
		tempo(1, MIN);
		element.sendKeys(valor);
		tempo(1, MIN);
		element.sendKeys(Keys.TAB);
	}
	/*	public static void inserirTextoCampo(By by, String texto) {
	
	if(driver.findElement(by).isDisplayed()) {
		driver.findElement(by).clear();
		driver.findElement(by).sendKeys(texto);
	}
}
 */
	
	/*******************************************************************************************
	 * SERVE PARA SELECIONAR A COMBOBOX, PASSANDO COMO PAR�METRO O BY
	 * E O VALOR A SER SELECIONADO EXEMPLO: selecionaCombo("comboid",
	 * "teste");
	 * 
	 * @param id
	 * @param valor
	 * @throws InterruptedException
	 */
	public static void selecionaCombo(By by, String valor) throws InterruptedException {
		tempo(1, MIN);
		MobileElement element = driver.findElement(by);
		element.click();
		tempo(1, MIN);
		element.sendKeys(valor);
		tempo(1, MIN);
		element.sendKeys(Keys.TAB);
	}
	/*******************************************************************************************
	 * SERVE PARA SELECIONAR O OBJETO COM PROPRIEDADE NAME, PASSANDO COMO PAR�METRO
	 * O NAME E O VALOR A SER SELECIONADO EXEMPLO: selecionaComboId("comboname",
	 * "teste");
	 * 
	 * @param name
	 * @param valor
	 * @param driver
	 * @throws InterruptedException
	 */
	public void selecionaComboName(String name, String valor, AndroidDriver<?> driver) throws InterruptedException {
		tempo(1, MIN);
		MobileElement element = (MobileElement) driver.findElement(By.name(name));
		element.click();
		tempo(1, MIN);
		driver.findElement(By.name(name)).sendKeys(valor);
		tempo(1, MIN);
		driver.findElement(By.name(name)).sendKeys(Keys.TAB);
	}

	/*******************************************************************************************
	 * SERVE PARA SELECIONAR O OBJETO COM PROPRIEDADE XPATH, PASSANDO COMO PAR�METRO
	 * O XPATH E O VALOR A SER SELECIONADO EXEMPLO:
	 * selecionaComboPath("/*comboxpath/*", "teste");
	 * 
	 * @param xpath
	 * @param valor
	 * @param driver
	 * @throws InterruptedException
	 */
	public static void selecionaComboPath(String xpath, String valor, AndroidDriver<?> driver) throws InterruptedException {
		tempo(1, MIN);
		MobileElement element = (MobileElement) driver.findElement(By.xpath(xpath));
		element.click();
		tempo(1, MIN);
		driver.findElement(By.xpath(xpath)).sendKeys(valor);
		tempo(1, MIN);
		driver.findElement(By.xpath(xpath)).sendKeys(Keys.TAB);
	}

	/*******************************************************************************************
	 * SERVE PARA PRINTAR AS AÇÕES EM TELA 
	 * 
	 * @throws IOException
	 */
	public static String foto() {

		File printFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyy-hh-mm-ss");
		Date d = new Date();
		String data = dateFormat.format(d);
		String nomeImagem = data + ".jpeg";

		try {
			FileUtils.copyFile(printFile, new File("C:\\Desenvolvimento\\screenshot\\" + nomeImagem));
		} catch (Exception e) {
			e.printStackTrace();
		}

		return nomeImagem;
	}
	/*******************************************************************************************
	 * ESTE MÉTODO PERMITE O ACESSO AOS DADOS NO ARQUIVO TXT, NESTE CASO PEGA AS
	 * INFORMA��ES DE URL, USUARIO E SENHA PASSANDO O NUMERO DA LINHA DOS MESMOS
	 * 
	 * @param driver
	 * @throws IOException 
	 * @throws FileNotFoundException
	 */
	public static void acessoLogin(AndroidDriver<?> driver, int url, int usuario, int senha) throws IOException {

		boolean resultadoExecucao;
		resultadoExecucao = pagina(driver, getValor_1(url));

		if (resultadoExecucao == true) {

			resultadoExecucao = loginAcesso(driver, getValor_2(usuario), getValor_3(senha));
			foto();
		} else {

			System.out.println("Pagina não carregada");
		}
		foto();
	}
	
	public static void acessoLogin(AndroidDriver<?> driver, String url, String usuario, String senha) throws IOException {

		boolean resultadoExecucao;
		resultadoExecucao = pagina(driver, url);

		if (resultadoExecucao == true) {

			resultadoExecucao = loginAcesso(driver, usuario, senha);
			foto();
		} else {

			System.out.println("Pagina não carregada");
		}
		foto();
	}
	/************************************************************************************************
	 * ACESSA O LONGIN
	 * 
	 */
	public static boolean loginAcesso(AndroidDriver<?> driver, String usuario, String senha) throws IOException {
		try {
			esperaOjetoAparecer(30, LeitorExcel.getConteudo(3, 4));
			//INFORMANDO O CPF
			inserirTextoCampo(By.xpath(LeitorExcel.getConteudo(2, 4)), usuario);foto();
			
			//CLICANDO NA TELA
			clicarObjeto(By.xpath(LeitorExcel.getConteudo(6, 4)));
			foto();
			
			//CLICANDO NO BOTÃO PROXIMO
			clicarObjeto(By.xpath(LeitorExcel.getConteudo(3, 4)));
			foto();
		
			//INFORMANDO A SENHA
			inserirTextoCampo(By.xpath(LeitorExcel.getConteudo(2, 4)),senha);
			foto();

			//CLICANDO NO BOTÃO ENTRAR
			clicarObjeto(By.xpath(LeitorExcel.getConteudo(4, 4)));
			foto();
			esperaOjetoAparecer(100, LeitorExcel.getConteudo(84, 6));

			return true;
		} catch (Exception e) {
			return false;
		}
	}
	/************************************************************************************************
	 * ACESSA O LONGIN
	 * 
	 */
	public static boolean loginAcessoMobile(String cpf, String senha) throws IOException {
		try {
			esperaOjetoAparecer(80, LeitorExcel.getConteudo(2, 4));
			//INFORMANDO O CPF
			inserirTextoCampo(By.xpath(LeitorExcel.getConteudo(2, 4)), cpf);
			foto();
			
			//CLICANDO NA TELA
			clicarObjeto(By.xpath(LeitorExcel.getConteudo(6, 4)));
			foto();
			
			//CLICANDO NO BOTÃO PROXIMO
			clicarObjeto(By.xpath(LeitorExcel.getConteudo(3, 4)));
			foto();
		
			//INFORMANDO A SENHA
			inserirTextoCampo(By.xpath(LeitorExcel.getConteudo(2, 4)),senha);
			foto();

			//CLICANDO NO BOTÃO ENTRAR
			clicarObjeto(By.xpath(LeitorExcel.getConteudo(4, 4)));
			foto();
			esperaOjetoAparecer(100, LeitorExcel.getConteudo(84, 6));

			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public static void logoff (String menususp, String sair) {
		
		MobileElement menu = driver.findElement(By.xpath(menususp));
		menu.click();
		MobileElement saida = driver.findElement(By.xpath(sair));
		saida.click();
	
		
	}

	/******************************************************************************
	 *VALIDA USUÁRIOS DE SERVIÇO
	 * 
	 */
	public static boolean pagina(AndroidDriver<?> driver, String url) throws IOException{
		
		boolean Retorno = false;
		
		driver.get(url);foto();
		
		try {
			Retorno = true;
			return Retorno;
			
		} catch (Exception e) {
			System.out.println("Falha no usuário");
			
			return Retorno;
		}
		
	}
	/*******************************************************************************************
	 * ESTE MÉTODO PASSA O MOUSE SOBRE A LINHA OU OBJETO PARA MOSTRAR A SOMBRA
	 * Ex.: mouseOver("xpathlinha", "xpathcoluna");
	 * @param driver
	 * @throws FileNotFoundException
	 */
	public static void mouseOver(String xpathlinha, String xpathcoluna) {

		//
		Actions action = new Actions(driver);
		MobileElement mostralinha = driver.findElement(By.xpath(xpathlinha));

		action.moveToElement(mostralinha).moveToElement(driver.findElement(By.xpath(xpathcoluna))).click().build()
				.perform();

	}
	/*******************************************************************************************
	 * ESTE MÉTODO PASSA O MOUSE SOBRE A LINHA OU OBJETO PARA MOSTRAR A SOMBRA
	 * 
	 * @param driver
	 * @throws FileNotFoundException
	 */
	public static void mouseOverFato(int xpathlinha, int xpathcoluna) {

		//
		Actions action = new Actions(driver);
		MobileElement mostralinha = driver.findElement(By.xpath(getTipoFato(xpathlinha)));

		action.moveToElement(mostralinha).moveToElement(driver.findElement(By.xpath(getXpath(xpathcoluna)))).click().build()
				.perform();

	}
	/*******************************************************************************************
	 * ESTE MÉTODO PASSA O MOUSE SOBRE A LINHA OU OBJETO PARA MOSTRAR A SOMBRA
	 * 
	 * @param driver
	 * @throws FileNotFoundException
	 */
	public static void mouseOverRemu(int xpathlinhaRemu, int xpathcolunaRemu) {

		//
		Actions action = new Actions(driver);
		MobileElement mostralinha = driver.findElement(By.xpath(getValor_6(xpathlinhaRemu)));

		action.moveToElement(mostralinha).moveToElement(driver.findElement(By.xpath(getXpath_6(xpathcolunaRemu)))).click().build()
				.perform();

	}
	/*******************************************************************************************
	 * ESTE MÉTODO PASSA O MOUSE SOBRE A LINHA OU OBJETO PARA MOSTRAR A SOMBRA
	 * 
	 * @param driver
	 * @throws FileNotFoundException
	 */
	public static void mouseOverPag(int xpathlinhaPg, int xpathcolunaPg) {

		//
		Actions action = new Actions(driver);
		MobileElement mostralinha = driver.findElement(By.xpath(getValor_7(xpathlinhaPg)));

		action.moveToElement(mostralinha).moveToElement(driver.findElement(By.xpath(getXpath_7(xpathcolunaPg)))).click().build()
				.perform();

	}

	/*******************************************************************************************
	 * ESTE MÉTODO PASSA O MOUSE SOBRE A LINHA OU OBJETO PARA MOSTRAR A SOMBRA
	 * 
	 * @param driver
	 * @throws FileNotFoundException
	 */
	public static void mouseOverLib(int xpathlinha, int xpathcoluna) {

		//
		Actions action = new Actions(driver);
		MobileElement mostralinha = driver.findElement(By.xpath(getValor(xpathlinha)));

		action.moveToElement(mostralinha).moveToElement(driver.findElement(By.xpath(getXpathValor(xpathcoluna)))).click().build()
				.perform();

	}

	/*******************************************************************************************
	 * ESTE MÉTODO PASSA O MOUSE SOBRE A LINHA OU OBJETO PARA MOSTRAR A SOMBRA
	 * 
	 * @param driver
	 * @throws FileNotFoundException
	 */

	public static void mouseOver(String xpathcoluna) {
		Actions action = new Actions(driver);

		action.moveToElement(driver.findElement(By.xpath(xpathcoluna))).click().build().perform();
	}
	/*******************************************************************************************
	 * ESTE MÉTODO PASSA O MOUSE SOBRE A LINHA OU OBJETO PARA MOSTRAR A SOMBRA
	 * 
	 * @param driver
	 * @throws FileNotFoundException
	 */

	public static void mouseOverFato(int xpathcoluna) {
		Actions action = new Actions(driver);

		action.moveToElement(driver.findElement(By.xpath(getXpath(xpathcoluna)))).click().build().perform();
	}
	/*******************************************************************************************
	 * ESTE MÉTODO PASSA O MOUSE SOBRE A LINHA OU OBJETO PARA MOSTRAR A SOMBRA
	 * 
	 * @param driver
	 * @throws FileNotFoundException
	 */

	public static void mouseOverRemu(int xpathcolunaRemu) {
		Actions action = new Actions(driver);

		action.moveToElement(driver.findElement(By.xpath(getXpath_6(xpathcolunaRemu)))).click().build().perform();
	}
	/*******************************************************************************************
	 * ESTE MÉTODO PASSA O MOUSE SOBRE A LINHA OU OBJETO PARA MOSTRAR A SOMBRA
	 * 
	 * @param driver
	 * @throws FileNotFoundException
	 */

	public static void mouseOverPag(int xpathcolunaPag) {
		Actions action = new Actions(driver);

		action.moveToElement(driver.findElement(By.xpath(getXpath_7(xpathcolunaPag)))).click().build().perform();
	}

	/*******************************************************************************************
	 * ESTE MÉTODO PASSA O MOUSE SOBRE A LINHA OU OBJETO PARA MOSTRAR A SOMBRA
	 * 
	 * @param driver
	 * @throws FileNotFoundException
	 */

	public static void mouseOverLib(int xpathcoluna) {
		Actions action = new Actions(driver);

		action.moveToElement(driver.findElement(By.xpath(getXpathValor(xpathcoluna)))).click().build().perform();
	}

	/*******************************************************************************************
	 * ESTE MÉTODO FAZ A COMPARAÇÃO ENTRE VALORES
	 * 
	 * @param driver
	 * @throws FileNotFoundException
	 */

	public static void comparaValorLinhas(String tipoFato, String path, String mensagem) {
		try {
			comparaValorXpath(tipoFato, path);
		} catch (Error e) {

			Evidencia evidencia = new Evidencia();
			evidencia.setMensagem(mensagem);
			evidencia.setImagem(foto());
			evidencias.add(evidencia);
			System.out.println(mensagem);
		}
	}
	public static void comparaValor(String texto, String path) {
		comparaValorXpath(texto, path);
	}

	public static void comparaValorCal(String tipoFato, String path, String mensagem) {
		try {
			comparaValorXpath(tipoFato, path);
		} catch (Error e) {

			Evidencia evidencia = new Evidencia();
			evidencia.setMensagem(mensagem);
			evidencia.setImagem(foto());
			evidencias.add(evidencia);
			System.out.println(mensagem);
		}
	}

	public static void geraMensagem (String mensagem) {
		
		Evidencia evidencia = new Evidencia();
		evidencia.setMensagem(mensagem);
		evidencia.setImagem(foto());
		evidencias.add(evidencia);
		System.out.println(mensagem);
	
	}
	
	/*******************************************************************************************
	 * ESTE MÉTODO FAZ A COMPARAÇÃO ENTRE FALORES
	 * 
	 * @param driver
	 * @throws FileNotFoundException
	 */
	public static void comparaValorLib(int tipoFato, int path, int mensagem) {
		try {
			comparaValorXpath(getValor(tipoFato), getXpathValor(path));
		} catch (Error e) {

			Evidencia evidencia = new Evidencia();
			evidencia.setMensagem(getMensagem(mensagem));
			evidencia.setImagem(foto());
			evidencias.add(evidencia);
			System.out.println(getMensagem(mensagem));
		}
	}
	/*******************************************************************************************
	 * ESTE MÉTODO FAZ A COMPARAÇÃO ENTRE FALORES PASSANDO COMO PARÂMETRO O NUMERO DA LINHA
	 * 
	 * @param driver
	 * @throws FileNotFoundException
	 */

	public static void comparaValorFato(int tipoFato, int path, int mensagem) {
		try {
			comparaValorXpath(getTipoFato(tipoFato), getXpath(path));
		} catch (Error e) {

			Evidencia evidencia = new Evidencia();
			evidencia.setMensagem(getMensagem(mensagem));
			evidencia.setImagem(foto());
			evidencias.add(evidencia);
			System.out.println(getMensagem(mensagem));
		}
	}
	/*******************************************************************************************
	 * ESTE MÉTODO FAZ A COMPARAÇÃO ENTRE FALORES PASSANDO COMO PARÂMETRO O NUMERO DA LINHA
	 * 
	 * @param driver
	 * @throws FileNotFoundException
	 */

	public static void comparaValorRemu(int tipoRem, int pathRem, int mensagem) {
		try {
			comparaValorXpath(getValor_6(tipoRem), getXpath_6(pathRem));
		} catch (Error e) {

			Evidencia evidencia = new Evidencia();
			evidencia.setMensagem(getMensagem(mensagem));
			evidencia.setImagem(foto());
			evidencias.add(evidencia);
			System.out.println(getMensagem(mensagem));
		}
	}
	/*******************************************************************************************
	 * ESTE MÉTODO FAZ A COMPARAÇÃO ENTRE FALORES PASSANDO COMO PARÂMETRO O NUMERO DA LINHA
	 * 
	 * @param driver
	 * @throws FileNotFoundException
	 */

	public static void comparaValorPag(int tipoPg, int pathPg, int mensagem) {
		try {
			comparaValorXpath(getValor_7(tipoPg), getXpath_7(pathPg));
		} catch (Error e) {

			Evidencia evidencia = new Evidencia();
			evidencia.setMensagem(getMensagem(mensagem));
			evidencia.setImagem(foto());
			evidencias.add(evidencia);
			System.out.println(getMensagem(mensagem));
		}
	}

	/*******************************************************************************************
	 * ESTE MÉTODO FAZ A COMPARAÇÃO ENTRE VALORES DA TABELA COM A APLICAÇÃO 
	 * PASSANDO COMO PARÂMETRO A QUERY, XPATH DO VALOR, O VALOR DA MENSAGEM 
	 * Ex.: comparaValorTabela("query", 1, "xpath", "mensagem");
	 *  
	 * @param driver
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * @throws FileNotFoundException
	 */

////	public static void comparaValorTabela(int query, int coluna, int xpath, int mensagem) throws ClassNotFoundException, SQLException {
////		List<ContratoDTO> contratos = Conexao.consultaTabela(getValor_5(query), coluna);
////		
////		try {
////			for(ContratoDTO contrato : contratos) {
////				comparaValorXpath(contrato.getCodigo(), getXpathValor(xpath));
////			}
////		} catch (Exception e) {
////
////			Evidencia evidencia = new Evidencia();
////			evidencia.setMensagem(getMensagem(mensagem));
////			evidencia.setImagem(foto());
////			evidencias.add(evidencia);
////			System.out.println(getMensagem(mensagem));
////		}
//	}
	/*******************************************************************************************
	 * ESTE MÉTODO FAZ A COMPARAÇÃO ENTRE VALORES DO TXT COM A APLICAÇÃO 
	 * PASSANDO COMO PARÂMETRO O TIPO, XPATH DO VALOR, O VALOR DA MENSAGEM 
	 * 
	 * @param driver
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * @throws FileNotFoundException
	 */
	
	public static void comparaValor(int tipo, int path, int mensagem) {
		try {
			comparaValorXpath(getValor_4(tipo), getXpathValor_4(path));
		} catch (Error e) {

			Evidencia evidencia = new Evidencia();
			evidencia.setMensagem(getMensagem(mensagem));
			evidencia.setImagem(foto());
			evidencias.add(evidencia);
			System.out.println(getMensagem(mensagem));
		}
	}
	/*******************************************************************************************
	 * ESTE MÉTODO INSERE A MENSAGEM EM UM ARQUIVO
	 * 
	 * @param driver
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * @throws FileNotFoundException
	 */
	public static String getMensagemEvidencia(String nomeImagem) {
		for(Evidencia evidencia : evidencias) {
			if(evidencia.getImagem().equals(nomeImagem))
				return evidencia.getMensagem();
		}
		return null;
	}
	/*******************************************************************************************
	 * ESTE MÉTODO FAZ A COMPARAÇÃO ENTRE VALORES DO TXT COM A APLICAÇÃO 
	 * PASSANDO COMO PARÂMETRO O TIPO, XPATH DO VALOR, O VALOR DA MENSAGEM 
	 * 
	 * @param driver
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * @throws FileNotFoundException
	 */
	public static void compararMensagem(int tipoFato, int path, int mensagem, String nomeImagem) {
		try {
			comparaValorXpath("", getXpath(path));
		} catch (Error e) {

			Evidencia evidencia = new Evidencia();
			evidencia.setMensagem(getMensagem(mensagem));
			evidencia.setImagem(nomeImagem);
			evidencias.add(evidencia);
			System.out.println(getMensagem(mensagem));
		}
	}
	/*******************************************************************************************
	 * ESTE MÉTODO DELETA OS ARQUIVOS DE UMA PASTA, PODE SER USADO ANTES OU DEPOIS
	 * DA EXECUÇÃO DA SUITE OU CLASSE PASSANDO COMO PARAMETRO O CAMINHO DA PASTA A
	 * SER DELETADA
	 * Ex.: deletarArquivo("localPasta");
	 * 
	 * @param driver
	 * @throws FileNotFoundException
	 */

	public static void deletarArquivo(String localPasta) throws IOException {

		String caminhoPasta = localPasta;
		File pasta = new File(caminhoPasta);

		for (File arquivo : pasta.listFiles()) {
			Files.delete(arquivo.toPath());
		}
	}
	/*******************************************************************************************
	 * ESTE MÉTODO ESPERA O OBJETO ATÉ ELE APARECER NA TELA, PASSANDO COMO PARÂMETROS O TEMPO E
	 * O XPATH DO OBJETO
	 * Exemplo: esperaObjetoAparecer(5, "xpath do objeto"); 
	 * @param driver
	 * @throws FileNotFoundException
	 */
	public static void esperaOjetoAparecer(int tempo, String path) {
		WebDriverWait wait = new WebDriverWait(driver, tempo);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(path)));

		
	}
    /******************************************************************************************
     * ESTE MÉTODO RETIRA O PONTO E SUBSTITUI VIRGULA POR PONTO NOS VALORES MONETÁRIOS
     * Ex.: transformaValor("value"); 
     * 
     * @param value
     * @return
     */
	public static double transformaValor(String value) {
		return Double.parseDouble(value.replaceAll("\\D", ""));
	}
	/**
	 * ESTE MÉTODO PÕE MÁSCARA NOS VALORES
	 * @param value
	 * @return
	 */
	public static String transformaValorString (Double value) {
		DecimalFormat df = new DecimalFormat("###,###,###,##0.00");
		String format = df.format(value);
		return (format);
	}
	/**
	 * ESTE MÉTODO PÕE MÁSCARA NOS VALORES LIMITANDO AS CASAS DECIMAIS
	 * @param total
	 * @return
	 */
	public static String transformaValorDouble (Double total) {
		DecimalFormat df = new DecimalFormat("###########0.00");
		df.setMinimumFractionDigits(2);
		String format = df.format(total);
		return (format);
	}
	/**
	 * ESTE MÉTODO PÕE MÁSCARA NOS VALORES
	 * @param value
	 * @return
	 */
	 public static String transformaValorMon(Double value) {
	        NumberFormat format = new DecimalFormat("###,###,###,##0.00");
	        String valorFormatado = format.format(value);
	        return (valorFormatado);
	        		       
	}
	public static double transformaValorMonetario(String value) throws ParseException {
		NumberFormat currencyInstance = NumberFormat.getCurrencyInstance(Locale.forLanguageTag("pt-BR"));
		return currencyInstance.parse(value).doubleValue();
	}
	 
	public static void inicioConsole() {
		
	}
	
	protected static Object visibilityOfElementLocated(By xpath) {
		// TODO Auto-generated method stub
		return null;
	}
	public static void lerPlanilhaExcel(String nomePlanilha, String aba, int linha, int coluna) throws BiffException, IOException {

		Workbook workbook = Workbook.getWorkbook(new File("teste.xls"));
		Sheet sheet = workbook.getSheet(0);
		int linhas = sheet.getRows();
		
		System.out.println("Iniciando a leitura da planilha XLS:");

		for(int i = 0; i < linhas; i++){
			Cell a1 = sheet.getCell(0, i);
			Cell a2 = sheet.getCell(1, i);
			Cell a3 = sheet.getCell(2, i);
			String as1 = a1.getContents();
			String as2 = a2.getContents();
			String as3 = a3.getContents();
			
			System.out.println("Coluna 1: " + as1);
			System.out.println("Coluna 2: " + as2);
			System.out.println("Coluna 3: " + as3);
		}
		workbook.close();
		
//		String caminho = nomePlanilha;
//		File fp = new File(caminho);
//		try {
//			Workbook w = Workbook.getWorkbook(fp);
//			Sheet aba = w.getSheet(aba);
//			return aba.getCell(coluna - 1, linha - 1).getContents().toString();
//			
//		} catch (Exception ioe) {
//			return "ERRO NA LEITURA.";
//
		}
	public static void assertMensagem(String mensagemTela, String mensagemEspe) {
		String textTitulo = driver.findElement(By.xpath(mensagemTela.trim())).getText();//GUARDA O VALOR DO TITULO	
		if (textTitulo.equals(mensagemEspe)){
			geraMensagem("Validado com sucesso!");				
			}else {
				geraMensagem("ERRO na validação!");
			}

	}

	 /**
	    * CLICA EM UM OBJETO PASSANDO COMO PARAMETRO COMANDOS JAVASCRIPT
	    * Ex.:clicarObjetoJS("passa o by do objeto", "passa o comando JS")
	    * @param by
	    * @param JS
	    */
		public static void clicarObjetoJS(By by, String JS) {
			
			MobileElement button = driver.findElement(by);
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript(JS, button);
		}

	/**
	 * VALIDA MENSAGEM PASSANDO COMO PARÂMETRO O MENSAGEM ESPERADA E A XPATH DA MENSAGEM 
	 * Ex.:validarMensagem("mensagem esperada" ,xpath);
	 * @param xpath
	 * @param mensagem
	 */
	public static void validarMensagem(String esperada, String path) {

			try {
				comparaValorXpath(esperada, path);	
//				geraMensagem("Mensagem correta!");
				System.out.println("Mensagem correta!");
			} catch (Error e) {
				geraMensagem("Mensagem incorreta!");
				System.out.println("Mensagem incorreta!");
			}
}
	
	/**
	 * FAZ A ROLAGEM DE TELA PASSANDO COMO PARAMETRO A QUANTIDADE DE REPETIÇOES, A PORCENTAGEM QUE IRA ROLA
	 * E O BY 
	 * Ex.:validarMensagem(2, 0.4 , By.xpath("/grititit/"));
	 * @param PorcRolar
	 * @param by
	 * @return
	 * @throws Exception
	 */
	public  boolean rolagemTela (int qtd, Double PorcRolar, By by) throws Exception {
	//EXISTE NA TELA?
	boolean isFoundTheElement = driver.findElements(by).size() > 0;
	//NAO EXISTE
//	while (isFoundTheElement == false) {
	//SE NAO EXISTE CONTINUA PROCURANDO	
	for(int i=0; i<=qtd; i++) {
		swipeVertical(PorcRolar, 0.1, 0.5, 2000);
	}
	
//	isFoundTheElement = driver.findElements(by).size() > 0;
	
//	}
//	MobileElement clicar = driver.findElement(by);
//	clicar.click();
			  return isFoundTheElement;
			}
	public  void swipeVertical (
	  double startPercentage, double finalPercentage, double anchorPercentage, int duration)
	  throws Exception {
	  org.openqa.selenium.Dimension size = driver.manage().window().getSize();
	  int anchor = (int) (size.width * anchorPercentage);
	  int startPoint = (int) (size.height * startPercentage);
	  int endPoint = (int) (size.height * finalPercentage);
	  getTouchAction().press(PointOption.point(anchor, startPoint))
	  .waitAction(WaitOptions.waitOptions(Duration.ofMillis(duration)))
	  .moveTo(PointOption.point(anchor, endPoint)).release().perform();
	  
	  
	}
	@SuppressWarnings("rawtypes")
	public  TouchAction getTouchAction () {
		
			  return new TouchAction(driver);
			  
			

	}
	/**
	 * ESPERA O ELEMENTO FICAR VISIVEL, PRESENTE E CLICAVEL USANDO COMO
	 * PARAMETRO O TEMPO E O BY
	 * Ex.: esperaClique(900000000,By.xpath("/euhuihihiuhfi/"));
	 * @param tempo
	 * @param by
	 */
	public void esperaClique(int tempo, By by) {
		
			WebDriverWait wait = new WebDriverWait(driver, tempo*1000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(by)).click();
			foto();

		

//		driver.manage().timeouts().implicitlyWait(tempo*1000, TimeUnit.MINUTES);  
//		try {
//			driver.manage().timeouts().implicitlyWait(tempo*1000, TimeUnit.MINUTES); 
//			wait.until(ExpectedConditions.visibilityOfElementLocated(by)).click();
//			
//		} catch (Exception e) {
//			driver.manage().timeouts().implicitlyWait(tempo*1000, TimeUnit.MINUTES); 
//			wait.until(ExpectedConditions.presenceOfElementLocated((by))).click();
//
//		}
//		try {
//		} catch (Exception e) {
//			// TODO: handle exception
//		}

	}
	/**
	 * ESPERA O ELEMENTO  FICAR VISIVEL, PRESENTE E CLICAVEL PARA PREENCHER
	 * O CAMPO USANDO COMO PARAMETRO O TEMPO, O BY E O TEXTO QUE SERA PREENCHIDO
	 * Ex.: esperaPreencher(9000000, By.xpath("/euhuihihiuhfi/"),"teste"));
	 * @param tempo
	 * @param by
	 * @param texto
	 */
	public void esperaPreencher(int tempo, By by, String texto) {
		
		WebDriverWait wait = new WebDriverWait(driver, tempo);
		wait.until(ExpectedConditions.visibilityOfElementLocated(by)).click();

//		driver.manage().timeouts().implicitlyWait(tempo, TimeUnit.MINUTES);  
//		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
//		driver.manage().timeouts().implicitlyWait(tempo, TimeUnit.MINUTES);  
//		wait.until(ExpectedConditions.presenceOfElementLocated((by)));
//		driver.manage().timeouts().implicitlyWait(tempo, TimeUnit.MINUTES);  
//		wait.until(ExpectedConditions.elementToBeClickable((by)));
//		driver.manage().timeouts().implicitlyWait(tempo, TimeUnit.MINUTES);  
		inserirTextoCampo((by), texto);
	}

	public void executa(int command, ImmutableMap<Object, Object> immutableMap) {
	        executa(command, ImmutableMap.of());
	    }
 
}