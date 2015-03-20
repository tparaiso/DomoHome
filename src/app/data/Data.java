package app.data;

import app.common.*;
import app.data.home.Floor;
import app.data.home.Room;
import app.data.object.Light;
import app.data.object.ObjectHome;
import app.data.object.Radiator;
import app.services.DataService;

import java.util.ArrayList;

/**
 * Created by Nicolas on 16/03/2015.
 */
public class Data implements DataService {
    ArrayList<Floor> floors;
    ArrayList<Floor> miniFloors;
    ArrayList<Room> rooms;
    Character character;

    //    ArrayList<Room> rooms;
//    ArrayList<ObjectHome> objects;

    /**
     * Method to init the main content of the simulator
     */
    public void init() {
        floors = new ArrayList<Floor>();
        miniFloors = new ArrayList<Floor>();
        rooms = new ArrayList<Room>();
        character = new Character(new Dimension(10,200));

        initFloors();
        initRooms(0, 6);
        initRooms(1, 4);
        initRooms(2,1);

        initRoomsFirstFloor();
        initRoomsSecondFloor();
        initRoomsThirdFloor();

    }

    /**
     * Method to init the floors.
     */
    private void initFloors() {
        Floor floor_01 = new Floor();
        floor_01.setGroup(new Dimension(ParamDisplay.MAIN_FLOOR_DISPLAYED_X, ParamDisplay.MAIN_FLOOR_DISPLAYED_Y,
                        ParamDisplay.MAIN_FLOOR_DISPLAYED_WIDTH, ParamDisplay.MAIN_FLOOR_DISPLAYED_HEIGHT));
        floors.add(floor_01);

        Floor floor_02 = new Floor();
        floor_02.setGroup(new Dimension(ParamDisplay.MAIN_FLOOR_DISPLAYED_X, ParamDisplay.MAIN_FLOOR_DISPLAYED_Y,
                ParamDisplay.MAIN_FLOOR_DISPLAYED_WIDTH, ParamDisplay.MAIN_FLOOR_DISPLAYED_HEIGHT));
        floors.add(floor_02);

        Floor floor_03 = new Floor();
        floor_03.setGroup(new Dimension(ParamDisplay.MAIN_FLOOR_DISPLAYED_X, ParamDisplay.MAIN_FLOOR_DISPLAYED_Y,
                ParamDisplay.MAIN_FLOOR_DISPLAYED_WIDTH, ParamDisplay.MAIN_FLOOR_DISPLAYED_HEIGHT));
        floors.add(floor_03);

    }

    /**
     * Method to init the rooms without creating the rectangles for their display.
     * @param floorIndex
     * @param noOfRoom
     */
    private void initRooms(int floorIndex, int noOfRoom) {
        RoomsEnum.ROOM enumRoom = RoomsEnum.ROOM.CHAMBRE_1;
        for (int i = 0; i < noOfRoom; i++) {
            if (floorIndex == 0) {
                switch (i) {
                    case 0:
                        enumRoom = RoomsEnum.ROOM.CHAMBRE_1;
                        break;
                    case 1:
                        enumRoom = RoomsEnum.ROOM.SALON_1;
                        break;
                    case 2:
                        enumRoom = RoomsEnum.ROOM.ENTREE_1;
                        break;
                    case 3:
                        enumRoom = RoomsEnum.ROOM.CUISINE_1;
                        break;
                    case 4:
                        enumRoom = RoomsEnum.ROOM.SDB_1;
                        break;
                    case 5:
                        enumRoom = RoomsEnum.ROOM.GARDEN_1;
                        break;
                }
            } else {
                if (floorIndex == 1) {
                    switch (i) {
                        case 0:
                            enumRoom = RoomsEnum.ROOM.SALLE_JEU_2;
                            break;
                        case 1:
                            enumRoom = RoomsEnum.ROOM.COULOIR_2;
                            break;
                        case 2:
                            enumRoom = RoomsEnum.ROOM.CHAMBRE_2;
                            break;
                        case 3:
                            enumRoom = RoomsEnum.ROOM.SDB_2;
                            break;
                    }
                } else {
                    switch (i) {
                        case 0:
                            enumRoom = RoomsEnum.ROOM.SALLE_JEU_2;
                            break;
                        case 1:
                            enumRoom = RoomsEnum.ROOM.COULOIR_2;
                            break;
                        case 2:
                            enumRoom = RoomsEnum.ROOM.CHAMBRE_2;
                            break;
                        case 3:
                            enumRoom = RoomsEnum.ROOM.SDB_2;
                            break;
                    }
                }
            }
            Room room = new Room(floors.get(floorIndex), enumRoom);
            rooms.add(room);
            floors.get(floorIndex).addRoom(room);
        }
    }

