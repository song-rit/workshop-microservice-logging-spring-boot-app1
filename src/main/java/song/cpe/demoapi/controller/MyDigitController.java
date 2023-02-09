package song.cpe.demoapi.controller;

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

    @GetMapping(value = "/isOddNumber/{digit}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResultResponse> isOddNumber(
            @PathVariable Integer digit
    ) {

        logger.info("digit: {}", digit);
        ResultResponse response = new ResultResponse();
        response.result = true;
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



