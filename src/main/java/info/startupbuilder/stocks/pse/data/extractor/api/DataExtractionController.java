package info.startupbuilder.stocks.pse.data.extractor.api;

import info.startupbuilder.stocks.pse.data.extractor.DataExtractionService;
import info.startupbuilder.stocks.pse.data.extractor.client.PSE;
import lombok.RequiredArgsConstructor;
import org.springframework.data.rest.webmvc.BasePathAwareController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@RequiredArgsConstructor
@BasePathAwareController
public class DataExtractionController {

    private final DataExtractionService dataExtractionService;

    /**
     * extracts the components of a certain sector
     *
     * @param sessionId the session id as extracted from the PSE home page
     * @return the result
     */
    @GetMapping(path = "syncCompany")
    public @ResponseBody PSE.StockResult syncCompany(
            @RequestParam("sessionId") String sessionId,
            @RequestParam("sector") String sector) {

        return dataExtractionService.syncCompanyList(sessionId, sector);
    }
}
