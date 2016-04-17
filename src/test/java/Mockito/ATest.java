package Mockito;

import org.junit.Before;
import org.junit.Test;


import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ATest {
    private A a;
    private Repo mockRepo;

    @Before
    public void setUp() throws Exception {
        a = new A();
        mockRepo = mock(Repo.class);
        when(mockRepo.getNumbers()).thenReturn(Arrays.asList(1, 2, 3, 4));

    }

    @Test
    public void testAPlusB() throws Exception {
        assertThat(a.aPlusB(2,3));
    }

    @Test
    public void testMock() {
        assertThat(mockRepo.getNumbers().size()).isEqualTo(4);
        System.out.println(mockRepo.getNumbers());
    }

}