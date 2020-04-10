package info.startupbuilder.stocks.pse.data.extractor.api;

import info.startupbuilder.stocks.pse.data.extractor.client.PSE;
import lombok.RequiredArgsConstructor;
import org.springframework.data.rest.webmvc.BasePathAwareController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequiredArgsConstructor
@BasePathAwareController
public class DemoController {

    private final PSE pse;

    @GetMapping("demo")
    public @ResponseBody String index() {
        var sessionId = """
            af1094d0c8cc1c6108e5833a93c7a84e7d32e2253784e8834777651c4787658d.e38NbNeRbx0Pa40Lc3mMa3qQah4Ke0
        """.trim();

        String response;

        try {
            response = pse.index("JSESSIONID=" + sessionId + "; cookieconsent_status=dismiss", "ALL");
        } catch (Exception e) {
            response = e.getMessage();
        }

        return response;
    }
}
