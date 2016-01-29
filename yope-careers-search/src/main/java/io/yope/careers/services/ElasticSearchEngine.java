package io.yope.careers.services;

import com.google.common.collect.Lists;
import io.yope.careers.domain.Member;
import io.yope.careers.domain.Query;
import io.yope.careers.interfaces.CareerSearchEngine;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Created by enrico.mariotti on 29/01/2016.
 */
@Service
public class ElasticSearchEngine implements CareerSearchEngine {

    @Override
    public Collection<Member> search(Query query) {
        return Lists.newArrayList();
    }

    @Override
    public void index(final Member member) {

    }
}
