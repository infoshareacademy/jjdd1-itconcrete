package isacademy.jjdd1.itconcrete.smartconnect.schedule;

import java.nio.file.Path;
import java.util.List;
import java.util.Optional;

class InitialDataChecker {

    boolean checkIfSchedulesArePresent (List<Path> listOfSchedules) {
        Optional<List<Path>> listOfFiles = Optional.ofNullable(listOfSchedules);
        return listOfFiles.isPresent();
    }
}
