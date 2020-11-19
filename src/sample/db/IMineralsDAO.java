package sample.db;

import sample.models.Mineral;

import java.util.List;

public interface IMineralsDAO {

    List<Mineral> getMinerals();

    void addMineral(Mineral mineral);

    void deleteMineral(Mineral mineral);
}
