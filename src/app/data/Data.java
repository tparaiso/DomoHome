package app.data;

import app.common.*;
import app.data.home.Floor;
import app.data.home.Room;
import app.data.object.Light;
import app.data.object.ObjectHome;
import app.services.DataService;

import java.util.ArrayList;

/**
 * Created by Nicolas on 16/03/2015.
 */
public class Data implements DataService {
    ArrayList<Floor> floors;
    ArrayList<Floor> miniFloors;

    //    ArrayList<Room> rooms;
    ArrayList<ObjectHome> objects;

    public void init() {
        floors = new ArrayList<Floor>();
        miniFloors = new ArrayList<Floor>();

//        rooms = new ArrayList<Room>();
        objects = new ArrayList<ObjectHome>();
        initFloors();
        //initRooms();
        initObjects();
    }

    public ArrayList<Room> getRooms() {
        return null;
    }

    private void initFloors() {
        int divider = 1;
        floors.add(new Floor(new Dimension(ParamDisplay.MAIN_FLOOR_DISPLAYED_X, ParamDisplay.MAIN_FLOOR_DISPLAYED_Y,
                ParamDisplay.MAIN_FLOOR_DISPLAYED_WIDTH, ParamDisplay.MAIN_FLOOR_DISPLAYED_HEIGHT)
                , divider));

        floors.add(new Floor(new Dimension(ParamDisplay.MAIN_FLOOR_DISPLAYED_X, ParamDisplay.MAIN_FLOOR_DISPLAYED_Y,
                ParamDisplay.MAIN_FLOOR_DISPLAYED_WIDTH, ParamDisplay.MAIN_FLOOR_DISPLAYED_HEIGHT)
                , divider));

        floors.add(new Floor(new Dimension(ParamDisplay.MAIN_FLOOR_DISPLAYED_X , ParamDisplay.MAIN_FLOOR_DISPLAYED_Y ,
                ParamDisplay.MAIN_FLOOR_DISPLAYED_WIDTH, ParamDisplay.MAIN_FLOOR_DISPLAYED_HEIGHT)
                , divider));

    }
    private void initMiniFloors() {
        int divider = 1;
        miniFloors.add(new Floor(new Dimension(ParamDisplay.MAIN_FLOOR_DISPLAYED_X, ParamDisplay.MAIN_FLOOR_DISPLAYED_Y,
                ParamDisplay.MAIN_FLOOR_DISPLAYED_WIDTH, ParamDisplay.MAIN_FLOOR_DISPLAYED_HEIGHT)
                , divider));

        miniFloors.add(new Floor(new Dimension(ParamDisplay.MAIN_FLOOR_DISPLAYED_X, ParamDisplay.MAIN_FLOOR_DISPLAYED_Y,
                ParamDisplay.MAIN_FLOOR_DISPLAYED_WIDTH, ParamDisplay.MAIN_FLOOR_DISPLAYED_HEIGHT)
                , divider));

        miniFloors.add(new Floor(new Dimension(ParamDisplay.MAIN_FLOOR_DISPLAYED_X , ParamDisplay.MAIN_FLOOR_DISPLAYED_Y ,
                ParamDisplay.MAIN_FLOOR_DISPLAYED_WIDTH, ParamDisplay.MAIN_FLOOR_DISPLAYED_HEIGHT)
                , divider));

    }
    //Function to initialize all rooms for floors 1,2,3 (the big floors)
    private ArrayList<Room> initRoomsFirstFloor(int divider) {
        ArrayList<Room> rooms = new ArrayList<Room>();
            Room room01_01 = new Room();
            room01_01.setGroup(new Dimension(ParamFirstFloor.FIRST_ROOM_X, ParamFirstFloor.FIRST_ROOM_Y, ParamFirstFloor.FIRST_ROOM_WIDTH, ParamFirstFloor.FIRST_ROOM_HEIGHT),
                    divider, floors.get(0), true);
            rooms.add(room01_01);

            Room room01_02 = new Room();
            room01_02.setGroup(new Dimension(ParamFirstFloor.SECOND_ROOM_X, ParamFirstFloor.SECOND_ROOM_Y, ParamFirstFloor.SECOND_ROOM_WIDTH, ParamFirstFloor.SECOND_ROOM_HEIGHT),
                    divider, floors.get(0), false);
            rooms.add(room01_02);

            Room room01_03 = new Room();
            room01_03.setGroup(new Dimension(ParamFirstFloor.THIRD_ROOM_X, ParamFirstFloor.THIRD_ROOM_Y, ParamFirstFloor.THIRD_ROOM_WIDTH, ParamFirstFloor.THIRD_ROOM_HEIGHT),
                    divider, floors.get(0), false);
            rooms.add(room01_03);

            Room room01_04 = new Room();
            room01_04.setGroup(new Dimension(ParamFirstFloor.FOURTH_ROOM_X, ParamFirstFloor.FOURTH_ROOM_Y, ParamFirstFloor.FOURTH_ROOM_WIDTH, ParamFirstFloor.FOURTH_ROOM_HEIGHT),
                    divider, floors.get(0), false);
            rooms.add(room01_04);

            Room room01_05 = new Room();
            room01_05.setGroup(new Dimension(ParamFirstFloor.FIFTH_ROOM_X, ParamFirstFloor.FIFTH_ROOM_Y, ParamFirstFloor.FIFTH_ROOM_WIDTH, ParamFirstFloor.FIFTH_ROOM_HEIGHT),
                    divider, floors.get(0), false);
            rooms.add(room01_05);

            Room garden = new Room();
            rooms.add(garden.getGarden(ParamFirstFloor.GARDEN_ROOM_WIDTH, ParamFirstFloor.GARDEN_ROOM_HEIGHT, ParamFirstFloor.GARDEN_ROOM_X, ParamFirstFloor.GARDEN_ROOM_Y));

        return rooms;

    }

