package com.zinglabs.zwerewolf.entity;

import com.zinglabs.zwerewolf.entity.role.UserRole;
import com.zinglabs.zwerewolf.util.RoomUtil;

import java.util.*;

/**
 * 房间实体类
 * @author wangtonghe
 * @date 2017/7/24 18:20
 */
public class Room {

    /**
     * 房间id
     */
    private int id;

    /**
     * 房间人数
     */
    private int number;

    /**
     * 模式
     */
    private int modalId;

    /**
     * 房主
     */
    private int owner;

    /**
     * 房间玩家信息
     */
    private Map<Integer,UserRole> players = new HashMap<>();


    public Room(int id, int modalId, int owner) {
        this.id = id;
        this.modalId = modalId;
        this.number =  RoomUtil.getNumByModal(modalId);
        this.owner = owner;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getModalId() {
        return modalId;
    }

    public void setModalId(int modalId) {
        this.number =  RoomUtil.getNumByModal(modalId);
        this.modalId = modalId;
    }

    public Map<Integer, UserRole> getPlayers() {
        return players;
    }

    public void setPlayers(Map<Integer, UserRole> players) {
        this.players = players;
    }

    public int getOwner() {
        return owner;
    }

    public void setOwner(int owner) {
        this.owner = owner;
    }

    public boolean enterRoom(int userId){
        if(players.containsKey(userId)){
            return true;
        }
        if(players.size()>=this.number){  //房间人数已满
            return false;
        }
        UserRole userRole = new UserRole();
        userRole.setPosition(players.size() + 1);
        userRole.setUserId(userId);
        players.put(userId, userRole);
        return true;
    }

    public int getCurNumber(){
        return players.size();
    }







}
