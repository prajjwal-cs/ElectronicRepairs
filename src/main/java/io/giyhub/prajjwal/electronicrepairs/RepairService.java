package io.giyhub.prajjwal.electronicrepairs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RepairService {
    private final RepairRepository repairRepository;

    @Autowired
    public RepairService(RepairRepository repairRepository) {
        this.repairRepository = repairRepository;
    }

    public Repair createRepairRequest(Repair repair) {
        repair.setStatus("Pending");
        return repairRepository.save(repair);
    }

    public Repair updateRepairStatus(Long repairId, String status) {
        Repair repair = repairRepository.findById(repairId).orElseThrow(() -> new RuntimeException("Repair not found"));
        repair.setStatus(String.valueOf(repair));
        return repairRepository.save(repair);
    }

    public List<Repair> getAllRepairs() {
        return repairRepository.findAll();
    }

    public List<Repair> getRepairsByCustomerName(String customerName) {
        return repairRepository.findByCustomerName(customerName);
    }

    public List<Repair> getRepairsByStatus(String status) {
        return repairRepository.findByStatus(status);
    }

    public List<Repair> getRepairsByDevice(String device) {
        return repairRepository.findByDevice(device);
    }

    public List<Repair> getRepairsByCustomerNameAndDevice(String customerName, String device) {
        return repairRepository.findByCustomerNameAndDevice(customerName, device);
    }

    public Long getCountByStatus(String status) {
        return repairRepository.countByStatus(status);
    }

    public List<Repair> getPendingRepairsOrderedByCustomerName(String customerName) {
        return repairRepository.findPendingRepairsOrderedByCustomerName(customerName);
    }

    public void deleteRepair(Long repairId) {
        repairRepository.deleteById(repairId);
    }
}
