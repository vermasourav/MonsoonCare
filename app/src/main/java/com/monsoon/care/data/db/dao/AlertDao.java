package com.monsoon.care.data.db.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import androidx.lifecycle.LiveData;
import com.monsoon.care.data.db.entities.AlertEntity;
import java.util.List;

/**
 * Room Database Access Object (DAO) for Alert operations
 */
@Dao
public interface AlertDao {

    @Insert
    long insertAlert(AlertEntity alert);

    @Insert
    void insertAlerts(List<AlertEntity> alerts);

    @Update
    void updateAlert(AlertEntity alert);

    @Delete
    void deleteAlert(AlertEntity alert);

    @Query("DELETE FROM alerts WHERE id = :id")
    void deleteAlertById(int id);

    @Query("SELECT * FROM alerts WHERE id = :id")
    LiveData<AlertEntity> getAlertById(int id);

    @Query("SELECT * FROM alerts ORDER BY timestamp DESC")
    LiveData<List<AlertEntity>> getAllAlerts();

    @Query("SELECT * FROM alerts WHERE isRead = 0 ORDER BY timestamp DESC")
    LiveData<List<AlertEntity>> getUnreadAlerts();

    @Query("SELECT * FROM alerts WHERE severity = :severity ORDER BY timestamp DESC")
    LiveData<List<AlertEntity>> getAlertsBySeverity(String severity);

    @Query("SELECT * FROM alerts WHERE type = :type ORDER BY timestamp DESC")
    LiveData<List<AlertEntity>> getAlertsByType(String type);

    @Query("SELECT * FROM alerts WHERE isSynced = 0")
    List<AlertEntity> getUnsyncedAlerts();

    @Query("DELETE FROM alerts WHERE timestamp < :thresholdTime")
    void deleteOldAlerts(long thresholdTime);

    @Query("SELECT COUNT(*) FROM alerts WHERE isRead = 0")
    LiveData<Integer> getUnreadAlertCount();
}

