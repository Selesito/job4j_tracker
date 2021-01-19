package ru.job4j.collection;

import org.junit.Test;
import java.util.Comparator;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.assertThat;

public class JobTest {
    @Test
    public void whenCompatorByNameAndPrority() {
        Comparator<Job> cmpNamePriority = new JobDescByName()
                .thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenCompatorByNameIncr() {
        Comparator<Job> cmpName = new JobIncrByName();
        int rsl = cmpName.compare(
                new Job("Petr", 2),
                new Job("Roman", 1)
        );
        assertThat(rsl, lessThan(1));
    }

    @Test
    public void whenCompatorByNameDesc() {
        Comparator<Job> cmpName = new JobDescByName();
        int rsl = cmpName.compare(
                new Job("Roman", 2),
                new Job("Ivan", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenCompatorByPriority() {
        Comparator<Job> cmpName = new JobDescByPriority();
        int rsl = cmpName.compare(
                new Job("Roman", 2),
                new Job("Ivan", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenCompatorByPriorityIncr() {
        Comparator<Job> cmpName = new JobIncrByPriority();
        int rsl = cmpName.compare(
                new Job("Roman", 1),
                new Job("Ivan", 2)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenCompatorByProrityAndName() {
        Comparator<Job> cmpNamePriority = new JobIncrByName()
                .thenComparing(new JobIncrByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Fix bug", 0),
                new Job("Fix bug", 2)
        );
        assertThat(rsl, lessThan(0));
    }
}