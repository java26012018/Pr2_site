package dao;

import static dao.Dao.getConnection;
import entity.Item;
import entity.User;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;

public class UserDao extends Dao {

    public static User getByLogin(String login) {
        User out = null;
        try (Connection c = getConnection(); Statement st = c.createStatement()) {
            ResultSet rs = st.executeQuery("SELECT * FROM bmwuser WHERE login='" + login + "'");
            if (rs.next()) {
                out = new User(
                        rs.getInt("id"), 
                        rs.getString("login"), 
                        rs.getString("pass"), 
                        rs.getString("basket"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return out;
    }
    
    public static void add(User u){
        try (Connection c = getConnection(); Statement st = c.createStatement()) {
            st.executeUpdate(
                    "INSERT INTO bmwuser VALUES("+
                            u.getId()+",'"+
                            u.getLogin()+"','"+
                            u.getPass()+"','"+
                            u.getBasket()+"')");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void update(User u){
        try (Connection c = getConnection(); Statement st = c.createStatement()) {
            st.executeUpdate(
                    "UPDATE bmwuser SET login='"+
                            u.getLogin()+"', pass='"+
                            u.getPass()+"', basket='"+
                            u.getBasket()+"' WHERE id="+
                            u.getId());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void remove(User u){
        try (Connection c = getConnection(); Statement st = c.createStatement()) {
            st.executeUpdate("DELETE bmwuser WHERE id="+u.getId());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
