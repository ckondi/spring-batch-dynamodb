package my.batch.workload.springbatchdynamodb.writer;

import my.batch.workload.springbatchdynamodb.entity.UserEntity;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserWriter implements ItemWriter<UserEntity> {

    @Override
    public void write(List<? extends UserEntity> items) throws Exception {

    }
}
