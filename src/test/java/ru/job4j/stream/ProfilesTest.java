package ru.job4j.stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ProfilesTest {

    @Test
    public void whenGetAddresses() {
        List<Address> adresses = Arrays.asList(
                new Address("Volgograd", "Lenina", 4, 7),
                new Address("Astrakhan", "Admirala", 43, 2),
                new Address("Rostov", "Petra", 88, 13),
                new Address("Astrakhan", "Admirala", 43, 2),
                new Address("Rostov", "Petra", 88, 13)
        );
        List<Profile> list = Arrays.asList(
                new Profile(adresses.get(0)),
                new Profile(adresses.get(1)),
                new Profile(adresses.get(2)),
                new Profile(adresses.get(3)),
                new Profile(adresses.get(4))
        );
        assertThat(
                Profiles.collect(list),
                is(adresses)
        );
    }

    @Test
    public void whenGetAddressDuplicat() {
        List<Address> adresses = Arrays.asList(
                new Address("Volgograd", "Lenina", 4, 7),
                new Address("Astrakhan", "Admirala", 43, 2),
                new Address("Rostov", "Petra", 88, 13),
                new Address("Astrakhan", "Admirala", 43, 2),
                new Address("Rostov", "Petra", 88, 13)
        );
        List<Profile> list = Arrays.asList(
                new Profile(adresses.get(0)),
                new Profile(adresses.get(1)),
                new Profile(adresses.get(2)),
                new Profile(adresses.get(3)),
                new Profile(adresses.get(4))
        );
        assertThat(
                Profiles.collectSorted(list),
                is(
                        Arrays.asList(
                                adresses.get(1),
                                adresses.get(2),
                                adresses.get(0)
                        )
                )
        );
    }
}