    private ArrayList<Room> initRoomsSecondFloor(int divider) {
        ArrayList<Room> rooms = new ArrayList<Room>();
        Room room01_01 = new Room();

        room01_01.setGroup(new Dimension(ParamSecondFloor.FIRST_ROOM_X, ParamFirstFloor.FIRST_ROOM_Y, ParamSecondFloor.FIRST_ROOM_WIDTH, ParamSecondFloor.FIRST_ROOM_HEIGHT),
                divider, floors.get(1), true);
        rooms.add(room01_01);

        Room room01_02 = new Room();
        room01_02.setGroup(new Dimension(ParamSecondFloor.SECOND_ROOM_X, ParamSecondFloor.SECOND_ROOM_Y, ParamSecondFloor.SECOND_ROOM_WIDTH, ParamSecondFloor.SECOND_ROOM_HEIGHT),
                divider, floors.get(1), false);
        rooms.add(room01_02);

        Room room01_03 = new Room();
        room01_03.setGroup(new Dimension(ParamSecondFloor.THIRD_ROOM_X, ParamSecondFloor.THIRD_ROOM_Y, ParamSecondFloor.THIRD_ROOM_WIDTH, ParamSecondFloor.THIRD_ROOM_HEIGHT),
                divider, floors.get(1), false);
        rooms.add(room01_03);

        Room room01_04 = new Room();
        room01_04.setGroup(new Dimension(ParamSecondFloor.FOURTH_ROOM_X, ParamSecondFloor.FOURTH_ROOM_Y, ParamSecondFloor.FOURTH_ROOM_WIDTH, ParamSecondFloor.FOURTH_ROOM_HEIGHT),
                divider, floors.get(1), false);
        rooms.add(room01_04);



        return rooms;
    }

    private ArrayList<Room> initRoomsThirdFloor(int divider) {
        ArrayList<Room> rooms = new ArrayList<Room>();
        Room room01_01 = new Room();
        room01_01.setGroup(new Dimension(ParamThirdFloor.FIRST_ROOM_X, ParamThirdFloor.FIRST_ROOM_Y, ParamThirdFloor.FIRST_ROOM_WIDTH, ParamThirdFloor.FIRST_ROOM_HEIGHT),
                divider, floors.get(2), true);
        rooms.add(room01_01);

        return rooms;
    }

    //Function to initialize all rooms for the mini floors
    private ArrayList<Room> initRoomsFirstMiniFloor(int divider) {
        ArrayList<Room> rooms = new ArrayList<Room>();
        Room room01_01 = new Room();
        room01_01.setGroup(new Dimension(ParamDisplay.X_MINI_MAP, ParamDisplay.Y_FIRST_LITTLE_MAP, ParamFirstFloor.FIRST_LITTLE_ROOM_WIDTH, ParamFirstFloor.FIRST_LITTLE_ROOM_HEIGHT),
                divider, floors.get(0), true);
        rooms.add(room01_01);

        Room room01_02 = new Room();
        room01_02.setGroup(new Dimension(ParamFirstFloor.SECOND_LITTLE_ROOM_X, ParamFirstFloor.SECOND_LITTLE_ROOM_Y, ParamFirstFloor.SECOND_LITTLE_ROOM_WIDTH, ParamFirstFloor.SECOND_LITTLE_ROOM_HEIGHT),
                divider, floors.get(0), false);
        rooms.add(room01_02);

        Room room01_03 = new Room();
        room01_03.setGroup(new Dimension(ParamFirstFloor.THIRD_LITTLE_ROOM_X, ParamFirstFloor.THIRD_LITTLE_ROOM_Y, ParamFirstFloor.THIRD_LITTLE_ROOM_WIDTH, ParamFirstFloor.THIRD_LITTLE_ROOM_HEIGHT),
                divider, floors.get(0), false);
        rooms.add(room01_03);

        Room room01_04 = new Room();
        room01_04.setGroup(new Dimension(ParamFirstFloor.FOURTH_LITTLE_ROOM_X, ParamFirstFloor.FOURTH_LITTLE_ROOM_Y, ParamFirstFloor.FOURTH_LITTLE_ROOM_WIDTH, ParamFirstFloor.FOURTH_LITTLE_ROOM_HEIGHT),
                divider, floors.get(0), false);
        rooms.add(room01_04);

        Room room01_05 = new Room();
        room01_05.setGroup(new Dimension(ParamFirstFloor.FIFTH_LITTLE_ROOM_X, ParamFirstFloor.FIFTH_LITTLE_ROOM_Y, ParamFirstFloor.FIFTH_LITTLE_ROOM_WIDTH, ParamFirstFloor.FIFTH_LITTLE_ROOM_HEIGHT),
                divider, floors.get(0), false);
        rooms.add(room01_05);

        Room garden = new Room();
        rooms.add(garden.getGarden(ParamFirstFloor.GARDEN_LITTLE_ROOM_WIDTH, ParamFirstFloor.GARDEN_LITTLE_HEIGHT, ParamFirstFloor.GARDEN_LITTLE_ROOM_X, ParamFirstFloor.GARDEN_LITTLE_ROOM_Y));

        return rooms;

    }

