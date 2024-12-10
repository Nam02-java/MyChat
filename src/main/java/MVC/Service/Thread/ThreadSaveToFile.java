package MVC.Service.Thread;

import MVC.Service.InterfaceService.File.SaveToFile;
import MVC.Service.InterfaceService.ID.IDManager;
import MVC.Service.ServiceImplenments.File.SaveToFileImplementation;
import MVC.Service.ServiceImplenments.ID.IDManagerImplementation;

import java.io.File;

public class ThreadSaveToFile extends Thread {

    private String message;
    private SaveToFile saveToFile;
    private File file;
    private IDManager idManager;

    public ThreadSaveToFile(String name, String message, File file) {
        super(name);
        this.message = message;
        this.file = file;
        this.saveToFile = new SaveToFileImplementation();
        this.idManager = new IDManagerImplementation();
    }

    @Override
    public void run() {
        synchronized (ThreadSaveToFile.class) {
            int id = idManager.updateMaxReceivedId(file);
            message = id + "." + " " + message;
            saveToFile.saveMessageToFile(file, message);
        }
    }
}
