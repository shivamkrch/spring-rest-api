package com.example.springrest;

import java.util.ArrayList;

import com.fasterxml.jackson.databind.util.JSONPObject;

public class UserService {

    private ArrayList<UserData> data;

    public UserService() {
        this.data = new ArrayList<UserData>();
        this.data.add(new UserData(1, "Leanne Graham", "bret", "Sincere@april.biz", "Romaguera-Crona", "hildegard.org",
                "1-770-736-8031 x56442"));
        this.data.add(new UserData(2, "Ervin Howell", "Antonette", "Shanna@melissa.tv", "Deckow-Crist", "anastasia.net",
                "010-692-6593 x09125"));
        this.data.add(new UserData(3, "Clementine Bauch", "Samantha", "Nathan@yesenia.net", "Romaguera-Jacobson",
                "ramiro.info", "1-463-123-4447"));
        this.data.add(new UserData(4, "Patricia Lebsack", "Karianne", "Julianne.OConner@kory.org", "Robel-Corkery",
                "kale.biz", "1-770-736-8037"));
        this.data.add(new UserData(5, "Chelsey Dietrich", "Kamren", "Lucio_Hettinger@annie.ca", "Keebler LLC",
                "demarco.info", "1-344-736-8031 x564"));
    }

    /**
     * @return the data
     */
    public ArrayList<UserData> getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(ArrayList<UserData> data) {
        this.data = data;
    }

    public UserData getUser(int id) {
        for (UserData dt : this.data) {
            if (dt.getId() == id) {
                return dt;
            }
        }
        return null;
    }

    public UserData deleteUser(int id) {
        for (UserData dt : this.data) {
            if (dt.getId() == id) {
                data.remove(dt);
                return dt;
            }
        }
        return null;
    }

    public UserData addUser(UserData user) {
        user.setId(data.get(data.size() - 1).getId() + 1);
        data.add(user);
        return user;
    }

    public ArrayList<UserData> updateUser(UserData data2) {
        for (UserData dt : this.data) {
            if (dt.getId() == data2.getId()) {
                UserData d = data.get(data.indexOf(dt));
                d.setCompany(data2.getCompany());
                d.setEmail(data2.getEmail());
                d.setName(data2.getName());
                d.setUsername(data2.getUsername());
                d.setWebsite(data2.getWebsite());
                d.setPhone(data2.getPhone());
                return data;
            }
        }
        return null;
    }

}
