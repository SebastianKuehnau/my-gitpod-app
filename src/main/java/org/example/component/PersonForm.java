package org.example.component;

import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import org.example.backend.Person;

public class PersonForm extends FormLayout {

    Binder<Person> personBinder = new Binder<>(Person.class);

    public PersonForm() {
        TextField nameField = new TextField("Name");
        personBinder.bind(nameField, Person::getName, Person::setName);
        DatePicker birthdayField = new DatePicker("Birthday");
        personBinder.bind(birthdayField, Person::getBirthday, Person::setBirthday);
        TextField emailField = new TextField("Email");
        personBinder.bind(emailField, Person::getEmail, Person::setEmail);

        add(nameField, birthdayField, emailField);
    }

    public void setItem(Person person) {
        personBinder.setBean(person);
    }

    public void clear() {
        personBinder.setBean(null);
    }
}
