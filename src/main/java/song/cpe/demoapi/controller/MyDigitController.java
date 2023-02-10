package song.cpe.demoapi.controller;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/digit")
public class MyDigitController {

    private Logger logger = LoggerFactory.getLogger(MyDigitController.class.getName());

    Counter requestCount;
    Counter evenNumberCount;
    Counter oddNumberCount;

    public MyDigitController(MeterRegistry registry) {
        requestCount = Counter.builder("request_counter")
                .description("Number of request")
                .register(registry);

        evenNumberCount = Counter.builder("even_number_counter")
                .description("even number of request")
                .register(registry);

        oddNumberCount = Counter.builder("odd_number_counter")
                .description("Odd number of request")
                .register(registry);

        oddNumberCount = Counter.builder("odd_number_counter")
                .description("Odd number of request")
                .register(registry);
    }

    @GetMapping(value = "/isEvenNumber/{digit}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResultResponse> isEvenNumber(
            @PathVariable Integer digit
    ) {
        requestCount.increment();

        logger.info("digit: {}", digit);

        ResultResponse response = new ResultResponse();

        if(digit % 2 == 0) {
            evenNumberCount.increment();
            logger.info("number is even number: {}", digit);
            response.result = true;
        } else {
            oddNumberCount.increment();
            logger.info("number is odd number: {}", digit);
            response.result = false;
        }

        return ResponseEntity.ok(response);
    }

    class ResultResponse {

        boolean result;

        public boolean isResult() {
            return result;
        }

        public void setResult(boolean result) {
            this.result = result;
        }
    }
}



