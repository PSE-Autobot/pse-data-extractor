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
     * extracts the components of a certain sector
     *
     * @param sessionId the session id as extracted from the PSE home page
     * @return the result
     */
    @GetMapping(path = "findIndexComposition")
    public @ResponseBody PSE.StockResult findIndexComposition(
            @RequestParam("sessionId") String sessionId,
            @RequestParam("sector") String sector) {
        return pse.findIndexComposition(sessionId, sector);
    }
}
