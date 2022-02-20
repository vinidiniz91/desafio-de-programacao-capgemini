package questao01;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.junit.Test;

public class Escada {

	
	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
		List<String> degraus = new ArrayList<>();
		
		System.out.print("Digite a quantidade de vezes: ");
		int qtdDegraus = entrada.nextInt();
		
		for (int i = 0; i < qtdDegraus; i++) {
		degraus.add(" ".repeat(qtdDegraus - i) + "*".repeat(i + 1));
		}
		
		for (String d : degraus ) {
		System.out.println(d);
		
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
		}
		}
	}
}
