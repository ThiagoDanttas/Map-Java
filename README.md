# Map - Java

---

### Map\<Key,Value>
[Clique para acessar a documenta��o MAP](https://docs.oracle.com/javase/10/docs/api/java/util/Map.html) <br>
� � uma cole��o de pares chave / valor <br>
� N�o admite repeti��es do objeto chave <br>
� Os elementos s�o indexados pelo objeto chave (n�o possuem posi��o) <br>
� Acesso, inser��o e remo��o de elementos s�o r�pidos <br>
� Uso comum: cookies, local storage, qualquer modelo chave-valor <br>

#### Principais implementa��es:
� HashMap - mais r�pido (opera��es O(1) em tabela hash) e n�o ordenado <br>
� TreeMap - mais lento (opera��es O(log(n)) em �rvore rubro-negra) e ordenado pelo compareTo do objeto (ou Comparator) <br>
� LinkedHashMap - velocidade intermedi�ria e elementos na ordem em que s�o adicionados

#### Alguns m�todos importantes
� put(key, value), remove(key), containsKey(key), get(key)  <br>
� Baseado em equals e hashCode <br>
� Se equals e hashCode n�o existir, � usada compara��o de ponteiros <br>
� clear() <br>
� size() <br>
� keySet() - retorna um Set\<K> <br>
� values() - retorna um Collection\<V>

### Exerc�cio proposto (Map)

Na contagem de votos de uma elei��o, s�o gerados v�rios registros
de vota��o contendo o nome do candidato e a quantidade de votos
(formato .csv) que ele obteve em uma urna de vota��o. Voc� deve
fazer um programa para ler os registros de vota��o a partir de um
arquivo, e da� gerar um relat�rio consolidado com os totais de cada
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

    // M�todo para somar os votos
    static int sum(int a, int b) {
        return a + b;
    }

}

~~~~