    /**
     * Method to initialize all rooms for floors No. 1 (for the main floor rectangle).
     */
    private void initRoomsFirstFloor() {
        floors.get(0).getSpecificRoom(0).setGroup(new Dimension(ParamFirstFloor.FIRST_ROOM_X, ParamFirstFloor.FIRST_ROOM_Y, ParamFirstFloor.FIRST_ROOM_WIDTH, ParamFirstFloor.FIRST_ROOM_HEIGHT),
                new Dimension(ParamDisplay.X_MINI_MAP, ParamDisplay.Y_FIRST_LITTLE_MAP, ParamFirstFloor.FIRST_LITTLE_ROOM_WIDTH, ParamFirstFloor.FIRST_LITTLE_ROOM_HEIGHT),
                true);

        floors.get(0).getSpecificRoom(1).setGroup(new Dimension(ParamFirstFloor.SECOND_ROOM_X, ParamFirstFloor.SECOND_ROOM_Y, ParamFirstFloor.SECOND_ROOM_WIDTH, ParamFirstFloor.SECOND_ROOM_HEIGHT),
                new Dimension(ParamFirstFloor.SECOND_LITTLE_ROOM_X, ParamFirstFloor.SECOND_LITTLE_ROOM_Y, ParamFirstFloor.SECOND_LITTLE_ROOM_WIDTH, ParamFirstFloor.SECOND_LITTLE_ROOM_HEIGHT),
                false);

        floors.get(0).getSpecificRoom(2).setGroup(new Dimension(ParamFirstFloor.THIRD_ROOM_X, ParamFirstFloor.THIRD_ROOM_Y, ParamFirstFloor.THIRD_ROOM_WIDTH, ParamFirstFloor.THIRD_ROOM_HEIGHT),
                new Dimension(ParamFirstFloor.THIRD_LITTLE_ROOM_X, ParamFirstFloor.THIRD_LITTLE_ROOM_Y, ParamFirstFloor.THIRD_LITTLE_ROOM_WIDTH, ParamFirstFloor.THIRD_LITTLE_ROOM_HEIGHT),
                false);

        floors.get(0).getSpecificRoom(3).setGroup(new Dimension(ParamFirstFloor.FOURTH_ROOM_X, ParamFirstFloor.FOURTH_ROOM_Y, ParamFirstFloor.FOURTH_ROOM_WIDTH, ParamFirstFloor.FOURTH_ROOM_HEIGHT),
                new Dimension(ParamFirstFloor.FOURTH_LITTLE_ROOM_X, ParamFirstFloor.FOURTH_LITTLE_ROOM_Y, ParamFirstFloor.FOURTH_LITTLE_ROOM_WIDTH, ParamFirstFloor.FOURTH_LITTLE_ROOM_HEIGHT),
                false);

        floors.get(0).getSpecificRoom(4).setGroup(new Dimension(ParamFirstFloor.FIFTH_ROOM_X, ParamFirstFloor.FIFTH_ROOM_Y, ParamFirstFloor.FIFTH_ROOM_WIDTH, ParamFirstFloor.FIFTH_ROOM_HEIGHT),
                new Dimension(ParamFirstFloor.FIFTH_LITTLE_ROOM_X, ParamFirstFloor.FIFTH_LITTLE_ROOM_Y, ParamFirstFloor.FIFTH_LITTLE_ROOM_WIDTH, ParamFirstFloor.FIFTH_LITTLE_ROOM_HEIGHT),
                false);

        floors.get(0).getSpecificRoom(5).setGroup(new Dimension(ParamFirstFloor.GARDEN_ROOM_X, ParamFirstFloor.GARDEN_ROOM_Y, ParamFirstFloor.GARDEN_ROOM_WIDTH, ParamFirstFloor.GARDEN_ROOM_HEIGHT),
                new Dimension(ParamFirstFloor.GARDEN_LITTLE_ROOM_X, ParamFirstFloor.GARDEN_LITTLE_ROOM_Y,ParamFirstFloor.GARDEN_LITTLE_ROOM_WIDTH, ParamFirstFloor.GARDEN_LITTLE_HEIGHT),
                false);

    }

