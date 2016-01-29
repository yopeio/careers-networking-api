package io.yope.careers.interfaces;

import io.yope.careers.domain.Member;
import io.yope.careers.domain.Query;

import java.util.Collection;

/**
 * Created by enrico.mariotti on 29/01/2016.
 */
public interface CareerSearchEngine {

    /**
     * Search for non-sensitive data.
     * @param query
     * @return
     */
    Collection<Member> search(Query query);

    /**
     * Index non-sensitive data.
     * @param member
     */
    void index(Member member);
}
