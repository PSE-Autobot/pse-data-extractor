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

    /**
     * curl --location
     * --request GET 'http://localhost:8080/api/test?sessionId=xxxjSessionIdxxx'
     *
     * @param sessionId the session id as extracted from the PSE home page
     * @return the result
     */
    @GetMapping(path = "test")
    public @ResponseBody PSE.Result index(@RequestParam("sessionId") String sessionId) {
        return pse.index("JSESSIONID=" + sessionId + "; cookieconsent_status=dismiss", "ALL");
    }
}
