package info.startupbuilder.stocks.pse.data.extractor.repository;

import info.startupbuilder.stocks.pse.data.extractor.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CompanyRepository extends JpaRepository<Company, Integer> {

    Optional<Company> findBySecuritySymbol(String symbol);
}
