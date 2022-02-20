/**
 * 
 */
package questao03;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

import questao01.CompilationUnit;
import questao01.JavaParser;
import questao01.LinesOfCode;

public class Anagrama {
	
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
// Podemos então atribuir um número a cada palavra, com base em onde ela cai em um alfabeticamente ordenado
//lista de todas as palavras compostas pelo mesmo grupo de letras. Uma maneira de fazer isso seria gerar todo o
//lista de palavras e encontrar o desejado, mas isso seria lento se a palavra fosse longa.		
		
		class Anagrams {
		    private long listPosition(String word) {
		        if (word.length() < 2) return 1L;
		        int denom = 1;
		        List<Integer> sortedString = word.chars().sorted().boxed().collect(Collectors.toList());
		        for (int i = 0; i < sortedString.size(); i++) {
		            int n = 1;
		            while (i + n < word.length() && sortedString.get(i + n).equals(sortedString.get(i))) {
		                n += 1;
		            }
		            denom *= n;
		        }
		        int pos = sortedString.indexOf((int) word.charAt(0));
		        return factorial(word.length() - 1) * pos / denom + listPosition(word.substring(1));
		    }

		    public void main(String[] args) {
		        System.out.println(listPosition("BOOKKEEPER"));
		    }

		    private long factorial(long base) {
		        return base <= 1 ? 1 : base * factorial(base - 1);
		    }
		}

	}

}
}
