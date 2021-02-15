package metodosauxiliares;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class LeitorExcel{
	
	private static List<List<String>> planilha = new ArrayList<List<String>>(0);

	public static void main(String[] args) throws BiffException, IOException {
//		System.out.println(getConteudo(1, 1));
//		lerCsv();
	}
	
	public static void lerExcel(String caminhoExcel) throws BiffException, IOException {
		Workbook workbook = Workbook.getWorkbook(new File(caminhoExcel));
		Sheet sheet = workbook.getSheet(0);
		int linhas = sheet.getRows();
		int colunas = sheet.getColumns();
		
//		System.out.println("Iniciando a leitura da planilha XLS:");
		
		for(int i = 1; i < linhas; i++) {
			List<String> conteudoLinha = new ArrayList<String>(1);
			for(int j = 0; j < colunas; j++) {
				Cell cell = sheet.getCell(j, i); 
				conteudoLinha.add(cell.getContents());
			}
			planilha.add(conteudoLinha);
		}
		
		workbook.close();
		
		
		
	}
	static String caminhoGeral = "..\\projetocucumber\\Utils\\dataPools\\";
	static String caminhoElementos= caminhoGeral+"elementos.xls";
	
	public String getElementos(int linha, int coluna) throws BiffException, IOException {
		lerExcel(caminhoElementos);
		return planilha.get(linha-1).get(coluna-1);	
		
	}
	public String Lerplanilha(int lin, int col) {
		String caminho = caminhoElementos;
		File fp = new File(caminho);
		try {
			Workbook wb = Workbook.getWorkbook(fp);
			Sheet aba = wb.getSheet(0);
			return aba.getCell(col - 1, lin - 1).getContents().toString();
		} catch (Exception ioe) {
			return "Erro de LEITURA.";
		}
	}
}
