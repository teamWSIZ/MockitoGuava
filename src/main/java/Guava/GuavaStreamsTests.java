package Guava;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Created by mareckip on 14.04.16.
 */
public class GuavaStreamsTests {
    public static void main(String[] args) {
        Set<String> s = Sets.newConcurrentHashSet();
        s.add("alpha");
        s.add("beta");
        s.stream().forEach(d -> {
            System.out.println(d);
        });

        List<Integer> l = Lists.reverse(Lists.newArrayList(1, 2, 3));
        l.stream().map(x->x*x).forEach(d-> System.out.println(d));
        List<Integer> w = l.stream().collect(Collectors.toList());
        System.out.println(w);

    }
}
