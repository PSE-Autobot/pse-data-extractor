package info.startupbuilder.stocks.pse.data.extractor;

import feign.Contract;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@EnableFeignClients("info.startupbuilder.stocks.pse.data.extractor.client")
@SpringBootApplication
public class PseDataExtractorApplication {

	public static void main(String[] args) {
		SpringApplication.run(PseDataExtractorApplication.class, args);
	}

	/**
	 * for reference:
	 * https://github.com/OpenFeign/feign
	 *
	 * @return a better contract
	 */
	@Bean
	public Contract useFeignAnnotations() {
		return new Contract.Default();
	}
}
