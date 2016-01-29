package io.yope.careers.interfaces;

import io.yope.careers.domain.Member;

/**
 * Created by enrico.mariotti on 28/01/2016.
 */
public interface CareerBlockchain {
    Member write(Member member);

    Member findByHash(String hash);
}
