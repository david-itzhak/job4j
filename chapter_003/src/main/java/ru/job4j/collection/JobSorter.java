package ru.job4j.collection;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Класс сортировки обобщённых данных типа Job.
 * Сортируем данные через компаратор, по полям name, priority.
 * Комбинированные сортировки по возрастанию и по убыванию.
 *
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @since 18.05.2020
 */
public class JobSorter {
    public static void main(String[] args) {
        List<Job> jobs = Arrays.asList(
                new Job("Impl task", 1),
                new Job("Fix bug", 0)
        );

        jobs.sort(new JobAscByName().thenComparing(new JobAscByPriority()));
        System.out.println("name-priority: " + jobs);
        jobs.sort(new JobAscByPriority().thenComparing(new JobDescByName()));
        System.out.println("priority-name: " + jobs);

        Comparator<Job> compareName = Comparator.comparing(Job::getName);
        Comparator<Job> comparePriority = Comparator.comparing(Job::getPriority);
        Comparator<Job> combine = compareName.thenComparing(comparePriority);
        jobs.sort(combine);
    }
}
