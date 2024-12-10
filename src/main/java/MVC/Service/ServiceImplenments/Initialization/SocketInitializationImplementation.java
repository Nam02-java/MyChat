package MVC.Service.ServiceImplenments.Initialization;

import MVC.Model.Data;
import MVC.Service.InterfaceService.ConnectionInitialization.SocketInitialization;
import MVC.Service.LazySingleton.UserName.UserNameManager;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class SocketInitializationImplementation implements SocketInitialization {
    @Override
    public Socket setUp() throws IOException {
        Socket socket = new Socket("Localhost", Data.getPORT());
        return socket;
    }
}
