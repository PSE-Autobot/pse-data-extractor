package info.startupbuilder.stocks.pse.data.extractor.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.math.BigInteger;

@Entity
@Table(name = "pse_company")
@Data @AllArgsConstructor @NoArgsConstructor
public class Company {

    @Id
    Integer companyId;

    BigDecimal lastTradePrice;
    BigDecimal totalMarketCapitalization;
    BigDecimal marketCapitilization;
    BigDecimal freeFloatLevel;
    BigDecimal percentWeight;
    Integer securityID;
    String securitySymbol;
    String securityName;
    String lastTradeDate;
    BigInteger outstandingShares;
}
