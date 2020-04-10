package info.startupbuilder.stocks.pse.data.extractor;

import info.startupbuilder.stocks.pse.data.extractor.client.PSE;
import info.startupbuilder.stocks.pse.data.extractor.entity.Company;
import info.startupbuilder.stocks.pse.data.extractor.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class CompanyService {

    private final PSE pse;
    private final CompanyRepository companyRepository;

    @Transactional
    public PSE.StockResult findIndexComposition(String sessionId,String sector) {

        var results = pse.findIndexComposition(sessionId, sector);

        results.getRecords().forEach(r -> {
            var company = new Company();
            BeanUtils.copyProperties(r, company);
            companyRepository.save(company);
        });

        return results;
    }
}
