package io;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import engine.OperationManager;

import java.io.File;
import java.io.IOException;

/**
 * This class contains the Jackson-based methods which can save the data as a json file type,
 * and at the same time can convert the json file into corresponding data
 *
 * @author Ziming Wang
 * @version 1.0
 */
public class DataManager {

    /**
     * This method can convert the tasks and projects data saved in the OperationManager class into a .json file type
     * @param operationManager The object of type OperationManager saves the data of all tasks and projects
     */
    public void saveAllData(OperationManager operationManager){

        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File("TodoList.json"), operationManager);

        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * This method can convert the data in the existing .json file into an object of type OperationManager and return
     * @return Return an OperationManager type object that contains all tasks and projects data
     */
    public OperationManager loadAllData(){

        OperationManager operationManager = new OperationManager();

        try {
            operationManager = new ObjectMapper().reader(OperationManager.class).readValue(new File("TodoList.json"));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return operationManager;
    }
}
