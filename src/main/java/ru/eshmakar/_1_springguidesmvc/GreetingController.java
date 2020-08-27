package ru.eshmakar._1_springguidesmvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.eshmakar._1_springguidesmvc.domain.Message;
import ru.eshmakar._1_springguidesmvc.repos.MessageRepo;

import java.util.Map;

@Controller
public class GreetingController {
    @Autowired //используется, чтобы автоматически получить бины от репозитории юзера
    private MessageRepo messageRepo;


    //this Controller work with mustache
    @GetMapping("greeting")
    public String greeting(@RequestParam(name = "name", required = false, defaultValue = "World") String name,
                           Map<String, Object> model){

        model.put("name", name);
        return "greeting";
    }


    @GetMapping
    public String main(Map<String, Object> model){ //здесь уже необходимо сделать список, без этого не работает
        Iterable<Message> messages = messageRepo.findAll();
        model.put("messages", messages); //put - это синоним add.atribute (thymeleaf)
        return "main";
    }
    @PostMapping
    public String add(@RequestParam String text, @RequestParam String tag, Map<String, Object> model){
        Message message = new Message(text, tag);
        messageRepo.save(message);

        Iterable<Message> messages = messageRepo.findAll();
        model.put("messages", message);

        return "main";
    }

    @PostMapping("filter")
    public String filter(@RequestParam String filter, Map<String, Object> model){
        Iterable<Message> messages;
        if (filter != null && !filter.isEmpty())
            messages = messageRepo.findByTag(filter);
        else
            messages = messageRepo.findAll();


        model.put("messages", messages);
        return "main";
    }
}
