package io.yope.careers.ethereumj;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.ethereum.facade.Ethereum;
import org.ethereum.facade.EthereumFactory;

import javax.annotation.PostConstruct;

/**
 * Created by enrico.mariotti on 29/01/2016.
 */
@Getter
@AllArgsConstructor
public class EthereumFacade {
    private Ethereum ethereum;
    private EthereumListener ethereumListener;

    @PostConstruct
    public void init() {
        ethereum.addListener(ethereumListener);
    }

}
