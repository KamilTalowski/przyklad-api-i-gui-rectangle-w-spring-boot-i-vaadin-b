package com.talowski.przykladapiiguirectanglewspringcootivaadinbyku;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
public class RectangleReader {

    private RectangleRepo rectangleRepo;

    @Autowired
    public RectangleReader(RectangleRepo rectangleRepo) {
        this.rectangleRepo = rectangleRepo;
    }

    @Value("${siteA1}")
    private int siteA1=1;
    @Value("${siteB1}")
    private int siteB1=2;

    @Value("${siteA2}")
    private int siteA2=3;
    @Value("${siteB2}")
    private int siteB2=4;

    @Value("${siteA3}")
    private int siteA3=4;
    @Value("${siteB3}")
    private int siteB3=5;

    @Value("${siteA4}")
    private int siteA4=5;
    @Value("${siteB4}")
    private int siteB4=6;

    //@GetMapping("/add")
    @EventListener(ApplicationReadyEvent.class)
    public void addRectangle(){
        Rectangle rectangle1 = new Rectangle(siteA1,siteB1);
        Rectangle rectangle2 = new Rectangle(siteA2,siteB2);
        Rectangle rectangle3 = new Rectangle(siteA3,siteB3);
        Rectangle rectangle4 = new Rectangle(siteA4,siteB4);
        rectangleRepo.save(rectangle1);
        rectangleRepo.save(rectangle2);
        rectangleRepo.save(rectangle3);
        rectangleRepo.save(rectangle4);
        System.out.println("adding rectangles data !!!!!!!!!!!!!!!");
    }
}
