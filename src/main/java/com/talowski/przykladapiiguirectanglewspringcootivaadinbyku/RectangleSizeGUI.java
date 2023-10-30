package com.talowski.przykladapiiguirectanglewspringcootivaadinbyku;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;



@Route
public class RectangleSizeGUI extends VerticalLayout {

    private RectangleRepo rectangleRepo;

    private TextArea textAreaRectangles;
    private  TextField textFieldRectanglesSize;
    private Button buttonBigger;
    private Button buttonSmaller;

    @Autowired
    public RectangleSizeGUI(RectangleRepo rectangleRepo) {
        this.rectangleRepo= rectangleRepo;
        this.textFieldRectanglesSize = new TextField("podaj rozmiar");
        textAreaRectangles = new TextArea("rezultat");
        buttonBigger = new Button("pokaz wieksze");
        buttonSmaller = new Button("pokaz mniejsze");

        buttonBigger.addClickListener(clickEvent -> textAreaRectangles.setValue(rectangleRepo.getBigRectangles(Integer.parseInt(textFieldRectanglesSize.getValue())).toString()));
        buttonSmaller.addClickListener(clickEvent -> textAreaRectangles.setValue(rectangleRepo.getSmallRectangles(Integer.parseInt(textFieldRectanglesSize.getValue())).toString()));


         add(textFieldRectanglesSize);
         add(buttonBigger);
         add(buttonSmaller);
         add(textAreaRectangles);

    }
}
