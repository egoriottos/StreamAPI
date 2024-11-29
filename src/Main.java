import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //1 фильтрация сотрудников по зарплате
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", 60000, "IT"),
                new Employee("Bob", 40000, "HR"),
                new Employee("Charlie", 55000, "IT")
        );
        employees.stream()
                .filter(e -> e.getSalary() > 50000)
                .map(Employee::getName)
                .forEach(System.out::println);

        //2 Поиск минимального значения
        List<Integer> numbers = Arrays.asList(10, -5, 2, 15, 0, -8, 7);
        numbers.stream()
                .min(Integer::compareTo)
                .ifPresent(System.out::println);

        //3 суммирование чисел
        List<Integer> numbersForSum = Arrays.asList(3, 6, 8, 12, 5, 21, 9);
        int i = numbersForSum.stream()
                .filter(n -> n % 3 == 0)
                .reduce(0, Integer::sum);
        System.out.println(i);

        //4 группировка по первой букве имени
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "Anna", "Brian");
        Map<Character, List<String>> namesToMap = names.stream()
                .collect(Collectors.groupingBy(name -> name.charAt(0)));
        namesToMap.forEach((k, v) -> System.out.println(k + "," + v + ";"));

        //5 Уникальные слова. Разбить текст на слова, удалить знаки препинания,
        // перевести в нижний регистр и вывести уникальные слова, отсортированные по алфавиту.
        String text = "Java is great! Stream API is powerful. Java is also versatile.";
        Arrays.stream(text.toLowerCase().split("\\W+"))
                .distinct()
                .sorted()
                .forEach(System.out::println);

        //6 Объединение коллекций
        //Объединить оба списка, удалить дубликаты и отсортировать строки по длине.
        List<String> list1 = Arrays.asList("apple", "banana", "cherry");
        List<String> list2 = Arrays.asList("banana", "date", "fig", "apple");
        Stream.of(list1, list2)
                .flatMap(Collection::stream)
                .distinct()
                .sorted(Comparator.comparingInt(String::length))
                .forEach(System.out::println);

        //7 Проверка на соответствие условиям
        //Проверить:Все ли числа четные.Есть ли хотя бы одно число больше 100.Нет ли отрицательных чисел.
        List<Integer> numbers7 = Arrays.asList(2, 4, 6, 8, 10);
        boolean hasInvalid = numbers7.stream().anyMatch(e -> e < 0 || e > 100);
        if (hasInvalid) {
            System.out.println("екорректные числа");
        }
        boolean hasOddNumbers = numbers7.stream().noneMatch(e -> e % 2 != 0);
        if (hasOddNumbers) {
            System.out.println("есть нечетные числа");
        }
        numbers7.stream()
                .filter(e -> e >= 0 && e < 100 && e % 2 == 0)
                .forEach(System.out::println);

        //8 Сортировка объектов
        List<Book> books = Arrays.asList(
                new Book("Java Programming", 450),
                new Book("Effective Java", 550),
                new Book("Clean Code", 300),
                new Book("Java for Beginners", 450)
        );
        books.stream()
                .sorted(Comparator.comparingInt(Book::getPrice).thenComparing(Book::getTitle))
                .forEach(System.out::println);

        //9 Обратный порядок строк Перевернуть каждую строку.
        List<String> words = Arrays.asList("stream", "java", "lambda", "api");
        words.stream()
                .map(e -> new StringBuilder(e).reverse().toString())
                .forEach(System.out::println);

        //10 Статистика по числам, Использовать IntStream для получения статистики:
        // сумма, среднее, максимум, минимум и количество
        List<Integer> numbers10 = Arrays.asList(15, 30, 45, 60, 75);
        IntStream intStream = numbers10.stream()
                .mapToInt(Integer::intValue);
        IntSummaryStatistics stats = intStream.summaryStatistics();
        System.out.println("Сумма: " + stats.getSum());
        System.out.println("Среднее: " + stats.getAverage());
        System.out.println("Максимум: " + stats.getMax());
        System.out.println("Минимум: " + stats.getMin());
        System.out.println("Количество: " + stats.getCount());

        //11 отфильтровать четные числа, Задача: Отфильтровать все четные числа и вывести их.
        List<Integer> numbers11 = Arrays.asList(10, 15, 20, 25, 30);
        numbers11.stream()
                .filter(e -> e % 2 == 0)
                .forEach(System.out::println);

        //12 Преобразовать строк в верхний регистр, Задача: Преобразовать каждую строку в верхний регистр и вывести результат.
        List<String> words12 = Arrays.asList("java", "stream", "lambda", "api");
        words12.stream()
                .map(String::toUpperCase)
                .forEach(System.out::println);

        //13 Проверка на наличие отрицательных чисел, Задача: Проверить, есть ли хотя бы одно отрицательное число в списке.
        List<Integer> numbers13 = Arrays.asList(15, 30, -45, 60, 75);
        numbers13.stream()
                .filter(e -> e > 0)
                .forEach(System.out::println);

        //14 Перевернуть список
        List<String> words14 = Arrays.asList("java", "stream", "lambda", "api");
        words14.stream().collect(Collectors.collectingAndThen(Collectors.toList(),list->{
            Collections.reverse(list);
            return list;
        }))
                .forEach(System.out::println);

        //15 Преобразование строк в длину
        List<String> words15 = Arrays.asList("java", "stream", "lambda", "api");
        words15.stream()
                .map(String::length)
                .forEach(System.out::println);

        //16 Выбор минимального числа
        List<Integer> numbers16 = Arrays.asList(15, 30, 45, 60, 75);
        numbers16.stream()
                .min(Integer::compareTo)
                .ifPresent(System.out::println);

        //17  Отфильтровать строки, где длина больше 5, и вернуть их в виде списка, добавив суффикс "-long"
        List<String> words17 = Arrays.asList("stream", "lambda", "java", "api", "function");
        words17.stream()
                .filter(e-> e.length() > 5)
                .map(e -> e + "-long")
                .forEach(System.out::println);

        //18 Использовать стрим для фильтрации четных чисел, которые больше 10, и найти их сумму
        List<Integer> numbers18 = Arrays.asList(5, 12, 19, 8, 14, 23);
        numbers18.stream()
                .filter(e-> e > 10 && e % 2 ==0)
                .reduce((integer, integer2) -> {
                    return integer + integer2;
                })
                .ifPresent(System.out::println);

        //19 Использовать стрим, чтобы проверить, есть ли строки, где первые две буквы одинаковы (например, "aad" или "aapple")
        List<String> words19 = Arrays.asList("apple", "banana", "add", "book", "anchor", "rrock");
        boolean booleans = words19.stream()
                .anyMatch(word-> word.length() > 1 && word.charAt(0)==word.charAt(1));
        System.out.println(booleans);

        //20 Сортировать строки так, чтобы:
        //Если длина строки меньше 4, то возвращать строку с удвоением длины (например, "cat" → "catcat").
        //Иначе возвращать строку без изменений.
        List<String> strings20 = Arrays.asList("cat", "elephant", "dog", "tiger");
        strings20.stream()
                .map(word-> word.length() < 4? word + word : word)
                .forEach(System.out::println);

    }
}