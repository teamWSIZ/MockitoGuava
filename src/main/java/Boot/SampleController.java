package Boot;

/**
 * Created by mareckip on 19.04.16.
 */
import ExceptionHandling.MyException;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;

@Data
@AllArgsConstructor
class SomeData {
    int x,y;
}

@Controller
@EnableAutoConfiguration
@ImportResource("conf.xml")
public class SampleController {

    @RequestMapping("/")
    @ResponseBody
    SomeData home(@RequestParam(name = "a", defaultValue = "12") Integer y) throws Exception {
        if (y.equals(11)) {
            throw new MyException("mea-culpa");
        }
        if (y.equals(10)) {
            throw new FileNotFoundException("No hackable file found");
        }
        return new SomeData(2, y);
    }

    @RequestMapping("/alpha")
    @ResponseBody
    String error() {
        return "Bad request";
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(SampleController.class, args);
    }
}
