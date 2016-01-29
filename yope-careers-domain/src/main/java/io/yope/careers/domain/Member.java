package io.yope.careers.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.List;

/**
 * Created by enrico.mariotti on 28/01/2016.
 */
@Builder(builderClassName="Builder", toBuilder=true)
@Getter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@ToString(includeFieldNames = false)
public class Member {
    private List<Education> educations;
    private String name;
    private String surname;
    private int birthDate;
    private String hash;
}
