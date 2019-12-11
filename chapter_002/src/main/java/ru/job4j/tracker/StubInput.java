package ru.job4j.tracker;

/**
 * Класс-заглушка реализующий интерфейс Input и предназначеный
 * для тестирования пользовательского консольного ввода данных.
 *
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @since 03.12.2019
 */
public class StubInput implements Input {
    private String[] answers;
    private int position = 0;

    /**
     * Конструктор эмулирует ввод данных пользователем
     * @param answers входящие денные
     */
    public StubInput(String[] answers) {
        this.answers = answers;
    }

    @Override
    public String askStr(String question) {
        System.out.print(question);
        return answers[position++];
    }

    @Override
    public int askInt(String question) {
        return Integer.parseInt(askStr(question));
    }
}