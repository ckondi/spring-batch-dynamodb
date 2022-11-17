package my.batch.workload.springbatchdynamodb.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
@Builder
public class User implements Serializable {

    private String email;
    private Long id;
    private String firstName;
    private String lastName;
}