    /**
     * Method to initialize all rooms for floors No. 2 (for the main floor rectangle)
     *
     * @return ArrayList<Room>
     */
    private void initRoomsSecondFloor() {
        floors.get(1).getSpecificRoom(0).setGroup(new Dimension(ParamSecondFloor.FIRST_ROOM_X, ParamFirstFloor.FIRST_ROOM_Y, ParamSecondFloor.FIRST_ROOM_WIDTH, ParamSecondFloor.FIRST_ROOM_HEIGHT),
                new Dimension(ParamDisplay.X_MINI_MAP, ParamDisplay.Y_SECOND_LITTLE_MAP, ParamSecondFloor.FIRST_LITTLE_ROOM_WIDTH, ParamSecondFloor.FIRST_LITTLE_ROOM_HEIGHT), true);

        floors.get(1).getSpecificRoom(1).setGroup(new Dimension(ParamSecondFloor.SECOND_ROOM_X, ParamSecondFloor.SECOND_ROOM_Y, ParamSecondFloor.SECOND_ROOM_WIDTH, ParamSecondFloor.SECOND_ROOM_HEIGHT),
                new Dimension(ParamSecondFloor.SECOND_LITTLE_ROOM_X, ParamSecondFloor.SECOND_LITTLE_ROOM_Y, ParamSecondFloor.SECOND_LITTLE_ROOM_WIDTH, ParamSecondFloor.SECOND_LITTLE_ROOM_HEIGHT), false);

        floors.get(1).getSpecificRoom(2).setGroup(new Dimension(ParamSecondFloor.THIRD_ROOM_X, ParamSecondFloor.THIRD_ROOM_Y, ParamSecondFloor.THIRD_ROOM_WIDTH, ParamSecondFloor.THIRD_ROOM_HEIGHT),
                new Dimension(ParamSecondFloor.THIRD_LITTLE_ROOM_X, ParamSecondFloor.THIRD_LITTLE_ROOM_Y, ParamSecondFloor.THIRD_LITTLE_ROOM_WIDTH, ParamSecondFloor.THIRD_LITTLE_ROOM_HEIGHT), false);

        floors.get(1).getSpecificRoom(3).setGroup(new Dimension(ParamSecondFloor.FOURTH_ROOM_X, ParamSecondFloor.FOURTH_ROOM_Y, ParamSecondFloor.FOURTH_ROOM_WIDTH, ParamSecondFloor.FOURTH_ROOM_HEIGHT),
                new Dimension(ParamSecondFloor.FOURTH_LITTLE_ROOM_X, ParamSecondFloor.FOURTH_LITTLE_ROOM_Y, ParamSecondFloor.FOURTH_LITTLE_ROOM_WIDTH, ParamSecondFloor.FOURTH_LITTLE_ROOM_HEIGHT), false);
    }

    /**
     * Method to initialize all rooms for floors No. 3 (for the main floor rectangle)
     */
    private void initRoomsThirdFloor() {
        floors.get(2).getSpecificRoom(0).setGroup(new Dimension(ParamThirdFloor.FIRST_ROOM_X, ParamThirdFloor.FIRST_ROOM_Y, ParamThirdFloor.FIRST_ROOM_WIDTH, ParamThirdFloor.FIRST_ROOM_HEIGHT),
                new Dimension(ParamDisplay.X_MINI_MAP, ParamDisplay.Y_THIRD_LITTLE_MAP, ParamThirdFloor.FIRST_LITTLE_ROOM_WIDTH, ParamThirdFloor.FIRST_LITTLE_ROOM_HEIGHT),
                true);
    }

