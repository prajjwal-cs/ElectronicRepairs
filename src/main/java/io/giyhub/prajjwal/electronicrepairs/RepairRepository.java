package io.giyhub.prajjwal.electronicrepairs;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RepairRepository extends JpaRepository<Repair, Long> {
    List<Repair> findByCustomerName(String customerName);

    List<Repair> findByStatus(String status);

    List<Repair> findByDevice(String device);

    List<Repair> findByCustomerNameAndDevice(String customerName, String device);

    Long countByStatus(String status);

    @Query("SELECT r FROM Repair r WHERE r.status = 'Pending' ORDER BY r.customerName ASC")
    List<Repair> findPendingRepairsOrderedByCustomerName(String customerName);

    void deleteById(Long id);
}
