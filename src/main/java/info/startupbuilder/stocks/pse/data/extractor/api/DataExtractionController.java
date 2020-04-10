package info.startupbuilder.stocks.pse.data.extractor.api;

import info.startupbuilder.stocks.pse.data.extractor.DataExtractionService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.rest.webmvc.BasePathAwareController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequiredArgsConstructor
@BasePathAwareController
public class DataExtractionController {

    private final DataExtractionService dataExtractionService;

    /**
     * extracts the components of a certain sector
     *
     * @param sessionId the session id as extracted from the PSE home page
     */
    @PostMapping(path = "syncCompany")
    public ResponseEntity<String> syncCompany(
            @RequestParam("sessionId") String sessionId,
            @RequestParam("sector") String sector) {

        dataExtractionService.syncCompanyList(sessionId, sector);
        return ResponseEntity.ok("OK");
    }

    /**
     * extracts the historical price data of a certain company
     *
     * @param sessionId the session id as extracted from the PSE home page
     * @param symbol the ticker symbol
     */
    @PostMapping(path = "syncHistoricalData")
    public ResponseEntity<String> syncHistoricalData(
            @RequestParam("sessionId") String sessionId,
            @RequestParam("symbol") String symbol) {

        dataExtractionService.syncHistoricalData(sessionId, symbol);

        return ResponseEntity.ok("OK");
    }
}
