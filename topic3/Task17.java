package topic3;
/* Задание 17. Создать двухмерный квадратный массив, и заполнит его "бабочкой":
*   11111111
*   01111110
*   00111100
*   00011000
*   00111100
*   01111110
*   11111111
 */
public class Task17 {
    public static void main(String[] args) {
        char [][] butterfly = new char[13][13];
        for (int i=0;i<butterfly.length;i++ ){
            for (int j=0;j<butterfly[i].length;j++){
                butterfly[i][j]=' ';
            }
        }

        for (int i=0;i<(butterfly.length-1)/2+1;i++){
            for (int j=i;j<butterfly[i].length-i;j++){
                butterfly[i][j]=(char)666;
            }
        }
        for (int i=butterfly.length-1;i>=(butterfly.length-1)/2+1;i--){
            for (int j=i;j>=butterfly[i].length-i-1;j--){
                butterfly[i][j]=(char)333;
            }
        }
        for (char[] row:butterfly){
            for (char elem:row){
                System.out.print(elem+" ");
            }
            System.out.println();
        }
    }
}
