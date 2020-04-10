package info.startupbuilder.stocks.pse.data.extractor;

import info.startupbuilder.stocks.pse.data.extractor.client.PSE;
import info.startupbuilder.stocks.pse.data.extractor.entity.Company;
import info.startupbuilder.stocks.pse.data.extractor.entity.HistoricalData;
import info.startupbuilder.stocks.pse.data.extractor.repository.CompanyRepository;
import info.startupbuilder.stocks.pse.data.extractor.repository.HistoricalDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service @Transactional
public class DataExtractionService {

    private final PSE pse;
    private final CompanyRepository companyRepository;
    private final HistoricalDataRepository historicalDataRepository;

    public void syncCompanyList(String sessionId, String sector) {

        var results = pse.findIndexComposition(sessionId, sector)
                .getRecords();

        var list = results.stream().map(r -> {
            var company = new Company();
            BeanUtils.copyProperties(r, company);
            return company;
        }).collect(Collectors.toList());

        companyRepository.saveAll(list);
    }

    public void syncHistoricalData(String sessionId, String symbol) {

        Company toSync = companyRepository.findBySecuritySymbol(symbol)
                .orElseThrow();

        var historicalData = pse.findHistoricalData(sessionId, toSync.getSecurityID())
                .getRecords();

        var list = historicalData.stream().map(r -> {
            var h = new HistoricalData();
            BeanUtils.copyProperties(r,h);
            h.setCompany(toSync);
            h.setId(toSync.getCompanyId() + "_" + r.getTradingDate());
            return h;
        }).collect(Collectors.toList());

        historicalDataRepository.saveAll(list);
    }
}
