package org.nic.Server;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

import javafx.scene.image.Image;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.sql.SQLException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Server extends Thread
{
    private ServerSocket serverSocket;
    Socket server;

    public Server(int port) throws IOException, SQLException, ClassNotFoundException, Exception
    {
        serverSocket = new ServerSocket(port);
        serverSocket.setSoTimeout(180000);
    }

    public void run() {
        while (true) {
            try {
                server = serverSocket.accept();
                BufferedImage image = ImageIO.read(ImageIO.createImageInputStream(server.getInputStream()));
                CorruptorLogic edge = new CorruptorLogic();
                Image FXImage = SwingFXUtils.toFXImage(image, null);
                Color[][] img = (edge.filterImage(FXImage));
                edge.saveImage(img,"/Users/nicolaspoffley/Desktop/OUT/test");

            } catch (SocketTimeoutException st) {
                System.out.println("Socket timed out!");
                break;
            } catch (IOException e) {
                e.printStackTrace();
                break;
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
    }

    public static void main(String [] args) throws IOException, SQLException, ClassNotFoundException, Exception
    {
        Thread t = new Server(6066);
        t.start();
    }
}