    /**
     * Method to initialize all rooms for the mini floor no. 1
     *
     * @return ArrayList<Room>
     */
//    private ArrayList<Room> initRoomsFirstMiniFloor() {
//       /* ArrayList<Room> rooms = new ArrayList<Room>();
//        Room room01_01 = new Room(RoomsEnum.ROOM.CHAMBRE_1);
//
//        room01_01.setGroup(new Dimension(ParamDisplay.X_MINI_MAP, ParamDisplay.Y_FIRST_LITTLE_MAP, ParamFirstFloor.FIRST_LITTLE_ROOM_WIDTH, ParamFirstFloor.FIRST_LITTLE_ROOM_HEIGHT),
//                floors.get(0), true);
//        rooms.add(room01_01);
//
//        Room room01_02 = new Room(RoomsEnum.ROOM.SALON_1);
//        room01_02.setGroup(new Dimension(ParamFirstFloor.SECOND_LITTLE_ROOM_X, ParamFirstFloor.SECOND_LITTLE_ROOM_Y, ParamFirstFloor.SECOND_LITTLE_ROOM_WIDTH, ParamFirstFloor.SECOND_LITTLE_ROOM_HEIGHT),
//                floors.get(0), false);
//        rooms.add(room01_02);
//
//        Room room01_03 = new Room(RoomsEnum.ROOM.ENTREE_1);
//        room01_03.setGroup(new Dimension(ParamFirstFloor.THIRD_LITTLE_ROOM_X, ParamFirstFloor.THIRD_LITTLE_ROOM_Y, ParamFirstFloor.THIRD_LITTLE_ROOM_WIDTH, ParamFirstFloor.THIRD_LITTLE_ROOM_HEIGHT),
//                floors.get(0), false);
//        rooms.add(room01_03);
//
//        Room room01_04 = new Room(RoomsEnum.ROOM.CUISINE_1);
//        room01_04.setGroup(new Dimension(ParamFirstFloor.FOURTH_LITTLE_ROOM_X, ParamFirstFloor.FOURTH_LITTLE_ROOM_Y, ParamFirstFloor.FOURTH_LITTLE_ROOM_WIDTH, ParamFirstFloor.FOURTH_LITTLE_ROOM_HEIGHT),
//                floors.get(0), false);
//        rooms.add(room01_04);
//
//        Room room01_05 = new Room(RoomsEnum.ROOM.SDB_1);
//        room01_05.setGroup(new Dimension(ParamFirstFloor.FIFTH_LITTLE_ROOM_X, ParamFirstFloor.FIFTH_LITTLE_ROOM_Y, ParamFirstFloor.FIFTH_LITTLE_ROOM_WIDTH, ParamFirstFloor.FIFTH_LITTLE_ROOM_HEIGHT),
//                floors.get(0), false);
//        rooms.add(room01_05);
//
//        Room garden = new Room();
//        rooms.add(garden.getGarden(ParamFirstFloor.GARDEN_LITTLE_ROOM_WIDTH, ParamFirstFloor.GARDEN_LITTLE_HEIGHT, ParamFirstFloor.GARDEN_LITTLE_ROOM_X, ParamFirstFloor.GARDEN_LITTLE_ROOM_Y));
//
//        return rooms;*/
//        return null;
//    }


    /**
     * Method to initialize all rooms for the mini floor no. 2
     *
     * @return ArrayList<Room>
     */
//    private ArrayList<Room> initRoomsSecondMiniFloor() {
//        /*ArrayList<Room> rooms = new ArrayList<Room>();
//        Room room01_01 = new Room(RoomsEnum.ROOM.SALLE_JEU_2);
//
//        room01_01.setGroup(new Dimension(ParamDisplay.X_MINI_MAP, ParamDisplay.Y_SECOND_LITTLE_MAP, ParamSecondFloor.FIRST_LITTLE_ROOM_WIDTH, ParamSecondFloor.FIRST_LITTLE_ROOM_HEIGHT),
//                floors.get(1), true);
//        rooms.add(room01_01);
//
//        Room room01_02 = new Room(RoomsEnum.ROOM.COULOIR_2);
//        room01_02.setGroup(new Dimension(ParamSecondFloor.SECOND_LITTLE_ROOM_X, ParamSecondFloor.SECOND_LITTLE_ROOM_Y, ParamSecondFloor.SECOND_LITTLE_ROOM_WIDTH, ParamSecondFloor.SECOND_LITTLE_ROOM_HEIGHT),
//                floors.get(1), false);
//        rooms.add(room01_02);
//
//        Room room01_03 = new Room(RoomsEnum.ROOM.CHAMBRE_2);
//        room01_03.setGroup(new Dimension(ParamSecondFloor.THIRD_LITTLE_ROOM_X, ParamSecondFloor.THIRD_LITTLE_ROOM_Y, ParamSecondFloor.THIRD_LITTLE_ROOM_WIDTH, ParamSecondFloor.THIRD_LITTLE_ROOM_HEIGHT),
//                floors.get(1), false);
//        rooms.add(room01_03);
//
//        Room room01_04 = new Room(RoomsEnum.ROOM.SDB_2);
//        room01_04.setGroup(new Dimension(ParamSecondFloor.FOURTH_LITTLE_ROOM_X, ParamSecondFloor.FOURTH_LITTLE_ROOM_Y, ParamSecondFloor.FOURTH_LITTLE_ROOM_WIDTH, ParamSecondFloor.FOURTH_LITTLE_ROOM_HEIGHT),
//                floors.get(1), false);
//        rooms.add(room01_04);
//
//        return rooms;*/
//        return null;
//    }

