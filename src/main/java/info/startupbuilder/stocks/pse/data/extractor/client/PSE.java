package info.startupbuilder.stocks.pse.data.extractor.client;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import feign.Body;
import feign.Headers;
import feign.Param;
import feign.RequestLine;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.cloud.openfeign.FeignClient;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

@Headers({
        "Connection: keep-alive",
        "Sec-Fetch-Dest: empty",
        "X-Requested-With: XMLHttpRequest",
        "User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/80.0.3987.132 Safari/537.36",
        "Content-Type: application/x-www-form-urlencoded; charset=UTF-8",
        "Accept: */*",
        "Origin: https://www.pse.com.ph",
        "Sec-Fetch-Site: same-origin",
        "Sec-Fetch-Mode: cors",
        "Referer: https://www.pse.com.ph/stockMarket/marketInfo-marketActivity.html?tab=0",
        "Accept-Language: en-US,en;q=0.9,fil;q=0.8"
})
@FeignClient(name = "pse", url = "https://www.pse.com.ph", configuration = PSEConfig.class)
public interface PSE {

    @JsonIgnoreProperties(ignoreUnknown = true)
    @Data @AllArgsConstructor @NoArgsConstructor
    class Stock {
        BigDecimal lastTradePrice;
        BigDecimal totalMarketCapitalization;
        BigDecimal marketCapitilization;
        BigDecimal freeFloatLevel;
        BigDecimal percentWeight;
        Integer securityID;
        Integer companyId;
        String securitySymbol;
        String securityName;
        String lastTradeDate;
        BigInteger outstandingShares;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    @Data @AllArgsConstructor @NoArgsConstructor
    class StockResult {
        Integer count;
        List<Stock> records;
    }

    @Headers("Cookie: JSESSIONID={sessionId}; cookieconsent_status=dismiss")
    @RequestLine("POST /stockMarket/marketInfo-marketActivity-indicesComposition.html?method=getCompositionIndices&ajax=true")
    @Body("sector={sector}")
    StockResult findIndexComposition(@Param("sessionId") String sessionId, @Param("sector") String sector);

}
