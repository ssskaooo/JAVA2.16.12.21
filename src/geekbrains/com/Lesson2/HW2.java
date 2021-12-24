package geekbrains.com.Lesson2;

public class HW2 {

//1. Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4,
// при подаче массива другого размера необходимо бросить исключение MyArraySizeException.

//2. Далее метод должен пройтись по всем элементам массива, преобразовать в int, и просуммировать.
// Если в каком-то элементе массива преобразование не удалось (например, в ячейке лежит символ или текст вместо числа),
// должно быть брошено исключение MyArrayDataException, с детализацией в какой именно ячейке лежат неверные данные.

//3. В методе main() вызвать полученный метод, обработать возможные исключения MySizeArrayException
// и MyArrayDataException, и вывести результат расчета.
    public static void main(String[] args) {
        String[][] array = new String[][] {{"1","2","3","4"},
                                           {"2","3","4","1"},
                                           {"3","4","1","2"},
                                           {"4","1","2","3"}};
        try {
            try {
                int result = method(array);
                System.out.println(result);
            }catch (MyArraySizeException e){
                System.out.println("Размер массива превышен ! ");
            }
        }
        catch (MyArrayDataException e){
            System.out.println("Неправильное значение массива ! ");
            System.out.println("Ошибка в ячейке " + e.i + "x" + e.j);
        }

    }

    public static int method(String [][] array) throws MyArrayDataException, MyArraySizeException{
        int count = 0;
        if(array.length != 4){
            throw new MyArraySizeException();
        }
        for (int i = 0; i < array.length; i++) {
            if(array[i].length != 4){
                throw new MyArraySizeException();
            }
            for (int j = 0; j < array[i].length; j++) {
                try {
                    count = count + Integer.parseInt(array[i][j]);

                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j);
                }
            }
        }
        return count;
    }
}