    /**
     * Method to initialize all rooms for the mini floor no. 3
     *
     * @return ArrayList<Room>
     */
//    private ArrayList<Room> initRoomsThirdMiniFloor() {
//        /*ArrayList<Room> rooms = new ArrayList<Room>();
//        Room room01_01 = new Room(RoomsEnum.ROOM.GRENIER_3);
//
//        room01_01.setGroup(new Dimension(ParamDisplay.X_MINI_MAP, ParamDisplay.Y_THIRD_LITTLE_MAP, ParamThirdFloor.FIRST_LITTLE_ROOM_WIDTH, ParamThirdFloor.FIRST_LITTLE_ROOM_HEIGHT),
//                floors.get(2), true);
//
//        rooms.add(room01_01);
//
//        return rooms;*/
//        return null;
//    }

    /**
     * Method to initialize all the objects of the big house.
     */
    public ArrayList<ObjectHome> getObjectHomes(int floorNo) {
        ArrayList<ObjectHome> objectHomes = new ArrayList<ObjectHome>();

        switch (floorNo) {
            case 1: {
                Light lightFirstPlace = new Light();
                Light lightSecondPlace = new Light();
                Light lightThirdPlace = new Light();
                Light lightFourthPlace = new Light();
                Light lightFifthPlace = new Light();
                Light lightSixthPlace = new Light();
                Radiator radiatorFirst = new Radiator();

                lightFirstPlace.setGroup(new Dimension(ParamFirstFloor.FIRST_LIGHT_X, ParamFirstFloor.FIRST_LIGHT_Y, ParamDisplay.BIG_FLOOR_RADIUS_LIGTH),
                        new Dimension(ParamFirstFloor.FIRST_LITTLE_LIGHT_X, ParamFirstFloor.FIRST_LITTLE_LIGHT_Y, ParamDisplay.MINI_FLOOR_LITTLE_RADIUS_LIGTH), true);
                 lightSecondPlace.setGroup(new Dimension(ParamFirstFloor.SECOND_LIGHT_X, ParamFirstFloor.SECOND_LIGHT_Y, ParamDisplay.BIG_FLOOR_RADIUS_LIGTH),
                         new Dimension(ParamFirstFloor.SECOND_LITTLE_LIGHT_X, ParamFirstFloor.SECOND_LITTLE_LIGHT_Y, ParamDisplay.MINI_FLOOR_LITTLE_RADIUS_LIGTH), false);
                 lightThirdPlace.setGroup(new Dimension(ParamFirstFloor.THIRD_LIGHT_X, ParamFirstFloor.THIRD_LIGHT_Y, ParamDisplay.BIG_FLOOR_RADIUS_LIGTH),
                         new Dimension(ParamFirstFloor.THIRD_LITTLE_LIGHT_X, ParamFirstFloor.THIRD_LITTLE_LIGHT_Y, ParamDisplay.MINI_FLOOR_LITTLE_RADIUS_LIGTH),true);
                 lightFourthPlace.setGroup(new Dimension(ParamFirstFloor.FOURTH_LIGHT_X, ParamFirstFloor.FOURTH_LIGHT_Y, ParamDisplay.BIG_FLOOR_RADIUS_LIGTH),
                         new Dimension(ParamFirstFloor.FOURTH_LITTLE_LIGHT_X, ParamFirstFloor.FOURTH_LITTLE_LIGHT_Y, ParamDisplay.MINI_FLOOR_LITTLE_RADIUS_LIGTH),true);
                 lightFifthPlace.setGroup(new Dimension(ParamFirstFloor.FIFTH_LIGHT_X, ParamFirstFloor.FIFTH_LIGHT_Y, ParamDisplay.BIG_FLOOR_RADIUS_LIGTH),
                         new Dimension(ParamFirstFloor.FIFTH_LITTLE_LIGHT_X, ParamFirstFloor.FIFTH_LITTLE_LIGHT_Y, ParamDisplay.MINI_FLOOR_LITTLE_RADIUS_LIGTH),false);
                 lightSixthPlace.setGroup(new Dimension(ParamFirstFloor.SIXTH_LIGHT_X, ParamFirstFloor.SIXTH_LIGHT_Y, ParamDisplay.BIG_FLOOR_RADIUS_LIGTH),
                         new Dimension(ParamFirstFloor.SIXTH_LITTLE_LIGHT_X, ParamFirstFloor.SIXTH_LITTLE_LIGHT_Y, ParamDisplay.MINI_FLOOR_LITTLE_RADIUS_LIGTH),false);

                radiatorFirst.setGroupe(new Dimension(ParamFirstFloor.FIRST_RADIATOR_X, ParamFirstFloor.FIRST_RADIATOR_Y),
                        new Dimension(ParamFirstFloor.FIRST_LITTLE_RADIATOR_X, ParamFirstFloor.FIRST_LITTLE_RADIATOR_Y), false, ParamHome.RADIATOR_LANDSCAPE);

                objectHomes.clear();
                objectHomes.add(lightFirstPlace);
                objectHomes.add(lightSecondPlace);
                objectHomes.add(lightThirdPlace);
                objectHomes.add(lightFourthPlace);
                objectHomes.add(lightFifthPlace);
                objectHomes.add(lightSixthPlace);
                objectHomes.add(radiatorFirst);

                break;
            }
            case 2: {
                Light lightFirstPlace = new Light();
                Light lightSecondPlace = new Light();
                Light lightThirdPlace = new Light();
                Light lightFourthPlace = new Light();
                 lightFirstPlace.setGroup(new Dimension(ParamSecondFloor.FIRST_LIGHT_X, ParamSecondFloor.FIRST_LIGHT_Y, ParamDisplay.BIG_FLOOR_RADIUS_LIGTH),
                         new Dimension(ParamSecondFloor.FIRST_LITTLE_LIGHT_X, ParamSecondFloor.FIRST_LITTLE_LIGHT_Y, ParamDisplay.MINI_FLOOR_LITTLE_RADIUS_LIGTH),true);
                 lightSecondPlace.setGroup(new Dimension(ParamSecondFloor.SECOND_LIGHT_X, ParamSecondFloor.SECOND_LIGHT_Y, ParamDisplay.BIG_FLOOR_RADIUS_LIGTH),
                         new Dimension(ParamSecondFloor.SECOND_LITTLE_LIGHT_X, ParamSecondFloor.SECOND_LITTLE_LIGHT_Y, ParamDisplay.MINI_FLOOR_LITTLE_RADIUS_LIGTH),false);
                 lightThirdPlace.setGroup(new Dimension(ParamSecondFloor.THIRD_LIGHT_X, ParamSecondFloor.THIRD_LIGHT_Y, ParamDisplay.BIG_FLOOR_RADIUS_LIGTH),
                         new Dimension(ParamSecondFloor.THIRD_LITTLE_LIGHT_X, ParamSecondFloor.THIRD_LITTLE_LIGHT_Y, ParamDisplay.MINI_FLOOR_LITTLE_RADIUS_LIGTH),true);
                 lightFourthPlace.setGroup(new Dimension(ParamSecondFloor.FOURTH_LIGHT_X, ParamSecondFloor.FOURTH_LIGHT_Y, ParamDisplay.BIG_FLOOR_RADIUS_LIGTH),
                         new Dimension(ParamSecondFloor.FOURTH_LITTLE_LIGHT_X, ParamSecondFloor.FOURTH_LITTLE_LIGHT_Y, ParamDisplay.MINI_FLOOR_LITTLE_RADIUS_LIGTH),true);
                objectHomes.clear();
                objectHomes.add(lightFirstPlace);
                objectHomes.add(lightSecondPlace);
                objectHomes.add(lightThirdPlace);
                objectHomes.add(lightFourthPlace);
                break;
            }
            case 3: {
                Light lightFirstPlace = new Light();
                Light lightSecondPlace = new Light();
                 lightFirstPlace.setGroup(new Dimension(ParamThirdFloor.FIRST_LIGHT_X, ParamThirdFloor.FIRST_LIGHT_Y, ParamDisplay.BIG_FLOOR_RADIUS_LIGTH),
                         new Dimension(ParamThirdFloor.FIRST_LITTLE_LIGHT_X, ParamThirdFloor.FIRST_LITTLE_LIGHT_Y, ParamDisplay.MINI_FLOOR_LITTLE_RADIUS_LIGTH), true);
                 lightSecondPlace.setGroup(new Dimension(ParamThirdFloor.SECOND_LIGHT_X, ParamThirdFloor.SECOND_LIGHT_Y, ParamDisplay.BIG_FLOOR_RADIUS_LIGTH),
                         new Dimension(ParamThirdFloor.SECOND_LITTLE_LIGHT_X, ParamThirdFloor.SECOND_LITTLE_LIGHT_Y, ParamDisplay.MINI_FLOOR_LITTLE_RADIUS_LIGTH), false);
                objectHomes.clear();
                objectHomes.add(lightFirstPlace);
                objectHomes.add(lightSecondPlace);
                break;
            }
        }
        return objectHomes;
    }

