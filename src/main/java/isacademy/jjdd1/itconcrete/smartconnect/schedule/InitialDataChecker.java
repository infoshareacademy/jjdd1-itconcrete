package isacademy.jjdd1.itconcrete.smartconnect.schedule;

import java.io.File;
import java.util.Optional;

class InitialDataChecker {

    public boolean checkIfSchedulesDirectoriesArePresent (File[] listOfSchedulesDirectories) {
        Optional<File[]> listOfFiles = Optional.ofNullable(listOfSchedulesDirectories);
        return listOfFiles.isPresent();
    }

    public boolean checkPresenceOfScheduleResource(File[] listOfOneBuslineFiles){
        Optional<File[]> listOfFiles = Optional.ofNullable(listOfOneBuslineFiles);
        return listOfFiles.isPresent();
    }

}
