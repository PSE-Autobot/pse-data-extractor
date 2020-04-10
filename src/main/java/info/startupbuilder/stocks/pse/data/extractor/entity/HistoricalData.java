package info.startupbuilder.stocks.pse.data.extractor.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.math.BigInteger;

@Entity
@Table(name = "pse_historical_data")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HistoricalData {

    @Id
    String id;

    @ManyToOne
    Company company;

    BigDecimal sqLow;
    BigDecimal sqHigh;
    BigDecimal sqOpen;
    BigDecimal sqClose;
    BigDecimal lastTradePrice;
    BigDecimal sqPrevious;
    BigDecimal avgPrice;
    BigDecimal changeClose;
    BigDecimal totalValue;
    BigInteger totalVolume;
    String secQid;
    String tradingDate;
}
