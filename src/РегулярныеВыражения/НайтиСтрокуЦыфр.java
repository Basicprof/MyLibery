package РегулярныеВыражения;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class НайтиСтрокуЦыфр {
//    Группы сбора
//    Группы сбора представляют способ обращения с несколькими символами как с одной единицей.
// Они создаются путем размещения символов, которые предстоит сгруппировать, в серии круглых скобок.
// К примеру, регулярное выражение (dog) составляет отдельную группу, содержащую буквы "d", "o", и "g".
//
//    Группы сбора нумеруются посредством определения числа открывающих круглых скобок слева направо.
// Так, в выражении ((A)(B(C))) присутствуют четыре подобные группы:
//
//            ((A)(B(C)))
//            (A)
//            (B(C))
//            (C)
//    Для определения числа групп, представленных в выражении, вызвать метод groupCount на объекте
// класса matcher в Java. Метод groupCount извлекает число типа int, отображающее количество групп
// сбора, представленных в сопоставляемом шаблоне.
//
//    Также имеется специальная группа, группа 0, которая во всех случаях представляет выражение в
// полном виде. Данная группа не включается в сумму, представленную методом groupCount.
//
//    Пример
//    Ниже рассмотрен пример регулярного выражения в Java, иллюстрирующий способ выявления строки цифр
// в представленных буквенно-цифровых строках.
//
  public static void main( String args[] ) {
            // Строка для сканирования, чтобы найти шаблон
            String str = "Крещение Руси произошло в 988 году! Не так ли?";
            String pattern = "(.*)(\\d+)(.*)";

            // Создание Pattern объекта
            Pattern r = Pattern.compile(pattern);

            // Создание matcher объекта
            Matcher m = r.matcher(str);
            if (m.find( )) {
                System.out.println("Найдено значение: " + m.group(0));
                System.out.println("Найдено значение: " + m.group(1));
                System.out.println("Найдено значение: " + m.group(2));
            }else {
                System.out.println("НЕ СОВПАДАЕТ");
            }
        }
    }
}
