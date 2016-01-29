package io.yope.careers.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

/**
 * Created by enrico.mariotti on 29/01/2016.
 */
@Builder(builderClassName="Builder", toBuilder=true)
@Getter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@ToString(includeFieldNames = false)
public class Query {
    String query;
}