    private ArrayList<Room> initRoomsSecondMiniFloor(int divider) {
        ArrayList<Room> rooms = new ArrayList<Room>();
        Room room01_01 = new Room();

        room01_01.setGroup(new Dimension(ParamDisplay.X_MINI_MAP, ParamDisplay.Y_SECOND_LITTLE_MAP, ParamSecondFloor.FIRST_LITTLE_ROOM_WIDTH, ParamSecondFloor.FIRST_LITTLE_ROOM_HEIGHT),
                divider, floors.get(1), true);
        rooms.add(room01_01);

        Room room01_02 = new Room();
        room01_02.setGroup(new Dimension(ParamSecondFloor.SECOND_LITTLE_ROOM_X, ParamSecondFloor.SECOND_LITTLE_ROOM_Y, ParamSecondFloor.SECOND_LITTLE_ROOM_WIDTH, ParamSecondFloor.SECOND_LITTLE_HEIGHT),
                divider, floors.get(1), false);
        rooms.add(room01_02);

        Room room01_03 = new Room();
        room01_03.setGroup(new Dimension(ParamSecondFloor.THIRD_LITTLE_ROOM_X, ParamSecondFloor.THIRD_LITTLE_ROOM_Y, ParamSecondFloor.THIRD_LITTLE_ROOM_WIDTH, ParamSecondFloor.THIRD_LITTLE_ROOM_HEIGHT),
                divider, floors.get(1), false);
        rooms.add(room01_03);

        Room room01_04 = new Room();
        room01_04.setGroup(new Dimension(ParamSecondFloor.FOURTH_LITTLE_ROOM_X, ParamSecondFloor.FOURTH_LITTLE_ROOM_Y, ParamSecondFloor.FOURTH_LITTLE_ROOM_WIDTH, ParamSecondFloor.FOURTH_LITTLE_ROOM_HEIGHT),
                divider, floors.get(1), false);
        rooms.add(room01_04);



        return rooms;
    }

    private ArrayList<Room> initRoomsThirdMiniFloor() {
        int divider = 1;
        ArrayList<Room> rooms = new ArrayList<Room>();
        Room room01_01 = new Room();
        room01_01.setGroup(new Dimension(ParamDisplay.X_MINI_MAP, ParamDisplay.Y_THIRD_LITTLE_MAP, ParamThirdFloor.FIRST_LITTLE_ROOM_WIDTH, ParamThirdFloor.FIRST_LITTLE_ROOM_HEIGHT),
                divider, floors.get(2), true);
        rooms.add(room01_01);

        return rooms;
    }
    private void initObjects() {
        Light lightFirstPlace = new Light(new Dimension(ParamHome.FIRST_LIGHT_X, ParamHome.FIRST_LIGHT_Y, 15), true);

        Light lightSecondPlace = new Light(new Dimension(ParamHome.SECOND_LIGHT_X, ParamHome.SECOND_LIGHT_Y, 15), false);

    }

    public ArrayList<ArrayList<Room>> getMainFloor(int floorNo) {
        ArrayList<Room> rooms = new ArrayList<Room>();
        switch (floorNo) {
            case 1:
                rooms = initRoomsFirstFloor(1);
                break;
            case 2:
                rooms = initRoomsSecondFloor(1);
                break;
            case 3:
                rooms = initRoomsThirdFloor(1);
                break;
        }
        ArrayList<ArrayList<Room>> lel = new ArrayList<ArrayList<Room>>();
        lel.add(rooms);
        return lel;
    }

    public ArrayList<ArrayList<Room>> getSecondaryFloors(int floorNoInFull) {
        ArrayList<ArrayList<Room>> lel = new ArrayList<ArrayList<Room>>();
        ArrayList<Room> rooms;
        switch (floorNoInFull) {
            case 1:
                rooms = initRoomsFirstMiniFloor(1);
                lel.add(rooms);
               /* rooms = initRoomsThirdFloor(4);
                lel.add(rooms);*/
                break;
            case 2:
                rooms = initRoomsSecondMiniFloor(1);
                lel.add(rooms);
                /*rooms = initRoomsThirdFloor(4);
                lel.add(rooms);*/
                break;
            case 3:
                rooms = initRoomsThirdMiniFloor();
                lel.add(rooms);
                /*rooms = initRoomsFirstFloor(4);
                lel.add(rooms);*/
                break;
        }
        return lel;
    }
}
