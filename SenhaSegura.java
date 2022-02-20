/**
 * 
 */
package questao02;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

import org.junit.Test;

import questao01.CompilationUnit;
import questao01.JavaParser;
import questao01.LinesOfCode;

public class SenhaSegura {
	
	class LinesOfCodeTest{

		@Test
		public void testaQuantidadeLinhasDeCodigo() throws IOException{
			
			String className = "HelloWorld.java";
			File javaFile = new File("./test/"+className);
			
			LinesOfCode loc = new LinesOfCode();
			CompilationUnit cUnit = JavaParser.getJavaFile(javaFile, className);
			loc.measure(cUnit);
				
			assertEquals(23.0, loc.getCalculatedValue());
			System.out.println(loc.getAcronym() + ": " + loc.getCalculatedValue() + "\n");
		}


	public void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.printf("Senha: ");
		String senha = sc.next();
		senhaForte(senha);

		if (senhaForte(senha) == true) {
			System.out.println("Certo");
		} else {
			System.out.println("errado");
		}

		sc.close();

	}

	//para apresentar a senha
	public boolean senhaForte(String senha) {
		if (senha.length() < 6)
			return false;

		boolean achouNumero = false;
		boolean achouMaiuscula = false;
		boolean achouMinuscula = false;
		boolean achouSimbolo = false;
		for (char c : senha.toCharArray()) {
			if (c >= '0' && c <= '9') {
				achouNumero = true;
			} else if (c >= 'A' && c <= 'Z') {
				achouMaiuscula = true;
			} else if (c >= 'a' && c <= 'z') {
				achouMinuscula = true;
			} else if (c == '!' || c == '@' || c == '#' || c == '$' || c == '%' || c == '&' || c == '*' || c == '(' || c == ')' || c == '-' || c == '+'){
				achouSimbolo = true;
			}
		}
		return achouNumero && achouMaiuscula && achouMinuscula && achouSimbolo;		
	}
	
}
}
