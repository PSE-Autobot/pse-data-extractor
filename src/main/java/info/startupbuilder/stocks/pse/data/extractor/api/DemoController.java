package info.startupbuilder.stocks.pse.data.extractor.api;

import info.startupbuilder.stocks.pse.data.extractor.client.PSE;
import lombok.RequiredArgsConstructor;
import org.springframework.data.rest.webmvc.BasePathAwareController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@RequiredArgsConstructor
@BasePathAwareController
public class DemoController {

    private final PSE pse;

    @GetMapping(path = "test")
    public @ResponseBody String index(@RequestParam("sessionId") String sessionId) {

        String response;

        try {
            response = pse.index("JSESSIONID=" + sessionId + "; cookieconsent_status=dismiss", "ALL");
        } catch (Exception e) {
            response = e.getMessage();
        }

        return response;
    }
}
