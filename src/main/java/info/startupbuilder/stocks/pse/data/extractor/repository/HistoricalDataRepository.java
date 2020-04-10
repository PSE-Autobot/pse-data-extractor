package info.startupbuilder.stocks.pse.data.extractor.repository;

import info.startupbuilder.stocks.pse.data.extractor.entity.HistoricalData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoricalDataRepository extends JpaRepository<HistoricalData, String> {
}
