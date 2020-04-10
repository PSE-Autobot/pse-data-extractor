package info.startupbuilder.stocks.pse.data.extractor.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import feign.FeignException;
import feign.Response;
import feign.codec.Decoder;
import lombok.RequiredArgsConstructor;
import org.apache.commons.io.IOUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.lang.reflect.Type;

@Configuration
public class PSEConfig {

    @RequiredArgsConstructor
    static class PSEDecoder implements Decoder {

        private final ObjectMapper mapper;

        @Override
        public Object decode(Response response, Type type) throws IOException, FeignException {
            String decoded = IOUtils.toString(response.body().asInputStream());
            return mapper.readValue(decoded, (Class<?>) type);
        }
    }

    @Bean
    public Decoder feignDecoder() {
        return new PSEDecoder(new ObjectMapper());
    }
}
