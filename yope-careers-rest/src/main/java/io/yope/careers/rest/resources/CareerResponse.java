package io.yope.careers.rest.resources;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.deser.std.CollectionDeserializer;
import io.yope.careers.domain.Member;
import lombok.*;
import lombok.experimental.Accessors;

import java.util.Collection;

/**
 * Created by enrico.mariotti on 29/01/2016.
 */
@Accessors(fluent=true)
@JsonSerialize
@JsonInclude(JsonInclude.Include.NON_NULL)
@AllArgsConstructor
public class CareerResponse<T> {
    @JsonProperty private Member member;

    @JsonProperty private Collection<Member> members;
}
