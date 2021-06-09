import java.util.Arrays;
import java.util.Scanner;

public class Test {

    /* Задача по джаве
пользователь вводит произвольную строку. требуется - сформировать из строки массив отсортированный по сл. принципу - алфавитная сортировка по возрастанию чередуя буквы и цифры.

пример = строка 213авб
вывод = [1, а, 2, б, 3, в]*/

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        char[] symbolsBefore;
        symbolsBefore = str.toCharArray();
        Arrays.sort(symbolsBefore);
        int lettersCount = 0;
        int numbersCount = 0;
        while (symbolsBefore[lettersCount] < 224) { // using ASCII (American Standard Code for Information Interchange) http://book.itep.ru/10/ascii.htm
            lettersCount++;
        }
        int lettersStart = lettersCount;
        int a = 0;
        for (int i = 0; i < str.length(); i++) {
            if (i < lettersStart) {
                str = str.substring(0, a) + symbolsBefore[numbersCount++] + str.substring(a + 1);
                a += 1;
                str = str.substring(0, a) + symbolsBefore[lettersCount++] + str.substring(a + 1);
                a += 1;
            } else {
                if ((a % str.length()) != 0) {
                    str = str.substring(0, a) + symbolsBefore[lettersCount++] + str.substring(a + 1);
                }
                break;
            }
        }
        System.out.print("[");
        char[] symbolsAfter = str.toCharArray();
        for (int z = 0; z < symbolsAfter.length - 1; z++) {
            System.out.print(symbolsAfter[z] + ", ");
        }
        System.out.print(symbolsAfter[symbolsAfter.length - 1] + "]");
    }
}