    /**
     * Method to initialize all the objects of the big house.
     */
   /* public ArrayList<ObjectHome> getMiniObjectHomes(*//*int floorNo*//*) {
        ArrayList<ObjectHome> objectHomes = new ArrayList<ObjectHome>();

//        switch (floorNo) {
//            case 1: {
        Light lightFirstPlaceFloorOne = new Light(new Dimension(ParamFirstFloor.FIRST_LITTLE_LIGHT_X, ParamFirstFloor.FIRST_LITTLE_LIGHT_Y, ParamDisplay.MINI_FLOOR_LITTLE_RADIUS_LIGTH), false);
        Light lightSecondPlaceFloorOne = new Light(new Dimension(ParamFirstFloor.SECOND_LITTLE_LIGHT_X, ParamFirstFloor.SECOND_LITTLE_LIGHT_Y, ParamDisplay.MINI_FLOOR_LITTLE_RADIUS_LIGTH), false);
        Light lightThirdPlaceFloorOne = new Light(new Dimension(ParamFirstFloor.THIRD_LITTLE_LIGHT_X, ParamFirstFloor.THIRD_LITTLE_LIGHT_Y, ParamDisplay.MINI_FLOOR_LITTLE_RADIUS_LIGTH), true);
        Light lightFourthPlaceFloorOne = new Light(new Dimension(ParamFirstFloor.FOURTH_LITTLE_LIGHT_X, ParamFirstFloor.FOURTH_LITTLE_LIGHT_Y, ParamDisplay.MINI_FLOOR_LITTLE_RADIUS_LIGTH), true);
        Light lightFifthPlaceFloorOne = new Light(new Dimension(ParamFirstFloor.FIFTH_LITTLE_LIGHT_X, ParamFirstFloor.FIFTH_LITTLE_LIGHT_Y, ParamDisplay.MINI_FLOOR_LITTLE_RADIUS_LIGTH), false);
        Light lightSixthPlaceFloorOne = new Light(new Dimension(ParamFirstFloor.SIXTH_LITTLE_LIGHT_X, ParamFirstFloor.SIXTH_LITTLE_LIGHT_Y, ParamDisplay.MINI_FLOOR_LITTLE_RADIUS_LIGTH), false);

        Radiator radiatorFirst = new Radiator();
        radiatorFirst.setGroupe(new Dimension(ParamFirstFloor.FIRST_RADIATOR_X, ParamFirstFloor.FIRST_RADIATOR_Y), new Dimension(ParamFirstFloor.FIRST_LITTLE_RADIATOR_X, ParamFirstFloor.FIRST_LITTLE_RADIATOR_Y), false, ParamHome.RADIATOR_LANDSCAPE);


        objectHomes.add(lightFirstPlaceFloorOne);
        objectHomes.add(lightSecondPlaceFloorOne);
        objectHomes.add(lightThirdPlaceFloorOne);
        objectHomes.add(lightFourthPlaceFloorOne);
        objectHomes.add(lightFifthPlaceFloorOne);
        objectHomes.add(lightSixthPlaceFloorOne);
        objectHomes.add(radiatorFirst);
//            }
//            case 2: {
        Light lightFirstPlaceSecondFloor = new Light(new Dimension(ParamSecondFloor.FIRST_LITTLE_LIGHT_X, ParamSecondFloor.FIRST_LITTLE_LIGHT_Y, ParamDisplay.MINI_FLOOR_LITTLE_RADIUS_LIGTH), true);
        Light lightSecondPlaceSecondFloor = new Light(new Dimension(ParamSecondFloor.SECOND_LITTLE_LIGHT_X, ParamSecondFloor.SECOND_LITTLE_LIGHT_Y, ParamDisplay.MINI_FLOOR_LITTLE_RADIUS_LIGTH), false);
        Light lightThirdPlaceSecondFloor = new Light(new Dimension(ParamSecondFloor.THIRD_LITTLE_LIGHT_X, ParamSecondFloor.THIRD_LITTLE_LIGHT_Y, ParamDisplay.MINI_FLOOR_LITTLE_RADIUS_LIGTH), true);
        Light lightFourthPlaceSecondFloor = new Light(new Dimension(ParamSecondFloor.FOURTH_LITTLE_LIGHT_X, ParamSecondFloor.FOURTH_LITTLE_LIGHT_Y, ParamDisplay.MINI_FLOOR_LITTLE_RADIUS_LIGTH), true);

        objectHomes.add(lightFirstPlaceSecondFloor);
        objectHomes.add(lightSecondPlaceSecondFloor);
        objectHomes.add(lightThirdPlaceSecondFloor);
        objectHomes.add(lightFourthPlaceSecondFloor);
//            }
//            case 3: {
        Light lightFirstPlaceThirdFloor = new Light(new Dimension(ParamThirdFloor.FIRST_LITTLE_LIGHT_X, ParamThirdFloor.FIRST_LITTLE_LIGHT_Y, ParamDisplay.MINI_FLOOR_LITTLE_RADIUS_LIGTH), true);
        Light lightSecondPlaceThirdFloor = new Light(new Dimension(ParamThirdFloor.SECOND_LITTLE_LIGHT_X, ParamThirdFloor.SECOND_LITTLE_LIGHT_Y, ParamDisplay.MINI_FLOOR_LITTLE_RADIUS_LIGTH), false);

        objectHomes.add(lightFirstPlaceThirdFloor);
        objectHomes.add(lightSecondPlaceThirdFloor);
//            }
//        }

        return objectHomes;
    }*/

