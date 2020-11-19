package sample.db;

import sample.models.Mineral;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MineralsDAO implements IMineralsDAO {

    private final DBHandler dbHandler = new DBHandler();

    @Override
    public List<Mineral> getMinerals() {
        List<Mineral> minerals = new ArrayList<>();
        try {
            Statement statement = dbHandler.getDbConnection().createStatement();
            ResultSet set = statement.executeQuery("SELECT * FROM " + Const.MINERALS_TABLE);
            while (set.next()) {
                minerals.add(new Mineral(
                        set.getLong(Const.MINERAL_ID),
                        set.getString(Const.MINERAL_NAME),
                        set.getString(Const.MINERAL_FORMULA),
                        set.getString(Const.MINERAL_COLOR),
                        set.getString(Const.MINERAL_LINE_COLOR),
                        set.getString(Const.MINERAL_SHINE),
                        set.getString(Const.MINERAL_TRANSPARENCY),
                        set.getString(Const.MINERAL_HARDNESS),
                        set.getString(Const.MINERAL_DENSITY)
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return minerals;
    }

    @Override
    public void addMineral(Mineral mineral) {
        String command = "INSERT INTO " + Const.MINERALS_TABLE + "(" + Const.MINERAL_ID + ", " + Const.MINERAL_NAME + ", " +
                Const.MINERAL_FORMULA + ", " + Const.MINERAL_COLOR + ", " + Const.MINERAL_LINE_COLOR + ", " +
                Const.MINERAL_SHINE + ", " + Const.MINERAL_TRANSPARENCY + ", " + Const.MINERAL_HARDNESS + ", " + Const.MINERAL_DENSITY + ") Values(?,?,?,?,?,?,?,?,?);";
        try {
            PreparedStatement statement = dbHandler.getDbConnection().prepareStatement(command);
            statement.setLong(1, mineral.getId());
            statement.setString(2, mineral.getName());
            statement.setString(3, mineral.getFormula());
            statement.setString(4, mineral.getColor());
            statement.setString(5, mineral.getLineColor());
            statement.setString(6, mineral.getShine());
            statement.setString(7, mineral.getTransparency());
            statement.setString(8, mineral.getHardness());
            statement.setString(9, mineral.getDensity());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteMineral(Mineral mineral) {
        String command = "DELETE FROM " + Const.MINERALS_TABLE + " WHERE " + Const.MINERAL_ID + " = " + mineral.getId() + ";";
        try {
            Statement statement = dbHandler.getDbConnection().createStatement();
            statement.executeUpdate(command);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
