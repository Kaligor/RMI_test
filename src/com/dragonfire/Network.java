package com.dragonfire;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class Network
{

    GameLogicInterface Remote;

    public Network()
    {
        try
        {
            Remote = (GameLogicInterface) Naming.lookup("//172.16.1.73:1099/test");

        } catch (MalformedURLException | NotBoundException | RemoteException e)
        {
            System.out.println("Creating Logic Failed");
        }

    }
    
    

}