    @Override
    public Dimension getCharacterPosition() {
        return character.getPosition();
    }

    public ArrayList<Floor> getFloors() { return this.floors; }

    /**
     * Method to return the content of the main floor rectangle
     *
     * @param floorNo
     * @return ArrayList<ArrayList<Room>>
     */
    public ArrayList<ArrayList<Room>> getMainFloor(int floorNo) {
        ArrayList<Room> rooms = new ArrayList<Room>();
        switch (floorNo) {
            case 1:
                rooms = floors.get(0).getRooms();
                break;
            case 2:
                rooms = floors.get(1).getRooms();
                break;
            case 3:
                rooms = floors.get(2).getRooms();
                break;
        }
        ArrayList<ArrayList<Room>> roomsArray = new ArrayList<ArrayList<Room>>();
        roomsArray.add(rooms);
        return roomsArray;
    }

    /**
     * Method to return the content of the secondary floors rectangle
     *
     * @param floorNoInFull
     * @return ArrayList<ArrayList<Room>>
     */
    public ArrayList<ArrayList<Room>> getSecondaryFloors(int floorNoInFull) {
        ArrayList<ArrayList<Room>> roomsArray = new ArrayList<ArrayList<Room>>();
//        ArrayList<Room> rooms;
//        switch (floorNoInFull) {
//            case 1:
//                rooms = initRoomsFirstMiniFloor();
//                roomsArray.add(rooms);
//               /* rooms = initRoomsThirdFloor(4);
//                roomsArray.add(rooms);*/
//                break;
//            case 2:
//                rooms = initRoomsSecondMiniFloor();
//                roomsArray.add(rooms);
//                /*rooms = initRoomsThirdFloor(4);
//                roomsArray.add(rooms);*/
//                break;
//            case 3:
//                rooms = initRoomsThirdMiniFloor();
//                roomsArray.add(rooms);
//                /*rooms = initRoomsFirstFloor(4);
//                roomsArray.add(rooms);*/
//                break;
//        }
        return roomsArray;
    }

