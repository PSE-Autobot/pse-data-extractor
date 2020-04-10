package info.startupbuilder.stocks.pse.data.extractor.client;

import feign.Body;
import feign.Headers;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;

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
        "Accept-Language: en-US,en;q=0.9,fil;q=0.8",
        "Content-Type: text/plain"
})
@FeignClient(name = "pse", url = "https://www.pse.com.ph")
public interface PSE {

    @Headers("Cookie: {cookie}")
    @RequestLine("POST stockMarket/marketInfo-marketActivity-indicesComposition.html?method=getCompositionIndices&ajax=true")
    @Body("sector={sector}")
    String index(@Param("cookie") String cookie, @Param("sector") String sector);

}
