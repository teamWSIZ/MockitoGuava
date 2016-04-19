package MVC;


import Api.Version;
import Core.MyClass;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * Wersjonowanie za pomocą headerów, 16:34
 *
 * Używają GroovyDsl
 *   request {
 *      method 'POST'
 *      url '/ingredients'
 *      headers {
 *          header  'Content-Type': 'application/vnd.pl.devoxx.org....'
 *      }
 *   }
 *
 *   http://stackoverflow.com/questions/30923249/spring-4-requestmapping-consumes-vs-headers
 */


@RestController
@RequestMapping(value = "/ingredients",
        consumes = Version.AGGREGATOR_V1,
        produces = MediaType.APPLICATION_JSON_VALUE
)
public class IngredientsController {
    public MyClass produceMyclass(@RequestBody MyClass order) {

        return new MyClass();
    }
}