    /**
     * Method to init the floors to be displayed in the secondary floors rectangle.
     */
    private void initMiniFloors() {
       /* miniFloors.add(new Floor(new Dimension(ParamDisplay.MAIN_FLOOR_DISPLAYED_X, ParamDisplay.MAIN_FLOOR_DISPLAYED_Y,
                ParamDisplay.MAIN_FLOOR_DISPLAYED_WIDTH, ParamDisplay.MAIN_FLOOR_DISPLAYED_HEIGHT)
        ));

        miniFloors.add(new Floor(new Dimension(ParamDisplay.MAIN_FLOOR_DISPLAYED_X, ParamDisplay.MAIN_FLOOR_DISPLAYED_Y,
                ParamDisplay.MAIN_FLOOR_DISPLAYED_WIDTH, ParamDisplay.MAIN_FLOOR_DISPLAYED_HEIGHT)
        ));

        miniFloors.add(new Floor(new Dimension(ParamDisplay.MAIN_FLOOR_DISPLAYED_X, ParamDisplay.MAIN_FLOOR_DISPLAYED_Y,
                ParamDisplay.MAIN_FLOOR_DISPLAYED_WIDTH, ParamDisplay.MAIN_FLOOR_DISPLAYED_HEIGHT)
        ));*/

    }

    @Override
    public void setCharacterPosition(Dimension position) {
        character.setPosition(position);
    }

    public ArrayList<Room> getRooms() {
        return this.rooms;
    }

    public ArrayList<Room> initMiniMapPosition() {
        /*ArrayList<Room> rooms = new ArrayList<Room>();
        Room room01_01 = new Room();
        room01_01.setGroup(new Dimension(ParamDisplay.X_MINI_MAP, ParamDisplay.Y_FIRST_LITTLE_MAP, ParamFirstFloor.FIRST_LITTLE_ROOM_WIDTH, ParamFirstFloor.FIRST_LITTLE_ROOM_HEIGHT),
                floors.get(0), true);
        rooms.add(room01_01);

        return rooms;*/
        return null;
    }
}
