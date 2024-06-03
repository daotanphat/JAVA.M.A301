package fa.training.main;

import fa.training.entities.Person;
import fa.training.service.PersonService;
import fa.training.utils.Constants;
import fa.training.utils.Validator;

import java.util.ArrayList;
import java.util.List;

public class PersonManage {
    public static void main(String[] args) {
        Constants constants = new Constants();
        Validator validator = new Validator();
        PersonService personService = new PersonService();
        List<Person> personList = new ArrayList<>();

        int choice;
        do {
            constants.menu();
            choice = validator.inputInt("Enter your choice", 1, 4);
            switch (choice) {
                case 1:
                    personList = personService.addPersons();
                    break;
                case 2:
                    personService.updateStudents(personList);
                    break;
                case 3:
                    personService.displayTeacher(personList);
                    break;
                case 4:
                    personService.report(personList);
                    break;
            }
        }while (validator.checkQuit(choice));
    }
}
