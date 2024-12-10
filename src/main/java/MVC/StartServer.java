package MVC;

import MVC.Controller.Server.ServerManager;
import MVC.Model.Data;
import MVC.Service.NewSingleThreadExecutor.SingleThreadTaskManager;

import java.io.IOException;

public class StartServer {

    public static String stringDemo;
    public static SingleThreadTaskManager taskManager = new SingleThreadTaskManager();

    public static Data shareData;


    public static void main(String[] args) throws IOException {
        ServerManager serverManager = new ServerManager();
        serverManager.initializeServer();
    }
}


