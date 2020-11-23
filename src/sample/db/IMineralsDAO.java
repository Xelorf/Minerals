package sample.db;

import sample.models.Mineral;

import java.util.List;

/**
 * Интерфейс объекта доступа к данным
 */
public interface IMineralsDAO {

    List<Mineral> getMinerals();

    void addMineral(Mineral mineral);

    void deleteMineral(Mineral mineral);
}
