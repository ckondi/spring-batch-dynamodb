package my.batch.workload.springbatchdynamodb.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
@Builder
public class UserEntity implements Serializable {

    private Long id;
    private String email;
    private String firstName;
    private String lastName;
    private String fullName;

}
