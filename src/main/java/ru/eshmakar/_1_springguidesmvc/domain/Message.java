package ru.eshmakar._1_springguidesmvc.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity //сообщает спрингу, что это не кусок кода, а сущность, который необходимо сохранять в базу данных
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) //сообщаем, чтобы автоматический генерировался новый id в базе данных
    private Integer id; // вот этот id будет идентификатором

    private String text;
    private String tag;

    public Message(){} //если есть аннотация @Entity, то всегда должен быть пустой конструктор. Так как иначе спринг не сможет создать данный класс

    public Message(String text, String tag) {
        this.text = text;
        this.tag = tag;
    }

    //ЕСЛИ НЕ БУДЕТ РАБОТАТЬ, ВОЗМОЖНО ПОМОЖЕТ ПОМЕНЯТЬ МЕСТАМИ ГЕТТЕРЫ И СЕТТЕРЫ
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
