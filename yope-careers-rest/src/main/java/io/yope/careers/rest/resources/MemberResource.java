package io.yope.careers.rest.resources;

import io.yope.careers.domain.Member;
import io.yope.careers.domain.Query;
import io.yope.careers.services.CareerFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.Collection;

/**
 * Created by enrico.mariotti on 29/01/2016.
 */
@RequestMapping("/careers")
//@PreAuthorize("hasAuthority('ROLE_DOMAIN_USER')")
@RestController
public class MemberResource {

    @Autowired
    CareerFacade facade;

    @RequestMapping(method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public @ResponseBody
    CareerResponse<Member> create(final HttpServletResponse response,
                                  @RequestBody(required = true) final Member member) {
        Member saved = facade.write(member);
        return new CareerResponse(saved, null);
    }

    @RequestMapping(value = "/{memberHash}", method = RequestMethod.GET, consumes = "application/json", produces = "application/json")
    public @ResponseBody CareerResponse<Member> getBySenderHash(
            @PathVariable(value = "memberHash") final String memberHash) {
        final Member found = facade.findByHash(memberHash);
        return new CareerResponse(found, null);
    }

    @RequestMapping(method = RequestMethod.GET, consumes = "application/json", produces = "application/json", params = {"senderHash" })
    public @ResponseBody CareerResponse<Member> search(
            @RequestParam(value = "query", required = true) final String query) {
        final Collection<Member> members = facade.search(Query.builder().query(query).build());
        return new CareerResponse(null, members);
    }


}
