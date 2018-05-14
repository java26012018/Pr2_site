package dao;

import entity.Item;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class ItemDao extends Dao{

    public List<Item> get() {
        List<Item> out = new LinkedList<>();
        try (Connection c = getConnection(); Statement st = c.createStatement()) {
            ResultSet rs = st.executeQuery("SELECT * FROM bmwitem");
            while (rs.next()) {
                out.add(new Item(rs.getInt("id"),
                        rs.getString("model"),
                        rs.getInt("price"),
                        rs.getString("about"),
                        rs.getString("cat"),
                        rs.getString("pic")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return out;
    }

    public List<Item> getByCategoty(String category) {
        List<Item> out = new LinkedList<>();
        try (Connection c = getConnection(); Statement st = c.createStatement()) {
            ResultSet rs = st.executeQuery("SELECT * FROM bmwitem WHERE cat='" + category + "'");
            while (rs.next()) {
                out.add(new Item(rs.getInt("id"),
                        rs.getString("model"),
                        rs.getInt("price"),
                        rs.getString("about"),
                        rs.getString("cat"),
                        rs.getString("pic")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return out;
    }

    public Item getById(int id) {
        Item out = new Item();
        try (Connection c = getConnection(); Statement st = c.createStatement()) {
            ResultSet rs = st.executeQuery("SELECT * FROM bmwitem WHERE id=" + id + "");
            rs.next();
            out.setId(rs.getInt("id"));
            out.setModel(rs.getString("model"));
            out.setPrice(rs.getInt("price"));
            out.setAbout(rs.getString("about"));
            out.setCat(rs.getString("cat"));
            out.setPic(rs.getString("pic"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return out;
    }
}
