package io.yope.careers.ethereumj;

import lombok.extern.slf4j.Slf4j;
import org.ethereum.facade.Ethereum;
import org.ethereum.listener.EthereumListenerAdapter;

/**
 * Created by enrico.mariotti on 20/01/2016.
 */
@Slf4j
public class EthereumListener extends EthereumListenerAdapter {

    private Ethereum ethereum;

    public EthereumListener(Ethereum ethereum) {
        this.ethereum = ethereum;
    }

    @Override
    public void onSyncDone() {
        log.info("**** Yope Listener **** sync done!");
    }

}
