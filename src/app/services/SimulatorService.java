package app.services;

import app.data.home.Room;

import java.util.ArrayList;

/**
 * Created by Nicolas on 13/03/2015.
 */
public interface SimulatorService {
    public void init();
    public void start();
    public void destroy();
    public void setCharacterMove(int direction);
    public void pause();
    public boolean getPresence();
    public void setObjectsOn();
    public void setObjectsOn(int RoomID);
}
