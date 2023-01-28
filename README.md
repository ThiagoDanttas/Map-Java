# Map - Java

---

### Map\<Key,Value>
[Clique para acessar a documentação MAP](https://docs.oracle.com/javase/10/docs/api/java/util/Map.html) <br>
• É uma coleção de pares chave / valor <br>
• Não admite repetições do objeto chave <br>
• Os elementos são indexados pelo objeto chave (não possuem posição) <br>
• Acesso, inserção e remoção de elementos são rápidos <br>
• Uso comum: cookies, local storage, qualquer modelo chave-valor <br>

#### Principais implementações:
• HashMap - mais rápido (operações O(1) em tabela hash) e não ordenado <br>
• TreeMap - mais lento (operações O(log(n)) em árvore rubro-negra) e ordenado pelo compareTo do objeto (ou Comparator) <br>
• LinkedHashMap - velocidade intermediária e elementos na ordem em que são adicionados

#### Alguns métodos importantes
• put(key, value), remove(key), containsKey(key), get(key)  <br>
• Baseado em equals e hashCode <br>
• Se equals e hashCode não existir, é usada comparação de ponteiros <br>
• clear() <br>
• size() <br>
• keySet() - retorna um Set\<K> <br>
• values() - retorna um Collection\<V>

### Exercício proposto (Map)

Na contagem de votos de uma eleição, são gerados vários registros
de votação contendo o nome do candidato e a quantidade de votos
(formato .csv) que ele obteve em uma urna de votação. Você deve
fazer um programa para ler os registros de votação a partir de um
arquivo, e daí gerar um relatório consolidado com os totais de cada
candidato.

~~~~java


import java.io.*;
import java.text.ParseException;
import java.util.*;

public class Exercise {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Map<String, Integer> votes = new LinkedHashMap<>();

        System.out.print("Enter file full path: ");
        String path = sc.nextLine();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {

            String line = br.readLine();

            while(line != null) {

                String[] fields = line.split(";");
                String name = fields[0];
                int count = Integer.parseInt(fields[1]);

                if(votes.containsKey(name)) {
                    int voteSofar = votes.get(name);
                    votes.put(name, sum(count, voteSofar));
                } else {
                    votes.put(name, count);
                }

                line = br.readLine();

            }

            for (String key : votes.keySet()) {
                System.out.println(key + ": " + votes.get(key));
            }


        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }

    // Método para somar os votos
    static int sum(int a, int b) {
        return a + b;
    }

}

~~~~