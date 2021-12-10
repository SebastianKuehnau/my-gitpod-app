package org.example;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.data.selection.SelectionEvent;
import com.vaadin.flow.router.Route;
import org.example.backend.Person;
import org.example.backend.PersonService;
import org.example.component.PersonForm;

@Route("person-list")
public class PersonView extends HorizontalLayout {

    private final PersonForm personForm = new PersonForm();

    public PersonView(PersonService personService) {
        Grid<Person> personGrid = new Grid<>(Person.class);
        personGrid.setItems(personService.findAll());
        personGrid.addSelectionListener(this::selectItem);
        personGrid.addThemeVariants(GridVariant.LUMO_NO_BORDER);

        add(personGrid, personForm);

        setPadding(true);
        setMargin(true);
    }

    private void selectItem(SelectionEvent<Grid<Person>, Person> gridPersonSelectionEvent) {
        gridPersonSelectionEvent.getFirstSelectedItem().ifPresentOrElse(personForm::setItem, personForm::clear);
    }


}
