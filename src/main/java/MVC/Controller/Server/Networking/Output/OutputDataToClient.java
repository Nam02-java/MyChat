package MVC.Controller.Server.Networking.Output;

import MVC.Model.Data;
import MVC.Service.InterfaceService.IO.SocketDataOutput;
import MVC.Service.InterfaceService.Log.ReadLogServer;
import MVC.Service.Thread.ThreadSaveToFile;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.net.Socket;
import java.util.*;
public class OutputDataToClient {
    private SocketDataOutput socketDataOutput;
    private ReadLogServer readLogServer;
    private Data data;
    private File file = new File(Data.getFilePath());

    public OutputDataToClient(SocketDataOutput socketDataOutput, ReadLogServer readLogServer, Data data) {
        this.socketDataOutput = socketDataOutput;
        this.readLogServer = readLogServer;
        this.data = data;
    }
    public void sendData(Socket clientSocket, BufferedReader inFromClient) {
        String messageFromClient;
        Boolean onlySaveOnce = true;
        try {
            while ((messageFromClient = inFromClient.readLine()) != null) {
                if (messageFromClient.endsWith("1")) {
                    List<String> listChatHistory = readLogServer.read(data);
                    socketDataOutput.sendData(clientSocket, "History Size: " + listChatHistory.size());
                    for (String message : listChatHistory) {
                        socketDataOutput.sendData(clientSocket, "Old message ( " + message + " )");
                    }
                } else {
                    for (Socket socket : Data.getClientSockets()) {
                        if (socket != clientSocket) {
                            if (onlySaveOnce == true) {
                                Thread thread = new ThreadSaveToFile(
                                        Thread.currentThread().getName(),
                                        messageFromClient,
                                        file);
                                thread.start();
                                onlySaveOnce = false;
                            }
                            socketDataOutput.sendData(socket, messageFromClient);
                        }
                    }
                    onlySaveOnce = true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

