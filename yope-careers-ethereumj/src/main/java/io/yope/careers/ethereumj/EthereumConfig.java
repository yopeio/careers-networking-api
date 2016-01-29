package io.yope.careers.ethereumj;

import org.ethereum.facade.Ethereum;
import org.ethereum.facade.EthereumFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by enrico.mariotti on 29/01/2016.
 */
@Configuration
public class EthereumConfig {

    @Bean
    public Ethereum ethereum() {
        return EthereumFactory.createEthereum();
    }

    @Bean
    public EthereumListener ethereumListener(final Ethereum ethereum) {
        return new EthereumListener(ethereum);
    }

    @Bean
    public EthereumFacade ethereumFacade(final Ethereum ethereum, final EthereumListener listener) {
        return new EthereumFacade(ethereum, listener);
    }

    @Bean
    @ConfigurationProperties(prefix = "ethereum")
    public EthereumSettings settings() {
        return new EthereumSettings();
    }


}
