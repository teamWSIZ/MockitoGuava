package AlphaMock;

import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.HashSet;
import java.util.Set;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.anyVararg;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AATest {

//    @InjectMocks
    @Mock
    private AA testee;

    @Mock
    private Srv srv;

    private Dep dep;

    Set<Integer> ss = new HashSet<>();

    @Before
    public void setUp() {
        dep = new Dep(1, 1);
        when(testee.inc(any(Dep.class))).thenReturn(dep);
//        when(testee.inc(anyInt())).thenReturn(12);
        doAnswer(i -> {
            ss.add(((int) i.getArguments()[0]));
            return 0;
        }).when(testee).inc(anyInt());

        doAnswer(i->{
            System.out.println("Vararg called");
            return 0;
        }).when(testee).doo(anyString(), anyVararg());


    }

    @Test
    public void alphaTest() {
        Dep ddd = new Dep(5, 5);
        System.out.println(testee.inc(ddd));
    }


    @Test
    public void getaTest() {
        testee.inc(1);
        testee.inc(2);
        System.out.println(ss);
    }

    @Test
    public void variadicsTest() {
        new AA().doo("",1,4,3,2);
        testee.doo("",1,2,3,4);
    }

}
