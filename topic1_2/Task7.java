package topic1_2;
/*Задание 7. Имеются два дома размерами а на Ь и с на d. Имеется участок размерами e на f. Прверить
*помещаются ли эти дома на данном участке. Стороны домов параллельны сторонам участка, в остальном
* размещение может быть любым.
*/
public class Task7 {
    public static void main(String[] args) {
        int a=3,b=2,c=3,d=3,e=5,f=6;
        if (((a+c<=e)&&(b+d<=f))||((a+c<=f)&&(b+d<=e))||((a+d<=e)&&(b+c<=f))||
                ((a+d<=f)&&(b+c<=e))){
            System.out.println("Houses will fit");
        }else {
            System.out.println("Houses won't fit");
        }

    }
}
