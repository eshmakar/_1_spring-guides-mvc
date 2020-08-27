package ru.eshmakar._1_springguidesmvc.repos;

import org.springframework.data.repository.CrudRepository;
import ru.eshmakar._1_springguidesmvc.domain.Message;

import java.util.List;


//этот интерфейс позволяет получить полный список полей, либо найти их по идентификатору
//также этот интерфейс используется, чтобы сохранять записи пользователя
public interface MessageRepo extends CrudRepository<Message, Long> {
    //CrudRepository - дает возможность вызывать такие методы, без необходимости реализовывать их имплементацию: save, findOne, findAll, exists, count, delete, deleteAll
    List<Message> findByTag(String tag);
}
