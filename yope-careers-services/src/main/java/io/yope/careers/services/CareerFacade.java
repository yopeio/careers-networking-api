package io.yope.careers.services;

import io.yope.careers.domain.Member;
import io.yope.careers.domain.Query;
import io.yope.careers.interfaces.CareerBlockchain;
import io.yope.careers.interfaces.CareerSearchEngine;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Created by enrico.mariotti on 29/01/2016.
 */
@Service
public class CareerFacade {

//    @Autowired
    private CareerBlockchain careerBlockchain;

//    @Autowired
    private CareerSearchEngine searchEngine;

    public Member write(final Member member) {
        searchEngine.index(member);
        return careerBlockchain.write(member);
    }

    public Collection<Member> search(Query query) {
        return searchEngine.search(query);
    }

    public Member findByHash(String hash) {
        return careerBlockchain.findByHash(hash);
    }


}
