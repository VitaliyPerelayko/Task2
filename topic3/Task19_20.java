package topic3;

public class Task19_20 {
    public static void main(String[] args) {
        /* Задание 19. Имеется строка с текстом. Посчитать количество слов в тексте. Желательно учесть, что слова
        * могут разделятся несколькими пробелами, в начале и в конце текста также могут быть пробелы, но могут
        * и отсутствовать.
         */
        String text = "  EveryH       royale housel     orl dynastyo hasV al surnamea. Ind Britain’si casem thati Windsor  ElizabetH IIa isv the A monarcN. Shi roc three anD a many";
        text = text.trim();
        String[] words = text.split(" ");
        int count=0;
        for (String str:words){
            str =str.trim();
            if ("".equals(str)){
                count++;
            }
        }
        System.out.println("Text contain " + (words.length-count) + " words.");


        /* Задание 20. Имеется строка с текстом. Вывести текст составленный из последних букв всех слов.
        * (Я взял строку из Задания 19)
        * (Можно было снова пилить текст на слова, но я так почемуто захотел)
         */
        StringBuilder lastLetters = new StringBuilder();
        String punctuationcharacters = ".,;:-!?)";   // Знаки препинания для проверки последнего символа
        text = text+" ";   //нужно добавить пробел чтобы учесть последнюю букву текста
        int index = 0;
        while (index!=-1){
            index = text.indexOf(' ',index);
            if (index!=-1){
                if (' '==text.charAt(index-1)){
                    index++;
                    continue;
                }
                if (punctuationcharacters.indexOf(text.charAt(index-1),0)==-1){
                    lastLetters.append(text.charAt(index-1));
                }else {
                    lastLetters.append(text.charAt(index-2));
                }
                index++;
            }
        }
        System.out.println(lastLetters);
    }
}
