package Guava;

import com.google.common.base.Objects;
import org.apache.commons.lang3.BooleanUtils;

/**
 * Created by pm on 4/17/16.
 */
public class UtilsTests {
    public static void main(String[] args) {
        Boolean b = true;
        System.out.println(BooleanUtils.isTrue(b));
        System.out.println(Boolean.TRUE.equals(b));
        System.out.println(Objects.equal(true, b));
    }
}
